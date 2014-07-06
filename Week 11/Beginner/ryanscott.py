import time
anagram_set = set()

def perms(basestring, prefix=''):
	baselen = len(basestring)
	if baselen == 0 and prefix not in anagram_set:
		anagram_set.add(prefix)
		print(prefix)
	else:
		for i in range(0, baselen):
			perms(basestring[:i] + basestring[i+1:], prefix + basestring[i])

if __name__ == "__main__":
	start_time = time.time()
	perms('ryanscott')
	print('Took', time.time() - start_time, 'seconds!')