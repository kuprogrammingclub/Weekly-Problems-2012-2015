# Week 12

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
