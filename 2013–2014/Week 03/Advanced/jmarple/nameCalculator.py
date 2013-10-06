with open("names.txt") as f:
    content = f.readlines()
names = content[0]
names = names.split('\",\"')
nameValues = []
names.sort()
nameVal = 0
totalVal = 0
for i in names:
	nameVal += 1 
	val = 0
	for j in i:
		val += ord(j)
	nameValues.append(val * nameVal)
	totalVal += (val * nameVal)
print nameValues
print "The total value is:"
print totalVal
