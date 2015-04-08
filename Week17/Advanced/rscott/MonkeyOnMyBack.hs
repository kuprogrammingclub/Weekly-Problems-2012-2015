module Main (main) where

import Control.Monad
import Data.List
import Data.Ord
import System.Random

main :: IO ()
main = randomSentence >>= monkeyLoop 1

monkeyLoop :: Int -> String -> IO ()
monkeyLoop iter randStr = do
    let copies = replicate 100 randStr
    mutants <- mapM mutate copies
    let scoredMutants      = map (\str -> (str, score str)) mutants
        (maxStr, maxScore) = maximumBy (comparing snd) scoredMutants
    putStrLn $ "Iteration "
             ++ show iter
             ++ ": "
             ++ maxStr
             ++ " (score: "
             ++ show maxScore
             ++ ")"
    when (maxScore /= 28) $ monkeyLoop (iter+1) maxStr

randomChar :: IO Char
randomChar = randomRIO (' ', 'Z')

randomSentence :: IO String
randomSentence = replicateM 28 randomChar

weasel :: String
weasel = "METHINKS IT IS LIKE A WEASEL"

mutate :: String -> IO String
mutate = mapM $ \c -> do
    randDouble <- randomRIO (0.0, 1.0) :: IO Double
    if randDouble < 0.05
       then randomChar
       else return c

score :: String -> Int
score = length . filter (uncurry (==)) . zip weasel
