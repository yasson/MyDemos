package com.ys.ts.view_event_test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.ys.ts.utils.L;

/**
 * Created by nufeng on 2017/2/21.
 */

public class Son2View extends View {
    public Son2View(Context context) {
        super(context);
    }

    public Son2View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Son2View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.i("Son2----dispatchTouchEvent:" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        L.i("Son2----onTouchEvent:"+event.getAction());
        return super.onTouchEvent(event);
    }
}
