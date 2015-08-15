import sys
num = str(2**int(sys.argv[1]))
print "Sum of digits:"
result = 0
for i in num:
	result = result + int(i)
print result
