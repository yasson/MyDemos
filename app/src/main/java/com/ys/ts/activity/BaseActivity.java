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
        mSw= ViewHelper.getScreenWidth(this);
        mSh= ViewHelper.getScreenHeight(this);
        initView();
    }

    protected void initView() {

    }

    protected View findView(int resId){
        return findViewById(resId);
    }
}
