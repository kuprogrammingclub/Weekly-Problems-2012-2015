import time
PATH = '/home/xnux/workspace/PySandbox/PasswordSecurity_IN.txt'
VOWELS = {'a','e','i','o','u'}
CNSNTS = {'b','c','d','f','g','h','j','k','l','m',
		  'n','p','q','r','s','t','v','w','x','y','z'}

def has_vowel(word):
	for char in word:
		if char in VOWELS:
			return True
	return False

## Checks if word has three consecutive letters that are all vowels or all consonants
def has_consec_chars(word):
	for i, char in enumerate(word[:-2]): # Don't bother checking last two letters
		if (char in VOWELS and word[i+1] in VOWELS and word[i+2] in VOWELS) \
			or (char in CNSNTS and word[i+1] in CNSNTS and word[i+2] in CNSNTS):
			return True
	return False		 

## Checks if word has two consecutive identical letters (that aren't 'ee' or 'oo')
def has_char_run(word):
	for i, char in enumerate(word[:-1]):
		if char == 'e' or char == 'o':
			continue
		if char == word[i+1]:
			return True
	return False

if __name__ == "__main__":
	lines = []
	start_time = time.time()
	with open(PATH) as f:
		lines = f.read().splitlines()
	for line in lines[:lines.index('end')]: # Stop when 'end' is read from file
		cond = '' if (has_vowel(line) and not has_consec_chars(line)
			and not has_char_run(line)) else 'not '
		print('<'+line+'>','is ' + cond + 'acceptable.')
	print(time.time() - start_time, "seconds to complete!")