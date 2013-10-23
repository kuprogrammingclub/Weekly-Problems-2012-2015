#!/bin/bash

q="'"
r='"'
s="="
u='echo -e $p$n$n\\q$s$r$q$r$n\\r$s$q$r$q$n\\s$s$r$s$r\necho u$s$q$u$q\necho -e p$s$r$p$r$n\\n$s$r$m$r\necho m$s$q\\\\\\\\n$q\nprintf "$u"'
p="#!/bin/bash"
n="\n"
m='\\n'
echo -e $p$n$n\q$s$r$q$r$n\r$s$q$r$q$n\s$s$r$s$r
echo u$s$q$u$q
echo -e p$s$r$p$r$n\n$s$r$m$r
echo m$s$q\\\\n$q
printf "$u"
