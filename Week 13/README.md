#Week 12
##Beginner
(From <a href="http://www.reddit.com/r/dailyprogrammer/comments/19mn2d/030413_challenge_121_easy_bytelandian_exchange_1/">/r/dailyprogrammer</a>) Bytelandian Currency is made of coins with integers on them. There is a coin for each non-negative integer (including 0). You have access to a peculiar money changing machine. If you insert a N-valued coin, with N positive, It pays back 3 coins of the value N/2,N/3 and N/4, rounded down. For example, if you insert a 19-valued coin, you get three coins worth 9, 6, and 4. If you insert a 2-valued coin, you get three coins worth 1, 0, and 0. <em>0-valued coins cannot be used in this machine.</em>

One day you're bored so you insert a 7-valued coin. You get three coins back, and you then insert each of these back into the machine. You continue to do this with every positive-valued coin you get back, until finally you're left with nothing but 0-valued coins. You count them up and see you have 15 coins.

How many 0-valued coins could you get starting with a single 1000-valued coin? (e.g., entering "7" would give an answer of 15)

##Advanced
Let's face it, information is usually displayed in a pretty cruddy manner. Pretty much everything has to be couched in ads, and you also have to bear someone's atrocious typeface and, heaven-forbid, blinking text or distracting gifs. Was Web 2.0 a thing that just didn't happen to some people? Let's take a moment to explore the art of screen scraping. Given the webpage for a 5-day forecast (<a>http://www.weather.com/weather/5-day/Lawrence+KS+USKS0319:1:US</a>), write a program that gathers the meteorological data for each day and outputs it to a file in an organized pure text format. 

Of course, there are many ways to do this, but many programming languages have support for screen scraping functionality to varying degrees, normally as third-party libraries. The Python library, Beautiful Soup, is designed for the exact purpose of extracting organized web data. Regular Expressions are also a fast way of performing pattern matching that does not rely on a large set of enormously long conditionals, and are often used as effective arguments to screen scraping methods.

-
