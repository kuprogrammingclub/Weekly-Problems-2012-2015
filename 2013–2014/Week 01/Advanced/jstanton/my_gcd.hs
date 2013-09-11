{-
 Week 18
 Advanced, GCD
-}

--simple recursive gcd algorithm
-- doesn't do anything with negatives
my_gcd n m 
  | n == 0    = n
  | otherwise = gcd m $ mod n m
