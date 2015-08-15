import sys
word = sys.argv[1].lower()
result = True

for i in range (0, int(len(word)/2)):
    if word[i] != word[-(i+1)]:
       print word[i] + " does not equal " + word[-(i+1)]
       result = False
	   
if result:
	print "yup"
else:
	print "nope"
