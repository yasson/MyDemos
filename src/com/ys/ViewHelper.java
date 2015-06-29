package com.ys;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**工具类
 * Created by ys on 2015/3/11.
 */
public class ViewHelper {

    public static int getScreenWidth(Context context){
        return getDisplayMetrics((Activity) context).widthPixels;
    }

    public static int getScreenHeight(Context context){
        return getDisplayMetrics((Activity) context).heightPixels;
    }

    private static DisplayMetrics getDisplayMetrics(Activity context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
}
