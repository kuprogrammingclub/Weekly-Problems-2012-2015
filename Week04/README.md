# Week 4

## Beginner - Library Fine
__*Source*__: https://www.hackerrank.com/challenges/library-fine/

The Head Librarian at a library wants you to make a program that calculates the
fine for returning the book after the return date. You are given the actual and
the expected return dates. Calculate the fine as follows:<br>
1. If the book is returned on or before the expected return date, no fine will
be charged, in other words fine is 0.
2. If the book is returned in the same calendar month as the expected return
date, Fine = 15 Hackos × Number of late days
3. If the book is not returned in the same calendar month but in the same calendar
year as the expected return date, Fine = 500 Hackos × Number of late months
4. If the book is not returned in the same calendar year, the fine is fixed at
10000 Hackos.
<br>

#### Sample Input
```
9 6 2015
6 6 2015
```

#### Sample Output
```
45
```
<br>
