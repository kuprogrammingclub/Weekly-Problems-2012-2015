input_strand = raw_input("Enter a DNA string: ")
input_strand = input_strand.upper()

print("Input: %s" % input_strand)

output_strand = ''
for a in input_strand:
	if a == 'A':
		output_strand += 'T'
	elif a == 'T':
		output_strand += 'A'
	elif a == 'G':
		output_strand += 'C'
	elif a == 'C':
		output_strand += 'G'
	else:
		output_strand += a

print("Output: %s" % output_strand)