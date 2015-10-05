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

## Intermediate 1 - Sherlock & Watson
__*Source*__: https://www.hackerrank.com/challenges/sherlock-and-watson

John Watson performs an operation called Right Circular Rotation on an integer
array [a<sub>0</sub>, a<sub>1</sub>,..., a<sub>N−1</sub>]. Right Circular Rotation
transforms the array from [a<sub>0</sub>, a<sub>1</sub>, ..., a<sub>N−1</sub>] to
[a<sub>N−1</sub>, a<sub>0</sub>, ..., a<sub>N−2</sub>].

He performs the operation *K* times and tests Sherlock's ability to identify
the element at a particular position in the array. He asks *Q* queries. Each
query consists of one integer, *idx*, for which you have to print the element
at index idx in the rotated array, i.e. <i>a</i><sub><i>idx</i></sub>.

#### Input Format

The first line consists of three integers, *N*, *K*, and *Q*, separated by a single space.
The next line contains *N* space-separated integers which indicate the elements of the array *A*.<br>
Each of the next *Q* lines contains one integer per line denoting *idx*.

#### Output Format

For each query, print the value at index *idx* in the updated array separated by
newline.

#### Sample Input
```
3 2 3
1 2 3
0
1
2
```

#### Sample Output
```
2
3
1
```
<br>
