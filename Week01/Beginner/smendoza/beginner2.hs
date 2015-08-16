-- Author: Stefan Mendoza
-- Date: 16 August 2016
-- KU Competitive Programming, Week 1, Beginner Problem #2

{-# LANGUAGE OverloadedStrings #-}

module Main where

import qualified Data.List as L
import qualified Data.Text as T

main :: IO ()
main = putStrLn "Use GHCi."

palindrome :: String -> IO ()
palindrome phrase = do
    if spacesRemoved == T.reverse spacesRemoved
       then putStrLn $ "\"" ++ phrase ++ "\" is a palindrome!"
       else putStrLn $ "\"" ++ phrase ++ "\" is not a palindrome."
    where spacesRemoved = T.toLower $ T.replace " " "" $ T.pack phrase
