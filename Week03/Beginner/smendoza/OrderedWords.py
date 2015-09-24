# OrderedWords.py
#
# Author: Stefan Mendoza
# Date: 23 September 23
# Email: stefanmendoza.dev@gmail.com

import string
import sys

# Reading from stdin
# Call with:
# > python OrderedWords.py < words.txt
for line in sys.stdin:
    # Remove the newline from every word and turn all letters to lowercase
    word = line.strip().lower()

    # If there is a character in the word that's not in the alphabet, break
    if set(word) - set(string.ascii_letters) != set([]):
        print("\"" + word + "\" is not a valid string.")
    else:
        # Turn the list of characters into a list of their corresponding ASCII
        # values
        ascii_values = [ord(c) for c in word]

        ordered = True
        orderReversed = True

        # Make sure the ASCII values in the list are ASCENDING
        for i in range(0, len(ascii_values) - 1):
            if(ascii_values[i] > ascii_values[i + 1]):
                ordered = False
                break

        # Similarly to checking whether the list is ordered, if the word isn't
        # ordered, verify that the ASCII values are DESCENDING
        if not ordered:
            for i in range(0, len(ascii_values) - 1):
                if(ascii_values[i] < ascii_values[i + 1]):
                    orderReversed = False
                    break

        print(word),
        if ordered:
            print("IN ORDER")
        elif orderReversed:
            print("REVERSE ORDER")
        else:
            print("NOT IN ORDER")
