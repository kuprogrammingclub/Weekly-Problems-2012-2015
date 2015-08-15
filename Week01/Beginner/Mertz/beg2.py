# Python 3, Press Ctrl + Z to exit

while(True):
    is_palindrome = True
    word = input("Enter a word: ").lower()
    reverse = word[::-1]

    for a in range(int(len(word)/2)):
        if word[a] != reverse[a]:
            is_palindrome = False
            break

    if is_palindrome:
        print("{0} is a palidrome".format(word))
    else:
        print("{0} is NOT a palidrome".format(word))
