isPowerOf :: Int -> Int -> Bool
isPowerOf 0 _ = False
isPowerOf _ 1 = True
isPowerOf x p = (round (fromIntegral x ** (1 / fromIntegral p))) ^ p == x

maxPthPower :: Int -> Int
maxPthPower x
  | (x < 0) = error "Negative input"
  | otherwise = do
  let bigBeefyLog = floor $ logBase 2 $ fromIntegral x
  head [p | p <- [bigBeefyLog, bigBeefyLog-1 .. 1], isPowerOf x p]