#Week 15
##Beginner
Most programming languages must employ a library to perform matrix operations familiar in Linear Algebra. Write a program that collects successive rows of integers that will fill a matrix. Collect rows for a second matrix. Then find the resultant matrix gained from multiplying the two together.
For example, your dialogue may collect
<pre>
> 1 2 3
> 4 3 1
> 9 4 8
>
> 1 0 0 
> 0 1 0
> 0 0 1
> 
>Printing our expression:
>[1 2 3]  [1 0 0]   [1 2 3]
>[4 3 1]  [0 1 0] = [4 3 1]
>[9 4 8]  [0 0 1]   [9 4 8]
</pre>

##Advanced
In Scrabble, you arrange words on a board and each letter is given a numerical value depended on its frequency of use in the English language. The score a word gets you is dependent on the cumulative sum of individual values ascribed to the letters the word is composed of. The difference between Scrabble and Words with Friends is that when you play Words with Friends, it's too easy to use the cheating app. But now you'll write a program that, given the point value of each word and a string of random text (you may test any string), write a program that determines the highest point value word that can be constructed. You may find it useful to grab a list of English words (on *nix systems, the line
<pre>
cat /usr/share/dict/words > ~/words.txt
</pre>
will copy the dictionary to a file 'words.txt' in your home directory). The name of that dictionary file you're copying from might be different, but it ought to be in that directory. You can also grab compiled English wordlists elsewhere online. 

Here's a link to the the letter values: 
<a>http://en.wikipedia.org/wiki/Scrabble_letter_distributions</a>

You may also find it useful to describe some general rules for how English words are composed, so that you may rule out combinations before you test them. Read a little into English Morphology if you want to optimize in this manner. 
