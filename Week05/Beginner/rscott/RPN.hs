module Main where

import Data.Char
import System.Environment

main :: IO ()
main = getArgs >>= print . rpn

rpn :: [String] -> Int
rpn = head . foldl rpnFold []

rpnFold :: [Int] -> String -> [Int]
rpnFold stack []                                = stack
rpnFold stack str@(c:cs) | length str > 1       = (read str):stack
                         | null cs && isDigit c = (digitToInt c):stack
                         | null cs              = case stack of (n1:n2:ns) -> (op c n1 n2):ns
                         | otherwise            = undefined

op :: Char -> Int -> Int -> Int
op '+' n1 n2 = n1 + n2
op '-' n1 n2 = n1 - n2
op '*' n1 n2 = n1 * n2
op '^' n1 n2 = n1 ^ n2
op '/' n1 n2 = n1 `div` n2
op '%' n1 n2 = n1 `mod` n2