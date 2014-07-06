{- 
  Week 18
  Beginner, l33tify
-}
-- uses tail calls optimization
l33tify str             = aux str []
  where aux s acc       = 
          case s of 
            []     -> reverse $ '1':'!':acc 
            c : cs -> if c == '!'
                      then aux cs $ c:acc
                      -- checks to see if head last char was '!'
                      -- so it can add a '1'
                      else if length acc >= 1 && head acc == '!'
                           then aux cs $ (conv c):'1':acc
                           else aux cs $ (conv c):acc 
        conv c -- conversion function, using boolean guards 
          | c == 'e' || c == 'E' = '3'
          | c == 't' || c == 'T' = '7'
          | c == 'o' || c == 'O' = '0'
          | c == 'a' || c == 'A' = '4'
          | otherwise            = c
          
