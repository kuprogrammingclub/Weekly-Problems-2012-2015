"""
Takes a file name as parameter
reads file and creates maze
"""
def read_maze(file_name):
  #Open file
  f = open(file_name, 'r')
  
  #Get Maze Data
  rows = int(f.readline())
  cols = int(f.readline())
  
  #Get Start positon
  start_row = int(f.readline())
  start_col = int(f.readline())
  
  #Create Maze
  m = [['x' for a in range(0, cols)] for b in range(0, rows)]
  
  #Iterate over rows
  for a in range(0, rows):
    #Get row
    row = f.readline()
    #Iterate over columns
    for b in range(0, cols):
      #Copy values into maze
      m[a][b] = row[b]
  
  #Close file
  f.close()
  
  return m, rows, cols, start_row, start_col

"""
Prints maze
"""
def print_maze(m, r, c):
  #Iterate over rows
  for a in range(0, r):
    for b in range(0, c):
      print m[a][b],
    print


"""
Position class
"""
class Position:
  #Member row and col
  def __init__(self, r, c):
    self.m_row = r
    self.m_col = c

"""
Maze Walker class
"""
class MazeWalker:
  def __init__(self, maze, startRow, startCol, rows, cols):
    self.startPos = Position(startRow, startCol)
    self.curPos = Position(startRow, startCol)
    self.m_rows = rows
    self.m_cols = cols
    self.m_visited = [[0 for a in range(0, cols)] for b in range(0, rows)]
    self.m_visited[startRow][startCol] = 1
    self.m_maze = maze
    self.m_stack = []
  
  
  def storeValidMoves(self):
    #Get current position
    row = self.curPos.m_row
    col = self.curPos.m_col
    #Look left
    if(col > 0):
      #See if it is a valid move
      if(self.m_maze[row][col - 1] != '#' and not self.m_visited[row][col - 1]):
	#Create new positon
	p = Position(row, col - 1)
	#Add to m_stack
	self.m_stack.append(p)
    #Look down
    if(row > 0):
      #See if it is valid move
      if(self.m_maze[row - 1][col] != '#' and not self.m_visited[row - 1][col]):
	#Create a new positon
	p = Position(row - 1, col)
	#Add to m_stack
	self.m_stack.append(p)
    #Look right
    if(col < self.m_cols - 1):
      #See if valid move
      if(self.m_maze[row][col + 1] != '#' and not self.m_visited[row][col + 1]):
	#Create a new positon
	p = Position(row, col + 1)
	#Add to stack
	self.m_stack.append(p)
    #Look up
    if(row < self.m_rows - 1):
      #See if valid move
      if(self.m_maze[row + 1][col] != '#' and not self.m_visited[row + 1][col]):
	#Create a new position
	p = Position(row + 1, col)
	#Add to stack
	self.m_stack.append(p)

  def isGoalReached(self):
    answer = False
    if(self.m_maze[self.curPos.m_row][self.curPos.m_col] == '1'):
      answer = True
    return answer
  
  def move(self):
    #Get move off stack
    p = self.m_stack.pop()
    row = p.m_row
    col = p.m_col
    
    #Mark as m_visited
    self.m_visited[row][col] = 1
    
    #Change current position
    self.curPos.m_row = row
    self.curPos.m_col = col
    
    print("Moving to: %s , %s" % (row + 1, col + 1))

  def walk(self):
    #Store initial moves
    self.storeValidMoves()
    
    #Walk maze till out of moves or exited
    while(len(self.m_stack) != 0 and not self.isGoalReached()):
      #Move
      self.move()
      #Store new moves
      self.storeValidMoves()
      #Print Maze
      print_maze(self.m_visited, self.m_rows, self.m_cols)
      print_maze(self.m_maze, self.m_rows, self.m_cols)

"""
Program
"""

#Get the Maze and info
maze, rows, cols, startRow, startCol = read_maze("Maze.txt")

#Create MazeWalker
Walker = MazeWalker(maze, startRow, startCol, rows, cols)

#Walk maze
Walker.walk()