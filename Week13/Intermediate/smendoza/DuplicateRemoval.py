'''
DuplicateRemoval.py

@author Stefan Mendoza
@date 13 February 2015
'''

import time

word = raw_input("> ")
newWord = []

start = time.clock()
for i in word:
    if newWord.count(i) == 0:
        newWord.append(i)
end = time.clock() - start
print "\n", "".join(newWord)
print "Computing Time:", end, "seconds"