package com.ys.ts.arcview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.*;
import android.nfc.Tag;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.ys.ts.R;
import com.ys.view.BaseView;

/**
 * 扇形相关
 * Created by ys on 2015/3/11.
 */
public class MyArcView extends BaseView{

    private Paint mPaint;
    private Paint mPaintText;
    private RectF mRectF;
    private Region mRegionA;
    private RectF mRectF2;
    private Paint mPaint2;
    private Paint mPaint3;
    private Paint mPaint4;


    private int mRadius;
    private int mInterradius;
    private int mStrokeWidth;
    private int mLinearWidth;
    private int centerX;
    private int centerY;
    private String tag="yangsen";

//    radius="100dp"
//    interradius="40dp"
//    linearWidth="10dp"
//    stokenWidth="40dp"
    public MyArcView(Context context) {
        this(context, null);
    }

    public MyArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void obtainStyledAttributes(AttributeSet attrs) {
        final TypedArray array=getContext().obtainStyledAttributes(attrs, R.styleable.MyArcView);
        mRadius= (int) array.getDimension(R.styleable.MyArcView_radius,0);
        mInterradius= (int) array.getDimension(R.styleable.MyArcView_interRadius,0);
        mStrokeWidth= (int) array.getDimension(R.styleable.MyArcView_stokenWidth,0);
        mLinearWidth= (int) array.getDimension(R.styleable.MyArcView_linearWidth,0);
        array.recycle();
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);

        mPaintText=new TextPaint();
        mPaintText.setTextSize(26);
        mPaintText.setStyle(Paint.Style.STROKE);
        mPaintText.setStrokeWidth(2);
        mPaintText.setColor(Color.BLACK);

        mPaint2=new Paint();
        mPaint2.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint2.setAntiAlias(true);
        mPaint2.setColor(Color.BLACK);

        int left=mStrokeWidth/2+mLinearWidth;
        int top=mStrokeWidth/2+mLinearWidth;
        mRectF=new RectF();
        mRectF.left=left;
        mRectF.top=top;
        mRectF.right=mRadius*2+mLinearWidth*2-left;
        mRectF.bottom=mRadius*2+mLinearWidth*2-left;

    }

    public MyArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((mRadius*2+mLinearWidth*4),mRadius*2+mLinearWidth*4);
        centerX=getMeasuredWidth()/2;
        centerY=getMeasuredWidth()/2;

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed,left,top,right,bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(mLinearWidth , mLinearWidth );
        canvas.drawArc(mRectF, 0, 90, false, mPaint);
        canvas.restore();
        mPaint.setColor(Color.RED);
        canvas.save();
        canvas.translate(-mLinearWidth , mLinearWidth );
        canvas.drawArc(mRectF, 90, 90, false, mPaint);
        canvas.restore();
        mPaint.setColor(Color.YELLOW);
        canvas.save();
        canvas.translate(-mLinearWidth , -mLinearWidth );
        canvas.drawArc(mRectF, 180, 90, false, mPaint);
        Path path=new Path();
        path.addArc(mRectF,180,90);
        String a="系统垃圾";
        float textW=mPaintText.measureText(a);
        float vOffset= -(mPaintText.getFontMetrics().ascent+mPaintText.getFontMetrics().descent)/2;
        float textArcW=textW*(mRadius-mStrokeWidth/2)/(mRadius-mStrokeWidth/2);//计算字体顶部的弧度的长度
        float hOffset= (float) (Math.PI*(mRadius-mStrokeWidth/2)/4-textW/2);
//        float hOffset= (float) (Math.PI * 2 * mRadius / 4 / 2 - textW /2);
        canvas.drawTextOnPath(a, path, hOffset, vOffset, mPaintText);
        canvas.drawPath(path, mPaintText);
        canvas.restore();
        mPaint.setColor(Color.GRAY);
        canvas.save();
        canvas.translate(mLinearWidth , -mLinearWidth);
        canvas.drawArc(mRectF, 270, 90, false, mPaint);
        canvas.restore();
        canvas.drawRect(mRectF,mPaintText);
        mPaint.setColor(Color.GREEN);
        canvas.drawCircle(centerX,centerX,mInterradius/2,mPaint);
    }

    private void drawText(String txt) {
        Path path=new Path();
        path.addArc(mRectF,0,90);
        float textW=mPaintText.measureText(txt);
        float hOffset= (float) (Math.PI*mRadius/2-textW/2);
        float vOffset= mRadius+mLinearWidth+mStrokeWidth/2;

    }

    @Override
    public boolean onTouchEvent(@SuppressWarnings("NullableProblems") MotionEvent  event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
