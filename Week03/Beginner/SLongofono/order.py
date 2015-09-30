import sys
import string

def reverse(s):
	s = s[::-1] #reverse, thanks Adam
	for i in range(len(s)):
		if(i==0):
			pass
		else:
			if(s[i]<s[i-1]):
				return False
	return True

word = sys.argv[1].lower()
for i in range(len(word)):
	if(i==0):
		pass
	else:
		if(word[i]<word[i-1]):
			print word + " NOT IN ORDER\n"
			sys.exit(0)
	if(reverse(word)):
		print word + " REVERSE ORDER\n"
		sys.exit(0)

print word + " IN ORDER\n"
