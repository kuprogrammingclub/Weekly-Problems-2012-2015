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
