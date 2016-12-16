package com.ys.groovy


println "hhaah"
def runTwice = {
    a,c->
        c(c(a))
}

println runTwice(4,{it*3})
println runTwice (3) {it*3}

def f = {
    m,i,j->
        i+j+m.x+m.y
}
println f(1,x:3,3,y:2)

def g = {
    m,i,j,k,c->
        c(i+j+k,m.x+m.y)
}
println g(1,2,x:3,y:4,5){
    a,b->
        a*b
}
def e = {
    a,b,c=3,d='a'->
        "${a+b+c}$d"
}
println e(1,2)
println e(1,2,4)
println e(1,2,4,5)

println "---------"
def list=['a','b','g'] as Set
list.each{
    println it
}
list<<'e'
list<<'f'
list<<'c'

println "---------"

list.each{
    println it
}

def sb = new StringBuilder()
sb<<"I "
sb<<"am "
sb<<"a "
sb<<"b"
sb<<"o"
sb<<"y"
println sb


def cf = {
    arg,Object[] extras->
        def l= []
        l<<arg
        extras.each{
            l<<it
        }
        l
}
println cf(1)
println cf(1,2)
println cf(1,2,3)
println cf(1,2,3,4)

def df = {
    a,b,c->
        a+b+c
}
println df([1,2,3])

def ef = {
    a,b,c->
        "$a $b $c"
}
def eff = ef.curry('fly')
println eff("drive" ,"drive")

def efff = eff.curry('me')
def effff = ef.curry('fly')
println efff('walk')
println effff('me',"walk")

gcd = {
    m,n->
        m%n ==0?n:call(n,m%n)
}
println gcd(22,13)

def res = [];
{
    a,b->
        res<<a
        a<10&&call(b,a+b)
}(1,2)
println res


def file = new File("Test.groovy")
file.eachLine{
    println it
}
println file.getBytes()

def test = new Test();
test.tClosure("a","b"){
    a,b->
        println a*2+b*3
}
