package com.ys.view;

import android.content.Context;
import android.graphics.*;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Toast;
import com.ys.ts.R;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by ys on 2015/7/9.
 */
public class RotateAnimView extends BaseView{
    Bitmap mBmpDst;
    Bitmap mBmpSrc;

    Paint mPaint ;
    Paint mTxPaint ;

    String tag =getClass().getSimpleName();
    public RotateAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(tag, "RotateAnimView");
    }

    int i;
    @Override
    protected void init(Context context) {
        Log.d(tag,"init");
//        mBmpDst = Bitmap.createBitmap(sw/2,sw/2,null);
//        mBmpSrc = Bitmap.createBitmap(sw/2,sw/2,null);
        mBmpDst = BitmapFactory.decodeResource(getResources(), R.drawable.clean_scan_headerview_rotate_src);
        mBmpSrc = BitmapFactory.decodeResource(getResources(), R.drawable.clean_scan_headerview_rotate_dst);
//        mBmpDst = Bitmap.createScaledBitmap(dst,sw/2,sw/2,true);
//        mBmpSrc = Bitmap.createScaledBitmap(src,sw/2,sw/2,true);
        mPaint= new Paint();
        mPaint.setColor(Color.GREEN);
        mTxPaint = new TextPaint();
        mTxPaint.setColor(Color.YELLOW);


        mBs=new BitmapShader(mBmpDst,Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        mPaint.setShader(mBs);
//        BitmapShader bs=new BitmapShader(mBmpSrc,Shader)
    }

    BitmapShader mBs ;

    @Override
    protected void obtainStyledAttributes(AttributeSet attrs) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int wSize = MeasureSpec.getSize(widthMeasureSpec);
        int wMode = MeasureSpec.getMode(widthMeasureSpec);

        int hSize = MeasureSpec.getSize(heightMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);

        int width;
        int height;

        int bmgLength = mBmpDst.getWidth();

        int min = Math.min(wSize, hSize);

        if (wMode == MeasureSpec.EXACTLY) {
            width = wSize;
        } else {
            width = min;
        }
        if (hMode == MeasureSpec.EXACTLY) {
            height = hSize;
        } else {
            height = min;
        }
        setMeasuredDimension(bmgLength, bmgLength);


    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //        canvas.drawColor(android.R.color.holo_blue_bright);
//        canvas.drawBitmap(mBmpDst, 0, 0, null);
//        canvas.drawBitmap(mBmpSrc, 0, 0, mPaint);
//
//        //        canvas.drawText(mode.name(), 0, 0, mTxPaint);
//        Region region = new Region();
//        Rect rect = new Rect();
//        mToast.setText(mode.name());
//        mToast.show();
        canvas.drawBitmap(mBmpSrc,0,0,mPaint);
//        canvas.drawArc();
    }

    Toast mToast = Toast.makeText(getContext(), "", LENGTH_SHORT);

    public void scan() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 19; i++) {
                    setPorter(i);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    postInvalidate();
                }
            }
        }).start();
    }

    PorterDuff.Mode mode;

    public void setPorter(int i) {
        if (i == 1)
            mode = PorterDuff.Mode.ADD;
        if (i == 2)
            mode = PorterDuff.Mode.CLEAR;
        if (i == 3)
            mode = PorterDuff.Mode.DST;
        if (i == 4)
            mode = PorterDuff.Mode.DST_ATOP;
        if (i == 5)
            mode = PorterDuff.Mode.DST_IN;
        if (i == 6)
            mode = PorterDuff.Mode.DST_OUT;
        if (i == 7)
            mode = PorterDuff.Mode.DST_OVER;
        if (i == 8)
            mode = PorterDuff.Mode.LIGHTEN;
        if (i == 9)
            mode = PorterDuff.Mode.MULTIPLY;
        if (i == 10)
            mode = PorterDuff.Mode.OVERLAY;
        if (i == 11)
            mode = PorterDuff.Mode.SCREEN;
        if (i == 12)
            mode = PorterDuff.Mode.SRC;
        if (i == 13)
            mode = PorterDuff.Mode.SRC_ATOP;
        if (i == 14)
            mode = PorterDuff.Mode.SRC_IN;
        if (i == 15)
            mode = PorterDuff.Mode.SRC_OUT;
        if (i == 16)
            mode = PorterDuff.Mode.SRC_OVER;
        if (i == 17)
            mode = PorterDuff.Mode.XOR;
        if (i == 17)
            mode = PorterDuff.Mode.DARKEN;
//        mPaint.setXfermode(new PorterDuffXfermode(mode));
    }
}
