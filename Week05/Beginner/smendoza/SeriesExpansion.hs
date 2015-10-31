-- SeriesExpansion.hs
-- Author: Stefan Mendoza
-- Date: 31 October 2015
--
-- Source: https://www.hackerrank.com/challenges/eval-ex


module Main where


main :: IO ()
main = do
    print (evalSeries 20.0000)
    print (evalSeries 5.0000)
    print (evalSeries 0.5000)
    print (evalSeries (-0.5000))


factorial :: Float -> Float
factorial i
    | i == 0 = 1
    | otherwise = (i * (factorial (i - 1)))


evalSeries :: Float -> Float
evalSeries x = seriesExpansion x 1 0

seriesExpansion :: Float -> Float -> Float -> Float
seriesExpansion x count current
    | count == 1 = seriesExpansion x 2 1
    | count == 10 = current + (x**10)/(factorial 10)
    | otherwise   = seriesExpansion x (count + 1) (current + (x**count) / (factorial count))
