package com.ys.ts;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * test
 * Created by ys on 2015/2/28.
 */
public class Ts {

    public static void main(String[] args){
//        test1();
//        test2();
        test3();
    }

    private  static void test3() {
        getNextHeartTime();
    }
    private static long getNextHeartTime() {
        Calendar scalendar = Calendar.getInstance();
        scalendar.setTimeInMillis(System.currentTimeMillis());
        String time = "201507312330";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        try {
            Date date = simpleDateFormat.parse(time);
            scalendar.setTime(date);
            scalendar.add(Calendar.HOUR_OF_DAY, 1);
            System.out.print("time :"+simpleDateFormat.format(scalendar.getTimeInMillis()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int h = scalendar.get(Calendar.HOUR_OF_DAY);

        if ( h != 23) {
            ++h;
        } else {
            int Max = 8;
            int Min = 17;
            h = (int) Math.round(Math.random() * (Max - Min) + Min);

            scalendar.add(Calendar.DATE, 1);
        }

        int Max = 1;
        int Min = 59;
        int m = (int) Math.round(Math.random() * (Max - Min) + Min);
        scalendar.set(Calendar.HOUR_OF_DAY, h);
        scalendar.set(Calendar.MINUTE, m);

        return scalendar.getTimeInMillis();
    }
    private static void test2() {
        Map<Integer,String> maps = new HashMap<>();
        maps.put(1,"1");
        maps.put(2,"2");
        maps.put(3,"3");
        String a = maps.get(1);
        a= "a";
        String b = maps.get(1);
        System.out.print("b="+b);
    }

    //    private static void test1() {
//        ArrayList<String> arrayList=new ArrayList<String>();
//        ArrayList<String> as=new ArrayList<String>();
//        arrayList.add(null);
//        arrayList.add(null);
//        arrayList.add(null);
//        as.addAll(arrayList);
//        int a=arrayList.size();
//        System.out.print("size:"+a);
//        System.out.print("size2:"+as);
//
//        Map<String,String> map =new HashMap<>();
//        map.put("s", "adsf");
//        for (String s : map.keySet()){
//            String a1 = map.get(s);
//        }
//        new Thread(() -> {
//
//        }).start();
//    }
}
