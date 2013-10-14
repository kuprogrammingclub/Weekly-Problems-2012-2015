{-
  PigLatinfy.hs
-}

import Data.Char

vowels = "aeiou"

convertTo word = 
  if length front == 0
  then back ++ front ++ "way"
  else back ++ front ++ "ay"
  where
    front = takeWhile (\x-> not $ elem x vowels) word
    back  = dropWhile (\x-> not $ elem x vowels) word

