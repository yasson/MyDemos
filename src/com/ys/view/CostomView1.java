package com.ys.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

/**实现一个自定义view
 * Created by ys on 2015/2/26.
 */
public class CostomView1 extends View implements Runnable{
    private Paint mPaint;
    private float radio;
    public CostomView1(Context context) {
        super(context,null);
        init();
    }

    public CostomView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CostomView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setAntiAlias(true);
//        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(200,radio, radio,mPaint);
    }

    @Override
    public void run() {
        try {

            while (true){

                if (radio<200){
                    radio++;
                }else radio=0;
                postInvalidate();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }catch (Exception e){

            Log.d("yangsen", "thread stop");
        }
    }
}
