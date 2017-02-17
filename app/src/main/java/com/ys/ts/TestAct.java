package com.ys.ts;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.ys.ts.activity.BaseActivity;
import com.ys.ts.utils.L;

import java.util.ArrayList;

/**
 * Created by nufeng on 2/8/17.
 */

public class TestAct extends BaseActivity {


    int last;
    private android.os.Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            L.d(String.valueOf(msg.what));
            if (msg.what==last){
//                obtainMessage(last).sendToTarget();
                s.add(msg.what);
            }else {
                last = msg.what;
                print(last);
                if (s.size()>0){
                    last = s.remove(0);
                    print(last);
                }
            }

        }
    };
    ArrayList<Integer> s = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testThread();
    }

    private void testThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i<5){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    handler.sendEmptyMessage(1);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i<5){
                    i++;
                    handler.sendEmptyMessage(2);
//                    print("2");
                }
            }
        }).start();
    }
}
