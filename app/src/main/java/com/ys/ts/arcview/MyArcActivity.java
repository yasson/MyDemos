package com.ys.ts.arcview;

import android.os.Bundle;
import android.view.View;

import com.ys.ts.R;
import com.ys.ts.activity.BaseActivity;

/**
 * Created by ys on 2015/3/11.
 */
public class MyArcActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_my_arc);
        findView(R.id.btn1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                break;
        }
    }
}
