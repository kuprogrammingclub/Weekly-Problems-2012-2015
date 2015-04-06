#   This program would likely be a good
#   candidate for multiprocessing
from multiprocessing import Pool

#   Highest n value
upper_bound = 64000000

#####################
#   Function defs   #
#####################

#   Takes integer n
#   finds the divisors
#   returns as list
def find_factors(n):
    factors = []
    for x in range(1, n + 1):
        #   is a factor
        if n % x == 0:
            factors.append(x)
            #   is a square
            if x * x == n:
                factors.append(x)
    return factors

#   Takes integer n
#   returns the sum of the squares
#   of the divisors of n
def sigma2(n):
    return sum(map(lambda x: x*x, find_factors(n)))

'''
Not sure this is part of the actual solution
'''
#vals = [x for x in range(upper_bound)]

#   Takes in a list of factors
#   returns True if perfect square exist
def is_sq(values):
    for a in range(len(values)):
        for b in range(a + 1, len(values)):
            #   Perfect square exist
            if values[a] == values[b]: return True
    return False

#   Function to be used for
#   multi processing
def f(x):
    #   List of perfect squares
    s = []
    #   Find the value
    val = sigma2(x)
    #   Find its factors
    f = find_factors(val)
    #   If it is a perfect square
    #   add it to list
    if(is_sq(f)): s.append(val)
    return sum(s)

'''
'''

#####################
#   Actual program  #
#####################
'''
s = []
for x in range(1, upper_bound):
    #   Find the value
    val = sigma2(x)
    #   Find factors of val
    f = find_factors(val)
    #   If val is a perfect square
    #   add it to list
    if(is_sq(f)): s.append(val)

print(sum(s))
'''

print(sigma2(upper_bound))
