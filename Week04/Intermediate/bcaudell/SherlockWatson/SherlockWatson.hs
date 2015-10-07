rotateN n xs = take (length xs) (drop ((n-1) `mod` (length xs)) (cycle xs))
get n xs = xs !! n
sherlockWatson xs k qs = map ((flip get) (rotateN k xs)) qs
