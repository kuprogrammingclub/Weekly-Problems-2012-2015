module Main (main) where

import Control.Monad
import System.Environment

purdyTree :: Int -> Char -> Char -> IO ()
purdyTree n | odd n && n >= 3 = purdyTree' n
            | otherwise       = error "n must be an odd integer >= 3"

purdyTree' :: Int -> Char -> Char -> IO ()
purdyTree' n t l = do
    let layer blanks nonblanks = do
        putStr   blanks
        putStr   nonblanks
        putStrLn blanks
    
    forM_ [1,3..n] $ \r -> do
        let leaves = replicate r l
            blanks = replicate ((n-r) `div` 2) ' '
        layer blanks leaves
        
    let trunks = replicate 3 t
        blanks = replicate ((n-3) `div` 2) ' '
    layer blanks trunks

-------------------------------------------------------------------------------

main :: IO ()
main = getArgs >>= \args -> case args of
    n:t:l:_ -> purdyTree (read n) (read t) (read l)
    _       -> printUsage

printUsage :: IO ()
printUsage = getProgName >>= putStrLn . usage

usage :: String -> String
usage progName = unlines [ progName ++ " n t l"
                         , "where n is an odd integer >= 3"
                         , "      t is the trunk character"
                         , "      l is the leaves character"
                         ]