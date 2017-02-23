package com.ys.tsjava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nufeng on 2017/2/21.
 */

public class Test {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Test test = new Test();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                }
            };
            ts.add(t);
            t.start();
        }
        for (Thread t :  ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

//        while (Thread.activeCount() == 1)  //保证前面的线程都执行完
//            Thread.yield();
        System.out.println(test.inc);
    }
}
