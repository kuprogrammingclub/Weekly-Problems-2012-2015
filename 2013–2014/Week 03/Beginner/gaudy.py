"""
Input: File of horizontal words given as command line argument
Output: Same words written vertically like we were reading gaudy
Vegas signs
"""

import sys
vegas = []

def main(fileName):
    # Read dem files, tokenize dem words
    for line in open(fileName, 'r'):
        vegas.append(list(line.strip())) 

    # Dat array be jagged, take it to the dentist
    size = len(max(vegas, key=len))
    for entry in range(0, len(vegas)): 
        if (len(vegas[entry]) < size):
            vegas[entry] = vegas[entry] + [' '] * (size - len(vegas[entry]))
    
    # Print dem words like you transposed dat matrix
    for i in range(0, size):
        for j in range(0, len(vegas)):
            print(vegas[j][i], end='')
        print()

if __name__ == "__main__":
    main(sys.argv[1])
