'''
WordWithEnemies.py

@author Stefan Mendoza
@date 13 February 2015
'''

str1, str2 = raw_input().split()

word1 = []
word2 = []
for i in str1:
    word1.append(i)

for i in str2:
    word2.append(i)

for i in range(0, max(len(str1), len(str2))):
    if word2.count(str1[i]) > 0:
        word1.remove(str1[i])
        word2.remove(str1[i])

if len(word1) > len(word2):
    print "\"" + "".join(word1) + "\" > \"" + "".join(word2) + "\""
    print "Left wins!"
elif len(word1) < len(word2):
    print "\"" + "".join(word1) + "\" < \"" + "".join(word2) + "\""
    print "Right wins!"
else:
    print "\"" + "".join(word1) + "\" = \"" + "".join(word2) + "\""
    print "Tie!"