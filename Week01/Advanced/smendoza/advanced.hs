-- Author: Stefan Mendoza
-- Date: 16 August 2016

-- ===========
-- PERFORMANCE
-- ===========

-- *Main> main
-- The sum of the digits of 2^15 is 26
-- The sum of the digits of 2^1000 is 1366
-- The sum of the digits of 2^10000 is 13561
-- The sum of the digits of 2^100000 is 135178
-- (2.39 secs, 715,706,336 bytes)

module Main where

import           Data.Char
import qualified Data.List as L

main :: IO ()
main = do
    execute 2 15
    execute 2 1000
    execute 2 10000
    execute 2 100000

execute :: Integer -> Integer -> IO ()
execute base power =
    putStrLn $
        "The sum of the digits of " ++ (show base) ++ "^" ++ (show power)
        ++ " is " ++ (show $ sumDigits (calculate base power base 1) 0)


sumDigits :: String -> Int -> Int
sumDigits numString digitSum = do
    if not (L.null numString)
        then do let digit = digitToInt (head numString)
                sumDigits (tail numString) (digitSum + digit)
        else digitSum


calculate :: Integer -> Integer -> Integer -> Integer -> String
calculate base power current count = do
    if count == power
        then show current
        else calculate base power (base * current) (count + 1)
