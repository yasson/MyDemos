package com.ys.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.ys.ViewHelper;

/**
 * base custom view
 * Created by ys on 2015/3/11.
 */
public abstract class BaseView extends View{

    protected int sw=0;
    protected int sh=0;
    public BaseView(Context context) {
        this(context, null, 0);
    }

    public BaseView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        sw= ViewHelper.getScreenWidth(context);
        sh= ViewHelper.getScreenHeight(context);
        init(context);
        obtainStyledAttributes(attrs);
    }



    protected abstract void obtainStyledAttributes(AttributeSet attrs);
    protected abstract void init(Context context);

    /**
     * dp 2 px
     *
     * @param dpVal dp
     */
    protected int dp2px(int dpVal)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, getResources().getDisplayMetrics());
    }

    /**
     * sp 2 px
     *
     * @param spVal sp
     * @return px
     */
    protected int sp2px(int spVal)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, getResources().getDisplayMetrics());

    }
}
