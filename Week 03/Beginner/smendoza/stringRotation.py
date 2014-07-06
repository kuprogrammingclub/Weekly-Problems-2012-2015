# File Name: stringRotation.py
# Author: Stefan Mendoza
# Contact: stefan.mendoza@ku.edu
# Description: Takes in user inputed text and rotates it so it's displayed vertically instead of horizontally
# Created: 3 January 2014
# Last Modified: 4 January 2014

# receives the value for how many columns there will be
columnQuantity = raw_input('Please enter the number of lines of text to be entered: ')
columnQuantity = int(columnQuantity)
print 'Please enter your', columnQuantity, 'lines of text, pressing Enter after each one:'

# formatting
print

# creates a list of [number of user inputed strings] empty strings
userStrings = [''] * columnQuantity

# adds each user inputed string to the userStrings list
for x in range(0, columnQuantity):
	userStrings[x] = raw_input()

# sets longest equal to the length of the longest string in the list
longest = 0
for x in range(0, len(userStrings)):
	if len(userStrings[x]) > longest:
		longest = len(userStrings[x])

# adds spaces to the end of all strings shorter than the longest so all strings are of equal length
for x in range(0, len(userStrings)):
	while len(userStrings[x]) < longest:
		userStrings[x] = userStrings[x] + ' '

# formatting
print

# creates a list containing each row to be printed
# each row in finalList represents the item in the same index[x] of every string
finalList = [''] * longest
for x in range(0, longest):
	for y in range(0, columnQuantity):
		finalList[x] = finalList[x] + userStrings[y][x]

# prints each row of finalList, which represents the same index[x] character of every string
for x in range(0, longest):
	print finalList[x]
	print ''