#Week 4
##Beginner
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/1givnn/061713_challenge_130_easy_roll_the_dies/">/r/DailyProgrammer</a>) In many board games, you have to roll <a href="http://en.wikipedia.org/wiki/File:Dice_(typical_role_playing_game_dice).jpg">multiple multi-faces dice</a> to generate random numbers as part of the game mechanics. A classic die used is the d20 (die of 20 faces) in the game Dungeons & Dragons. This notation, often called the <a href="http://en.wikipedia.org/wiki/Dice_notation">Dice Notation</a>, is where you write NdM, where N is a positive integer representing the number of dies to roll, while M is a positive integer equal to or grater than two (2), representing the number of faces on the die. Thus, the string "2d20" simply means to roll the 20-faced die twice. On the other hand "20d2" means to roll a two-sided die 20 times.

Your goal is to write a program that takes in one of these Dice Notation commands and correctly generates the appropriate random numbers. Note that it does not matter how you <a href="http://en.wikipedia.org/wiki/Random_seed">seed your random number generation</a>, but you should try to as good programming practice.

For example:

    >> 2d20
    19 7
    >> 4d6
    5 3 4 6

##Advanced
(from <a href="http://www.reddit.com/r/dailyprogrammer/comments/1ee664/050813_challenge_124_intermediate_circular_graphs/">/r/DailyProgrammer</a>) A classic problem in computer science and <a href="http://en.wikipedia.org/wiki/Graph_theory">graph theory</a> is to detect if there are any <a href="http://en.wikipedia.org/wiki/Cycle_(graph_theory)">circular paths</a> in a given directed graph (sometimes called a cycle). Your goal is to write a program that takes in a series of edges, which defines a graph, and then print all sets of cycles onto a console or text file.

For the sake of clarity, we define a cycle as a set of vertices that have at least one incoming edge and one outgoing edge, where each node is only directly connected to at most two other nodes within the list.

You will first be given an integer N, which represents the number of edges that will be given on each following new-line. Edges are defined as two integer numbers, where the direction of the edge always goes from the left vertex to the right vertex. Simply print all vertices in a directed cycle; make sure that the cycle is closed. For example:

    >> 4
    >> 1 2
    >> 2 3
    >> 3 1
    >> 3 4
    1 2 3 1
