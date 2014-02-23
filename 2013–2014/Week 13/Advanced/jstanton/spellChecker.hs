{-
  SpellChecker.hs
  
  Pretty simple spell checker (and not really efficient, but it seems to work for now).
  
  Jim Stanton
-}

import Control.Monad

main = 
  do
  putStrLn "Enter a word to check:"
  word <- getLine
  sCheck <- spellCheck word
  if sCheck
  then putStrLn "Correct"
  else putStrLn "Incorrect, here are some similar spellings:" >> checkWord word where
  checkWord word =
    do
    wordList <- getSimilarWords word
    let len = length wordList 
    if len <= 10
    then mapM_ putStrLn wordList
    else mapM_ putStrLn (take 15 ((reverse $ takeWhile (<= word) wordList) ++ dropWhile (<= word) wordList))
   

dicFile = "/usr/share/dict/words"
dic = liftM lines $ readFile dicFile

spellCheck :: String -> IO Bool
spellCheck word = 
  liftM (elem word . takeWhile (<= word)) $ dic

getSimilarWords :: String -> IO [String]
getSimilarWords word = 
  liftM (filter (\w -> let wLen = length w in (wLen >= wordL-1 && wLen <= wordL+1 && not (difCheck w)))) dic where
  difCheck = if wordL > 4
             then differsByN (div wordL 2 - 1) word
             else differsByN 2 word
  wordL = length word


differsByN :: Int -> String -> String -> Bool
differsByN (-1)  _ _             = True
differsByN _ [] []             = False
differsByN n xs []             = length xs > n 
differsByN n [] xs             = length xs > n
differsByN n (x:str1) (y:str2) = 
  if x == y
  then differsByN n str1 str2 
  else differsByN (n-1) str1 str2

differsBy3 = differsByN 3
