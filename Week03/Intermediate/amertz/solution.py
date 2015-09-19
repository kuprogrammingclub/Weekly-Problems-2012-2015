def sum_list(list_one, list_two):
    list_one.append(0) if not len(list_one) else list_one
    list_two.append(0) if not len(list_two) else list_two
    string_one = ''.join(str(val) for val in list_one[::-1])
    string_two = ''.join(str(val) for val in list_two[::-1])
    total = str(int(string_one) + int(string_two))
    return [int(c) for c in total[::-1]]
