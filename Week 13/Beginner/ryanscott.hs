coins :: Int -> Int
coins 0 = 1
coins c = sum [coins (div c i) | i <- [2..4]]