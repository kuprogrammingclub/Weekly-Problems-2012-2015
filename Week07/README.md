# Week 7

## Beginner 

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

## Advanced

(From [/r/DailyProgrammer](http://www.reddit.com/r/dailyprogrammer/comments/2hssx6/29092014_challenge_182_easy_the_column_conundrum/)) Text formatting is big business. Every day we read information in one of several formats. Scientific publications often have their text split into [two columns, like this](https://isotropic.org/papers/chicken.pdf). Websites are often bearing one major column and a sidebar column, such as [Reddit](http://reddit.com). Newspapers very often have three to five columns. You've been commisioned by some bloke you met in [Asda](http://en.wikipedia.org/wiki/Asda) to write a program which, given some input text and some numbers, will split the data into the appropriate number of columns.

To start, you will be given 3 numbers on one line:

    <number of columns> <column width> <space width>

* number of columns: The number of columns to collect the text into.
* column width: The width, in characters, of each column.
* space width: The width, in spaces, of the space between each column.

After that first line, the rest of the input will be the text to format.

Here is an example [input](https://gist.githubusercontent.com/Quackmatic/b19f592be2c0ee9e22d7/raw/45457a757d1f126d94a4736354c78906eeb819a3/c182e-input.txt) and [output](https://gist.githubusercontent.com/Quackmatic/1ef9af9f3989e48ee1c4/raw/4cbcd546b7bc1dd415b9a804eb93e671d927cb43/c182e-output.txt). For this problem, I'd recommend redirecting your input from the input file itself. If you don't know how to do this, here's a [quick tutorial](http://en.wikipedia.org/wiki/Redirection_%28computing%29#Redirecting_standard_input_and_standard_output) if you're using a Bash-like shell.