package com.ys.core;

import android.app.Application;

/**
 * Created by nufeng on 2016/12/13.
 */

public class ApplicationContextGetter {

    private static ApplicationContextGetter instance;
    private Application context;

    private ApplicationContextGetter() {

    }

    public static synchronized ApplicationContextGetter getInstance() {
        if (instance == null) {
            instance = new ApplicationContextGetter();
        }
        return instance;
    }

    public void init(Application context) {
        this.context = context;
    }

    public Application get() {
        if (context == null) {
            try {
                throw new Exception("ApplicationContextGetter not init");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return context;
    }
}
