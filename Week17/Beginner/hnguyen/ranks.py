def ranks(scores):
    sort = sorted(list(set(scores)),reverse=True)
    dict = {}
    result = []
    for i in range(len(sort)):
        dict.update({sort[i]:(i+scores.count(sort[i-1]))})
    for i in range(len(scores)):
        result.append(dict.get(scores[i]))
    return result


    

