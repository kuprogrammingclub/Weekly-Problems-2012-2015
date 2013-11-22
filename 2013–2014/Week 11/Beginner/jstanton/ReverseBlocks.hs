revBlocks :: Int -> [a] -> [[a]]
revBlocks  _ [] = []
revBlocks k xs = (reverse first) : (revBlocks k rest) where
  (first, rest) = splitAt k xs
