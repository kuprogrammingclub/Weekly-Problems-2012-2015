# Week 2

## Beginner 

Draw a tree on your console using ASCII characters. For example,

```
> 7 # *
   *
  ***
 *****
*******
  ###
```

The input will be of the form *n* *t* *l*, where *n* is an odd integer greater than or equal to 3, *t* is the trunk character, and *l* is the leaves character. The tip of the tree will always consist of one *l* character, and each lower level adds two more *l* characters until the last level, which has *n* characters. The trunk will always consist of three *t* characters.

## Advanced
[Benford's law](http://en.wikipedia.org/wiki/Benford's_law) is a statistical phenomenon that occurs in numerical data. It states that in real-life sources of data sets, the number 1 occurs as the leading digit of a number about 30% of the time. This somewhat counterintuitive result has been shown to hold for street addresses, stock prices, ballot results, and much more.

Don't believe me? Why don't you verify it yourself? [Here](Advanced/lakes.csv) is a [comma-separated values (CSV)](http://en.wikipedia.org/wiki/Comma-separated_values) file containing data about Minnesota's lakes (scraped from [here](http://www.lakehomes.com/lakestats-mn.html)). Your task is to compute the first-digit distribution of some column from the lake data, be it size, littoral area, max depth, or water clarity.