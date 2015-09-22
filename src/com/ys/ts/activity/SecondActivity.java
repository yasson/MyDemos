package com.ys.ts.activity;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ys.ts.R;
import com.ys.ts.test.MyFragment;

/**
 *
 * Created by ys on 2015/3/11.
 */
public class SecondActivity extends BaseActivity implements View.OnClickListener{
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initialize();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("yangsen", "second Activity onDestroyed");
    }

    private void testContextThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    private void initialize() {

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragment fragment = new MyFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.f, fragment, fragment.getClass().getSimpleName()).commit();
            }
        });
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn2:
                testNoti();
                break;
        }
    }

    private void testNoti() {
        try {
            Notification ntf = new Notification();
            ntf.setLatestEventInfo(getApplicationContext(), "titleColor",
                                   "textColor", null);
            LinearLayout group = new LinearLayout(getApplicationContext());
            ViewGroup event = (ViewGroup) ntf.contentView.apply(
                    getApplicationContext(), group);
            recurseGroup(event);
            group.removeAllViews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private boolean recurseGroup(ViewGroup gp) {
        final int count = gp.getChildCount();
        for (int i = 0; i < count; ++i) {
            if (gp.getChildAt(i) instanceof TextView) {
                final TextView text = (TextView) gp.getChildAt(i);
                int color = text.getTextColors().getDefaultColor();
                Log.d("color","text :"+text.getText());
                if (text.getText().equals("titleColor")){
                    Log.i("color","titleColor color is "+color);
                }else
                if (text.getText().equals("textColor")){
                    Log.i("color","textColor color is "+color);

                }

//                return true;
            } else if (gp.getChildAt(i) instanceof ViewGroup)
                return recurseGroup((ViewGroup) gp.getChildAt(i));
        }
        return false;
    }
}
