#	SLongofono	Week 06 Fall 2015	Intermediate
#
#	Part I - Optimized Tivo scheduler
#
#	Write a program to schedule the maximum amount of TV shows
#	for recording, given a newline-separated text input of start
#	time, end time, and the name of the show. Time is formatted in
#	military standard.
#
#	Output should be a list of the shows recorded.
#


import sys		

def optimalSchedule(showDict):
	output = []
	x = findAfterTime(showDict, 0)
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

if len(sys.argv) < 2:
	print "Usage: python tivo.py <input.txt>"
	exit(0)

#Build dictionary,  key : value ::  Show name : [start, end]
file = open(sys.argv[1], "r")
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


print optimalSchedule(showDict)

