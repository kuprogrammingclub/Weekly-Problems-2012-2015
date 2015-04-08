ranks = lambda scores : [sorted(set(scores), reverse = True).index(x) + 1 for x in scores]
