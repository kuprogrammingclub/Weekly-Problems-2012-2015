module Main (main) where

import System.Environment (getArgs)

main :: IO ()
main = getArgs >>= \args -> case args of
    strand:_ -> putStrLn strand >> putStrLn (complement strand)
    _        -> putStrLn "Come on, at least give me something to work with."

complement :: String -> String
complement = map go
  where
    go :: Char -> Char
    go 'A' = 'T'
    go 'C' = 'G'
    go 'G' = 'C'
    go 'T' = 'A'
    go x   = x
