#Week 9
##Beginner
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

##Advanced
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

Words can be spelled horizontally (forwards or backwards), vertically (ascending or descending order), or diagonally in the grid. For example, the word HOLLAND can be found in the above grid:

```
F Y Y H N R <b><em>D</b></em>
R L J C I <b><em>N</b></em> U
A A W A <b><em>A</b></em> H R
N T K <b><em>L</b></em> P N E
C I <b><em>L</b></em> F S A P
E <b><em>O</b></em> G O T P N
<b><em>H</b></em> P O L A N D
```

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