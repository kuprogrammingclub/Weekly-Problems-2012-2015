module ChangeCombos where

changes :: [Int]
changes = [1, 2, 5, 10, 20, 50, 100]

combos :: Int -> Int -> Int
combos cents coins | cents < 0 || coins < 1 = 0
                   | cents == 0             = 1
                   | otherwise              = combos cents (coins-1)
                                              + combos (cents - changes !! (coins-1)) coins

main :: IO ()
main = print . combos 100 $ length changes
