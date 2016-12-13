package com.ys.ts.fuck_money;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.ys.view.BaseView;

/**
 * Created by nufeng on 2016/12/13.
 */

public class CoverView extends BaseView{
    public CoverView(Context context) {
        super(context);
    }

    public CoverView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CoverView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void obtainStyledAttributes(AttributeSet attrs) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mRect.width(),mRect.height());
    }

    @Override
    protected void init(Context context) {
        setBackgroundColor(Color.TRANSPARENT);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
    }
    Rect mRect;
    public void setRect(Rect rect){
        mRect = rect;
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        canvas.drawRect(mRect,paint);
    }
}
