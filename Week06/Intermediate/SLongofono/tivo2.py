#	SLongofono 	Week 06 Fall 2015	Intermediate
#
#	Part II - Optimized Tivo scheduler around a given condition
#
#	Write a program to schedule the maximum amount of shows
#	for recording, given that a certain show in the list must
#	be present.  Input is a single line with a show that must
#	be included, followed by the start time, end time, and the
#	name of each of the shows.  Each show will be on a new line.
#
#	Output should be a list of the shows recorded
#


import sys		

def Schedule(showDict, favShow):
	output = []
	min = 0
	max = showDict[favShow][0]

	#Fill in shows possible before favorite
	y = findBeforeTime(showDict, min, max)
	while len(y) > 0:
		output.append(y)
		min = showDict[y][1]
		max = showDict[favShow][0]
		showDict.pop(y)
		y = findBeforeTime(showDict, min, max)
	
	output.append(favShow)
	
	#Fill in anything else we can fit as before
	x = findAfterTime(showDict, showDict[favShow][1])
	showDict.pop(favShow)
	while len(x) > 0:
		output.append(x)
		minTime = showDict[x][1]
		showDict.pop(x)
		x = findAfterTime(showDict, minTime)
	return output	

#find the earliest entry at or beyond the time passed in
def findAfterTime(showDict, minTime):
	show = ""
	min = 2500
	for a,b in showDict.iteritems():
		if b[0] >= minTime and b[0] < min:
			min = b[0]
			show = a
	return show

#find the earliest entry at or beyond the minTime and
#ending at or before the maxTime
def findBeforeTime(showDict, minTime, maxTime):
	show = ""
	min = 2500
	max = 0
	for a,b in showDict.iteritems():
		if b[0] >= minTime and b[1] <= maxTime and b[0] < min:
			min = b[0]
			max = b[1]
			show = a
	return show
	
if len(sys.argv) < 2:
	print "Usage: python tivo2.py <input.txt>"
	exit(0)

#Build dictionary,  key : value ::  Show name : [start, end]
file = open(sys.argv[1], "r")
favShow = file.readline()
favShow = favShow.strip() + " "
temp = file.readline()
showDict = {}
while(temp):
	line = temp.split(' ')
	tempString = ""
	for i in range (2, len(line)):
		tempString = tempString + line[i].strip() + " "
	showDict[tempString] = [int(line[0]), int(line[1])]
	temp = file.readline()
file.close()

print Schedule(showDict, favShow)

