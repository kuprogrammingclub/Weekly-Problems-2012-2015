import timeit

# calculates a fibonacci sequence (purportedly) without assignment using an updating dictionary
def fib(count, calced):
    if count in [0, 1]:
        return count
    elif count in calced:
        return calced[count]
    else:
        calced.update({count: fib(count - 2, calced) + fib(count - 1, calced)})
        return calced[count]
        
print(map((lambda x : fib(x, {})), range(20)))
print(timeit.timeit("fib(30, {})", number = 100, setup = "from __main__ import fib"))

# calculates a fibonacci sequence and truly does not use assignment
def less_cheating_fib(count):
    if count in [0,1]:
        return count
    else:
        return less_cheating_fib(count - 2) + less_cheating_fib(count - 1)

print(map((lambda x : less_cheating_fib(x)), range(20)))
print(timeit.timeit("less_cheating_fib(30)", number = 100, setup = "from __main__ import less_cheating_fib"))

# via Paul 
def constant_formula(count):
    return int(((((5)**(.5) + 1)*.5)**count - ((-((5)**(.5)) + 1)*.5)**count)/((5)**.5))
    
print(map((lambda x : constant_formula(x)), range(20)))
print(timeit.timeit("constant_formula(30)", number = 100, setup = "from __main__ import constant_formula"))
