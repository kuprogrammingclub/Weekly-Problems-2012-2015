-- DivisibleBy7.hs
-- Author: Stefan Mendoza
-- Date: 31 August 2015
--
-- Source: https://www.reddit.com/r/dailyprogrammer/comments/3irzsi/20150828_challenge_229_hard_divisible_by_7/


module Main where

main :: IO ()
main = do
    let x = map show [1..10**6]
    let y = zip (map (\i -> fst $ splitAt ((length i) - 2) i) x)
                (map (\i -> snd $ splitAt 2 i) (map reverse x))
    -- print [read a :: Integer | (a, b) <- y, and [(read a :: Integer) `mod` 7 == 0, (read b :: Integer) `mod` 7 == 0]]
    print (sum [read a :: Integer | (a, b) <- y, and [(read a :: Integer) `mod` 7 == 0, (read b :: Integer) `mod` 7 == 0]])
