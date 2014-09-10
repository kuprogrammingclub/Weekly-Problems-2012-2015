sumOfDigits :: (Integral a) => a -> a
sumOfDigits a
  | a < 0     = sumOfDigits(-a)
  | a < 10    = a
  | otherwise = a `mod` 10 + sumOfDigits(a `div` 10)