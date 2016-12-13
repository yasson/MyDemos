package com.ys.ts.fuck_money;

import android.accessibilityservice.AccessibilityService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import com.ys.core.AppInstance;
import com.ys.ts.utils.L;
import com.ys.ts.utils.T;

import java.util.List;

/**
 * Created by nufeng on 2016/12/12.
 */

public class FMService extends AccessibilityService {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        L.i("onStartCommand");
        Notification.Builder b = new Notification.Builder(this);
        b.setContentText("辅助关闭权限管理弹窗,mt提示弹窗等").setContentTitle("ys辅助服务");
        startForeground(110,b.build());
        return START_NOT_STICKY;
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

        switch (event.getPackageName().toString()){
            case "com.samsung.android.packageinstaller":
                checkPerInfos(getRootInActiveWindow());
                break;
            case "com.samsung.android.MtpApplication":
                checkMtpAlert(getRootInActiveWindow());
                break;
            case "com.tencent.mm":
                dealMM(event);
                break;

        }
        L.d(event.toString());

    }

    /**
     * 处理微信问题
     */
    private void dealMM(AccessibilityEvent event) {
        switch (event.getEventType()){
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                List<CharSequence> ts = event.getText();
                boolean hasMoney = false;
                for (CharSequence s : ts){
                    if (TextUtils.isEmpty(s))
                        continue;
                    if (s.toString().contains("微信红包")){
                        hasMoney = true;
                        break;
                    }
                }
                if (hasMoney){
                    Notification nf = (Notification) event.getParcelableData();
                    PendingIntent pi = nf.contentIntent;
                    try {
                        pi.send();
                    } catch (PendingIntent.CanceledException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                String className = event.getClassName().toString();
                if (className.equals("com.tencent.mm.ui.LauncherUI")) {
                    //开始抢红包
                    openPacket();
                } else if (className.equals("com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI")) {
                    //开始打开红包
                    getPacket();
                }else if (className.equals("com.tencent.mm.ui.base.p")){
                    getPacket();
                }
                break;
        }
    }

    private void checkPerInfos(AccessibilityNodeInfo nodeInfo) {
        if (nodeInfo ==null)
            return;
        if (nodeInfo.findAccessibilityNodeInfosByText("应用程序权限管理").size()>0){
            L.w("应用程序权限管理");
            List<AccessibilityNodeInfo> is = nodeInfo.findAccessibilityNodeInfosByViewId("com.android.packageinstaller:id/confirm_button");
            if (is.size()==0)
                return;
            for (AccessibilityNodeInfo as : is){
                if (TextUtils.isEmpty(as.getText()))
                    continue;
                if (as.getText().equals("确认")){
                    L.w("应用程序权限管理 辅助关闭");
                    as.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
            }
        }
    }
    private void checkMtpAlert(AccessibilityNodeInfo nodeInfo){
        if (nodeInfo ==null)
            return;
        if (nodeInfo.findAccessibilityNodeInfosByText("注意").size()>0){
            L.w("mtp alert");
            List<AccessibilityNodeInfo> is = nodeInfo.findAccessibilityNodeInfosByViewId("android:id/button1");
            if (is.size()==0)
                return;
            for (AccessibilityNodeInfo as : is){
                if (TextUtils.isEmpty(as.getText()))
                    continue;
                if (as.getText().equals("确定")){
                    L.w("mtp 辅助关闭");
                    as.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
            }
        }
    }

    /**
     * 进入抢红包页面
     */
    private void openPacket() {
        final AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        new Thread(new Runnable() {
            @Override
            public void run() {
                recycle(nodeInfo);
            }
        }).start();

    }

    private void recycle(AccessibilityNodeInfo nodeInfo) {
        if (nodeInfo ==null)
            return;
        final Rect rect = new Rect();
        nodeInfo.getBoundsInScreen(rect);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AppInstance.ofUIHandler().post(new Runnable() {
            @Override
            public void run() {
                showView(rect);
            }
        });
        if (nodeInfo.getChildCount()==0){
            if (!TextUtils.isEmpty(nodeInfo.getText())){
                if ("领取红包".endsWith(nodeInfo.getText().toString())){
                    nodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                    AccessibilityNodeInfo parent = nodeInfo.getParent();
                    while (parent!=null){
//                        if (parent.isCheckable()){
//                        }
                        parent.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                        parent = parent.getParent();
                    }
                }
            }
        }else {
            for (int i =0,j=nodeInfo.getChildCount();i<j;i++){
                recycle(nodeInfo.getChild(i));

            }
        }
    }

    public void showView(Rect rect){
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        CoverView c = new CoverView(this);
        c.setRect(rect);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.format = PixelFormat.TRANSLUCENT;
        lp.width = 600;
        lp.height = 600;
        lp.flags = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        windowManager.addView(c,lp);
    }

    /**
     * 打开红包
     */
    private void getPacket() {
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        List<AccessibilityNodeInfo> infos = nodeInfo.findAccessibilityNodeInfosByText("微信红包");
        List<AccessibilityNodeInfo> btns = nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/bdg");
        for (AccessibilityNodeInfo info :btns){
            info.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }
    }

    @Override
    protected void onServiceConnected() {
        T.show("抢红包辅助服务开启");
        super.onServiceConnected();
    }

    @Override
    public void onInterrupt() {
        T.show("抢红包辅助服务关闭");
        L.w("onInterrupt");
    }
}
