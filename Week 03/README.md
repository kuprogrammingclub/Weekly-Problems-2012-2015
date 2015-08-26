# Week 3

### Beginner
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/1m1jam/081313_challenge_137_easy_string_transposition/">/r/DailyProgrammer</a>) It can be helpful sometimes to rotate a string 90-degrees, like a big vertical "SALES" poster or your business name on vertical neon lights, like <a href="http://imgur.com/766x8uM">this image from Las Vegas</a>. Your goal is to write a program that does this, but for multiples lines of text. This is very similar to a <a href="http://en.wikipedia.org/wiki/Transpose">Matrix Transposition</a>, since the order we want returned is not a true 90-degree rotation of text.

For example, if you're given the input

    5
    Kernel
    Microcontroller
    Register
    Memory
    Operator

then your program should output the result:

    KMRMO
    eieep
    rcgme
    nrior
    eosra
    lctyt
     oe o
     nr r
     t
     r
     o
     l
     l
     e
     r

Visit the <a href="http://www.reddit.com/r/dailyprogrammer/comments/1m1jam/081313_challenge_137_easy_string_transposition/">/r/DailyProgrammer</a> link for a full description of input restrictions (or, if you feel ambitious, you can ignore input restrictions altogether).

### Advanced
(from <a href="http://projecteuler.net/problem=22">Project Euler</a>): If you're not familiar with Project Euler, it is a website dedicated to devising computational problems that are intended to be solved by computers (ideally in a minute or less). Some of the problems require advanced mathematics, but I'll try to avoid them. The cool thing about Project Euler is that each problem has a specific answer, so if you come up with the answer, then submit it to the website for points! (And brag about it at meetings too.) Here is a typical problem:

Using [names.txt](Advanced/names.txt) (a 46K text file containing over five-thousand first names), begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
