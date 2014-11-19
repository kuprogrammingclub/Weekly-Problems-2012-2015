module Likes where

import System.Environment

likes :: [String] -> String
likes []        = "No one likes this :("
likes [x]       = x ++ " likes this"
likes [x, y]    = x ++ " and " ++ y ++ " like this"
likes [x, y, z] = x ++ ", " ++ likes [y, z]
likes (x:x':xs) = x ++ ", " ++ x' ++ " and " ++ show (length xs) ++ " others like this"

main :: IO ()
main = getArgs >>= putStrLn . likes
