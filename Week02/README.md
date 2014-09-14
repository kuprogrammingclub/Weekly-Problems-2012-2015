# Week 2

## Beginner 

Combination locks are mechanisms that are locked until a specific number combination is input. Either the input is a single dial that must rotate around in a special procedure, or have three disks set in specific positions. This challenge will ask you to compute how much you have to spin a single-face lock to open it with a given three-digit code.
The procedure for our lock is as follows: (lock-face starts at number 0 and has up to N numbers)
Spin the lock a full 2 times clockwise, and continue rotating it to the code's first digit.
Spin the lock a single time counter-clockwise, and continue rotating to the code's second digit.
Spin the lock clockwise directly to the code's last digit.
Input will consist of four space-delimited integers on a single line through console standard input. This integers will range inclusively from 1 to 255. The first integer is N: the number of digits on the lock, starting from 0. A lock where N is 5 means the printed numbers on the dial are 0, 1, 2, 3, and 4, listed counter-clockwise. The next three numbers are the three digits for the opening code. They will always range inclusively between 0 and N-1
Print the total rotation increments you've had to rotate to open the lock with the given code.
The problem is a little wordy but is pretty simple if you understand what is happenning.

```
> 5 1 2 3
21
```



## Advanced
For a positive integer n, let σ2(n) be the sum of the squares of its divisors. For example,

σ2(10) = 1 + 4 + 25 + 100 = 130.

Find the sum of all n, 0 < n < 64,000,000 such that σ2(n) is a perfect square.

```
> 10
130
```