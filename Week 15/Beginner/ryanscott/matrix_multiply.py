import sys

PATH = '/home/xnux/workspace/PySandbox/matrices.txt'

def read_matrices(path, times):
	matrices = []
	with open(path) as f:
		for _ in range(0, times):
			just_newlined = False
			just_added_int = False
			matrix = [[]]
			while True:
				c = f.read(1)
				if c == '\n':
					if just_newlined:
						matrices.append(matrix)
						break
					else:
						just_newlined = True
						just_added_int = False
				elif c == ' ':
					just_added_int = False
				elif c.isdigit():
					if just_newlined:
						matrix.append([])
					just_newlined = False
					if just_added_int:
						temp = matrix[-1].pop()
						matrix[-1].append(temp*10 + int(c))
					else:
						matrix[-1].append(int(c))
					just_added_int = True
				elif not c:
					matrices.append(matrix)
					break
	return matrices

def matrix_multiply(lmatrix, rmatrix):
	product = []
	indim = len(lmatrix[0])
	if indim != len(rmatrix):
		print('Error: mismatched matrix dimensions')
		sys.exit(1)
	else:
		for row in range(0, len(lmatrix)):
			product.append([])
			for col in range(0, len(rmatrix[0])):
				product[-1].append(sum([lmatrix[row][pos]*rmatrix[pos][col] for pos in range(0, indim)]))
	return product

if __name__ == '__main__':
	matrices = read_matrices(PATH, 2)
	for row in matrix_multiply(matrices[0], matrices[1]):
		print(row)