PATH = '/home/xnux/workspace/PySandbox/jabberwocky.txt'

'''All suffixes of the string, in sorted order'''
def sorted_suffixes(string):
	suffixes = []
	for i in range(0, len(string)):
		suffixes.append(string[i:])
	return sorted(suffixes)

'''Longest common prefix of str1 and str2'''
def lcp(str1, str2):
	for index, chrs in enumerate(zip(str1, str2)):
		if chrs[0] != chrs[1]:
			return str1[:index]
	return str1 if len(str1) == min(len(str1), len(str2)) else str2

'''Longest repeated substrings'''
def lrs(string):
	suffixes = sorted_suffixes(string)
	lrsubs = ['']
	for i in range(0, len(string)-1):
		prefix = lcp(suffixes[i], suffixes[i+1])
		if len(prefix) > len(lrsubs[0]):
			lrsubs = [prefix]
		elif len(prefix) == len(lrsubs[0]) and lrsubs[0] != '':
			lrsubs.append(prefix)
	return lrsubs

if __name__ == '__main__':
	string = input("What's your string? ")
	#string = ''
	#with open(PATH) as f:
	#	string = f.read().replace('\n', ' ')
	lrsubs = lrs(string)
	if lrsubs[0] == '':
		print('NoLongestRepeatedSubstringError')
	else:
		print(lrsubs)