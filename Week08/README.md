# Week 8

## Beginner 

A [Caesar cipher](http://en.wikipedia.org/wiki/Caesar_cipher) is a simple way of encrypting a message. It works by taking each letter in the message and replacing it by a different letter some fixed number of positions up or down the alphabet. This technique dates all the way back to ancient Rome (hence it being named after Julius Caesar).

You are tasked with creating a particular kind of Caesar cipher, namely, the [ROT13](http://en.wikipedia.org/wiki/ROT13) (rotate-by-13) cipher. This cipher shifts each letter by the letter 13 places further in the alphabet. You can imagine the mapping as follows, where the top is the original alphabet and the bottom is the new alphabet:

```
abcdefghijklmnopqrstuvwxyz
nopqrstuvwxyzabcdefghijklm
```

Here are possible inputs and outputs:

```
> Competitive Programming
Pbzcrgvgvir Cebtenzzvat
> rot13
ebg13
> LoLWuT
YbYJhG
```

Your implementation of ROT13 should preserve capitalization and ignore characters that are not letters in the English alphabet (e.g., numbers and punctuation).

## Advanced

A combination, mathematically speaking, is a unique way of picking some number of items from a set irrespective of order. As an example, there are 10 unique combinations of 3 items from the list `[1, 2, 3, 4, 5]`, and they are:

```
1 2 3
1 2 4
1 2 5
1 3 4
1 3 5
1 4 5
2 3 4
2 3 5
2 4 5
3 4 5
```

As input, you will be given two nonnegative integers *k* and *n*, separated by a space, followed by a newline, followed by *n* consecutive integers (separated by spaces) in ascending order. The output should be all of the combinations of those *n* integers that are of size *k*.

```
> 2 4
> 0 1 2 3
0 1
0 2
0 3
1 2
1 3
2 3
```
