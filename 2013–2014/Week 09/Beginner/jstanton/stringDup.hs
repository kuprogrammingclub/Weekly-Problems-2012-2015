pullDup str = pullDupChar str [] [] 

pullDupChar []  str dups = (reverse str, reverse dups)
pullDupChar [c] str dups = (reverse (c:str), reverse dups)
pullDupChar (c1:c2:rest) str dups = 
  if c1 == c2
  then pullDupChar (c2:rest) str (c1:dups)
  else pullDupChar (c2:rest) (c1:str) dups

test1 = "balloons"
test2 = "ddaaiillyypprrooggrraammeerr"
test3 = "dddaaaiiilllyyyppprrrooogggrrraaammmeeerrr"
test4 = "aaabbb"
test5 = "flabby aapples"
test6 = "so    many        spaces     in this"
tests = [test1,test2,test3,test4,test5,test6]
