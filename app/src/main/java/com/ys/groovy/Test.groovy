package com.ys.groovy

import groovy.lang.*

class Test{

    def x = 10

    def tClosure(String a,String b,Closure closure){
        println x
        println a+b
        closure(a,b)
    }


}