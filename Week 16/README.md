# Week 16

### Beginner
Take some string and find the longest substring that appears more than once in the string. If there is no longest repeated substring, return some error value. Examples:

<pre>
lrs("abcabcaacb") => "abca"
lrs("aababa") => "aba"
lrs("abcdefg") => NoLongestRepeatedSubstringError (or something to that effect)
</pre>

### Advanced
Take a grayscale PNG image and "colorize" it. The color scheme (e.g., sepia, reds, blues) can be your choice, but try to preserve the original image's brightness and contrast as much as possible. Also preserve transparency if the PNG image uses it. Some examples to take inspiration from are:

![Before...](http://i.stack.imgur.com/4BI8K.png "Grayscale")![...After!](http://i.stack.imgur.com/3ey5E.png "Colorized")
