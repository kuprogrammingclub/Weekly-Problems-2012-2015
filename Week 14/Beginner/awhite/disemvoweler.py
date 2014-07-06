if __name__ == '__main__':
	sentance = raw_input().replace(' ', '')
	vowles = ['a', 'e', 'i', 'o', 'u']
	line1 = [char for char in sentance if char not in vowles]
	line2 = [char for char in sentance if char in vowles]
	print ''.join(line1)
	print ''.join(line2)