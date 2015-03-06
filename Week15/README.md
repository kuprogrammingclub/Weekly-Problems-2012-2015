# Week 15

## Beginner 

Suppose you're given a list of integers, e.g., `[-2, 1, -3, 4, -1, 2, 1, -5, 4]`. How can you pick a contiguous sublist from the original list such that the sum of its integers is maximized? Your assignment is to create a program that answers this question for any such list. (Note: the length of the empty list `[]` is defined to be 0). Try to make your solution as efficient as possible, for bonus points.

### Examples

```
> [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Sublist: [4, -1, 2, 1], sum: 6
> [-2, -5, 6, -2, -3, 1, 5, -6]
Sublist: [6, -2, -3, 1, 5], sum: 7
```

## Advanced

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

### Examples

```
> [2,5,1,2,3,4,7,7,6]
10
> [2,5,1,3,1,2,1,7,7,6]
17
```