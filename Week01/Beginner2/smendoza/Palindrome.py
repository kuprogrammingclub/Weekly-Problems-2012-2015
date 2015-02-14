'''
Palindrome.py

@author Stefan Mendoza
@date 13 February 2015
'''

word = raw_input("> ")
word = list(word.lower())
print word

palindrome = True

if len(word)%2 == 0:
    cutoff = len(word)/2
else:
    cutoff = len(word)/2 + 1

for i in range(0, cutoff):
    if word[i] != word[(len(word) - 1) - i]:
        palindrome = False
        break

if palindrome:
    print "Palindrome"
else:
    print "Not a palindrome"