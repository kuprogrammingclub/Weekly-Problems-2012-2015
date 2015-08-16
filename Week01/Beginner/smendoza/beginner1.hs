-- Author: Stefan Mendoza
-- Date: 16 August 2016
-- KU Competitive Programming, Week 01, Beginner Problem #1

module Main where

main :: IO ()
main = do
    putStrLn "What's your name?"
    putStr "> "
    name <- getLine
    putStrLn $ "Hello, " ++ name ++ "!"
