module Main (main) where

import Data.Functor (void)
import Data.Word (Word)
import System.Environment (getArgs)
import System.Exit (ExitCode(..))
import System.Process (createProcess, shell, waitForProcess)

main :: IO ()
main = getArgs >>= \args -> case args of
    year:_ -> if cheating
                 then easterCheatCode year
                 else print . easter $ read year
    _      -> putStrLn "usage: easter <year>"

cheating :: Bool
cheating = False -- We'll won't outsource our work... for now

easterCheatCode :: String -> IO ()
easterCheatCode year = do
    let cmd = unwords ["ncal", year, "-e"]
    (_, _, _, procHandle) <- createProcess $ shell cmd
    void $ waitForProcess procHandle

-- Algorithm from http://www.whydomath.org/Reading_Room_Material/ian_stewart/2000_03.html
easter :: Word -> String
easter year = let a      = year `rem` 19
                  (b, c) = year `quotRem` 100
                  (d, e) = b `quotRem` 4
                  g      = (8*b + 13) `div` 25
                  h      = (19*a + b - d - g + 15) `rem` 30
                  m      = (a + 11*h) `div` 319
                  (j, k) = c `quotRem` 4
                  l      = (2*e + 2*j - k - h + m + 32) `rem` 7
                  n      = (h - m + l + 90) `div` 25 -- should be 3 or 4
                  p      = (h - m + l + n + 19) `rem` 32
               in show n ++ '/':show p
