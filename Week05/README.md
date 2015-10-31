# Week 5


## Beginner - Evaluating e<sup>x</sup>
__Source__: https://www.hackerrank.com/challenges/eval-ex

The series expansion of ex is given by:

1 + x + x<sup>2</sup>/2! + x<sup>3</sup>/3! + x<sup>4</sup>/4! + .......

Evaluate e^x for given values of x, by using the above expansion for the first 10
terms. The challenge is to accomplish this without either mutable state, or direct
declaration of local variables.

#### Input Format

The first line contains an integer number N which will be the number of test cases.
N lines follow, each line containing a value of x for which you need to output the
value of e<sup>x</sup> using the above series expansion.These input values have
exactly 4 decimal places each.

#### Output Format

N lines, each of them containing the value of e<sup>x</sup>, computed by your program.

#### Sample Input
```
4
20.0000
5.0000
0.5000
-0.5000
```

#### Sample Output
```
2423600.1887
143.6895
1.6487
0.6065
```
<br>


## Intermediate 1 - Scoring a Bowling Game
__Source__: https://www.reddit.com/r/dailyprogrammer/comments/3ntsni/20151007_challenge_235_intermediate_scoring_a/


You'll be given a bowling sheet for a single person on a line, with the ten frames
separated by a space. All scores are single characters: - for zero (aka a gutter
ball), 1-9 for 1-9 pins knocked down, / for a spare, and X for a strike. If you
see any two digit numbers (e.g. "63") that's actually the first and second ball
scores (a six then a three). Example:

```
X X X X X X X X X XXX
```

Your program should calculate the score for the sheet and report it. From our example:

```
300
```

Aka a perfect game.

#### Challenge Input
```
X -/ X 5- 8/ 9- X 81 1- 4/X
62 71  X 9- 8/  X  X 35 72 5/8
```

#### Challenge Output
```
137
140
```
<br>


## Hard - Divisible by 7
__Source__: https://www.reddit.com/r/dailyprogrammer/comments/3irzsi/20150828_challenge_229_hard_divisible_by_7/

Consider positive integers that are divisible by 7, and are also divisible by 7
when you reverse the digits. For instance, 259 counts, because 952 is also
divisible by 7. The list of all such numbers between 0 and 10<sup>3</sup> is:
```
7 70 77 161 168 252 259 343 434 525 595 616 686 700 707 770 777 861 868 952 959
```
The sum of these numbers is 10,787.<br>
Find the sum of all such numbers between 0 and 10<sup>11</sup>.

#### Challenge Input

Make your program work for an upper limit of 10<sup>N</sup> for any N, and be
able to efficiently handle N's much larger than 11.
