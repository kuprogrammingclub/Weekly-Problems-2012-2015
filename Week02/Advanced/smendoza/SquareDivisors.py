'''
SquareDivisors.py

@author Stefan Mendoza
@date 14 February 2015
'''

value = int(raw_input("> "))

divisors = []

for i in range(1, value + 1):
    if value % i == 0:
        divisors.append(i)

total = 0

print "o2(" + str(value) + ") =",
for i in divisors:
    total += i**2
    
    print i**2,
    
    if i != value:
        print "+",
    else:
        print "=", total