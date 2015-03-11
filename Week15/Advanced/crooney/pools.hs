pools :: [Int] -> Int
pools x = poolsLogic 0 x

poolsLogic :: Int -> [Int] -> Int
poolsLogic _ [] = 0
poolsLogic currentTop xs
  | currentHeight >= currentTop = poolsLogic currentHeight rest
  | currentHeight <  currentTop = (poolHeight - currentHeight) + (poolsLogic currentTop rest)
  where currentHeight  = head xs
       	rest           = tail xs
       	poolHeight     = min currentTop (maximum xs)
