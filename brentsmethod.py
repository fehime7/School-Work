#import error
from math import tan, cos

def rootsearch(f,a,b,dx):
    x1 = a; f1 = f(a)
    x2 = a + dx; f2 = f(x2)
    while f1*f2 > 0.0:
        if x1  >=  b: return None,None
        x1 = x2; f1 = f2
        x2 = x1 + dx; f2 = f(x2)
    else:
        return x1,x2

def brent(f,a,b,tol=1.0e-9):
    x1 = a; x2 = b;
    f1 = f(x1)
    if f1 == 0.0: return x1
    f2 = f(x2)
    if f2 == 0.0: return x2
#    if f1*f2 > 0.0: error.err("Root is not bracketed")
    x3 = 0.5*(a + b)
    for i in range(30):
        f3 = f(x3)
        if abs(f3) < tol: return x3
      # Tighten the brackets on the root
        if f1*f3 < 0.0: b = x3
        else: a = x3
        if (b - a) < tol*max(abs(b),1.0): return 0.5*(a + b)
      # Try quadratic interpolation
        denom = (f2 - f1)*(f3 - f1)*(f2 - f3)
        numer = x3*(f1 - f2)*(f2 - f3 + f1)       \
              + f2*x1*(f2 - f3) + f1*x2*(f3 - f1)
      # If division by zero, push x out of bounds
        try: dx = f3*numer/denom
        except ZeroDivisionError: dx = b - a
        x = x3 + dx
      # If iterpolation goes out of bounds, use bisection
        if (b - x)*(x - a) < 0.0:
            dx = 0.5*(b - a)
            x = a + dx
      # Let x3 <-- x & choose new x1 and x2 so that x1 < x3 < x2
        if x < x3:
            x2 = x3; f2 = f3
        else:
            x1 = x3; f1 = f3
        x3 = x
    print "Too many iterations in brent"


def f(x): return x - tan(x)
a,b,dx = (0.0, 20.0, 0.01)

print "The roots are for x - tan(x): "
while 1:
    x1,x2 = rootsearch(f,a,b,dx)
    if x1 != None:
        a = x2
        root = brent(f,x1,x2,tol=1.0e-9)
        if root != None: print root
    else:
        print "\nDone"
        break



def ff(x): return pow(x,3) - 10*pow(x,2) + 5
a,b,dx = (0.6, 0.8, 0.01)



print "The roots are for pow(x,3) - 10*pow(x,2) + 5= "
while 1:
    x1,x2 = rootsearch(ff,a,b,dx)
    if x1 != None:
        a = x2
        root = brent(ff,x1,x2,tol=1.0e-9)
        if root != None: print root
    else:
        print "\nDone"
        break



def fff(x): return x*abs(cos(x))-1

a,b,dx= (0.0, 4.0, 0.01)

print "The roots are for x*abs(cos(x))-1:  "
while 1:
    x1,x2 = rootsearch(fff,a,b,dx)
    if x1 != None:
        a = x2
        root = brent(fff,x1,x2,tol=1.0e-9)
        if root != None: print root
    else:
        print "\nDone"
        break
