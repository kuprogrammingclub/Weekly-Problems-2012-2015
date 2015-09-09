while True:
    s = input('Enter a string: ')
    r = s[::-1]
    funny = True
    for i in range(1, len(s)):
        if abs(ord(s[i]) - ord(s[i - 1])) != abs(ord(r[i]) - ord(r[i - 1])):
            funny = False
            break
    print("Funny" if funny else "Not Funny")
