import random
import string

#   String to be compared to
test_string = 'METHINKS IT IS LIKE A WEASEL'
string_length = len(test_string)
#   Set of characters that can be randomly chosen
#   to replace a character in the string from
characters = string.ascii_uppercase + string.whitespace
#   Score stats
high_score = 0
high_score_index = 0
count = 0

#   Generates a random string of characters
#   of length in
def random_string(char, n):
    #   Generate a random string
    return ''.join(random.SystemRandom().choice(char) for x in range(n))

#   Create a random string
rando_string = random_string(characters, string_length)

#   Loop until found
while(high_score != string_length):

    #   Make 100 copies
    _100_copies = [rando_string for x in range(0 , 100)]

    #   Initialize an empty score list
    string_score = [0 for x in range(0, 100)]

    #   Replace characters
    for a in range(0, len(_100_copies)):
        for b in range(0, string_length):
            #   Roll dice
            if(random.randint(1,20) == 1):
                #   Get a random character
                c = random.SystemRandom().choice(characters)
                #   Replace value
                _100_copies[a] = _100_copies[a][:b] + c + _100_copies[a][b+1:]

    #    Score each string
    high_score = 0
    high_score_index = 0
    for a in range(0, len(_100_copies)):
        for b in range(0, string_length):
            if(_100_copies[a][b] == test_string[b]):
                string_score[a] += 1

        #   Get high score
        if(string_score[a] > high_score):
            high_score = string_score[a]
            high_score_index = a
            #   Exit if perfect
            if(high_score == string_length):
                break

    #   Print results
    print("High score: %s" % high_score)
    print("String: %s" % _100_copies[high_score_index])

    #   Reassign random string
    rando_string = _100_copies[high_score_index]
    count += 1
    #   End while loop

#   Output count
print("Count: %s" % count)
