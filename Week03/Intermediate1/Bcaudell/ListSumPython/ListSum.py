def sumLists(a, b):
	#ensure the lists are the same length
	while len(a) < len(b):
		a.append(0)
	while len(b) < len(a):
		b.append(0)

	carry = 0
	output = []
	for x, y in zip(a,b):
		sum = x + y + carry
		output.append((sum) % 10)
		carry = (sum - output[-1]) / 10
	if carry > 0 or len(output) == 0:
		output.append(carry)
		
	return output