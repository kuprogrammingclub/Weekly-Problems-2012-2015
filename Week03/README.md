# Week 3

## Intermediate 1 - Linked List Addition
__*Source*__: Cracking The Coding Interview (5th Edition)

You have two numbers represented by a linked list, where each node contains a
single digit. The digits are stored in reverse order, such that the 1's digit is
at the head of the list. Write a function that adds the two numbers and returns
the sum as a linked list.

#### Sample Input
```
List A: 7 -> 1 -> 6
List B: 5 -> 9 -> 2

That is, 617 + 295.
```

#### Sample Output
```
2 -> 1 -> 9.
```

If you haven't taken EECS 268 yet or have just forgotten how to build a linked list:
https://en.wikipedia.org/wiki/Linked_list
<br>


## Hard - Chester, the Greedy Pomeranian
__*Source*__: https://www.reddit.com/r/dailyprogrammer/comments/3629st/20150515_challenge_214_hard_chester_the_greedy/

Chester is a very spirited young Pomeranian that lives in a pen that exactly
covers the unit square. He's sitting in the middle of it, at (0.5, 0.5), minding
his own business when out of nowhere, six of the most delicious dog treats you
could ever imagine start raining down from the sky.<br>

The treats land at these coordinates:
```
(0.9, 0.7) (0.7, 0.7) (0.1, 0.1)
(0.4, 0.1) (0.6, 0.6) (0.8, 0.8)
```

In the end, he's eaten the treats in this order:
```
(0.6, 0.6), (0.7, 0.7), (0.8, 0.8)
(0.9, 0.7), (0.4, 0.1), (0.1, 0.1)
```

Since he started at (0.5, 0.5), he will have travelled a total distance of roughly
1.646710... units.<br>
Your challenge today is to calculate the total length of Chester's journey to eat
all of the magically appearing dog-treats.


A small note - distance is calculated using the standard plane distance formula.
That is, the distance between a point with coordinates (x1, y1) and a point with
oordinates (x2, y2) is equal to:

```
sqrt((x1-x2)^2 + (y1-y2)^2)
```

#### Input
The first line of the input will be an integer N that will specify how many treats
have magically appeared. After that, there will follow N subsequent lines giving
the locations of the treats. Each of those lines will have two floating point
numbers on them separated by a space giving you the X and Y coordinate for that
particular treat.<br>
Each number provided will be between 0 and 1. Except for the first sample, all
numbers will be rounded to 8 decimal digits after the period.
Note that most of the inputs I will provide will be in external text files, as
they are too long to paste into this description. The bonus input, in particular,
is about 2 megabytes large.

#### Output

You will output a single line with a single number on it, giving the total length
of Chester's journey. Remember that he always starts at (0.5, 0.5), before going
for the first treat.


#### Sample Input 1
```
6
0.9 0.7
0.7 0.7
0.1 0.1
0.4 0.1
0.6 0.6
0.8 0.8
```

#### Sample Output 1
```
1.6467103925399036
```

#### Sample Input 2
*[This list of coordinates](https://gist.githubusercontent.com/anonymous/4bf5afdc1c85098de9b1/raw/676ca9e4b94668a534854f7c3142f100b4e00f03/sample2.txt)*

#### Sample Output 2
```
9.127777855837017
```
