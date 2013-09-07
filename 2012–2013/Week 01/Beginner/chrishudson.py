#!/usr/bin/env python
"""
By starting with 1 and 2, the first 10 terms of the Fibonacci sequence will be
1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ... 

By considering the terms in the Fibonacci sequence whose values do not exceed
four million, find the sum of the even-valued terms.
"""

import math

def fib(n):
    """
    Return the n'th number in the Fibonacci sequence
    1-indexed.
    """
    if n == 0:
        return 0

    if n < 3:
        return 1

    return fib(n-1) + fib(n-2)

if __name__ == '__main__':
    sum = 0
    n = 3
    while(True):
        val = fib(n)
        if val > 4000000:
            break

        sum += val

        #Even numbers in the sequence occur every 3 steps
        n += 3
    print sum
