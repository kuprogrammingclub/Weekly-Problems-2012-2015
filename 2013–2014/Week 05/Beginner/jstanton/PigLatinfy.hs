{-
  PigLatinfy.hs
-}

import Data.Char
import Data.List


main =
  do 
  putStr "Enter string to 'PigLatinfy': "
  str <- getLine
  let wordsToConvert = words $ map toLower str
  putStrLn $ intercalate " " $ map convertTo wordsToConvert

vowels = "aeiou"

convertTo word = 
  if length front == 0
  then back ++ front ++ "way"
  else back ++ front ++ "ay"
  where
    front = takeWhile (\x-> not $ elem x vowels) word
    back  = dropWhile (\x-> not $ elem x vowels) word

