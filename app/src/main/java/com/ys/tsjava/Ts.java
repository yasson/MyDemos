package com.ys.tsjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * test
 * Created by ys on 2015/2/28.
 */
public class Ts {

    interface A {
        String a = "a";

        void a();

    }
    interface B {
        String b = "b";

        void a();
    }

    interface C extends A, B {

    }

    static class D implements C {
        public D() throws Exception {
            throw new Exception();
        }
        @Override
        public void a() {
            StringBuilder sb = new StringBuilder();
            sb.reverse();
            char[] chars = b.toCharArray();
            System.out.print(A.a);
        }
    }

    static class E {
        void dos(){
            try {
                D d = new D();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        new D().a();
//            tetst6();
//        testNo();
//        testVolatile();
        long l = System.currentTimeMillis();
        testf1();
        println("1111----"+String.valueOf(System.currentTimeMillis()-l));
        long l1 = System.currentTimeMillis();
        testf2();
        println("222-----"+String.valueOf(System.currentTimeMillis()-l1));

    }



    public static void println(Object o){
        System.out.println(o.toString());
    }

    static int f(int n)

    {

        if(n<=1)

        {

            return 1;

        }

        return  f(n-1) + f(n-2);

    }
    static int count = 43;

   static void testf1()

    {

        int result;

        int i;

        for(i=0; i < count; i++)

        {

            result = f(i);

            print(result);

        }

    }
    static int[] arr=new int[count];

    static int f2(int n)

    {

        int result;

        if(n <= 1)

        {

            result = 1;

        }

        else

        {

            result = arr[n-1] + arr[n-2];

        }

        arr[n] = result;

        return result;

    }
    static void testf2()

    {

        int result;

        int i;

        for(i=0; i < count; i++)

        {

            result = f2(i);

            print(result);

        }

    }

    private static void print(int result) {
        System.out.print(result);
    }

    private static void printf(String s, int result) {
        System.out.printf(s,result);
    }


    private static void testNo() {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

    private static void testVolatile() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (a<10){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a++;
                                    System.out.println("a"+a);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (a<10){
                    try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    System.out.println("b"+a);
                }
            }
        }).start();
    }
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    static volatile int a;

    private static void tetst6() {
        String a = "abcde";
        String as = a.substring(a.indexOf('c'));
        System.out.print(as);
    }


    private static void test5() {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 6) {
                    i++;
                    synchronized (lock) {
                        System.out.print("1\n");
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 6) {
                    i++;
                    synchronized (lock) {
                        System.out.print("2\n");
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    private static void test4() {
        String a = (String) null;
        System.out.print(a + "1");
    }

    private static void test3() {
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
            System.out.print("time :" + simpleDateFormat.format(scalendar.getTimeInMillis()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int h = scalendar.get(Calendar.HOUR_OF_DAY);

        if (h != 23) {
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
        Map<Integer, String> maps = new HashMap<>();
        maps.put(1, "1");
        maps.put(2, "2");
        maps.put(3, "3");
        String a = maps.get(1);
        a = "a";
        String b = maps.get(1);
        System.out.print("b=" + b);
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
