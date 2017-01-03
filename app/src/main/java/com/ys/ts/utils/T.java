package com.ys.ts.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

import com.ys.core.AppInstance;

/**
 * Created by nufeng on 2016/12/13.
 */

public class T {

    private static Toast mToast;

    public static void init(){
        mToast =  Toast.makeText(AppInstance.context(),"",Toast.LENGTH_SHORT);
    }

    public static void show(final String ms){
        if (Looper.myLooper()==Looper.getMainLooper()){
            mToast.setText(ms);
            mToast.show();
        }else{
            AppInstance.ofUIHandler().post(new Runnable() {
                @Override
                public void run() {
                    mToast.setText(ms);
                    mToast.show();
                }
            });
        }
    }
}
