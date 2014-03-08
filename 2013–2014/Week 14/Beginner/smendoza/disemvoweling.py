#  Program: disemvoweling.py
#  Author: Stefan Mendoza
#  Description: Removes all vowels and spaces from user-inputed text, then prints out
#				both the disemvoweled text and the vowels that were removed
#  Date Changed: 4 March 2014

# creates a list from the user's input
# creates lists for the final, disemvoweled text and the vowels that are removed
userText = list(raw_input("\nEnter text: \n"));
disemvoweledList = []
vowelList = []

# checks to see if the item at index i is a vowel or space
# appends the vowels to vowelList and anything that's not a vowel/space to disemvoweledList
for i in range(0, len(userText)):
	if userText[i] in ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']:
		vowelList += userText[i]
	elif userText[i] != ' ':
		disemvoweledList += userText[i]

print "\nThe disemvoweled text is: \n" + ''.join(disemvoweledList)
print "\nThe vowels removed were: \n" + ''.join(vowelList) + "\n"