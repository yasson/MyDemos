package com.ys.ts;

import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.ys.ts.activity.CleanRoateAnimActivity;
import com.ys.ts.activity.MyCostomActivity;
import com.ys.ts.activity.MyOptActivity;
import com.ys.ts.activity.SecondActivity;
import com.ys.ts.arcview.MyArcActivity;
import com.ys.ts.float_dialog.DialogKeyEventTest;
import com.ys.ts.fuck_money.FuckMoneyActivity;
import com.ys.view.CostomView1;

public class MyActivity extends ListActivity implements View.OnClickListener{
    String tag="yangsen";
    private CostomView1 view1;
    Thread viewT;
    public static String[] titles={"test","自定义圆角图片","test context","my arc view","test opt","垃圾清理顶部选择view","dialog key事件拦截","抢红包插件"};

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view1=new CostomView1(getApplicationContext());
        initView();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position){
            case 0:
                openActivity(TestAct.class);
                break;
            case 1:
                openActivity(MyCostomActivity.class);
                break;
            case 2:
                openActivity(SecondActivity.class);
                break;
            case 3:
                openActivity(MyArcActivity.class);
                break;
            case 4:
                openActivity(MyOptActivity.class);
                break;
            case 5:
                openActivity(CleanRoateAnimActivity.class);
                break;
            case 6:
                openActivity(DialogKeyEventTest.class);
                break;
            case 7:
                openActivity(FuckMoneyActivity.class);
                break;

            default:
                break;
        }
    }


    private void openActivity(Class<?> c) {
        startActivity(new Intent(this, c));
    }

    private void showCostomCirCleView() {
        FrameLayout.LayoutParams lp=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin=200;
        lp.rightMargin=200;
        lp.topMargin=200;
        addContentView(view1,lp);
        viewT=new Thread(view1);
        viewT.start();
    }

    private void initView() {
        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,titles);
        getListView().setAdapter(arrayAdapter);
    }

    private void tsServiceUnbind() {
        bindService(new Intent(getApplicationContext(),TsService.class),conn, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(tag,"onServiceConnected");

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(tag,"onServiceDisconneted");
        }
    };

    public void getInf() {
        He.getSystemGarbageForOnkeyCheck(getApplicationContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
//                unbindService(conn);
//                String a=null;
//                a.toString();
                if (!viewT.isAlive()){
                    viewT=new Thread(view1);
                    viewT.start();
                }
                break;
            case R.id.button:
                viewT.interrupt();
                break;
        }
    }

}
