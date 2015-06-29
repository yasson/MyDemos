package com.ys.ts;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by ys on 2015/2/15.
 */
public class TsService extends Service{
    String  tag="yangsen";
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(tag,"onBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(tag,"on unbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(tag,"onDestroy");

    }
}
