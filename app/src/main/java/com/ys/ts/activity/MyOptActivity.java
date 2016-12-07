package com.ys.ts.activity;

import android.content.Context;
import android.content.pm.IPackageDataObserver;
import android.content.pm.PackageManager;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.ys.ts.R;

import java.lang.reflect.Method;

/**
 * Created by ys on 2015/4/2.
 */
public class MyOptActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_opt);
        clearCache(this);
    }

    private void clearCache(Context context) {
        {
            long ALL_YOUR_CACHE_ARE_BELONG_TO_US=Long.MAX_VALUE;
            PackageManager pm = context.getPackageManager();
            Method localMethod;
            try {
                localMethod = pm.getClass().getMethod("freeStorageAndNotify",
                                                      Long.TYPE, IPackageDataObserver.class);
                localMethod.invoke(pm, ALL_YOUR_CACHE_ARE_BELONG_TO_US, new IPackageDataObserver.Stub() {

                    @Override
                    public void onRemoveCompleted(String packageName, boolean succeeded) throws RemoteException {
                        Log.d("yangsen", "onRemoveCompleted:" + packageName + " is succ " + succeeded);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
