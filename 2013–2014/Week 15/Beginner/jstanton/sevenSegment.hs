{-
  sevenSegment.hs
  Jim Stanton
  with comments!
-}

import Data.List
import qualified Data.Map as Map
import Control.Monad

main = 
  do
    putStr "Enter a number for the display: "
    str <- getLine
    mapM_ putStrLn $ strFormatter str

-- handy strings used to build the displays
full    = " +--+"
left    = " |   "
right   = "    |"
both    = " |  |"
bothCap = " +  +"
endCap  = "    +"

-- Map/Dictionary to convert a single charactert to a list of strings to display
nums = Map.fromList [('1', endCap : (copy 5 right) ++ [endCap]), 
                     ('2', [full, right, right, full, left, left, full]),
                     ('3', [full, right ,right, full, right, right, full]),
                     ('4', [bothCap, both, both, full, right, right, endCap]),
                     ('5', [full, left, left, full, right, right, full]),
                     ('6', [full, left, left, full, both, both, full]),
                     ('7', full : (copy 5 right) ++ [endCap]),
                     ('8', [full, both, both, full, both, both, full]),
                     ('9', [full, both, both, full, right, right, endCap]),
                     ('0', full: (copy 5 both) ++ [full])]

-- helper function to make a list that contains n copies of the list xs
copy :: Int -> [a] -> [[a]]
copy n xs = foldl (\acc _ -> xs : acc) [] [1..n] 


-- this function puts the strings together so they print on the correct line
-- the transpose function ensures that each line of each individual number is 
-- concatenated together 
strFormatter :: String -> [String]
strFormatter = map concat . transpose  . strBuilder 

-- builds a list of Strings by looking up each character from the command
-- line in the map/dictionary nums and appending it to the list
strBuilder :: String -> [[String]]
strBuilder = foldr (\n acc -> (nums Map.! n) : acc) []  
-- Intersting note here, this is using a fold right instead
-- of fold left b/c fold left reverses the string order. The
-- numbers print correctly, but are ordered backwards