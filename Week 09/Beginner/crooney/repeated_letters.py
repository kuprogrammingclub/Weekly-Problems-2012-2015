original = raw_input()

original = original.lower()

if original[0] == 'a':
    last_letter = 'b'
else:
    last_letter = 'a'
    
new = ""
removed = ""
for letter in original:
    if letter == last_letter:
        removed = removed + letter
    else:
        new = new + letter
    last_letter = letter

print new
print removed
