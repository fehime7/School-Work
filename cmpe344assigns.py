#!/usr/bin/python

from numpy import *
from math import tan

## module rootsearch

def rootsearch(f,a,b,dx):
    x1 = a; f1 = f(a)
    x2 = a + dx; f2 = f(x2)
    while f1*f2 > 0.0:
        if x1  >=  b: return None,None
        x1 = x2; f1 = f2
        x2 = x1 + dx; f2 = f(x2)
    else:
        return x1,x2

from math import log,ceil


def bisect(f,x1,x2,switch=0,epsilon=1.0e-9):
    f1 = f(x1)
    if f1 == 0.0: return x1
    f2 = f(x2)
    if f2 == 0.0: return x2

    n = ceil(log(abs(x2 - x1)/epsilon)/log(2.0))
    for i in arange(n):
        x3 = 0.5*(x1 + x2); f3 = f(x3)
        if (switch == 1) and (abs(f3) >abs(f1)) \
                         and (abs(f3) > abs(f2)):
            return None
        if f3 == 0.0: return x3
        if f2*f3 < 0.0:
            x1 = x3; f1 = f3
        else:
            x2 =x3; f2 = f3
    return (x1 + x2)/2.0

## example4_ 3

def f(x): return x - tan(x)

a,b,dx = (0.0, 20.0, 0.01)

print "The roots are for x - tan(x): "

while 1:
    x1,x2 = rootsearch(f,a,b,dx)
    if x1 != None:
        a = x2
        root = bisect(f,x1,x2,1)
        if root != None: print root
    else:
        print "\nDone"
        break

def ff(x): return pow(x,3) - 10*pow(x,2) + 5

a,b,dx = (0.6, 0.8, 0.01)

print "The roots are for:"

print "pow(x,3) - 10*pow(x,2) + 5"

while 1:
    x1,x2 = rootsearch(ff,a,b,dx)
    if x1 != None:
        a = x2
        root = bisect(ff,x1,x2,1)
        if root != None: print root
    else:
        print "\nDone"
        break

def fff(x): return x*abs(cos(x))-1

a,b,dx = (0.0, 4.0, 0.01)

print "The roots are x*abs(cos(x))-1 "

while 1:
    x1,x2 = rootsearch(fff,a,b,dx)
    if x1 != None:
        a = x2
        root = bisect(fff,x1,x2,1)
        if root != None: print root
    else:
        print "\nDone"
        break
