# pflor

A Clojure library designed to take 5 seconds to start up, then
crop a matrix to not have all-0 border columns or rows.

## Usage

Make sure you have java version >= 6 and (leiningen)[http://leiningen.org/] installed.

Put your matrix of the form:

```
00000000000
01101111100
00111101111
00000000000
```

in a file in `resources/`

Then `lein run resources/the-filename`

## License

Copyright © 2013 pflor

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
