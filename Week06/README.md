# Week 6 - Wednesday, 2 December 2015


## Beginner - TBA
__Source__: TBA
<br>


## Intermediate 1 - VHS Recording Problem
__Source__: https://www.reddit.com/r/dailyprogrammer/comments/3u6o56/20151118_challenge_242_intermediate_vhs_recording/

All nineties kids will remember the problem of having to program their VHS
recorder to tape all their favorite shows. Especially when 2 shows are aired at
the same time, which show do we record? Today we are going to program the recorder,
so that we have a maximum amount of tv shows on one tape.<br>

You receive a timetable with when the shows start and when it ends. All times
are in Military time. We can switch between channels instantaneously, so if a
shows start on the same time a other one stops, you can record them.<br>


### Part 1
We want to know what shows we have recorded, so instead of showing the number of
shows, show the names of the shows we recorded.

#### Sample Input 1
```
1535 1610 Pokémon
1610 1705 Law & Order
1615 1635 ER
1615 1635 Ellen
1615 1705 Family Matters
1725 1810 The Fresh Prince of Bel-Air
```

#### Sample Output 1
```
Pokémon
Law & Order
The Fresh Prince of Bel-Air
```

### Part 2

Now the first line will be a must see show. We don't care if we don't max out
the number of shows, but we sure want to have our favorite recorded.

#### Sample Input 2
```
The Fresh Prince of Bel-Air
1530 1555 3rd Rock from the Sun
1550 1615 The Fresh Prince of Bel-Air
1555 1615 Mad About You
1615 1650 Ellen
1655 1735 Quantum Leap
```

#### Sample Output 2
```
The Fresh Prince of Bel-Air
Ellen
Quantum Leap
```
<br>


## Intermediate 2 - Quicksort In-Place
__Source__: https://www.hackerrank.com/challenges/quicksort3

Create an in-place version of Quicksort. You need to follow
[Lomuto Partitioning](http://en.wikipedia.org/wiki/Quicksort#Algorithm) method.

#### Input Description
There will be two lines of input:<br>
n - the size of the array<br>
ar - the n numbers of the array<br>

#### Output Format
Print the entire array on a new line at the end of every partitioning method.

#### Constraints
1 ≤ n ≤ 5000<br>
−10000 ≤ x ≤ 10000,x ∈ ar<br>
There are no duplicate numbers.<br>

#### Sample Input
```
7
1 3 9 8 2 7 5
```

#### Sample Output
```
1 3 2 5 9 7 8
1 2 3 5 9 7 8
1 2 3 5 7 8 9
```
<br>


## Hard - TBA
__Source__: TBA
