#	Get input and make uppercase
input_strand = raw_input("Enter a DNA string: ")
input_strand = input_strand.upper()
#	Print back input
print("Input: %s" % input_strand)
#	Create empty string
output_strand = ''
#	Find complements
for a in input_strand:
	if a == 'A': output_strand += 'T'
	elif a == 'T': output_strand += 'A'
	elif a == 'G': output_strand += 'C'
	elif a == 'C': output_strand += 'G'
	else: output_strand += a
#	Print results
print("Output: %s" % output_strand)