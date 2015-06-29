package com.ys.ts;

import android.app.Activity;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;

/**
 * 实验shader进行图片处理
 * Created by ys on 2015/2/26.
 */
public class ShaderDemo extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShapeDrawable shapeDrawable=new ShapeDrawable(new OvalShape());

    }
}
