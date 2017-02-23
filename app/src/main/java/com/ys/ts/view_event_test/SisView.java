package com.ys.ts.view_event_test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.ys.ts.utils.L;

/**
 * Created by nufeng on 2017/2/21.
 */

public class SisView extends View {
    public SisView(Context context) {
        super(context);
    }

    public SisView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SisView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.i("Sis----dispatchTouchEvent:" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        L.i("Sis----onTouchEvent:"+event.getAction());
        return super.onTouchEvent(event);
    }
}
