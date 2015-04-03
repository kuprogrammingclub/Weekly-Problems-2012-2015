#	Values to test
values = [-2, -5, 6, -2, -3, 1, 5, -6]
#	Get initial sum and assume it is the max
sublist_max = sum(values)
#	Get inital max sub list
max_list = values

#	Iterate over list
for a in range(len(values)):
	#	Reset sum
	s = 0
	#	Iterate over rest of list
	for b in range(a, len(values)):
		#	Increment sum
		s += values[b]
		#	Test for new max
		if s > sublist_max:
			#	Reassign max values
			sublist_max = s
			max_list = values[a:b + 1]

#	Print results
print('Sublist: %s Sum: %s' % (max_list, sublist_max))