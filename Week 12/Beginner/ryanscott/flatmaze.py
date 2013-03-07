PATH = '/home/xnux/workspace/PySandbox/flatmaze.txt'
shortest_paths = ()

def load_maze(path):
	maze = ['']
	start = ()
	x, y = 0, 0
	with open(path) as f:
		while True:
			c = f.read(1)
			
			if c == 'S':
				start = (x, y)
			
			if c == '\n':
				maze.append('')
				x = 0
				y += 1
			elif not c: #EOF
				break
			else:
				x += 1
				maze[y] += c
	return (maze, start)

def solve_maze(maze, x, y, length=1):
	if maze[y][x] == ' ':
		maze[y] = maze[y][:x] + '0' + maze[y][x+1:]
		length += 1
	elif maze[y][x] == 'X':
		global shortest_paths
		if not shortest_paths or length < shortest_paths[0]:
			shortest_paths = (length, list(maze))
		elif length == shortest_paths[0]:
			shortest_paths += (list(maze),)
		return
	
	dirs = [(y, x-1), (y, x+1), (y-1, x), (y+1, x)]
	for ydir, xdir in dirs:
		if maze[ydir][xdir] == ' ' or maze[ydir][xdir] == 'X':
			solve_maze(maze, xdir, ydir, length)
	
	maze[y] = maze[y][:x] + ' ' + maze[y][x+1:]
	
def find_shortest_path():
	print('Path' if len(shortest_paths) == 2 else 'Paths',
		'(' + str(len(shortest_paths) - 1) + ')',
		'of length', shortest_paths[0])
	for maze in shortest_paths[1:]:
		for line in maze:
			print(line)
		print()

if __name__ == '__main__':
	maze, start = load_maze(PATH)
	solve_maze(maze, start[0], start[1])
	find_shortest_path()
	