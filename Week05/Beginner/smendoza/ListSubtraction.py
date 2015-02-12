'''
ListSubtraction.py

@author Stefan Mendoza
@date 11 February 2015
'''

set1 = input('Enter the first list: ')
set2 = input('Enter the second list: ')

# While the value x in set2 can be found in set1, removes x until
# x can no longer be found in set1
for x in set2:
	if set1.count(x) > 0:
		while set1.count(x) > 0:
			set1.remove(x)

print set1