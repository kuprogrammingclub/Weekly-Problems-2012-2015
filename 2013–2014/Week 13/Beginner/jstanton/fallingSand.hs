{-
  Falling Sand
  Week 13
  Jim Stanton
-}

import Control.Monad
import Data.List

main = 
  do
  n <- getLine
  grid <- replicateM (read n::Int) getLine
  putStrLn ""
  let newGrid = transpose.(map dropSand) $ transpose grid
  mapM_ putStrLn newGrid
  

dropSand :: String -> String
dropSand []            = []
dropSand ('.':'#':col) = '.':'#': dropSand col
dropSand ('.':' ':col) = ' ': dropSand ('.':col)
dropSand ('.':'.':col) = case rest of
                            ('.':col) -> ('.':'.':col)
                            _         -> dropSand ('.':rest) 
                         where rest = dropSand ('.':col)
dropSand (c:col)       = c : dropSand col
