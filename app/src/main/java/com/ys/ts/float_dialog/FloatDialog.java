package com.ys.ts.float_dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * Created by nufeng on 2016/12/7.
 */

public class FloatDialog extends Dialog {

    public FloatDialog(Context context) {
        this(context, 0);
    }

    public FloatDialog(Context context, int themeResId) {
        super(context, themeResId);
//        Window window = getWindow();
//        WindowManager.LayoutParams lp = window.getAttributes();
//        window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
//        lp.width = 200;
//        lp.height = 200;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("ys","onKeyDown------");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.d("ys","onKeyUp");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d("ys","dispatchKeyEvent");
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("ys","dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }
}
