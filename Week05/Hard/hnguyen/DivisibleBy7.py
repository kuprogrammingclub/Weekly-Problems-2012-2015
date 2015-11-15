
# coding: utf-8

# In[19]:

import math
class Memoize:
    def __init__(self, f):
        self.f = f
        self.memo = {}
    def __call__(self, *args):
        if not args in self.memo:
            self.memo[args] = self.f(*args)
        return self.memo[args]
def alpha(N, x, i):
    return (x - 10**N*i) % 7
def beta(N, y, i):
    return (2*i + 5*y) % 7
def F(m, n, x, y):
    if m == 0:
        N = int (math.log10(n)) - 1
        if N != 0:
            return sum(F(j*10**N, (j+1)*10**N, x, y) for j in range(0, 10))
        else:
            if x != y:
                return 0
            else:
                return sum(1 for j in range(0, 10) if j % 7 == x)     
    else:
        N = int (math.log10(m))        
        i = m/(10**N)
        return F(0, 10**N, alpha(N, x, i), beta(N, y, i))
def G(m, n, x, y):
    if m == 0:
        N = int (math.log10(n)) - 1
        if N != 0:
            return sum(G(j*10**N, (j+1)*10**N, x, y) for j in range(0, 10))
        else:
            if x != y:
                return 0
            else:
                return sum(j for j in range(0, 10) if j % 7 == x) 
    else:
        N = int (math.log10(m))        
        i = m/(10**N)
        return F(0, 10**N, alpha(N, x, i), beta(N, y, i))*m + G(0, 10**N, alpha(N, x, i), beta(N, y, i))
def div(n):
    return G(0, 10**n, 0, 0)
F = Memoize(F)
G = Memoize(G)
div(100)

