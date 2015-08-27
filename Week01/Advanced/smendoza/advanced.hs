-- Author: Stefan Mendoza
-- Date: 27 August 2016

-- ===========
-- PERFORMANCE
-- ===========

-- The below involves executing the code using the GHC interpreter (GHCi)

-- *Main> sum $ map digitToInt (show $ 2 ^ 10)
-- 7
-- (0.01 secs, 3,101,000 bytes)

-- *Main> sum $ map digitToInt (show $ 2 ^ 100)
-- 115
-- (0.01 secs, 3,102,536 bytes)

-- *Main> sum $ map digitToInt (show $ 2 ^ 1000)
-- 1366
-- (0.01 secs, 3,096,520 bytes)

-- *Main> sum $ map digitToInt (show $ 2 ^ 10000)
-- 13561
-- (0.01 secs, 3,646,152 bytes)

-- *Main> sum $ map digitToInt (show $ 2 ^ 100000)
-- 135178
-- (0.02 secs, 10,733,552 bytes)

-- *Main> sum $ map digitToInt (show $ 2 ^ 1000000)
-- 1351546
-- (0.28 secs, 81,042,696 bytes)

-- *Main> sum $ map digitToInt (show $ 2 ^ 10000000)
-- 13546438
-- (3.52 secs, 783,466,904 bytes)

-- *Main> sum $ map digitToInt (show $ 2 ^ 100000000)
-- 135481777
-- (54.80 secs, 7,838,030,592 bytes)

module Main where

import           Data.Char

main :: IO ()
main = putStrLn "Use GHCi"

execute :: Int -> IO ()
execute power = print $ sum $ map digitToInt (show $ 2 ^ power)
