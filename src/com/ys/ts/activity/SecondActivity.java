package com.ys.ts.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.ys.ts.R;
import com.ys.ts.test.MyFragment;

/**
 * Created by ys on 2015/3/11.
 */
public class SecondActivity extends BaseActivity{
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initialize();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("yangsen","second Activity onDestroyed");
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
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragment fragment=new MyFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.f,fragment,fragment.getClass().getSimpleName()).commit();
            }
        });
    }

}
