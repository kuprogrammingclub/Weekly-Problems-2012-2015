def sum_list(list_one, list_two):
    if len(list_one) == 0:
        list_one.append(0)
    if len(list_two) == 0:
        list_two.append(0)
        
    list_one = list_one[::-1]
    list_two = list_two[::-1]
    string_one = ''.join(str(val) for val in list_one)
    string_two = ''.join(str(val) for val in list_two)
    total = str(int(string_one) + int(string_two))
    total = [int(c) for c in total]
    return total[::-1]
