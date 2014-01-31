#Week 11
##Beginner
(From <a href="http://programmingpraxis.com/2011/08/26/reverse-every-k-nodes-of-a-linked-list/">Programming Praxis</a>): Given a list of elements and a block size k, return the list of elements with every block of k elements reversed, starting from the beginning of the list. For instance, given the list 1, 2, 3, 4, 5, 6 and the block size 2, the result is 2, 1, 4, 3, 6, 5.

##Advanced
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/1g7gyi/061213_challenge_128_intermediate_covering/">r/DailyProgrammer</a>): Matrix city currently has very poor road conditions; full of potholes and are in dire need of repair. The city needs your help figuring out which streets (and avenues) they should repair. Chosen streets are repaired fully, no half measures, and are end-to-end. They're asking you to give them the minimum number of roads to fix such that all the potholes are still patched up. (They're on a very limited budget.)

Fortunately, the city was planned pretty well, resulting in a grid-like structure with its streets!

<b>Input description</b>: You will be given an integer N on standard input, which represents the N by N matrix of integers to be given next. You will then be given N number of rows, where each row has N number of columns. Elements in a row will be space delimited. Any positive integer is considered a good road without problems, while a zero or negative integer is a road with a pot-hole.

<b>Output description</b>: For each row you want to repair, print "row X repaired", where X is the zero-indexed row value you are to repair. For each column you want to repair, print "column X repaired", where X is the zero-indexed column value you are to repair.

For example,

>> 5
>> 0 4 0 2 2
>> 1 4 0 5 3
>> 2 0 0 0 1
>> 2 4 0 5 2
>> 2 0 0 4 0

Row 0 repaired.
Row 2 repaired.
Row 4 repaired.
Column 2 repaired.

x x x x x
1 4 x 5 3
x x x x x
2 4 x 5 2
x x x x x
