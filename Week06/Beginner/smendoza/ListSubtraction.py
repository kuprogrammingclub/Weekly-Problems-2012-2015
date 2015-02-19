#!/bin/python2

'''
ListSubtraction.py

Takes two user-inputted lists and removes all values from the first list that are
present in the second list.

@author Stefan Mendoza
@date 19 February 2015
'''

set1 = list(raw_input('Enter the first list: ').split())
set2 = list(raw_input('Enter the second list: ').split())

for i in set1:
    if i in set2:
        while i in set1:
            set1.remove(i)

for i in range(0, len(set1)):
    set1[i] = int(set1[i])

print set1