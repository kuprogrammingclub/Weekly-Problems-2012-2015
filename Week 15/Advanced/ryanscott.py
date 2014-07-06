PATH = '/home/xnux/workspace/PySandbox/words.txt' # A ~4.7 MB file which I didn't upload
POINTS = {'a': 1, 'b': 3, 'c': 3, 'd': 2, 'e': 1, 'f': 4, 'g': 2, 'h': 4, 'i': 1, 'j': 8, 'k': 5, 'l': 1, 'm': 3,
		  'n': 1, 'o': 1, 'p': 3, 'q': 10, 'r': 1, 's': 1, 't': 1, 'u': 1, 'v': 4, 'w': 4, 'x': 8, 'y': 4, 'z': 10}
FREQS = {'a': 9, 'b': 2, 'c': 2, 'd': 4, 'e': 12, 'f': 2, 'g': 3, 'h': 2, 'i': 9, 'j': 1, 'k': 1, 'l': 4, 'm': 2,
		  'n': 6, 'o': 8, 'p': 2, 'q': 1, 'r': 6, 's': 4, 't': 6, 'u': 4, 'v': 2, 'w': 2, 'x': 1, 'y': 2, 'z': 1}

def best_words_and_scores(hand, dictionary):
	hand_freqs = dict()
	best_words = ['No best word']
	best_scores = [0]
	
	for char in hand.lower():
		if char in hand_freqs:
			hand_freqs[char] += 1
		else:
			hand_freqs[char] = 1
	
	for word in dictionary:
		score = 0
		word_freqs = dict()
		word_rejected = False
		for char in word.lower():
			if char not in hand_freqs:
				word_rejected = True
				break
			if char in word_freqs:
				word_freqs[char] += 1
			else:
				word_freqs[char] = 1
			if word_freqs[char] > FREQS[char] or \
			   word_freqs[char] > hand_freqs[char]:
				word_rejected = True
				break
			score += POINTS[char]
		if word_rejected:
			continue
		if best_scores == [0] or score > best_scores[0]:
			best_words = [word]
			best_scores = [score]
		elif score == best_scores[0]:
			best_words.append(word)
			best_scores.append(score)
	return best_words, best_scores

def open_dictionary(path):
	with open(path) as f:
		return f.read().splitlines()

if __name__ == '__main__':
	hand = input("What's your Scrabble hand? ")
	#all_tiles = ''
	#for letter in FREQS:
	#	for _ in range(0,FREQS[letter]):
	#		all_tiles += letter
	dictionary = open_dictionary(PATH)
	words, scores = best_words_and_scores(hand, dictionary)
	for word, score in zip(words, scores):
		print(word,score)