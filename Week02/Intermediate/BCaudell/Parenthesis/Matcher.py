class Matcher(object):
	validPairs = [('(', ')'),( '{','}'),('[', ']')]

	def isMatching(str):
		if Matcher.isNullString(str):
			return True
		else:
			try:
				return Matcher.substringsMatching(str)
			except UnmatchedException as e:
				return False
		
	def isNullString(str):
		return str == ""
		
	def isOddLength(str):
		return len(str) % 2 == 1
		
	def substringsMatching(str):
		substrings = []
		openIndex = None
		nestedCount = 0
		for i in range(len(str)):
			if Matcher.isOpening(str[i]):
				if openIndex == None:
					openIndex = i
				elif str[openIndex] == str[i]:
					nestedCount += 1
			elif openIndex != None and Matcher.isClosing(str[i]) and Matcher.isPair(str, openIndex, i):
				if nestedCount == 0:
					substrings.append(str[openIndex+1:i]) #don't include the braces in the substring
					openIndex = None
				else:
					nestedCount -= 1
		if openIndex != None:
			raise UnmatchedException
		elif len(substrings) > 0:
			return Matcher.checkSubstrings(substrings)
		else:
			return True
			
	def isOpening(char):
		for (open, close) in Matcher.validPairs:
			if open == char:
				return True
		return False
		
	def isClosing(char):
		for (open, close) in Matcher.validPairs:
			if close == char:
				return True
		return False
		
	def isPair(str, openIndex, closeIndex):
		for (open, close) in Matcher.validPairs:
			if open == str[openIndex] and close == str[closeIndex]:
				return True
		return False
		
	def checkSubstrings(substrings):
		for str in substrings:
			if not Matcher.isMatching(str):
				return False
		return True
		
class UnmatchedException(Exception):
	pass