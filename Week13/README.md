# Week 13

## Beginner (Words with Enemies)

(Problem credit goes to [/r/DailyProgrammer](http://www.reddit.com/r/dailyprogrammer))

Your task to create a word game in which two opponents battle each other, one word at a time. Every round, both combatants will put forth a single word each. If both words have a common letter, the two letters will cancel out at a ratio of 1 for 1 (e.g., if the two words are `bee` and `the`, only one `e` will be canceled out from `bee`). Whichever player has the most letters remaining will be declared the winner.

### Examples:

```
> because cause
Left wins!
```

Explanation: `because` and `cause` share one `c`, one `a`, one `u`, one `s`, and one `e`, so the left player has `"be"` remaining, while the right player has `""` (the empty string) remaining.

```
> hat cat
Tie!
```

This is because the `a` and `t` cancel out from both sides, leaving behind one `h` for the left player and one `c` for the right player, an equal amount.

## Intermediate

Create a function that takes a string of lowercase characters and outputs the string after any duplicate occurrence of a character has been removed.

Also, make your algorithm as efficient as possible. See if you can achieve better performance that O(*n*^2).

### Examples:

```
> mississippi
misp
> inthejunglethemightyjunglethelionsleepstonight
inthejuglmyosp
> zingdwarfjocksvexlymphqutb
zingdwarfjocksvexlymphqutb
```