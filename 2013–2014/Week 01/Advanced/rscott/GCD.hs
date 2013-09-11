gcd' :: Integral a => a -> a -> a
gcd' a 0 = abs a
gcd' a b = gcd b (a % b)
  where a % b = mod a (abs b)

gcd'' :: Integral a => [a] -> a
gcd'' [] = error "Empty list"
gcd'' (x:xs) = foldl gcd' x xs