-- converts an ip address in decimal to four octets in decimal
import Data.Tuple
import Data.List

main = interact convert

convert = intercalate "." . map (show . binToDec) . splitBy 8 . decToBin 32 . read

-- gives the n lowest order bits (zero padded) of the given Integer in list format
decToBin :: Int -> Integer -> [Integer]
decToBin n = reverse . take n . (++ [0,0..]) . unfoldr(\n -> if n==0 then Nothing else Just $ swap $ divMod n 2)

splitBy :: Int -> [a] -> [[a]]
splitBy _ [] = []
splitBy n xs = take n xs : splitBy n (drop n xs)

binToDec :: [Integer] -> Integer
binToDec = foldl1 ((+) . (*2))