# Python 3, press Ctrl + Z to exit
while(True):
    number = input("Enter a number: ")
    total = 0

    for a in number:
        total += int(a)

    print("Sum of {0}: {1}".format(number, total))
