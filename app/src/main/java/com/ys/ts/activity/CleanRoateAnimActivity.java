package com.ys.ts.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import com.ys.ts.R;
import com.ys.view.RotateAnimView;

/**
 *
 * Created by ys on 2015/7/9.
 */
public class CleanRoateAnimActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_clean_roate_anim);
        startService(new Intent(this, Se.class));

//        rv.scan();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    public static class Se extends Service{
        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

            View rv = LayoutInflater.from(getApplicationContext()).inflate(R.layout.ui_clean_roate_anim,null);
            windowManager.addView(rv, null);
            return super.onStartCommand(intent, flags, startId);
        }

        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
    }
}
