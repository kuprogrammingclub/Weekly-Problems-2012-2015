'''
rankings.py

Given a list of scores, return the list of ordered for each value in the list. The largest value
has rank 1, the second-largest value has rank 2, and so on. Ties should be handled by assigning
the same rank to all tied values.

Author: Stefan Mendoza
Date: 3 April 2015
'''

# Get user input
numbers = raw_input("Please enter a list of numbers, separated by spaces: ")
numbers = numbers.split()

# Cast the user input to a list of integers
for i in range(0, len(numbers)):
	numbers[i] = int(numbers[i])

# Sort the ranks from greatest to longest
ordered = numbers
ordered.sort()
ordered.reverse()

# Generates the list of ranks
'''
The trick here is that list.index(value) only gets the index of the first occurence of that
value in the list. So for [3, 3, 3, 3, 3, 5, 1], rank 2 will be printed out for every occurence
of 3 because the sorted (descending) list is [5, 3, 3, 3, 3, 3, 1]. Once it reaches 1 it will
print out rank 7 because the duplicate values have been accounted for.
'''
ranks = []
for i in range(0, len(numbers)):
	ranks.append(ordered.index(numbers[i]) + 1)

print "\nOriginal:", numbers
print "Ranks:   ", ranks, "\n"