-- rot13.hs
-- Andrei Elliott
-- Ceaser cypher program

import Data.Char
import Data.List


main = interact $ unlines . map rot13 . lines

rotate :: Int -> String -> String
rotate n = map (encode n . toLower)


rot13 = rotate 13


encode :: Int -> Char -> Char
encode n c = let ls = ['a'..'z'] in case elemIndex c ls of
       	     	      		    	 Just i -> cycle ls !! (i + n)
					 Nothing -> c