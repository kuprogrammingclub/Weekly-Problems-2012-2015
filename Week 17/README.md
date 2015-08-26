# Week 17

### Beginner
Given four points, determine if they form a square. (A square is defined as a four-sided polygon where all sides are of equal length, and where the sides intersect at 90° angles.) Assume that all four points are distinct to make your life easier. For example:

```
> (1, 0) (1, 2) (2, 1) (0, 1)
> It's a square
>
> (1, 0) (1, 2) (2, 1) (0, 9)
> Nope, not a square
```

### Advanced
<a href="http://en.wikipedia.org/wiki/Word_Ladder">Word Ladder</a> is a super-groovy game where you a given a length-<em>n</e> word and are tasked with transforming it into a different length-<em>n</em> word by a series of single-character substitutions. You win the game if you can derive the new word using a minimum number of substitutions. For example, a straightforward ladder that turns <tt>lisp</tt> to <tt>ruby</tt> is <tt>lisp → risp → rusp → rubp → ruby</tt>. That's easy enough, but not very satisfying, since none of the intermediate words are, well, actual words. If we restrict ourselves to using words found in most dictionaries, we could obtain the word latter <tt>lisp → list → mist → mint → pint → punt → puns → runs → rubs → ruby</tt>.

Implement a word ladder solver using dictionary words (on Linux, you can use the terminal command cat <tt>/usr/share/dict/words > ~/words.txt</tt> to get a dictionary saved to <tt>~/words.txt</tt>). Assume all words are composed solely of lowercase ASCII characters (note that Linux dictionaries might include words with more than lowercase ASCII characters, so be sure to filter them out).
