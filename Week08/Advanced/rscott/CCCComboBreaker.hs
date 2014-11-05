module CCCComboBreaker where

import Control.Monad (forM_)
import Data.List (subsequences)

-- | Cheating
combCheat :: Int -> [a] -> [[a]]
combCheat n = filter ((==n) . length) . subsequences

-- | Only does what it's supposed to, nothing more
comb :: Int -> [a] -> [[a]]
comb 0 _      = [[]]
comb _ []     = []
comb m (x:xs) = map (x:) (comb (m-1) xs) ++ comb m xs

------------------------------------------------------
-- Warning: Output-related baloney ahead
------------------------------------------------------

printComb :: Show a => Bool -> Int -> [a] -> IO ()
printComb cheat n l = forM_ (comb' n l) $ \line -> do
    printyThings line
    putStrLn ""
  where
    comb' :: Int -> [a] -> [[a]]
    comb' = if cheat then combCheat else comb
    
    printyThings [] = return ()
    printyThings [x] = putStr $ show x
    printyThings (x:xs) = putStr (show x ++ " ") >> printyThings xs