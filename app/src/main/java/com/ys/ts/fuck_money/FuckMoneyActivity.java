package com.ys.ts.fuck_money;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ys.core.AppInstance;
import com.ys.ts.R;
import com.ys.ts.activity.BaseActivity;
import com.ys.ts.fuck_money.api.FuckMoneyApi;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by nufeng on 2016/12/12.
 */

public class FuckMoneyActivity extends BaseActivity implements View.OnClickListener, AccessibilityManager.AccessibilityStateChangeListener {


    private AccessibilityManager accMgr;


    private Button mBtnStart;
    private Button mBtnStop;
    private LinearLayout mContainer;
    @Override
    protected int getContentView(Bundle savedInstanceState) {
        return R.layout.fuck_money;
    }

    @Override
    protected void initView() {
        super.initView();
        mBtnStart = findView(R.id.btn1);
        mBtnStop = findView(R.id.btn2);
        mContainer = findView(R.id.container);
        mBtnStart.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initService();
    }

    private void initService() {
        if (checkAccPermission()){
            mBtnStart.setText("服务已开启");
        }else {
            mBtnStart.setText("开启服务");
        }
    }

    private boolean checkAccPermission() {
        accMgr = (AccessibilityManager) getSystemService(ACCESSIBILITY_SERVICE);
        accMgr.addAccessibilityStateChangeListener(this);
        List<AccessibilityServiceInfo> infos = accMgr.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_GENERIC);
        if (infos==null)
            return false;
        for (AccessibilityServiceInfo info : infos){
            if (info==null|| TextUtils.isEmpty(info.getId()))
                continue;
            if (info.getId().equals("com.ys.ts/.fuck_money.FMService")){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        accMgr.removeAccessibilityStateChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                goSetService();
                break;
            case R.id.btn2:
                FuckMoneyApi.setApiGetIndex();
                break;
        }
    }

    private void goSetService() {
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(intent);
    }

    @Override
    public void onAccessibilityStateChanged(boolean enabled) {
        if (enabled){
            startService(new Intent(FuckMoneyActivity.this,FMService.class));
            mBtnStart.setText("服务已开启");
        }
    }
}
