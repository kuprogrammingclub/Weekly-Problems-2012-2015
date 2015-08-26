# KU Programming Club (2014-2015)

Week 01
=======

### Beginner 1

This one should be informative if you've had very little programming experience thus far. You should create a program which asks the user for their name, and then responds with a friendly greeting. For example,

```
What's your name?
> John Doe
Hello, John Doe!
```

If you're looking for inspiration on a language to use, here's a basic tutorial for [Java](http://www.codeproject.com/Articles/2853/Java-Basics-Input-and-Output) and [C++](http://www.cplusplus.com/doc/tutorial/basic_io/).


### Beginner 2

Create a program that checks if a word is a [palindrome](http://en.wikipedia.org/wiki/Palindrome)—that is, a word which is spelled the same when its letters are reversed, such as "noon" or "racecar". Capitalization of letters isn't important. Just check if the letters would be the same if reversed.

```
> Noon
Palindrome
> racecar
Palindrome
> Groot
Not a palindrome
```


### Advanced

This problem comes from [Project Euler](http://projecteuler.net/), a neat website filled with mathematically-oriented programming challenges. This problem is actually [problem 16](http://projecteuler.net/problem=16) from Project Euler in disguise, so if you're so inclined, you can create a Project Euler account, submit your solution, and earn points! Yeah!

Anyway, your goal is to find the sum of the digits of a rather large number. For example, 2^15 = 32678, so the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26. What is the sum of the digits of 2^1000? 2^10000? 2^100000?



Week 02
========

### Beginner

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


### Advanced
For a positive integer n, let σ2(n) be the sum of the squares of its divisors. For example,

σ2(10) = 1 + 4 + 25 + 100 = 130.

Find the sum of all n, 0 < n < 64,000,000 such that σ2(n) is a perfect square.

```
> 10
130
```



Week 03
=======

### Beginner

Draw a tree on your console using ASCII characters. For example,

```
> 7 # *
   *
  ***
 *****
*******
  ###
```

The input will be of the form *n* *t* *l*, where *n* is an odd integer greater than or equal to 3, *t* is the trunk character, and *l* is the leaves character. The tip of the tree will always consist of one *l* character, and each lower level adds two more *l* characters until the last level, which has *n* characters. The trunk will always consist of three *t* characters.

### Advanced

[Benford's law](http://en.wikipedia.org/wiki/Benford's_law) is a statistical phenomenon that occurs in numerical data. It states that in real-life sources of data sets, the number 1 occurs as the leading digit of a number about 30% of the time. This somewhat counterintuitive result has been shown to hold for street addresses, stock prices, ballot results, and much more.

Don't believe me? Why don't you verify it yourself? [Here](Advanced/lakes.csv) is a [comma-separated values (CSV)](http://en.wikipedia.org/wiki/Comma-separated_values) file containing data about Minnesota's lakes (scraped from [here](http://www.lakehomes.com/lakestats-mn.html)). Your task is to compute the first-digit distribution of some column from the lake data, be it size, littoral area, max depth, or water clarity.



Week 04
=======

### Beginner

A Polygon is a geometric two-dimensional figure that has n-sides (line segments) that closes to form a loop. Polygons can be in many different shapes and have many different neat properties, though this challenge is about Regular Polygons. Our goal is to compute the permitter of an n-sided polygon that has equal-length sides given the circumradius. This is the distance between the center of the Polygon to any of its vertices; not to be confused with the apothem!

Input will consist of one line on standard console input. This line will contain first an integer N, then a floating-point number R. They will be space-delimited. The integer N is for the number of sides of the Polygon, which is between 3 to 100, inclusive. R will be the circumradius, which ranges from 0.01 to 100.0, inclusive.

```
> 5 3.7
21.748
> 100 1.0
6.282
```


### Advanced

A Ranked Voting System is a system that chooses a result based on a ranked-preference rather than a simple majority. A standard ranked ballot generally has multiple choices, only one of which one can be picked. A ranked ballot allows you to choose the order in which you prefer candidates. An example could be that you prefer choice B first, then choice C, and finally choice A.

There are some neat implications on how this differs from conventional voting systems, and is used in many different countries and states (check out the same article's list of current uses on the overall system; well worth a watch! The overall difference between the two system is that a more agreed-upon candidate could win during a heavily split election.
Your goal is to take a list of candidates and voter's ballots, implement this voting system (using the Instant-runoff rules), and print the results of the fictional election.

Input: On standard console input, you will be given two space-delimited integers, N and M. N is the number of votes, while M is the number of candidates. After this line, you will be given the candidates line, which is a space-delimited set of M-number of candidate names. These names are one-word lower-case letters only. This is followed by N-lines of ballots, where each ballot is a list of M-integers, from 0 to M-1, representing the order of preference.
Note that the order of preference for ballots goes from left-to-right. The integers are the index into the candidate list. For the example below, you can map 0: Knuth, 1: Turing, 2: Church. This means that if the ballot row is "1 0 2", that means the voter prefers Turing over Knuth over Church.

Output: On standard console input, you will be given two space-delimited integers, N and M. N is the number of votes, while M is the number of candidates. After this line, you will be given the candidates line, which is a space-delimited set of M-number of candidate names. These names are one-word lower-case letters only. This is followed by N-lines of ballots, where each ballot is a list of M-integers, from 0 to M-1, representing the order of preference.
Note that the order of preference for ballots goes from left-to-right. The integers are the index into the candidate list. For the example below, you can map 0: Knuth, 1: Turing, 2: Church. This means that if the ballot row is "1 0 2", that means the voter prefers Turing over Knuth over Church.

```
> 5 3
> Knuth Turing Church
> 1 0 2
> 0 1 2
> 2 1 0
> 2 1 0
> 1 2 0

Round 1: 40.0% Turing, 40.0% Church, 20.0% Knuth
Round 2: 60.0% Turing, 40.0% Church
Turing is the winner
```


Week 05
=======

### Beginner

In earlier decades, a style of input known as [reverse Polish notation](http://en.wikipedia.org/wiki/Reverse_Polish_notation) (RPN) was quite popular in calculators. For example, the infix expression `(3 + 4) * 8` would be represented as `3 4 + 8 *` in RPN. As just demonstrated, RPN does not require any parentheses or operator precedence, so it is must faster for calculators to parse (although a bit wonky to look at if you're not used to it).

RPN parsing can be thought of as stack based. One starts by reading characters from left to right. If one sees a number, push it onto the stack. If one sees an operator, pop the first two numbers off of the stack, evaluate them with the operator (all operators are assumed to take two arguments), and push the result back onto the stack. When you are done, there should only be one value on the stack: the final result. For example:

    Input      Stack
    3 4 + 8 *
    4 + 8 *    3
    + 8 *      3 4
    8 *        7
    *          7 8
               56

Your task is to implement a RPN calculator that, at the very least, is capable of addition (`+`), subtraction (`-`), and multiplication (`*`). Feel free to add more operators such as division (`/`), the modulo operation (`%`), or exponentiation (`^`).

    > 0 4 - 2 *
    -8

### Advanced

The [Monty Hall problem](http://en.wikipedia.org/wiki/Monty_Hall_problem) is a famous puzzle that originally appeared in the game show _Let's Make a Deal_. In the puzzle, you are presented with three doors, one of which leads to a car, while the other two lead to goats. When you select a door, the host reveals one of the doors which leads to a goat, and then gives you the chance to switch to the other mystery door. Is it better to stick with your original selection, or switch to the other door?

As it turns out, the best strategy is to _always_ switch doors, which gives you a 2/3 chance of winning. To test out this theory, you should create a Monty Hall simulator that tracks how many times a player wins by staying, and how many times a player wins by switching. Here is one way you could structure the game:

    Door 1  Door 2  Door 3
    One of these hides a car. Which do you choose?
    > 1
    Ah! It looks like Door 2 hides a goat! What to do now?
    Stay with Door 1? Or switch to Door 3?
    > 1
    You fool! Door 3 had the car!

    Won if stayed: 0/1 (0%). Won if switched: 1/1 (100%).
    Try again?



Week 06
=======

## Beginner

Everyone knows that you can add (that is, concatenate) two lists together, but what about subtracting two lists? Let's implement a list subtraction program. The program should take two list arguments and remove all values from the first list that are present in the second list. For example,

    > [1,2] [1]
    [2]
    > [7,8,8,8,8,9] [8]
    [7,9]
    > [1,2,3] [3,4,5]
    [1,2]

## Advanced

A [Sierpinski triangle](http://en.wikipedia.org/wiki/Sierpinski_triangle) is a famous type of fractal that dates back to at least the 13th century. It can be thought of as triangles nested within triangles nested within triangles nested in... well, as many levels of triangles as you want.

Create a program which generates a Sierpinski triangle with a certain nested triangle depth. For example,

```
> 0
*
> 1
 *
* *
> 2
   *  
  * *
 *   *
* * * *
> 3
       *
      * *
     *   *
    * * * *
   *       *  
  * *     * *
 *   *   *   *
* * * * * * * *
> 4
               *
              * *
             *   *
            * * * *
           *       *
          * *     * *
         *   *   *   *
        * * * * * * * *
       *               *
      * *             * *
     *   *           *   *
    * * * *         * * * *
   *       *       *       *  
  * *     * *     * *     * *
 *   *   *   *   *   *   *   *
* * * * * * * * * * * * * * * *
```

Keep in mind that your output need not be formatted exactly like this. If it's more convenient, you can output the triangle from a different perspective. For example,

```
> 3
*
* *
*   *
* * * *
*       *
* *     * *
*   *   *   *
* * * * * * * *
```



Week 07
=======

### Beginner

Assuming you have done basic algebra, you may have seen equations in the form `y = ax + b`, where `a` and `b` are constants. This is a linear equation, and it forms a graph of a straight line when you plot `y` with respect to `x`.

Your goal is to read in two linear equations and output one of the following:

* If the two lines intersect at a single point, print out that point (e.g., `(1, 2)`).
* If the two lines are parallel, print `Parallel`.
* If the two lines are the same, print `Same`.

Here are some example inputs and outputs:

```
> y=2x+2
> y=5x-4
(2, 6)
> y=8x+2
> y=8x+5
Parallel
> y=10x+4
> y=10x+4
Same
```

You may assume that all input equations are of the form `y=ax+b`. However, for an extra challenge, also consider when `a` = 1 (e.g., `y = x + 1`), when `b` = 0 (e.g., `y = 5x`), or even equations that don't depend on `x` or `y`! (e.g., `y = 5` or `x = 0`).

### Advanced

(From [/r/DailyProgrammer](http://www.reddit.com/r/dailyprogrammer/comments/2hssx6/29092014_challenge_182_easy_the_column_conundrum/)) Text formatting is big business. Every day we read information in one of several formats. Scientific publications often have their text split into [two columns, like this](https://isotropic.org/papers/chicken.pdf). Websites are often bearing one major column and a sidebar column, such as [Reddit](http://reddit.com). Newspapers very often have three to five columns. You've been commisioned by some bloke you met in [Asda](http://en.wikipedia.org/wiki/Asda) to write a program which, given some input text and some numbers, will split the data into the appropriate number of columns.

To start, you will be given 3 numbers on one line:

    <number of columns> <column width> <space width>

* number of columns: The number of columns to collect the text into.
* column width: The width, in characters, of each column.
* space width: The width, in spaces, of the space between each column.

After that first line, the rest of the input will be the text to format.

Here is an example [input](https://gist.githubusercontent.com/Quackmatic/b19f592be2c0ee9e22d7/raw/45457a757d1f126d94a4736354c78906eeb819a3/c182e-input.txt) and [output](https://gist.githubusercontent.com/Quackmatic/1ef9af9f3989e48ee1c4/raw/4cbcd546b7bc1dd415b9a804eb93e671d927cb43/c182e-output.txt). For this problem, I'd recommend redirecting your input from the input file itself. If you don't know how to do this, here's a [quick tutorial](http://en.wikipedia.org/wiki/Redirection_%28computing%29#Redirecting_standard_input_and_standard_output) if you're using a Bash-like shell.



Week 08
=======

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



Week 09
=======

### Beginner

(From <a href="http://en.wikipedia.org/wiki/Bogosort">Wikipedia</a>) You'll be developing a sorting algorithm that doesn't do much actual sorting; that is, every time you rearrange the items in a list, you'll be rearranging them into a <em>random order</em>. If that sounds crazy, it's because it is (think of it like ordering a deck of cards by shuffling it repeatedly). Develop a bogosort algorithm that acts on some list type and test it on increasingly large lists—see how long bogosort takes to slow to a crawl.

### Advanced

In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
1p, 2p, 5p, 10p, 20p, 50p and £1 (100p).

It is possible to make £1 in the following way:
1×50p + 2×20p + 1×5p + 1×2p + 3×1p

How many different ways can £1 be made using any number of coins?



Week 10
=======

### Beginner
Due to a catastrophic version control failure, Facebook finds itself needing to rewrite its friend-related algorithms. You are assigned with writing the code that outputs who likes a particular post. The algorithm is as follows:

* If only one person likes a post (e.g., Mark), then output `Mark likes this`.
* If only two people like a post (e.g., Mark and Giselle), then output `Mark and Giselle like this`.
* If only three people like a post (e.g., Mark, Giselle, and Rory), then output `Mark, Giselle and Rory like this`.
* If four or more people like a post (e.g., Mark, Giselle, Rory, and Lucy), then output `Mark, Giselle and 2 others like this`. Make to increase the amount in `and 2 others` depending on how many people like it.
* If no one likes a post, then output `No one likes this :(`.

The input will be given as a space-separated list of names, ended by a newline.

```
> Mark
Mark likes this
> Mark Giselle
Mark and Giselle like this
> Mark Giselle Rory
Mark, Giselle and Rory like this
> Mark Giselle Rory Lucy
Mark, Giselle and 2 others like this
>
No one likes this :(
```

### Advanced
An [IP address](http://en.wikipedia.org/wiki/IP_address) is a numeric label that you often use in networking. Some examples are `192.0.2.1`, `255.255.255.0`, and `169.254.0.0`. An IP address consists of four octets in the form `X.X.X.X`, where each `X` is a 32-bit unsigned integer (i.e., an integer from 0 to 255). For example, the IP address `128.32.10.1` can be decomposed as follows:

* The first octet, `128`, is `10000000` in binary.
* The second octet, `32`, is `00100000` in binary.
* The third octet, `10`, is `00001010` in binary.
* The fourth octet, `1`, is `00000001` in binary.

Therefore, `128.32.10.1` is equivalent to `10000000.00100000.00001010.00000001` in binary, or `2149583361` in decimal.

Your task is to write a function which converts a decimal representation of an IP address into the `X.X.X.X` form.

```
> 2149583361
128.32.10.1
> 123456789
7.91.205.21
```



Week 11
=======

### Beginner
Print the numbers from 1 to 1000 without using any loop or conditional statements. Don’t just write the printf() or cout statement 1000 times. Be creative and try to find the most efficient way!

### Advanced
To give a holiday theme. Santa is busy delivering presents on Christmas Eve. A strong gust of wind blows away his map. He knows his relative location to the next house but there are new skyscrapers built in the neighborhood since last year. Give Santa instructions on how to get to the next house.

Input:
You will receive the size of the map which is a square, followed by a map with S for Santa and 1 for the next house with # as buildings and other noncrossable terrain.

Output:
Give a list of movements he needs to make to reach the next house.

`````````
> 5
> #S ##
> ##  #
>     #
> #  #1
> ##

East, South, South, South, South, East, East, North
``````````
Output doesn't have to be on the same line. Can use left, right, up and down instead of cardinal directions.

Bonus:
1. Make it able to take rectangle maps instead of just a square.
2. Make it able to take in multiple houses with the order of the houses he must travel as denoted by the value they are given, ex. 1, 2, etc. If he is on a house you must say Stop, before continuing on to the next house.



Week 12
=======

### Beginner

Create a code cipher. When given a string of only letters, switch every letter with the letter 13 spots ahead of it. i.e. `a -> n` and `t -> g`. Don't worry about capitalization.

Optional: make the function be able to take a number argument that tells you how far to shift.

Examples:
```
> coding
pbqvat
> CaEsAr
pnrfne
```

### Intermediate

Write a [Fibonacci sequence](https://en.wikipedia.org/wiki/Fibonacci_number) function that contains no assignment. In Java and C++, this is the `=` operator. Given a number n return the nth number in the sequence.

Examples:
```
> fib 1
1
> fib 2
1
> fib 3
2
> fib 4
3
> fib 5
5
```



Week 13
=======

### Beginner (Words with Enemies)

(Problem credit goes to [/r/DailyProgrammer](http://www.reddit.com/r/dailyprogrammer))

Your task to create a word game in which two opponents battle each other, one word at a time. Every round, both combatants will put forth a single word each. If both words have a common letter, the two letters will cancel out at a ratio of 1 for 1 (e.g., if the two words are `bee` and `the`, only one `e` will be canceled out from `bee`). Whichever player has the most letters remaining will be declared the winner.

__Examples:__

```
> because cause
"be" > ""
Left wins!
```

__Explanation:__
`because` and `cause` share one `c`, one `a`, one `u`, one `s`, and one `e`, so the left player has `"be"` remaining, while the right player has `""` (the empty string) remaining.

```
> hat cat
"h" = "c"
Tie!
```

This is because the `a` and `t` cancel out from both sides, leaving behind one `h` for the left player and one `c` for the right player, an equal amount.

### Intermediate

Create a function that takes a string of lowercase characters and outputs the string after any duplicate occurrence of a character has been removed.

Also, make your algorithm as efficient as possible. See if you can achieve better performance that O(*n*²).

___Examples:___

```
> mississippi
misp
> inthejunglethemightyjunglethelionsleepstonight
inthejuglmyosp
> zingdwarfjocksvexlymphqutb
zingdwarfjocksvexlymphqutb
```



Week 14
=======

### Beginner

(Problem credit goes to [/r/DailyProgrammer](http://www.reddit.com/r/dailyprogrammer))

All great things start with something small. Sometimes people don't even realize what goes into making a 'small' thing.
A popular story is linked above about a group of graphics programmers who create a rendering engine in some amount of time. After some time HR came to see what the programmers had accomplished. They responded by showing a black triangle on a tv.
HR was less than impressed (understand for a non techie) but it goes to show the natural evolution of a program. What they didn't realize is that the programmers have created their base engine and can now easily add and extend on top of it.
Maybe you can follow similar steps?

On your screen, display the letter K made out of squares.
You may use any libraries available to you.
The squares may be of any size and of any color.

### Advanced

(Problem credit goes to [/r/DailyProgrammer](http://www.reddit.com/r/dailyprogrammer))

Given the year- Write a program to figure out the exact date of Easter for that year.

Bonus : Figure out what day is Easter for every year from noe to 2025.

__Examples:__

```
> 2015
April 5
(alternate output) 4/5

> 1994
4/3
```



Week 15
=======

### Beginner

Suppose you're given a list of integers, e.g., `[-2, 1, -3, 4, -1, 2, 1, -5, 4]`. How can you pick a contiguous sublist from the original list such that the sum of its integers is maximized? Your assignment is to create a program that answers this question for any such list. (Note: the length of the empty list `[]` is defined to be 0). Try to make your solution as efficient as possible, for bonus points.

__Examples__

```
> [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Sublist: [4, -1, 2, 1], sum: 6
> [-2, -5, 6, -2, -3, 1, 5, -6]
Sublist: [6, -2, -3, 1, 5], sum: 7
```

### Advanced

Image you have walls of different heights:

                 _ _
                |7 7|_
       _        |    6|
      |5|      _|     |
      | |    _|4      |
     _| |  _|3        |
    |2  |_|2          |
    |____1____________|

We can represent this as a list of heights, i.e., `[2,5,1,2,3,4,7,7,6]`.

Now suppose that it rains, and that puddles accumulate between walls, but fall off the sides. After it stops raining, the rain (represented by `X`s in the diagram below) looks like this:

                 _ _
                |7 7|_
       _        |    6|
      |5|X X X X|     |
      | |X X X|4      |
     _| |X X|3        |
    |2  |X|2          |
    |____1____________|

The puddle occupies a volume of 10.

Your task is to devise a program which, given a list of nonnegative integers representing wall heights, will calculate the volume of rain that will be left trapped between walls after raining.

__Examples__

```
> [2,5,1,2,3,4,7,7,6]
10
> [2,5,1,3,1,2,1,7,7,6]
17
```



Week 16
=======

Both problems come from dailyprogrammer on reddit.

### Beginner

DNA - deoxyribonucleic acid - is the building block of every organism. It contains information about hair color, skin tone, allergies, and more. It's usually visualized as a long double helix of base pairs. DNA is composed of four bases - adenine, thymine, cytosine, guanine - paired as follows: A-T and G-C.
Meaning: on one side of the strand there may be a series of bases.
It is your job to generate one side of the DNA strand and output the two DNA strands. Your program should take a DNA sequence as input and return the complementary strand.

__Examples__

```
> A T A A G C
A T A A G C
T A T T C G
> A A T G C C T A T G G C
A A T G C C T A T G G C
T T A C G G A T A C C G
```

### Advanced

A recurrence relation is a mathematical construct for defining a series of numbers. It works by first giving an initial term, and then recursively defining the rest of the series as functions of the first one. For example, let's say we have a series of numbers called u, which is defined by this recurrence relation:
u[0] = 1
u[n+1] = 2 * u[n]
The first relation tells us that u(0), the first term in the series, is 1. The second relation says that, given the n-th term u(n), the next term (u(n+1)) is the previous term multiplied by two. So, to get the second term in the series, you multiply the first term by two, to get 2. To get the third term in the series, you multiply the second term by two, to get 4.
Recurrence relations get their name in part due to their recursive nature, as successive terms are essentially defined as recursive application of a function.

Input: The equation to use, the start value, the number of terms to print out.

__Examples__

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



Week 17
=======

### Beginner

(Credit to [Codewars](http://www.codewars.com))

Given a list of scores, return the list of ranks for each value in the list. The largest value has rank 1, the second-largest value has rank 2, and so on. Ties should be handled by assigning the same rank to all tied values. For example:

```
ranks([9,3,6,10]) = [2,4,3,1]
```

and

```
ranks([3,3,3,3,3,5,1]) = [2,2,2,2,2,1,7]
```

because there is one 1st-place value, a five-way tie for 2nd place, and one in 7th place.

### Advanced

(Credit to [Programming Praxis](http://programmingpraxis.com/2014/11/14/dawkins-weasel/))

The [infinite monkey theorem](https://en.wikipedia.org/wiki/Infinite_monkey_theorem) is a statistical thought experiment in which an army of monkeys are placed in front of typewriters and ordered to hit keys at random. Assuming that these monkeys type with uniform randomness, the probability of them producing the complete works of William Shakespeare, given enough time, is 100%. Unfortunately, the time it would take to do so would probably be much longer than the age of the universe. That makes me a sad monkey.

To speed up the process a bit, we'll train one primate (you) to randomly type out a single sentence from a Shakespeare work (`METHINKS IT IS LIKE A WEASEL`). Here is your task:

1. Create a random string of 28 characters.
2. Make 100 copies of the string.
3. For each character in each of the 100 copies, with a probability of 5%, replace the character with a new random character.
4. Compare each new string with `METHINKS IT IS LIKE A WEASEL` and give each a score (the number of letters in the string that are correct and in the correct position).
5. If any of the new strings has a perfect score (28), halt. Otherwise, take the highest-scoring string, and go to step 2.

For bonus points, print out the highest-scoring string in each iteration of steps 2-5.
