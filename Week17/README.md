# Week 17

## Beginner 

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

## Advanced

(Credit to [Programming Praxis](http://programmingpraxis.com/2014/11/14/dawkins-weasel/))

The [infinite monkey theorem](https://en.wikipedia.org/wiki/Infinite_monkey_theorem) is a statistical thought experiment in which an army of monkeys are placed in front of typewriters and ordered to hit keys at random. Assuming that these monkeys type with uniform randomness, the probability of them producing the complete works of William Shakespeare, given enough time, is 100%. Unfortunately, the time it would take to do so would probably be much longer than the age of the universe. That makes me a sad monkey.

To speed up the process a bit, we'll train one primate (you) to randomly type out a single sentence from a Shakespeare work (`METHINKS IT IS LIKE A WEASEL`). Here is your task:

1. Create a random string of 28 characters.
2. Make 100 copies of the string.
3. For each character in each of the 100 copies, with a probability of 5%, replace the character with a new random character.
4. Compare each new string with `METHINKS IT IS LIKE A WEASEL` and give each a score (the number of letters in the string that are correct and in the correct position).
5. If any of the new strings has a perfect score (28), halt. Otherwise, take the highest-scoring string, and go to step 2.

For bonus points, print out the highest-scoring string in each iteration of steps 2-5.
