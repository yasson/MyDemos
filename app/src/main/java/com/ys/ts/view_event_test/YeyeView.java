package com.ys.ts.view_event_test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.ys.ts.utils.L;

/**
 * Created by nufeng on 2017/2/21.
 */

public class YeyeView extends FrameLayout {

    public YeyeView(Context context) {
        super(context);
    }

    public YeyeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public YeyeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.w("Yeye++++dispatchTouchEvent:" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    int i = 0;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        L.w("Yeye++++onInterceptTouchEvent:" + ev.getAction()+ " i:"+i);
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                i=0;
//                return false;
////                break;
//            case MotionEvent.ACTION_MOVE:
//                i++;
//                if (i>12&&i<15){
//                    L.w("Yeye++++onInterceptTouchEvent true" );
//                    return true;
//                }else {
//                    L.w("Yeye++++onInterceptTouchEvent false" );
//                    return false;
//                }
////                break;
//            case MotionEvent.ACTION_UP:
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                break;
//        }
        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        L.w("Yeye++++onTouchEvent:" + ev.getAction());
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
