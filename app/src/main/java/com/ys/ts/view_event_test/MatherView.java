package com.ys.ts.view_event_test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.ys.ts.utils.L;

/**
 * Created by nufeng on 2017/2/21.
 */

public class MatherView extends FrameLayout {

    public MatherView(Context context) {
        super(context);
    }

    public MatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.d("Mather----dispatchTouchEvent:" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    int i = 0;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        L.d("Mather----onInterceptTouchEvent:" + ev.getAction());
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                i = 0;
                return false;
//                break;
            case MotionEvent.ACTION_MOVE:
                i++;
                if (i > 5 && i < 10) {
                    return true;
                } else {
                    return false;
                }
//                break;
            case MotionEvent.ACTION_UP:
                break;
            case 3:
                return true;
        }
        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        L.d("Mather----onTouchEvent:" + ev.getAction() + " i:"+i);
        i++;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                i = 0;
//                L.w("Mather----onTouchEvent true");
                return false;
//                break;
            case MotionEvent.ACTION_MOVE:
                if (i > 5 && i < 10) {
//                    L.w("Mather----onTouchEvent true");
                    return true;
                } else {
//                    L.w("Mather----onTouchEvent false");
                    return false;
                }
//                break;
            case MotionEvent.ACTION_UP:
                break;
        }
//        L.w("Mather----onTouchEvent false");
        return false;
    }
}
