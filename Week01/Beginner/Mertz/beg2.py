# Python 3, Press Ctrl + Z to exit

while(True):
    is_palindrome = True
    word = input("Enter a word: ").lower()
    reverse = word[::-1]

    for a, b in zip(word, reverse):
        if a != b:
            is_palindrome = False
            break

    if is_palindrome:
        print(word, "is a palindrome")
    else:
        print(word, "is NOT a palindrome")
