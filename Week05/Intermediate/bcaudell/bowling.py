def score(balls):
	balls = balls.replace(' ', '') # remove spaces
	score = 0
	ball = 0
	
	for frame in range(10):
		if isGutterOrCount(balls[ball]):
			if isGutterOrCount(balls[ball+1]):
				score += count(balls[ball]) + count(balls[ball+1])
			elif isSpare(balls[ball+1]):
				score += 10 + count(balls[ball+2])
			ball += 2
		elif isStrike(balls[ball]):
			if not isSpare(balls[ball+2]):
				score += 10 + count(balls[ball+1]) + count(balls[ball+2])
			else:
				score += 20
			ball += 1
	return score
	
def isGutterOrCount(c):
	return c.isdigit() or c == '-'
	
def isSpare(c):
	return c == '/'

def isStrike(c):
	return c == "X"
	
def count(c):
	if c.isdigit():
		return int(c)
	elif c == '/' or c == 'X':
		return 10
	elif c == '-':
		return 0