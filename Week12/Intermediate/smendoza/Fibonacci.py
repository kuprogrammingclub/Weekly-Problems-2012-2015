'''
Fibonacci.def

Computes the fibonacci sequence up to the 1000th position.
Computing time is ~ 0.30 seconds

@author: Stefan Mendoza
@date: 8 February 2015
'''

import time

def fibonacci(prior, current, position, count):
    if position == 0:
        return 0
    elif position == 1 or position == count:
        return current
    else:
        return fibonacci(current, prior + current, position, count + 1)

start = time.clock()
for i in range(1, 1000):
	print "\n", i, ":"
	print fibonacci(0, 1, i, 1)
	print
print "\nComputing Time:", (time.clock() - start), "seconds"