-- funny.hs
{- determines if a string is "funny" i.e. if the absolute difference in ascii 
   values of adjacent characters reads the same forward and backward -}

module Funny where

import Data.Char
import Data.Function

main :: IO ()
main = interact $ unlines . map funnyLine . lines

funnyLine :: String -> String
funnyLine xs | isFunny xs = "Funny"
	     | True    	  = "Not Funny"

isFunny :: String -> Bool
isFunny xs = isPalindrome $ zipWith ((abs .) . (-) `on` ord) xs (tail xs)

isPalindrome :: Eq a => [a] -> Bool
isPalindrome xs = and $ zipWith (==) xs (take ((length xs + 1) `div` 2) $ reverse xs)
