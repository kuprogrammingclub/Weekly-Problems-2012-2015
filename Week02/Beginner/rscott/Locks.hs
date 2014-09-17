module Main where

import Data.Word
import System.Environment

-------------------------------------------------------------------------------
-- The workhorse of the program

totalIncrements :: Int -> Int -> Int -> Int -> Int
totalIncrements n d1 d2 d3 =
    let turn1 = 2 * n + d1
        turn2 = n + ((d1 - d2) `mod` n)
        turn3 = if d3 == d2 then n else (d3 - d2) `mod` n
     in turn1 + turn2 + turn3

-------------------------------------------------------------------------------
-- Other silly things

main :: IO ()
main = do
    args <- getArgs
    case args of
         n:d1:d2:d3:_ -> print $ totalIncrements (read n) (read d1) (read d2) (read d3)
         _            -> printUsage

printUsage :: IO ()
printUsage = do
    progName <- getProgName
    putStrLn $ usage progName

usage :: String -> String
usage progName = unlines [ "usage: " ++ progName ++ " N d1 d2 d3"
                         , "where N is the number of digits on the lock, starting from 0,"
                         , "and d1, d2, and d3 are digits 1 through 3, respectively"
                         ]