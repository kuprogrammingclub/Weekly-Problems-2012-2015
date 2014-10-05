# Week 5

## Beginner 

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

## Advanced

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