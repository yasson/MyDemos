package com.ys.ts.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.ys.core.AppInstance;

/**
 * Created by nufeng on 2016/12/13.
 */

public class T extends Toast{

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public T(Context context) {
        super(context);
    }

    public static void show(String ms){
        makeText(AppInstance.context(),ms,Toast.LENGTH_SHORT).show();
    }
}
