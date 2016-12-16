package com.ys.groovy.hah.com.ys.groovy

println "Hello Groovy"

def a = 1
def b = "im b"
def c = 2
def int d = 1
e = false
assert a == 1, "aaaaaaaaaa"
println binding.variables.c
//assert binding.variables.c ==2,"cccccccccc"
assert binding.variables.e == false, "ddddddddd"

//定义函数,参数类型可以不指定
String func(a, b) {
    //...
    return f2(a, b)
}

def f2(a, b) {
    println "f2---$a $b"
}

//funca()

f2 1, 2

println b.getClass()

//List
println "----List------"
def aList = [4, "ba", false]
println aList

aList[1] = 3

println aList
aList[10] = 10
println aList.size()

//map
println "----Map------"
def aMap = [i: 10, j: 11]
println aMap.x

def x = "xx"
def bMap = [x: 12, y: 13]
def cMap = [(x): 14, y: 15]
println bMap.x
println cMap.(xx)

aMap.i = 100
println aMap['i']

//Range
println "-----Rang-----"

def aRange = 1..5
println aRange

def bRange = "a"..<"c"
println bRange
println bRange.getFrom()
println bRange.to

//Closure
println "----Closure------"

def aClosure = {
    aa, bb ->
        "aclosure $a and $b"
}
aClosure 1, 2


def callAclosure(a, aClosure) {
    aClosure(a, a + 1)
}
//callAclosure(1{
//    println
//})
def bClosure = {
    it ->
        println "hello $it"
}
bClosure()

//def tClosure(a, b, ScriptGroup.Closure closure){
//    closure();
//}

//tClosure(1,2,{
//    println "tClosure call"
//})

//def test = new Test();

//test.tClosure(1,2{
//    println "ahahaha"
//})
def cloList = [1, 2, 3, 4, 5]

//com.ys.groovy.Test.tClosure(1,2,{
//    println "testC----"
//})
try {
    h = 9
    assert binding.variables.h == 9
} finally {

}
assert h == 9
assert binding.variables.h == 9


def w = 'coffee'
def f = {
    def z = 'tea'
    w + ' and ' + z //a refers to the variable a outside the closure,
    //and is remembered by the closure
}
println f()
//assert f() == 'coffee and tea'


t = {
    def u = {
        "milk"
    }
    u
}
q = t

assert t==q

v1 = t()
v2 = t()
assert  v1!=v2
println v1()
println v2()

def cc = {
    println it
}

cc('fuck')

def ccc = {
    def ddd = {
        it*3
    }
    ddd(it)*3
}
println ccc("ha")

it = 2

ee = {
    assert it == 3
    assert owner.it == 2
}
ee 3

def times = {
    x1 ->
        {
            y1->
                x1*y1
        }

}
println times(3)(4)

def runTwice = {
    a1
}