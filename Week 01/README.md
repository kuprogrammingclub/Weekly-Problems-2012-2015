# Week 1

### Beginner
Write a program that takes in a string as input (a name for example) and makes it <em>u83rl337!!</em>. For any character you wish, choose a non-letter replacement, then go through your input and replace the appropriate characters so that the output phrase has been "1337ified".

So say we pass in her ladyship, the revered Rear Admiral 'Grace Hopper'. We might get something much more contemporary, <em>gr4c3 h0pp3r!!!!1</em>

### Advanced
Implement the Euclidean Algorithm for finding greatest common divisors (gcd), which states that for any two integers <em>a</em> and <em>b</em> (where <em>b</em> ≠ 0), there exist integers <em>q</em> and <em>r</em> such that <em>a</em> = <em>bq</em> + <em>r</em> and 0 ≤ <em>r</em> < |<em>b</em>|. (As a special case, gcd(0, 0) = 0.) Since gcd(<em>a</em>, <em>b</em>) = gcd(<em>b</em>, <em>r</em>), you can repeatedly divide until you find the gcd. For example, for gcd(30, 4):

```
30 = 4 * 7 + 2, with a = 30, b = 4
4 = 2 * 2 + 0, with a =  4, b = 2
```

Therefore, gcd(30, 4) = 2. The algorithm is described <a href="https://en.wikipedia.org/wiki/Euclidean_algorithm">here</a>. Make sure to skip the "Implementations" section, though—that's cheating!
