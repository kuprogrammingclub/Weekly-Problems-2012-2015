import string

def shifter(letter, index):
    chars = string.ascii_lowercase
    return chars[(chars.index(letter) + index) % len(chars)] #sure hope its 26, but future proofing it regardless

test_list = [ ('a', 2),
              ('b', 5),
              ('z', -1) ]
print([shifter(x, y) for x, y in test_list])
