
# coding: utf-8

# In[38]:

import random
import numpy as np
wordsRDD = sc.textFile('enable1.txt', 4)
dif = input('Difficulty (1-5)? ')
words = map(lambda x: x.upper(), wordsRDD.filter(lambda x: len(x) == 4+11*(dif-1)//4).takeSample(False, 5+15*(dif-1)//4)) 
print '\n'.join(words)
correct = random.choice(words)
guess = ''
i = 4
while i > 0 and guess != correct:
    guess = raw_input('Guess (%s left)? ' % i).upper()
    if len(guess) != len(correct):
        print 'Not same length'
    elif guess in words:
        correct_letter = sum(1*(guess[x]==correct[x]) for x in range(0, len(correct)))
        print('%s/%s correct' % (correct_letter, len(correct)))
        i = i - 1
        if guess == correct:
            print 'You win!'
        elif i == 0:
            print 'You lose!'
    else:
        print 'Not in list'

