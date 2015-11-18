#
#
#	SLongofono	Week 05 Fall 2015	Intermediate
#
#	Write a Mastermind (tm) clone using strings instead of pegs.  The user will
#	be presented with a list of words, all of the same length.  They then guess
#	a word; if it is the chosen word, they win; if it is not correct, tell them
#	how many letters were in the correct position.  Keep track of tries (4 max).
#	Offer a more difficult mode with more words/more letters.
#
#
#


import os
import subprocess
import random
import sys

class Wordlist():
	def __init__(self, assetPath):
		self.sizes = []
		self.path = assetPath
		self.files = ["3words.txt","4words.txt", "5words.txt", "6words.txt", "7words.txt", "8words.txt", "9words.txt", "10words.txt"]
		
		#build metadata
		for i in self.files:
			x = subprocess.Popen(['wc', '-l', i], shell=False, stdout=subprocess.PIPE)
			y = x.communicate()[0]
			y = y.split(' ')
			y = y[0]
			self.sizes.append(int(y))
			
	#generates a random list given the size of words, number of words
	def getList(self, numWords, lenWords):
		if lenWords > 10:
			lenWords = 10
		result = []
		nums = [] #because enumerate and loop don't play nice
		file = open(self.files[lenWords-3], 'r')
		for i in range (numWords):
			nums.append(random.randint(1, self.sizes[lenWords-3]-1))
		for j, line in enumerate(file): #enumerate so we don't have to load the whole thing every time
			if j in nums:
				result.append(line.strip())
		return result
				
if __name__=="__main__":
	path = os.getcwd()
	words = Wordlist(path)
	os.system("clear")
	print "\n\n\t\t\t====================\n\t\t\t====================\n\t\t\t=====MasterMind=====\n\t\t\t====================\n\t\t\t====================\n\n"
		
	print "Rules:\tYou will be presented with a number of words.  Your goal is to guess the correct word.\n\tYou only get 4 tries per round, so choose wisely!\n\n"
	
	while(True):	
		x = 0
		while(x<1 or x>10):
			x = int(raw_input("Difficulty? (1-10):    "))
		if x == 1:
			q = words.getList(5,3)
		elif x == 2:
			q = words.getList(5,4)
		elif x == 3:
			q = words.getList(6,5)
		elif x == 4:
			q = words.getList(7,6)
		elif x == 5:
			q = words.getList(8,7)
		elif x == 6:
			q = words.getList(10,7)
		elif x == 7:
			q = words.getList(10,8)
		elif x == 8:
			q = words.getList(10,9)
		elif x == 9:
			q = words.getList(10,10)
		elif x == 10:
			q = words.getList(15,10)
		
		secret = q[random.randint(0, len(q)-1)]
		tries = 4
		win = False
		print "Here is your puzzle:\n\n"

		for i in q:
			print i

		while(tries > 0):
			guess = ''
			print "\n\n\nyou have ", tries, " tries left for this round."
			while(len(guess) < len(secret)):
				guess = raw_input("Enter your guess (must be the same length):\t")
			if guess == secret:
				tries = 0
				win = True
			else:
				tries = (tries - 1)
				count = 0
				for i in range(len(secret)):
					if secret[i]==guess[i]:
						count = count + 1
				print count, "/", len(secret), " were correct"
		if win:
			print "You win!\n\n"
		else:
			print "Can't win them all...\n\n"
		s = raw_input("Play again? (y/n)")
		if s.lower() != 'y':
			sys.exit(0)

