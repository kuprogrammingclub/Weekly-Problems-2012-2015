# Week 10

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
