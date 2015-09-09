# Week 2

## Beginner 1 - Funny String
__*Source*__: https://www.hackerrank.com/challenges/funny-string

Suppose you have a string S which has length N and is indexed from 0 to N−1.
String R is the reverse of the string S. The string S is funny if the condition
<br><br>
|S<sub>i</sub> − S<sub>i − 1</sub>| = |R<sub>i</sub> − R<sub>i − 1</sub>|
<br><br>
is true for every i from 1 to N − 1.

(Note: Given a string str, str<sub>i</sub> denotes the ascii value of the i<sup>th</sup> character (0-indexed) of str. |x| denotes the absolute value of an integer x)

For each string, print Funny or Not Funny in separate lines.
Also, assume we're only using lowercase due to the fact that mixing case would
involve odd offsets.

#### Sample Input
```
acxz
bcxz
```

#### Sample Output
```
Funny
Not Funny
```
<br>

## Beginner 2 - Time Conversion
__*Source*__: https://www.hackerrank.com/challenges/time-conversion

You are given time in AM/PM format. Convert this into a 24 hour format.<br>
*Note*: Midnight is 12:00:00AM or 00:00:00 and 12 Noon is 12:00:00PM.

#### Sample Input
```
07:05:45PM
```

#### Sample Output
```
19:05:45
```

## Intermediate 1 - Parentheses Matching
__*Source*__: https://www.hackerrank.com/challenges/java-stack

A string containing only parentheses is balanced if the following is true:
1. if it is an empty string
2. if A and B are correct, AB is correct,
3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"<br>
Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.
For each case, print 'true' if the string is balanced, 'false' otherwise.

#### Sample Input
```
{}()
({()})
{}(
[]
```

#### Sample Output
```
true
true
false
true
```

<br>

## Intermediate 2 - The Grid Search
__*Source*__: https://www.hackerrank.com/challenges/the-grid-search

Given a 2D array of digits, try to find the location of a given 2D pattern of digits. For example, consider the following 2D matrix:

```
1234567890  
0987654321  
1111111111  
1111111111  
2222222222  
```

Assume we need to look for the following 2D pattern:

```
876543  
111111  
111111
```

If we scan through the original array, we observe that the 2D pattern begins at the second row and the third column of the larger grid (the 8 in the second row and third column of the larger grid is the top-left corner of the pattern we are searching for).

So, a 2D pattern of P digits is said to be present in a larger grid G, if the latter contains a contiguous, rectangular 2D grid of digits matching with the pattern P, similar to the example shown above.

Display 'YES' or 'NO', depending on whether (or not) you find that the larger grid G contains the rectangular pattern P. The evaluation will be case sensitive.

#### Sample Input
```
2
10 10
7283455864
6731158619
8988242643
3830589324
2229505813
5633845374
6473530293
7053106601
0834282956
4607924137
3 4
9505
3845
3530
15 15
400453592126560
114213133098692
474386082879648
522356951189169
887109450487496
252802633388782
502771484966748
075975207693780
511799789562806
404007454272504
549043809916080
962410809534811
445893523733475
768705303214174
650629270887160
2 2
99
99
```

#### Sample Output
```
YES
NO
```

__NOTE:__ HackerRank has a more detailed explanation at the source URL, so if
you don't understand this small snippet of the problem statement, make sure to
read the full one.

<br>

## Intermediate 3 - Contiguous Chains
__*Source*__: https://www.reddit.com/r/dailyprogrammer/comments/3gpjn3/20150812_challenge_227_intermediate_contiguous/

If something is contiguous, it means it is connected or unbroken. For a chain, this would mean that all parts of the chain are reachable without leaving the chain. So, in this little piece of ASCII-art:

```
xxxxxxxx
x      x
```

there is only 1 contiguous chain, while in this

```
xxxx xxxx

x
```

there are 3 contiguous chains. Note that a single x, unconnected to any other, counts as one chain.
For the purposes of this problems, chains can only be contiguous if they connect horizontally of vertically, not diagonally. So this image

```
xx
  xx
    xx
```

contains three chains.

Your challenge today is to write a program that calculates the number of contiguous chains in a given input.

__Input:__<br>
The first line in the input will consist of two numbers separated by a space,
giving the dimensions of the ASCII-field you're supposed to read. The first
number gives the number of lines to read, the second the number of columns
(all lines have the same number of columns). After that follows the field itself,
consisting of only x's and spaces.

__Output:__<br>
Output a single number giving the number of contiguous chains.

#### Sample Input
```
{}()
({()})
{}(
[]
```

#### Sample Output
```
true
true
false
true
```

<br>
