import copy
PATH = '/home/xnux/workspace/PySandbox/laddermaze.txt'
shortest_paths = ()

def load_maze(path):
	maze, floor = [], ['']
	start = ()
	x, y, z = 0, 0, 0
	just_newlined = False
	with open(path) as f:
		while True:
			c = f.read(1)
			
			if c == 'S':
				start = (x, y, z)
			
			if c == '\n':
				if just_newlined:
					maze.append(floor)
					floor = ['']
					x, y = 0, 0
					z += 1
					just_newlined = False
				else:
					just_newlined = True
					floor.append('')
					x = 0
					y += 1
			elif not c: #EOF
				maze.append(floor)
				break
			else:
				just_newlined = False
				x += 1
				floor[y] += c
	return (maze, start)

def solve_maze(maze, x, y, z, length=1, just_climbed=False):
	
	if maze[z][y][x] == ' ':
		maze[z][y] = maze[z][y][:x] + '0' + maze[z][y][x+1:]
		length += 1
	elif maze[z][y][x] == 'X':
		global shortest_paths
		if not shortest_paths or length < shortest_paths[0]:
			shortest_paths = (length, copy.deepcopy(maze))
		elif length == shortest_paths[0]:
			shortest_paths += (copy.deepcopy(maze),)
		return
	elif maze[z][y][x] == '#' and not just_climbed:
		for level, floor in enumerate(maze):
			if level != z and floor[y][x] == '#':
				length += 1
				maze[z][y] = maze[z][y][:x] + '$' + maze[z][y][x+1:]
				solve_maze(maze, x, y, level, length, True)
	elif maze[z][y][x] == '#' and just_climbed:
		length += 1
		maze[z][y] = maze[z][y][:x] + '$' + maze[z][y][x+1:]
	
	dirs = [(y, x-1), (y, x+1), (y-1, x), (y+1, x)]
	for ydir, xdir in dirs:
		if maze[z][ydir][xdir] == ' ' \
				or maze[z][ydir][xdir] == 'X' \
				or maze[z][ydir][xdir] == '#':
			solve_maze(maze, xdir, ydir, z, length)
	
	if maze[z][y][x] == '$':
		maze[z][y] = maze[z][y][:x] + '#' + maze[z][y][x+1:]
	else:
		maze[z][y] = maze[z][y][:x] + ' ' + maze[z][y][x+1:]
	
def find_shortest_path():
	print('Path' if len(shortest_paths) == 2 else 'Paths',
		'(' + str(len(shortest_paths) - 1) + ')',
		'of length', shortest_paths[0])
	for maze in shortest_paths[1:]:
		for floor in maze:
			for line in floor:
				print(line)
		print('-----------')

if __name__ == '__main__':
	maze, start = load_maze(PATH)
	solve_maze(maze, start[0], start[1], start[2])
	find_shortest_path()
	