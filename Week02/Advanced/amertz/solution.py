#   This program would likely be a good
#   candidate for multiprocessing


#   Highest n value
upper_bound = 100
#   List of perfect squares
s = []

#####################
#   Function defs   #
#####################

#   Takes integer n
#   finds the divisors
#   returns as list
def find_factors(n):
    factors = []
    x = n
    while(x != 0):
        #   is a factor
        if n % x == 0:
            factors.append(x)
            #   is a square
            if x * x == n:
                factors.append(x)
        x -= 1
    return factors

#   Takes integer n
#   Finds the sum of the squares
#   of the divisors of n
def sigma2(n):
    #   Get factors
    factors = find_factors(n)
    return sum(map(lambda x: x*x, factors))

#   Takes in a list of factors
#   returns True if perfect square exist
def is_sq(values):
    p_sq = False
    for a in range(len(values)):
        for b in range(a + 1, len(values)):
            if values[a] == values[b]:
                p_sq = True
                break
    return p_sq

#####################
#   Actual program  #
#####################
for x in range(1, upper_bound):
    #   Find the value
    val = sigma2(x)
    #   Find its factors
    f = find_factors(val)
    #   If it is a perfect square
    #   add it to list
    if(is_sq(f)): s.append(val)

#   Print the sum
print(sum(s))
