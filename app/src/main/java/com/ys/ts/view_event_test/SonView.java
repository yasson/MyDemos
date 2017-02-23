package com.ys.ts.view_event_test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.ys.ts.utils.L;

/**
 * Created by nufeng on 2017/2/21.
 */

public class SonView extends View {
    public SonView(Context context) {
        super(context);
    }

    public SonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.i("Son----dispatchTouchEvent:" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }
    int i = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        L.i("Son----onTouchEvent:"+event.getAction()+" i:"+i);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                i=0;
//                return true;
//                break;
            case MotionEvent.ACTION_MOVE:
                i++;
                if (i>2&&i<5){
                    return true;
                }else {
                    return false;
                }
//                break;
            case MotionEvent.ACTION_UP:
                break;
            case 3:
                return true;
        }
        return super.onTouchEvent(event);
    }
}
