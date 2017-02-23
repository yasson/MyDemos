package com.ys.ts.view_event_test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.ys.ts.utils.L;

/**
 * Created by nufeng on 2017/2/21.
 */

public class FatherView extends FrameLayout {

    public FatherView(Context context) {
        super(context);
    }

    public FatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.i("Father++++dispatchTouchEvent:" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    int i = 0;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        L.i("Father++++onInterceptTouchEvent:" + ev.getAction()+ " i:"+i);
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                i=0;
                return false;
//                break;
            case MotionEvent.ACTION_MOVE:
                i++;
                if (i>12&&i<15){
//                    L.w("Father++++onInterceptTouchEvent true" );
                    return true;
                }else {
//                    L.w("Father++++onInterceptTouchEvent false" );
                    return false;
                }
//                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        L.i("Father++++onTouchEvent:" + ev.getAction());
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                i=0;
//                return true;
////                break;
//            case MotionEvent.ACTION_MOVE:
//                if (i>5&&i<10){
//                    return true;
//                }else {
//                    return false;
//                }
////                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
        return false;
    }
}
