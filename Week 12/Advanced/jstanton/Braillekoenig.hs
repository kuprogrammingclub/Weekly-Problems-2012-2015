{-
  Braillekoenig
-}

import Data.List.Split
import Data.List

main = getContents >>= (mapM_ printer) . takeWhile (not.null) . lines where
  printer notes = putStrLn $ checkForMajors notes ++ " Major"

cleanLine :: String -> String
cleanLine = filter (not . (flip  elem) "whqesr") where
-- majors
cs = chunksOf 2 "B#E#A#D#G#C#F#Gm" -- the ends of each string 
cb = chunksOf 2 "FbCbGbDbAbEbBbFm" -- note the fallback major

checkForMajors :: String -> String
checkForMajors notes = 
  if null scales
  then "C"
  else head scales  where
  (_ , scales) = unzip $ dropWhile dropNotes (zip cs majorsl) ++ dropWhile dropNotes (zip cb majorsr)
  dropNotes = not . (flip isInfixOf) notes .fst -- drop possible majors out based on substrings
  majorsl = ["C#", "F#", "B", "E", "A", "D", "G"] 
  majorsr = ["Cb", "Gb", "Db", "Ab", "Eb", "Bb", "F"]
