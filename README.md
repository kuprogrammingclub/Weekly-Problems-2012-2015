KU Programming Club
===================

Week 01
=======

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



Week 02
=======

### Beginner
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/1kphtf/081313_challenge_136_easy_student_management/">/r/DailyProgrammer</a>) You are a computer science professor at South Harmon Institute of Technology, and are in dire need of automatic grading! The good news is you have all of your student's assignments in an easy-to-read format, making automation easy!

You will be given a list of unique student names, and then a list of their assignment grades. All assignments are based on 20 points and are scored in whole-numbers (integers). All students have received the same number of assignments, so you don't have to worry about managing <a href="http://en.wikipedia.org/wiki/Iliffe_vector">jagged arrays</a>.

(Note, it says arrays there, but there should be a way to do it without arrays if you haven't covered them yet in a class if you're clever with your loops and outputs.)

### Advanced
Did you get tired of simplifying Boolean Algebra expressions by hand for Dr. Minden? Me too. Deduce the formal grammar for Boolean Algebra and write a program that can do your homework, that is, take a well-formed Boolean expression and simplify it as far as can be done. So if we have:

    A`B`C + AB`C + ABC + ABC`
    B`C + AB

Define your grammar using any symbols you'd like for unary and binary operators. If you find it necessary, feel free to use other symbols, such as parens for separating expressions clearly.



Week 03
=======

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



Week 04
=======

### Beginner
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/1givnn/061713_challenge_130_easy_roll_the_dies/">/r/DailyProgrammer</a>) In many board games, you have to roll <a href="http://en.wikipedia.org/wiki/File:Dice_(typical_role_playing_game_dice).jpg">multiple multi-faces dice</a> to generate random numbers as part of the game mechanics. A classic die used is the d20 (die of 20 faces) in the game Dungeons & Dragons. This notation, often called the <a href="http://en.wikipedia.org/wiki/Dice_notation">Dice Notation</a>, is where you write NdM, where N is a positive integer representing the number of dies to roll, while M is a positive integer equal to or grater than two (2), representing the number of faces on the die. Thus, the string "2d20" simply means to roll the 20-faced die twice. On the other hand "20d2" means to roll a two-sided die 20 times.

Your goal is to write a program that takes in one of these Dice Notation commands and correctly generates the appropriate random numbers. Note that it does not matter how you <a href="http://en.wikipedia.org/wiki/Random_seed">seed your random number generation</a>, but you should try to as good programming practice.

For example:

    >> 2d20
    19 7
    >> 4d6
    5 3 4 6

### Advanced
(from <a href="http://www.reddit.com/r/dailyprogrammer/comments/1ee664/050813_challenge_124_intermediate_circular_graphs/">/r/DailyProgrammer</a>) A classic problem in computer science and <a href="http://en.wikipedia.org/wiki/Graph_theory">graph theory</a> is to detect if there are any <a href="http://en.wikipedia.org/wiki/Cycle_(graph_theory)">circular paths</a> in a given directed graph (sometimes called a cycle). Your goal is to write a program that takes in a series of edges, which defines a graph, and then print all sets of cycles onto a console or text file.

For the sake of clarity, we define a cycle as a set of vertices that have at least one incoming edge and one outgoing edge, where each node is only directly connected to at most two other nodes within the list.

You will first be given an integer N, which represents the number of edges that will be given on each following new-line. Edges are defined as two integer numbers, where the direction of the edge always goes from the left vertex to the right vertex. Simply print all vertices in a directed cycle; make sure that the cycle is closed. For example:

    >> 4
    >> 1 2
    >> 2 3
    >> 3 1
    >> 3 4
    1 2 3 1



Week 05
=======

### Beginner
(adapted from <a href="http://openbookproject.net/pybiblio/practice/wilson/piglatin.php">here</a>): You are going to create a translation machine for a very specific language: <a href="https://en.wikipedia.org/wiki/Pig_Latin">Pig Latin</a>. For example, "Competitive programming" translates to "Ompetitivecay ogrammingpray" in Pig Latin, and "Apples" translates to either "Applesway" or "Applesyay" depending on the dialect of Pig Latin you prefer. Optionally, you can also create a machine that translates from Pig Latin back to English.

### Advanced
(from <a href="http://projecteuler.net/problem=31">Project Euler</a>): In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p)

It is possible to make £2 in the following way:

    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

How many different ways can £2 be made using any number of coins?



Week 06
=======

### Beginner
Using any language you choose (as per usual), implement a <a href="http://en.wikipedia.org/wiki/Quine_(computing)">quine</a>, that is, a program that takes no input but outputs its own source code. Bonus cool points for writing programs as concise as possible, or for writing programs that would create a loop between languages if each output was actually compiled and ran.

### Advanced
(Something mathy from <a href="http://www.reddit.com/r/dailyprogrammer/comments/1fcpnx/053013_challenge_126_intermediate_perfect_pth/">/r/DailyProgrammer</a>): An integer X is a "perfect square power" if there is some integer Y such that Y<sup>2</sup> = X. An integer X is a "perfect cube power" if there is some integer Y such that Y<sup>3</sup> = X. We can extrapolate this where P is the power in question: an integer X is a "perfect Pth power" if there is some integer Y such that Y<sup>P</sup> = X.

Your goal is to find the highest value of P for a given X such that for some unknown integer Y, Y<sup>P</sup> should equal X. You can expect the given input integer X to be within the range of an unsigned 32-bit integer (0 to 4,294,967,295).



Week 07
=======

### Beginner
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/w4ma2/762012_challenge_73_intermediate/">/r/DailyProgrammer</a>): Write a program that, given an ASCII binary matrix of 0's and 1's like this:

    0000000000000000
    0000000000000000
    0000011001110000
    0000001111010000
    0000011001110000
    0000011011100000
    0000000000110000
    0000101000010000
    0000000000000000
    0000000000000000
    0000000000000000

Outputs the smallest cropped sub-matrix that still contains all 1's (that is, remove all borders of 0's):

    01100111
    00111101
    01100111
    01101110
    00000011
    10100001

### Advanced
(Adapted from <a href="http://openbookproject.net/pybiblio/practice/elkner/literaryanalysis.php">here</a>): Your English teacher has just asked you to write a paper analyzing a classic work of literature. Since you are an amazing programmer, you decide to put your skills to use. You plan to create a computer-generated report of the vocabulary used in your favorite literary classic.

Your objective is to write a program that will take a text file as input and return a report listing alphabetically all the words in the file and the number of occurrences of each. An example text (Lewis Carroll's <em>Through the Looking-Glass</em>) can be found <a href="http://www.gutenberg.org/cache/epub/12/pg12.txt">here</a>.



Week 08
=======

### Beginner
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/1k7s7p/081313_challenge_135_easy_arithmetic_equations/">/r/DailyProgrammer</a>): <a href="http://en.wikipedia.org/wiki/Unix">Unix</a>, the famous multitasking and multi-user operating system, has several standards that defines Unix commands, system calls, subroutines, files, etc. Specifically within <a href="http://en.wikipedia.org/wiki/Version_7_Unix">Version 7</a> (though this is included in many other Unix standards), there is a game called "arithmetic". To quote the <a href="http://en.wikipedia.org/wiki/Man_page">Man Page</a>:

> Arithmetic types out simple arithmetic problems, and waits for an answer to be typed in. If the answer is correct, it types back "Right!", and a new problem. If the answer is wrong, it replies "What?", and waits for another answer. Every twenty problems, it publishes statistics on correctness and the time required to answer.

Your goal is to implement this game, with some slight changes, to make this an [Easy]-level challenge. You will only have to use three arithmetic operators (addition, subtraction, multiplication) with four integers. An example equation you are to generate is <tt>2 x 4 + 2 - 5</tt>.

### Advanced
(From <a href="http://programmingpraxis.com/2013/08/16/monkey-grid-puzzle/">Programming Praxis</a>): There is a monkey which can walk around on a planar grid. The monkey can move one space at a time left, right, up or down. That is, from <tt>(x, y)</tt> the monkey can go to <tt>(x+1, y)</tt>, <tt>(x-1, y)</tt>, <tt>(x, y+1)</tt>, and <tt>(x, y-1)</tt>. Points where the sum of the digits of the absolute value of the x coordinate plus the sum of the digits of the absolute value of the y coordinate are lesser than or equal to 19 are accessible to the monkey. For example, the point <tt>(59, 79)</tt> is inaccessible because <tt>5 + 9 + 7 + 9 = 30</tt>, which is greater than 19. Another example: the point <tt>(-5, -7)</tt> is accessible because <tt>abs(-5) + abs(-7) = 5 + 7 = 12</tt>, which is less than 19. How many points can the monkey access if it starts at <tt>(0, 0)</tt>, including <tt>(0, 0)</tt> itself?

Your task is to write a program that counts the number of available points. When you are finished, you are welcome to <a href="http://programmingpraxis.com/2013/08/16/monkey-grid-puzzle/2/">read</a> or <a href="http://programmingpraxis.codepad.org/68dndvxS">run</a> a suggested solution, or to post your own solution or discuss the exercise in the comments below.



Week 09
=======

### Beginner
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/qzil1/3162012_challenge_26_easy/">/r/DailyProgrammer</a>): Given a string, remove consecutive duplicate letters and put them in a separate string. Print out both the string with the letters removed and a string made of the removed letters. For example:

```
>> balloons
balons
lo

>> ddaaiillyypprrooggrraammeerr
dailyprogramer
dailyprogramer

>> aaabbbb
ab
aabbb

>> flabby aapples
flaby aples
bap
```

### Advanced
(From <a href="http://programmingpraxis.com/2009/05/26/word-search-solver/">Programming Praxis</a>): <a href="https://en.wikipedia.org/wiki/Word_search">Word searches</a> are a type of puzzle game in which a player must find certain words hidden in a grid of letters, such as:

```
F Y Y H N R D
R L J C I N U
A A W A A H R
N T K L P N E
C I L F S A P
E O G O T P N
H P O L A N D
```

Words can be spelled horizontally (forwards or backwards), vertically (ascending or descending order), or diagonally in the grid. For example, the word HOLLAND can be found in the above grid by starting from the bottom-left corner and going diagonally up-right.

Since you are lazy, you decide to write a program to do word searches for you. Your program will need a list of words to find (e.g., ITALY, HOLLAND, POLAND, SPAIN, FRANCE, JAPAN, TOGO, and PERU) and a grid of letters. Given these, the program should output all of the chosen words that it could find, the location of the first letter, and in which direction the word is oriented. For example, with the above grid:

```
ITALY row 5 column 2 up
HOLLAND row 7 column 1 up right
POLAND row 7 column 2 right
SPAIN row 5 column 5 up
FRANCE row 1 column 1 down
JAPAN row 2 column 3 down right
TOGO row 6 column 5 left
PERU row 5 column 7 up
```



Week 10
=======

### Beginner
(From <a href="http://programmingpraxis.com/2012/10/09/two-word-games/">Programming Praxis</a>):  It’s been a while since we played word games. We have two today:

1. Find all the words in a dictionary that contain exactly five vowels (a, e, i, o and u) in ascending order.

2. Find all the words in a dictionary of length at least six that contain letters in strictly ascending alphabetical order.

These games are easy to play using regular expressions, so you should solve them without regular expressions, using only simple string manipulations. If your system doesn’t provide a dictionary, you can find one at <a>http://icon.shef.ac.uk/Moby/mwords.html</a>.

Your task is to play the two games.

### Advanced
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/1b3ka1/032713_challenge_121_intermediate_path_to/">/r/DailyProgrammer</a>): Clicking on the first link in the main text of a Wikipedia article not in parentheses or italics, and then repeating the process for subsequent articles, usually eventually gets you to the Philosophy article. As of May 26, 2011, 94.52% of all articles in Wikipedia lead eventually to the article Philosophy. The rest lead to an article with no wikilinks or with links to pages that do not exist, or get stuck in loops. <a href="http://www.youtube.com/watch?v=vehDe2lSptU">Here's a Youtube video demonstrating this phenomenon</a>.

Your goal is to write a program that will find the path from a given article to the Philosophy article by following the first link (not in parentheses, italics or tables) in the main text of the given article. Make sure you have caching implemented from the start so you only need to fetch each page once.

You will then extend the program to do a depth-first search in search of the Philosophy article, backtracking if you get stuck and quitting only when you know there is no such path. The last thing you will do is generalise it to do a DFS towards any goal article.

Hint: Yes, there is a Wikipedia API. Feel free to use it.

The original formulation of this problem is found in the alternative text to <a href="http://www.youtube.com/watch?v=vehDe2lSptU">XKCD: Extended Mind</a>.

<b>Input description</b>: Two strings, both which are names of existing Wikipedia articles (in the Wikipedia language of your choice).

<b>Output description</b>: A path of Wikipedia articles, each linked from the previous one, that leads from the start article to the end article.

* Links in parentheses, italics and tables should not be considered
* Links leading outside the main article namespace should not be considered
* Links are to be considered in the order they appear in an article
* The path should be created in a depth-first fashion
* You must implement article caching early on

You choose the output datastructure yourself, or print to standard-out.

<b>Sample input</b>:

* From: Molecule
* To: Philosophy

<b>Sample output</b>:

* Molecule
* Atom
* Matter
* Invariant mass
* Energy
* Kinetic energy
* Physics
* Natural philosophy
* Philosophy

<b>Challenge input</b>:

* From: Asperger syndrome
* To: Logic

<b>Challenge output</b>:

* Asperger syndrome
* Autism spectrum
* Pervasive developmental disorder
* Mental disorder
* Psychology
* Applied science
* Natural science
* Science
* Knowledge
* Fact
* Proof (truth)
* Necessity and sufficiency
* Logic



Week 11
=======

### Beginner
(From <a href="http://programmingpraxis.com/2011/08/26/reverse-every-k-nodes-of-a-linked-list/">Programming Praxis</a>): Given a list of elements and a block size k, return the list of elements with every block of k elements reversed, starting from the beginning of the list. For instance, given the list 1, 2, 3, 4, 5, 6 and the block size 2, the result is 2, 1, 4, 3, 6, 5.

### Advanced
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/1g7gyi/061213_challenge_128_intermediate_covering/">r/DailyProgrammer</a>): Matrix city currently has very poor road conditions; full of potholes and are in dire need of repair. The city needs your help figuring out which streets (and avenues) they should repair. Chosen streets are repaired fully, no half measures, and are end-to-end. They're asking you to give them the minimum number of roads to fix such that all the potholes are still patched up. (They're on a very limited budget.)

Fortunately, the city was planned pretty well, resulting in a grid-like structure with its streets!

<b>Input description</b>: You will be given an integer N on standard input, which represents the N by N matrix of integers to be given next. You will then be given N number of rows, where each row has N number of columns. Elements in a row will be space delimited. Any positive integer is considered a good road without problems, while a zero or negative integer is a road with a pot-hole.

<b>Output description</b>: For each row you want to repair, print "row X repaired", where X is the zero-indexed row value you are to repair. For each column you want to repair, print "column X repaired", where X is the zero-indexed column value you are to repair.

For example,
```
>> 5
>> 0 4 0 2 2
>> 1 4 0 5 3
>> 2 0 0 0 1
>> 2 4 0 5 2
>> 2 0 0 4 0
```

```
Row 0 repaired.
Row 2 repaired.
Row 4 repaired.
Column 2 repaired.
```

```
x x x x x
1 4 x 5 3
x x x x x
2 4 x 5 2
x x x x x
```



Week 12
=======

Both of these challenges come from KU ACM's 2013 <a href="https://github.com/KU-Competitive-Programming/ku-acm-competition-2013/blob/master/problem_set.pdf?raw=true">programming competition</a>.

### Beginner

<u>Problem 1: <b>(filter web)</b></u>

As a programmer, you find unbalanced parentheses unsightly, so you decide to write a program to shield your eyes whilst browsing the interwebs. You figure if the author couldn’t balance their parentheses, they probably didn’t have anything good to say, so you might as well discard their message.

A balanced string is a string for which each and every ‘(‘ has a matching ‘)’ somewhere to its right. We are programmers, so parentheses may be nested.

<b>Input</b>: write a program that reads multiple strings, separated by newlines, from stdin.

<b>Output</b>: If the parentheses in the string are balanced, or if it contains no parentheses, print <code>balanced</code> to stdout; otherwise print out <code>unbalanced</code>. Each entry should be separated by newlines.

```
sample input                    sample output

(word (with friends))           balanced
)()BALANCED?(()                 unbalanced
ever and forever and for        balanced
o()xxx[{::::::::::::>           balanced
quoted ones still break "("     unbalanced
```

### Advanced

<u>Problem 6: <b>(Der Braillekönig)</b></u>

Towards the end of Franz Schubert’s life, he had gone both deaf and blind, so he converted all his sheet music to braille, using braille letters and symbols to stand for each note. Schubert wasn’t a fan of documentation though, so he always omitted the key signatures from his pieces. Despite your modest knowledge of music, the Royal Museum has tasked you with determining the key of each piece of music. Music is normally arrayed on a staff like so:

![What an incredible alt text](https://raw.github.com/KU-Competitive-Programming/Weekly-Problems/master/2013%E2%80%932014/Week%2012/staff.png)

Luckily, Ada Lovelace produced a braille reading routine that converts each piece of sheet music to a stream of characters, where E, F, G, A, B, C, D represent the notes.

Notes are encoded with further information using a prefix and suffix system. The beat prefix indicates how long the note is held. Whole notes are preceded by a 'w', half notes by an 'h', quarter notes by a 'q', eighth notes by an 'e', and sixteenth notes be an 's'. Rests are denoted by an 'r' and accept the same beat prefixes as notes. A note is 'sharp' if it is followed by a '#', and it is flat if followed by a lowercase 'b'. Thanks, Ada!

Each major key signature has the following characteristics: (Gist: <a>http://bit.ly/13ZKpW1</a>)

```
C major - (no sharps or flats)
G major - F#                            F major - Bb
D major - F#, C#                        Bb major - Bb, Eb
A major - F#, C#, G#                    Eb major - Bb, Eb, Ab
E major - F#, C#, G#, D#                Ab major - Bb, Eb, Ab, Db
B major - F#, C#, G#, D#, A#            Db major - Bb, Eb, Ab, Db, Gb
F# major - F#, C#, G#, D#, A#, E#       Gb major - Bb, Eb, Ab, Db, Gb, Cb
C# major - F#, C#, G#, D#, A#, E#, B#   Cb major - Bb, Eb, Ab, Db, Gb, Cb, Fb
```

For instance, a stream of music that consists entirely of the characters:

    qF#eF#qEeDqEeDeC#qBqAeG#eAeC#eEeA

would be in A major, since it contains F#, C#, and G#.

We know each piece of music to be complete, to contain all notes in its scale, and to be in a major key (Schubert was <em>insanely</em> happy). For example, if by the end of a piece you have encountered a Bb and an Eb but no additional flats, you may assume the key to be Bb major.

<b>Input</b>: stdin will consist of successive streams of music, separated by newlines.

<b>Output</b> should be the key of the music as named in the above table (that is, without quotes), separated by newlines. You may assume the key never changes and that there are no double sharps/flats. Assume that all pieces of music correspond to the above grammar (i.e. there are no errors in the input).

```
sample input                    sample output
sCsDsEsFsGsAsBsC                C major
hBqA#qG#hF#hEhD#qC#qF#wB        B major
```
