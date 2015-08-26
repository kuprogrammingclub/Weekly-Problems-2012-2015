# Week 6

### Beginner
Using any language you choose (as per usual), implement a <a href="http://en.wikipedia.org/wiki/Quine_(computing)">quine</a>, that is, a program that takes no input but outputs its own source code. Bonus cool points for writing programs as concise as possible, or for writing programs that would create a loop between languages if each output was actually compiled and ran.

### Advanced
(Something mathy from <a href="http://www.reddit.com/r/dailyprogrammer/comments/1fcpnx/053013_challenge_126_intermediate_perfect_pth/">/r/DailyProgrammer</a>): An integer X is a "perfect square power" if there is some integer Y such that Y<sup>2</sup> = X. An integer X is a "perfect cube power" if there is some integer Y such that Y<sup>3</sup> = X. We can extrapolate this where P is the power in question: an integer X is a "perfect Pth power" if there is some integer Y such that Y<sup>P</sup> = X.

Your goal is to find the highest value of P for a given X such that for some unknown integer Y, Y<sup>P</sup> should equal X. You can expect the given input integer X to be within the range of an unsigned 32-bit integer (0 to 4,294,967,295).
