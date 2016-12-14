package com.ys.ts.utils;

import com.ys.core.AppInstance;

/**
 * Created by nufeng on 2016/12/14.
 */

public class SCTools {

    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = AppInstance.context().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = AppInstance.context().getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
