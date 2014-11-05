module Rot13 where

import Data.Char

shift :: Char -> Char
shift c | isAsciiLower c = shifted 'a'
        | isAsciiUpper c = shifted 'A'
        | otherwise = c
  where
    shifted a = chr $ ((ord c - ord a + delta) `mod` range) + ord a
    range = ord 'z' - ord 'a' + 1
    delta = 13

rot13 :: String -> String
rot13 = map shift