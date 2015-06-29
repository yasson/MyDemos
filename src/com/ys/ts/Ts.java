package com.ys.ts;

import java.util.ArrayList;

/**
 * Created by ys on 2015/2/28.
 */
public class Ts {
    public static void main(String[] args){
        ArrayList<String> arrayList=new ArrayList<String>();
        ArrayList<String> as=new ArrayList<String>();
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null);
        as.addAll(arrayList);
        int a=arrayList.size();
        System.out.print("size:"+a);
        System.out.print("size2:"+as);
    }
}
