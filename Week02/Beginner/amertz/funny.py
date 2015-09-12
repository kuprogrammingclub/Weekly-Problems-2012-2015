def is_funny():
    s = input('Enter a string: ')
    r = s[::-1]
    for i in range(1, len(s)):
        if abs(ord(s[i]) - ord(s[i - 1])) != abs(ord(r[i]) - ord(r[i - 1])):
            return False
    return True

print("Funny" if is_funny() else "Not Funny")
