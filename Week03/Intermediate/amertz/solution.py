def sum_list(list_one, list_two):
    list_one.append(0) if len(list_one) == 0 else list_one
    list_two.append(0) if len(list_two) == 0 else list_two
    string_one = ''.join(str(val) for val in list_one[::-1])
    string_two = ''.join(str(val) for val in list_two[::-1])
    total = str(int(string_one) + int(string_two))
    return [int(c) for c in total[::-1]]
