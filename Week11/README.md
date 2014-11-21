#Week 11
##Beginner
Print the numbers from 1 to 1000 without using any loop or conditional statements. Don’t just write the printf() or cout statement 1000 times. Be creative and try to find the most efficient way!

##Advanced
To give a holiday theme. Santa is busy delivering presents on Christmas Eve. A strong gust of wind blows away his map. He knows his relative location to the next house but there are new skyscrapers built in the neighborhood since last year. Give Santa instructions on how to get to the next house.

Input:
You will receive the size of the map which is a square, followed by a map with S for Santa and 1 for the next house with # as buildings and other noncrossable terrain.

Output:
Give a list of movements he needs to make to reach the next house.

`````````
> 5
> #S ##
> ##  #
>     #
> #  #1
> ##

East, South, South, South, South, East, East, North
``````````
Output doesn't have to be on the same line. Can use left, right, up and down instead of cardinal directions.

Bonus:
1. Make it able to take rectangle maps instead of just a square.
2. Make it able to take in multiple houses with the order of the houses he must travel as denoted by the value they are given, ex. 1, 2, etc. If he is on a house you must say Stop, before continuing on to the next house.
