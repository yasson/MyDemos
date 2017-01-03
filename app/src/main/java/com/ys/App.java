package com.ys;

import android.app.Application;

import com.ys.core.ApplicationContextGetter;
import com.ys.ts.utils.T;

/**
 * Created by nufeng on 2016/12/13.
 */

public class App extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationContextGetter.getInstance().init(this);
        T.init();
    }
}
