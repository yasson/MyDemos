package com.ys;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**工具类
 * Created by ys on 2015/3/11.
 */
public class ViewHelper {

    public static int getScreenWidth(Context context){
        return getDisplayMetrics(context).widthPixels;
    }

    public static int getScreenHeight(Context context){
        return getDisplayMetrics( context).heightPixels;
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
}
