import itertools
import sys

cache = {}

def parts(min_part, num):
	if min_part > num:
		return 0
	elif min_part == num:
		return 1
	elif (min_part, num) in cache:
		return cache[(min_part, num)]
	else:
		num_parts = parts(min_part + 1, num) + parts(min_part, num - min_part)
		cache[(min_part, num)] = num_parts
		return num_parts
	
if __name__ == '__main__':
	sys.setrecursionlimit(10000) #We're going to need to recurse A LOT in this problem. Recursion immersion, if you will.
	print('Dissecting numbers. Please wait...')
	for n in itertools.count(1):
		num_parts = parts(1, n)
		if num_parts % 99900 == 0: #Warning: don't go above this number if you value your time.
			print('DONE!', 'p(' + str(n) + ') =',num_parts)
			break