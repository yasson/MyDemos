package com.ys.ts.fuck_money.api;

import android.widget.Toast;

import com.ys.core.AppInstance;
import com.ys.ts.utils.L;
import com.ys.ts.utils.T;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络请求接口封装
 * Created by nufeng on 12/29/16.
 */

public class FuckMoneyApi {
    public static final String API_IP = "http://127.0.0.1:63343";
    public static final String API_GET_INDEX = API_IP+"/FuckMoney/index.php";

    public static void setApiGetIndex(){
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(API_GET_INDEX).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                L.d(e.toString());
                T.show(e.toString());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                L.d(response.body().string());
                T.show(response.body().string());
            }
        });
//        try {
//            Response response = client.newCall(request).execute();
//            return response.body().toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "";
    }

}
