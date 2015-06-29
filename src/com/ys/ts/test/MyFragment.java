package com.ys.ts.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.ys.ts.R;
import com.ys.ts.activity.SecondActivity;

/**
 * Created by ys on 2015/3/11.
 */
public class MyFragment extends Fragment{
    private Context mContext;
    private Context mAppContext;
    private Context mGetActivity;
    private SecondActivity secondActivity;
    private Button button2;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mContext=activity;
        this.mGetActivity=getActivity();
        this.mAppContext=activity.getApplicationContext();
        secondActivity= (SecondActivity) activity;
        activity=null;
        startTestThread();

    }

    private void startTestThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                while (a<10){
                    Log.d("yangsen","mContext:"+mContext);
                    Log.d("yangsen", "AppContext:" + mAppContext);
                    Log.d("yangsen", "GetActivity:" + getActivity());
                    Log.d("yangsen", "mGetActivity:" + mGetActivity);
                    Log.d("yangsen", "secondActivity:" + secondActivity);
                    Log.d("yangsen", "onDestroyed:" + secondActivity.isDestroyed());
                    try{
                        mContext.getResources().getString(R.string.app_name);
                    }catch (Exception e){
                        Log.w("yangsen","exception :mContext"+mContext);
                    }
                    try{
                        mAppContext.getResources().getString(R.string.app_name);
                    }catch (Exception e){
                        Log.w("yangsen","exception :mAppContext"+mAppContext);
                    }
                    try{
                        mGetActivity.getResources().getString(R.string.app_name);
                    }catch (Exception e){
                        Log.w("yangsen","exception :mGetActivity"+mGetActivity);
                    }
                    try{
                        getActivity().getResources().getString(R.string.app_name);
                    }catch (Exception e){
                        Log.w("yangsen","exception :getActivity()"+getActivity());
                    }
                    try{
                        secondActivity.getResources().getString(R.string.app_name);
                    }catch (Exception e){
                        Log.w("yangsen","exception :secondActivity"+secondActivity);
                    }
                    a++;
                    sleep();
                }
                Log.e("yangsen","over");
                Log.d("yangsen"," mContext:"+mContext);
                Log.d("yangsen", " AppContext:" + mAppContext);
                Log.d("yangsen", " secondActivity:" + secondActivity);
                Log.d("yangsen", " onDestroyed:" + secondActivity.isDestroyed());
                try{
                    mContext.getResources().getString(R.string.app_name);
                }catch (Exception e){
                    Log.w("yangsen"," exception :mContext"+mContext);
                }
                try{
                    mAppContext.getResources().getString(R.string.app_name);
                }catch (Exception e){
                    Log.w("yangsen"," exception :mAppContext"+mAppContext);
                }
                try{
                    secondActivity.getResources().getString(R.string.app_name);
                }catch (Exception e){
                    Log.w("yangsen"," exception :secondActivity"+secondActivity);
                }

            }
        }).start();

    }
    private void sleep() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f_second,container,false);
        initialize(view);
        return view;
    }

    private void initialize(View v) {

        button2 = (Button) v.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondActivity.finish();
            }
        });
    }
}
