def paren_counter(input):
    paren_count = {'c_bracket':0, 'brace':0, 'paren':0}
    paren_dict = { "{": ('c_bracket', 1), "}":('c_bracket', -1), "[":('brace', 1),
                   "]":('brace', -1), "(": ('paren', 1), ")":('paren', -1)}

    for i in input:
        paren_count[paren_dict[i][0]] += paren_dict[i][1]
        if paren_count[paren_dict[i][0]] < 0:
            return False

    return not(any([i for _, i in paren_count.iteritems()]))

print paren_counter("{[]}")
print paren_counter("{{[[((")
print paren_counter("")
print paren_counter("}}]][[{{")
print paren_counter("((()))()(())")
print paren_counter("([)]")


