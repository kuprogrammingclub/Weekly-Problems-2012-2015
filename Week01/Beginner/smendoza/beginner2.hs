-- Author: Stefan Mendoza
-- Date: 16 August 2016
-- KU Competitive Programming, Week 1, Beginner Problem #2

{-# LANGUAGE OverloadedStrings #-}

module Main where

import Data.Char

main :: IO ()
main = putStrLn "Use GHCi."

palindrome :: String -> IO ()
palindrome phrase =
    let spacesRemoved = map toLower $ filter (`elem` (['a'..'z'] ++ ['A'..'Z'])) phrase in
    if spacesRemoved == reverse spacesRemoved
       then putStrLn "Palindrome"
       else putStrLn "Not a palindrome"
