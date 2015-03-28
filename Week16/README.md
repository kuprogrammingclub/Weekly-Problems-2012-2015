# Week 16

Both problems come from dailyprogrammer on reddit.

## Beginner 

DNA - deoxyribonucleic acid - is the building block of every organism. It contains information about hair color, skin tone, allergies, and more. It's usually visualized as a long double helix of base pairs. DNA is composed of four bases - adenine, thymine, cytosine, guanine - paired as follows: A-T and G-C.
Meaning: on one side of the strand there may be a series of bases.
It is your job to generate one side of the DNA strand and output the two DNA strands. Your program should take a DNA sequence as input and return the complementary strand.

### Examples

```
> A T A A G C 
A T A A G C 
T A T T C G
> A A T G C C T A T G G C
A A T G C C T A T G G C
T T A C G G A T A C C G
```

## Advanced

A recurrence relation is a mathematical construct for defining a series of numbers. It works by first giving an initial term, and then recursively defining the rest of the series as functions of the first one. For example, let's say we have a series of numbers called u, which is defined by this recurrence relation:
u[0] = 1
u[n+1] = 2 * u[n]
The first relation tells us that u(0), the first term in the series, is 1. The second relation says that, given the n-th term u(n), the next term (u(n+1)) is the previous term multiplied by two. So, to get the second term in the series, you multiply the first term by two, to get 2. To get the third term in the series, you multiply the second term by two, to get 4.
Recurrence relations get their name in part due to their recursive nature, as successive terms are essentially defined as recursive application of a function.

Input: The equation to use, the start value, the number of terms to print out.

### Examples

```
> *3 +2 *2
> 0
> 7
Term 0: 0
Term 1: 4
Term 2: 28
Term 3: 172
Term 4: 1036
Term 5: 6220
Term 6: 37324
Term 7: 223948
```
