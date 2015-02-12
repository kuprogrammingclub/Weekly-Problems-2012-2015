'''
ASCIITree.py
Purpose: Takes in three values initially:
		 - An odd integer representing the amount of leaves at the final depth
		 - A character (in String form) representing the leaf
		 - A character (in String form) representing the trunk
		 Prints a centered tree using these characters beginning at 1 leaf,
		 iterating by an odd number of leafs until the final depth. The trunk
		 is always three characters.

@author Stefan Mendoza
@date 11 February 2015
'''

finalDepthCount, trunk, leaf = raw_input('> ').split()
finalDepthCount = int(finalDepthCount)

print
for i in range(1, finalDepthCount + 4, 2):
	if i < finalDepthCount:
		spaceCount = (finalDepthCount - i)/2
		print ' ' * (spaceCount - 1), leaf * i, ' ' * (spaceCount - 1)
	elif i == finalDepthCount:
		print leaf * finalDepthCount
	else:
		spaceCount = (finalDepthCount - 3)/2
		print ' ' * (spaceCount - 1), trunk * 3, ' ' * (spaceCount - 1)
print