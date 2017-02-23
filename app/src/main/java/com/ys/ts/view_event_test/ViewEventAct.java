package com.ys.ts.view_event_test;

import android.os.Bundle;
import android.view.MotionEvent;

import com.ys.ts.R;
import com.ys.ts.activity.BaseActivity;
import com.ys.ts.utils.L;

/**
 * Created by nufeng on 2017/2/21.
 */

public class ViewEventAct extends BaseActivity {

    @Override
    protected int getContentView(Bundle savedInstanceState) {
        return R.layout.view_event_act;
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.e("Act*****-dispatchTouchEvent:" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        L.e("Act*****onTouchEvent:" + event.getAction());

        return true;
    }
}
