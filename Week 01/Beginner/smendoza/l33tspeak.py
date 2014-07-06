# File Name: l33tspeak.py
# Author: Stefan Mendoza
# Contact: stefan.mendoza@ku.edu
# Description: Takes in a string as input and replaces certain characters with their corresponding "1337" character.
# Created: 2 January 2014
# Last Modified: 3 January 2014

userInput = raw_input('Please enter your phrase to be 1337ified: ') # sets the phrase to be 1337ified as whatever string the user inputs
userInput_upper = userInput.upper() # creates an uppercase string of userInput

l33tDictionary = ['A', '4', 'E', '3', 'I', '!', 'O', '0', 'L', '1', 'T', '7'] # creates a "1337" dictionary for A, E, I, O, L, and T
l33tWord = '' # the final output is initialized as an empty string to be concatenated with slices of userInput and l33tdictionary


match = False # initially there is no match between the userInput and l33tDictionary
for x in range(0, len(userInput)):
	for y in range(0, len(l33tDictionary), 2): # increments through l33tDictionary by 2, so that only letters are checked
		
		# if userInput & l33tDictionary have a letter in common, the value after that letter in l33tDictionary is concatenated to l33tWord
		if userInput_upper[x] == l33tDictionary[y]:
			l33tWord = l33tWord + l33tDictionary[y+1]
			match = True # certifies that there was a match between the two strings
	
	# if there wasn't a match, the current letter in userInput is concatenated to l33tWord
	if match == False:
		l33tWord = l33tWord + userInput[x]
	match = False # match is reset back to false before userInput goes to the next letter

# prints the 1337ified phrase
print '\nYour 1337ified phrase is:'
print l33tWord