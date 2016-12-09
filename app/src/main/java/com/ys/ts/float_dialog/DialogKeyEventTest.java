package com.ys.ts.float_dialog;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.ys.ts.R;
import com.ys.ts.activity.BaseActivity;

/**
 * 研究dialog 出现的时候对key事件的拦截机制
 * Created by nufeng on 2016/12/7.
 */

public class DialogKeyEventTest extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        super.initView();
//        findViewById()
        showDg();
    }

    private void showDg() {
        FloatDialog dialog = new FloatDialog(this, R.style.FloatDialog);
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.dog));
        dialog.setContentView(imageView);
        dialog.setTitle("我是dialog");
        dialog.setCanceledOnTouchOutside(false);
        Window dialogWindow = dialog.getWindow();
        if (dialogWindow != null) {
//            dialogWindow.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            dialogWindow.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
            lp.width = 600;
            lp.height = 800;
//            lp.x = 400;
//            lp.y = 400;
        }
        dialog.show();
    }
}
