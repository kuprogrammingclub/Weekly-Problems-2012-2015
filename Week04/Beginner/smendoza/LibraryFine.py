'''
LibraryFine.py

Author: Stefan Mendoza
Date:   4 October 2015
Email:  stefanmendoza.dev@gmail.com
'''

import sys
from datetime import *

actual = sys.stdin.readline().split()
expected = sys.stdin.readline().split()

actual = list(map(lambda s: int(s), actual))
expected = list(map(lambda s: int(s), expected))

actual = date(actual[2], actual[1], actual[0])
expected = date(expected[2], expected[1], expected[0])

if (actual - expected).days <= 0:
    print(0)
elif actual.year > expected.year:
    print(10000)
elif actual.month == expected.month and actual.year == expected.year:
    print( ((actual - expected).days) * 15)
else:
    print( (actual.month - expected.month) * 500)
