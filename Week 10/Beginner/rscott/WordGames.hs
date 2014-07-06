import Data.Char
import qualified Data.Set as S

vowels :: S.Set Char
vowels = S.fromList "aeiou"

aeiou :: String -> Bool
aeiou word = (filter (flip S.member vowels) $ map toLower word) == "aeiou"

ascending :: Ord a => [a] -> Bool
ascending [] = True
ascending [_] = True
ascending (x:xs@(y:zs)) = x < y && ascending xs

sixSorted :: String -> Bool
sixSorted word = (length word >= 6) && (ascending $ map toLower word)

readFileLines :: FilePath -> IO [String]
readFileLines fp = readFile fp >>= \ f -> return $ lines f

printMatches :: (String -> Bool) -> [String] -> IO ()
printMatches p = mapM_ putStrLn . filter p

main :: IO ()
main = do
	words <- readFileLines "words.txt"
	putStrLn "\nGame 1\n-----"
	printMatches aeiou words
	putStrLn "\nGame2\n-----"
	printMatches sixSorted words
	putStrLn ""