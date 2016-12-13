package com.ys.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by nufeng on 2016/12/13.
 */

public class AppInstance {
    private static Handler mHandler;

    public static Handler ofUIHandler(){
        if (mHandler==null){
            mHandler = new Handler(Looper.getMainLooper());
        }
        return mHandler;
    }
    public static Context context(){
        return ApplicationContextGetter.getInstance().get();
    }
}
