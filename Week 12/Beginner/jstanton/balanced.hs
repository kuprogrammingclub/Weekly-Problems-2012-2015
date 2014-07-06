{-
  Balanced
  Balanced Paranthesis
-}

import Control.Monad

main = getContents >>= (mapM_ printer).takeWhile (not.null). lines where
  printer :: String -> IO ()
  printer str = if isBalanced str
                then putStrLn "Balanced!"
                else putStrLn "Not Balanced!"
  

isBalanced :: String -> Bool
isBalanced str = null $ foldl charCheck [] str where
  charCheck :: String -> Char -> String
  charCheck ('(':xs) ')' = xs
  charCheck xs '('       = '(':xs
  charCheck xs _         = xs 
