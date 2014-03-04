{-
  Disemvowel.hs
-}

import Data.List

vowels = "aeiou"

--Standard library version
dmv1 :: String -> (String, String)
dmv1 = partition ((flip elem) vowels) . filter ( /= ' ') 

-- From scratch
dmv2 :: String -> (String, String)
dmv2 []     = ([], [])
dmv2 (c:cs)  
  | elem c vowels = (c:stripped, body)
  | c == ' '      = (stripped, body) 
  | otherwise     = (stripped, c:body) where
  (stripped, body) = dmv2 cs