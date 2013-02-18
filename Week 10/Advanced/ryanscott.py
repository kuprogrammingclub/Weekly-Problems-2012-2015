import time
BASE64 = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+/'

def is_num_in_base_n(num, base_n):
    for digit in num:
        if BASE64.index(digit) > (base_n - 1):
            return False
    return True

def to_base_10(num, num_base):
    num_base_10 = 0
    power = len(num) - 1
    for digit in num:
        num_base_10 += BASE64.index(digit) * (num_base**power)
        power -= 1
    return num_base_10

def base_10_to_base_n(num_base_10, base_n):
    cur_num = num_base_10
    num_base_n = ''
    while cur_num > 0:
        num_base_n = BASE64[cur_num % base_n] + num_base_n
        cur_num = cur_num // base_n
    return num_base_n

if __name__ == "__main__":
    num = input('Enter number: ')
    base = int(input('Enter base: '))
    if is_num_in_base_n(num, base) and base >= 2 and base <= 64:
        start_time = time.time()
        num_base_10 = to_base_10(num, base)
        for b in range(2,65):
            if b == base:
                print('Base', str(b)+':', num)
            elif b == 10:
                print('Base', str(b)+':' ,num_base_10)
            else:
                print('Base', str(b)+':', base_10_to_base_n(num_base_10, b))
        print(time.time() - start_time, "seconds to complete!")
    else:
        print('Error: invalid input')