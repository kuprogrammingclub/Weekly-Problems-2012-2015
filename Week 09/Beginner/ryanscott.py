import random
import time
PATHNAME = '/home/xnux/workspace/PySandbox/perfection_IN.txt'
PERFECT = 'PERFECT'
DEFICIENT = 'DEFICIENT'
ABUNDANT = 'ABUNDANT'
divisors_map = {1: DEFICIENT} # 1 has no proper divisors

'''
Returns a set of proper divisors of num
'''
def proper_divisors(num):
    proper_divisors = {1} # Except for 1, but num_property guards against this
    for divisor in range(2, (num//2)+1): # There's no point in going past half the value of num, since they can't evenly divide num
        if num%divisor == 0:
            proper_divisors.add(divisor)
    return proper_divisors

'''
Returns a string describing the "perfection" of num
'''
def num_property(num):
    if num in divisors_map: # Easy way to access already-checked numbers
        return divisors_map.get(num)
    divisor_sum = sum(proper_divisors(num))
    if divisor_sum == num:
        divisors_map.update({num: PERFECT}) # Save tons of time by adding each number's property to a dictionary
        return PERFECT
    elif divisor_sum < num:
        divisors_map.update({num: DEFICIENT})
        return DEFICIENT
    else:
        divisors_map.update({num: ABUNDANT})
        return ABUNDANT

if __name__ == "__main__":
    print('Generating random numbers, please wait...')
    # Generate ONE MILLION NUMBERS, YO (increase the randrange at your own risk)
    # If the max is 60,000, it takes about 150 seconds.
    rand_nums = [random.randrange(1,30001) for i in range(1,1000001)]
    print('PERFECTION OUTPUT')
    start_time = time.time()
    for index, rand_num in enumerate(rand_nums, 1): # Start index at 1
        print('Number', str(index) + ':', rand_num, num_property(rand_num))
    print('END OF OUTPUT')
    print(time.time() - start_time, "seconds to complete!")
