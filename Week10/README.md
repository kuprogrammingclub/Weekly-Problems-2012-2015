# Week 10

## Beginner 
Due to a catastrophic version control failure, Facebook finds itself needed to rewrite its friend-related algorithms. You are assigned with writing the code that outputs who likes a particular post. The algorithm is as follows:

* If only one person likes a post (e.g., Mark), then output `Mark likes this`.
* If only two people like a post (e.g., Mark and Giselle), then output `Mark and Giselle like this`.
* If only three people like a post (e.g., Mark, Giselle, and Rory), then output `Mark, Giselle and Rory like this`.
* If four or more people like a post (e.g., Mark, Giselle, Rory, and Lucy), then output `Mark, Giselle and 2 others like this`. Make to increase the amount in `and 2 others` depending on how many people like it.
* If no one like a post, then output `No one likes this :(`.

The input will be given as a space-separated list of names, ended by a newline.

```
> Mark
Mark likes this
> Mark Giselle
Mark and Giselle like this
> Mark Giselle Rory
Mark, Giselle and Rory like this
> Mark Giselle Rory Lucy
Mark, Giselle and 2 others like this
> 
No one likes this :(
```

## Advanced
An [IP address](http://en.wikipedia.org/wiki/IP_address) is a numeric label that you often use in networking. Some examples are `192.0.2.1`, `255.255.255.0`, and `169.254.0.0`. An IP address consits of four octets in the form `X.X.X.X`, where each `X` is a 32-bit unsigned integer (i.e., an integer from 0 to 255). For example, the IP address `128.32.10.1` can be decomposed as follows:

* The first octet, `128`, is `10000000` in binary.
* The second octet, `32`, is `00100000` in binary.
* The third octet, `10`, is `00001010` in binary.
* The fourth octet, `1`, is `00000001` in binary.

Therefore, `128.32.10.1` is equivalent to `10000000.00100000.00001010.00000001` in binary, or `2149583361` in decimal.

Your task is to write a function which converts a decimal representation of an IP address into the `X.X.X.X` form.

```
> 2149583361
128.32.10.1
> 123456789
7.91.205.21
```