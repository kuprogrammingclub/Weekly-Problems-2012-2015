# Week 4

## Beginner - Library Fine
__Source__: https://www.hackerrank.com/challenges/library-fine/

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
__Source__: https://www.hackerrank.com/challenges/sherlock-and-watson

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

## Intermediate 2 - Space Code Breaking
__Source__: https://www.reddit.com/r/dailyprogrammer/comments/38fjll/20150603_challenge_217_intermediate_space_code/

Copying my ASCII data over as input is causing problems. I see that some people
who were true heroes and tackled the problem early are seeing this. To fix this
we will be altering the challenge. Input will be a set of numbers each represent
a byte in the message. Hopefully this will fix the issues.
<br><br>

#### Input Format

Message broken down into numbers representing the ASCII values of the message between " "

#### Output Format

The name of the system and the message decoded.
<br><br>

#### Encryption & Planet Systems
```
Omicron V: will take and invert the 5th bit. (0001 0000) That is the bit location
in the byte where we invert the bit.

Hoth: Takes the value of the ASCII character and adds 10 to it.

Ryza IV: Takes the value of the ASCII character and subtracts 1 to it.

Htrae: reverses the characters.
```
<br>

#### Validation

It is not enough to just take the message and decode it in all 4 ways and let
you decide which one is right or wrong. You need to have your program/solution
determine the right decoding. All messages are in english (I know even in the
future on alien planets).

<br>

#### Sample Input
```
" 101 99 97 101 112 32 110 105 32 101 109 111 99 32 101 87 "
```

#### Sample Output
```
Htrae: We come in Peace
```
<br>

## Intermediate 3 - DNA Restriction Enzymes
__Source__: https://www.reddit.com/r/dailyprogrammer/comments/307m27/20150325_challenge_207_intermediate/

#### Description

See the source link for a description of the problem; specifically, how to differentiate
between split and blunt ends.

#### Input Format

You'll be given a list of DNA restriction enzymes and their recognition site and
where the cut occurs. The input will be structured as enzyme name, if the enzyme
makes a "sticky" or "blunt" end cut, the DNA recognition sequence and the position
of the cut marked with a caret ("^"). For the sticky ends, you should assume the
mirror image of the complementary strand gets the same cut, leaving one of the
strands to overhang (hence it's "sticky").

```
BamHI sticky G^GATCC
HaeIII blunt GG^CC
HindIII sticky A^AGCTT
```

Then you'll be given a DNA sequence and be asked to cut it with the listed enzymes.
For sake of convenience, the DNA sequence is broken into blocks of 10 bases at a
time and in lengths of 6 blocks per row. You should merge these together and drop
the first column of digits.


#### Output Format

Your program should emit the name of the enzyme, the cut positions for that enzyme,
and the contextualized cut. For the above the solution would be:

#### Sample Input
```
1 gagttttatc gcttccatga cgcagaagtt aacactttcg gatatttctg atgagtcgaa
61 aaattatctt gataaagcag gaattactac tgcttgttta cgaattaaat cgaagtggac
121 tgctggcgga aaatgagaaa attcgaccta tccttgcgca gctcgagaag ctcttacttt
181 gcgacctttc gccatcaact aacgattctg tcaaaaactg acgcgttgga tgaggagaag
241 tggcttaata tgcttggcac gttcgtcaag gactggttta gatatgagtc acattttgtt
301 catggtagag attctcttgt tgacatttta aaagagcgtg gattactatc tgagtccgat
361 gctgttcaac cactaatagg taagaaatca tgagtcaagt tactgaacaa tccgtacgtt
421 tccagaccgc tttggcctct attaagctta ttcaggcttc tgccgttttg gatttaaccg
481 aagatgattt cgattttctg acgagtaaca aagtttggat ccctactgac cgctctcgtg
541 ctcgtcgctg cgttgaggct tgcgtttatg gtacgctgga ctttgtggga taccctcgct
601 ttcctgctcc tgttgagttt attgctgccg tcaaagctta ttatgttcat cccgtcaaca
661 ttcaaacggc ctgtctcatc atggaaggcg ctgaatttac ggaaaacatt attaatggcg
721 tcgagcgtcc ggttaaagcc gctgaattgt tcgcgtttac cttgcgtgta cgcgcaggaa
781 acactgacgt tcttactgac gcagaagaaa acgtgcgtca aaaattacgt gcggaaggag
841 tgatgtaatg tctaaaggta aaaaacgttc tggcgctcgc cctggtcgtc cgcagccgtt
```

#### Sample Output
```
BamHI 517 agttt[g gatcc]ctactg
HaeIII 435 gcttt[gg cc]tctattaa
HaeIII 669 caaac[gg cc]tgtctcat
HindIII 444 ctatt[a agctt]attcag
HindIII 634 cgtca[a agctt]attatg
```

#### Challenge

Write some code that identifies any and all symmetrical points along the DNA
sequence where an enzyme (not just the three listed) could cut. These should be
even-length palindromes between 4 and 10 bases long.

<br>

## Interview Practice

Implement a stack and queue using linked lists. (Try not to use data structures
already provided by the language, like in Python. Try to build the structures
from the container object to the final linked structure with functionality.)
