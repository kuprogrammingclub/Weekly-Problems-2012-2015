import math

if __name__ == '__main__':
    perfect_num = int(input())
    
    found = False
    
    for power in range(int(math.log(perfect_num, 2)), 1, -1):
        base = (perfect_num ** (float(1) / power))
        found = (base == int(base)) and (base != 1)
        if found:
            print '{0}^{1}={2}'.format(int(base), power, perfect_num)
            break
            
    if found == False: print '{0}^1={0}'.format(perfect_num)