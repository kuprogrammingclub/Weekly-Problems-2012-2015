#Week 4
##Beginner
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/106go0/9202012_challenge_100_easy_sleep_cycle_estimator/">/r/dailyprogrammer</a>) The human body goes through 90 minute sleep cycles during the night, and you feel more refreshed if you wake up at the end of a sleep cycle than if you wake up during a sleep cycle. The challenge is to make a program that takes a wake-up time and outputs the possible times to fall asleep so that you will wake up at the end of a sleep cycle.

Example:

Input (Wake-up time): 6:15 AM

Output (when to go to sleep): 9:15 PM, 10:45 PM, 12:15 AM, or 1:45 AM

Bonus 1: Be able to input a sleep time and output potential wake-up times

Bonus 2: Account for how long it takes to fall asleep

##Advanced
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/106gse/9202012_challenge_100_intermediate_bad_word_filter/">/r/dailyprogrammer</a>) Write a program called 'censor' that takes in one argument on the command line. This argument is the filename of a newline-separated wordlist of profanity such as

<a>http://urbanoalvarez.es/blog/2008/04/04/bad-words-list/</a> or

<a>http://www.bannedwordlist.com/SwearWordResources.htm</a>

The program should then read a text from standard in, and print it out again, but replacing every instance of a word in the wordlist with a 'censored' version. The censored version of a word has the same first character as the word, and the rest of the characters are replaced with '*'.

For example, the 'censored' version of 'peter' would be 'p****'

Example:

<pre>
>echo 'You jerkface!' | censor badwords.txt
You j***face!
</pre>

-
