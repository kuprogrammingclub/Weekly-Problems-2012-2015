#Joshua Marple Feb. 2014
def funkyList(list, blockSize):
	for i in [list[i:i+blockSize] for i in range(0, len(list), blockSize)]:
		for j in i[::-1]:
			print(j,end=" ")
funkyList([1,2,3,4,5,6],2)