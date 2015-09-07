-- TimeConversion.hs
-- Author: Stefan Mendoza
-- Date: 27 August 2015
--
-- Source: https://www.hackerrank.com/challenges/time-conversion

module Main where

import Data.Char

main :: IO ()
main = putStrLn "Use GHCi."

timeConversion :: String -> IO ()
timeConversion twelveHour =
    if (digitToInt $ twelveHour !! 1) > 2 || (digitToInt $ twelveHour !! 1) < 0
        then putStrLn "Invalid time given!"
        else case drop 8 twelveHour of
                "AM" -> case take 2 twelveHour of
                            "12" -> putStrLn $ "00" ++ take 6 (drop 2 twelveHour)
                            otherwise -> case twelveHour !! 1 of
                                '0' -> putStrLn $ "1" ++ show (2 + digitToInt (twelveHour !! 1))
                                       ++ take 5 (drop 2 twelveHour)
                                otherwise -> putStrLn $ take 8 twelveHour
                "PM" -> case take 2 twelveHour of
                            "12" -> putStrLn $ take 8 twelveHour
                            otherwise -> putStrLn $ show (1 + digitToInt (head twelveHour))
                                                 ++ show (2 + digitToInt (twelveHour !! 1))
                                                 ++ take 6 (drop 2 twelveHour)
                otherwise -> putStrLn "Invalid time given!"
