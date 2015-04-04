#	Takes in a string of DNA bases
#	Returns complement of bases
def DNA_Complement(a, b):
	#	Print values along way
	print('A: %s B: %s' % (a,b))
	#	If we have used all values
	if(len(a) == 0): return b
	#	Find complement values
	elif a[0] == 'A': b += 'T'
	elif a[0] == 'T': b += 'A'
	elif a[0] == 'G': b += 'C'
	elif a[0] == 'C': b += 'G'
	#	Pass rest of string onward
	return DNA_Complement(a[1:],b)

#	Get input and make upper case
input_strand = raw_input("Enter a DNA string: ")
input_strand = input_strand.upper()
#	Print back input
print("Input: %s\n" % input_strand)
#	Get output
output_strand = DNA_Complement(input_strand, '')
#	Print output
print("\nOutput: %s" % output_strand)