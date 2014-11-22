from copy import deepcopy

def north(loc):
	return [loc[0], loc[1]+1]
def south(loc):
	return [loc[0], loc[1]-1]
def east(loc):
	return [loc[0] + 1, loc[1]]
def west(loc):
	return [loc[0] - 1, loc[1]]

x = []
f = open('data.txt', 'r');
size = 0
for line in f:
	if size == 0:
		size = int(line)
	else:
		x.append(line)

visit = [[0 for i in range(0, size)] for j in range(0, size)]
solutions = []
visited_path = []

start = [-1,-1]
for i in range(0, len(x)):
	if (x[i].find('S')  == 1):
		start = [i, x[i].find('S')]

print(start)

def finder(path, visited, loc):
	npath = deepcopy(path)
	nvisited = deepcopy(visited)
	npath.append(loc)
	nvisited[loc[0]][loc[1]] = 1
	if (x[loc[0]][loc[1]] == '1'):
		solutions.append(path)
		visited_path.append(nvisited)
	else:
		if (north(loc)[1] >= 0 and north(loc)[1] < size and visited[north(loc)[0]][north(loc)[1]] == 0 and x[north(loc)[0]][north(loc)[1]] != '#'):
			finder(npath, nvisited, north(loc))
		if (south(loc)[1] >= 0 and south(loc)[1] < size and visited[south(loc)[0]][south(loc)[1]] == 0 and x[south(loc)[0]][south(loc)[1]] != '#'):
			finder(npath, nvisited, south(loc))
		if (east(loc)[0] >= 0 and east(loc)[0] < size and visited[east(loc)[0]][east(loc)[1]] == 0 and x[east(loc)[0]][east(loc)[1]] != '#'):
			finder(npath, nvisited, east(loc))
		if (west(loc)[0] >= 0 and west(loc)[0] < size and visited[west(loc)[0]][west(loc)[1]] == 0 and x[west(loc)[0]][west(loc)[1]] != '#'):
			finder(npath, nvisited, west(loc))

finder([], visit, start)

solution_len = [len(i) for i in solutions]

for i in visited_path[solution_len.index(min(solution_len))]:
	print(i)