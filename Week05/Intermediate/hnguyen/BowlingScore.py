
# coding: utf-8

# In[47]:

s = raw_input('Input ')
s = "".join(s.split())
i = len(s) - 1
score = [0]*len(s)
raw_score = [0]*len(s)
while i >= 0:
    if s[i] == 'X':
        if i >= len(s) - 3:
            score[i] = 10
        else:
            score[i] = 10 + raw_score[i+1] + raw_score[i+2]
        raw_score[i] = 10
    elif s[i] == '/':
        if i >= len(s) - 3:
            score[i] = 10
        else:
            score[i] = 10 + raw_score[i+1]
        raw_score[i] = 10
        i = i - 1
    elif s[i] == '-':
        score[i] = 0
        raw_score[i] = 0
    else:
        score[i] = int (s[i])
        raw_score[i] = int (s[i])
    i = i - 1
print sum(score)

