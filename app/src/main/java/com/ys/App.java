package com.ys;

import android.app.Application;

import com.ys.core.ApplicationContextGetter;

/**
 * Created by nufeng on 2016/12/13.
 */

public class App extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationContextGetter.getInstance().init(this);
    }
}
