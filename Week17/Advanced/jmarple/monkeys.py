import string
import random

alphabet = string.ascii_uppercase + " "
ref = "METHINKS IT IS LIKE A WEASEL"

## randomly generate a string of specified length
def random_gen_string(length):
    return_str = ""
    for _ in range(length):
        return_str = return_str + random.choice(alphabet)
    return return_str

## modify a previously given string
## each character has probability "prob" to be modified
def random_mod_string(string, prob):
    return_str = ""
    for i in string:
        if random.random() < prob:
            return_str = return_str + random.choice(alphabet)
        else:
            return_str = return_str + i
    return return_str

## determines how many characters two strings have in common
def num_in_common(a, b):
    common = 0
    for (x,y) in zip(a, b):
        if x == y:
            common += 1
    return common

## initialize strings
cur_string = random_gen_string(28)
list_of_strings = [cur_string for _ in range(100)]
cur_loop = 0


## iterate towards ref
while (num_in_common(ref, cur_string) < 28):
    for i in range(100):
        list_of_strings[i] = random_mod_string(cur_string, 0.05)
    closeness = [num_in_common(x, ref) for x in list_of_strings]
    max_val = max(closeness)
    max_index = closeness.index(max_val)
    cur_string = list_of_strings[max_index]
    print(cur_loop, cur_string)
    cur_loop += 1
        
        
    
