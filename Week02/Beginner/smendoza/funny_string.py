# funny_string.py
# Author: Stefan Mendoza
# Date: 7 September 2015
#
# Source: https://www.hackerrank.com/challenges/funny-string

import string

# Create a list from a string of all the alphabet
alphabet = list(string.ascii_lowercase)

# Remove any trailing whitespace
s = input("> ").strip().lower()

# Create a string that is the reverse of s
r = s[::-1]

funny = True
for i in range(1, len(s)):
    # list_name.index(value) retrieves the index of the value in list_name
    x = abs(alphabet.index(s[i]) - alphabet.index(s[i - 1]))
    y = abs(alphabet.index(r[i]) - alphabet.index(r[i - 1]))
    if(x != y):
        funny = False
        break

if funny:
	print("Funny")
else:
	print("Not funny")
