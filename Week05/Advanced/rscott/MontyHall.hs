module Main where

import Control.Lens

import Data.Char
import Data.Ix
import Data.List

import System.Random

data Door = Car | Goat deriving (Read, Eq, Ord, Show)

main :: IO ()
main = montyHall 0 0

montyHall :: Int -> Int -> IO ()
montyHall stayed total = do
    doors <- randomDoors
    putStrLn "Door 1  Door 2  Door 3"
    putStrLn "One of these doors hides a car. Which do you choose?"
    
    myDoor1 <- askDoor $ const True
    let Just (goat1',_) = ifind (\ind behindDoor -> ind /= (myDoor1-1) && behindDoor == Goat) doors
        goat1 = goat1' + 1
        otherDoor = head $ [1..numDoors] \\ [myDoor1, goat1]
    
    putStrLn . showString "Ah! It looks like Door "
             . shows goat1
             . showString " hides a goat! What to do now?"
             $ ""
    putStrLn . showString "Stay with Door "
             . shows myDoor1
             . showString "? Or switch to Door "
             . shows otherDoor
             . showChar '?'
             $ ""
    
    myDoor2 <- askDoor (/= goat1)
    
    let gameEnd :: Bool -> IO Int
        gameEnd True  = do
            putStrLn . showString "Congratulations! Door "
                     . shows myDoor2
                     . showString " has the car!\n"
                     $ ""
            return $ stayed + 1
        gameEnd False = do
            putStrLn . showString "You fool! Door "
                     . shows myDoor2
                     . showString " has the car!\n"
                     $ ""
            return stayed
    
    stayed' <- case doors !! (myDoor2-1) of
         Car  -> gameEnd True
         Goat -> gameEnd False
    let total' = total + 1
    
    putStrLn . showString "Won if stayed: "
             . showsPercentage stayed' total'
             . showString ". Won if switched : "
             . showsPercentage (total' - stayed') total'
             . showChar '.'
             $ ""
    putStrLn "Try again?"
    
    let askAgain :: IO ()
        askAgain = do
            putStr "> "
            yn <- (fmap . map) toLower getLine
            case yn of
                "y" -> do
                    putStrLn "----------------------------------------\n"
                    montyHall stayed' total'
                "n" -> return ()
                _   -> do
                    putStrLn "Come on, give me a better answer than that."
                    askAgain

    askAgain

askDoor :: (Int -> Bool) -> IO Int
askDoor p = do
    putStr "> "
    d <- readLn
    if doorRange `inRange` (d-1) && p d
        then return d
        else do
            putStrLn "That's not a valid door. Get your act together!"
            askDoor p

randomDoors :: IO [Door]
randomDoors = do
    a <- randomRIO doorRange
    return $ replicate numDoors Goat & ix a .~ Car

numDoors :: Int
numDoors = 3

doorRange :: (Int, Int)
doorRange = (0, numDoors - 1)

showsPercentage :: Int -> Int -> ShowS
showsPercentage n d = shows n
                    . showChar '/'
                    . shows d
                    . showString " ("
                    . shows (100*(fromIntegral n / fromIntegral d))
                    . showString "%)"