package com.ys.ts.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.ys.ViewHelper;
import com.ys.ts.R;

/**
 * Created by ys on 2015/2/28.
 */
public class BaseActivity extends FragmentActivity {
    protected  int mSw=0;
    protected  int mSh=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView(savedInstanceState));
        initView();
    }

    protected int getContentView(Bundle savedInstanceState) {
        return 0;
    }

    protected void initView() {
        mSw= ViewHelper.getScreenWidth(this);
        mSh= ViewHelper.getScreenHeight(this);
    }

    protected <T extends View> T findView(int resId){
        return (T) findViewById(resId);
    }
}
