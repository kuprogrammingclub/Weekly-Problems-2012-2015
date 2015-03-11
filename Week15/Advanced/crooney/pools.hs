pools :: [Int] -> Int
pools x = poolsLogic 0 0 x

poolsLogic :: Int -> Int -> [Int] -> Int
poolsLogic index currentTop xs
  | index == length xs          = 0
  | currentHeight >= currentTop = poolsLogic (index+1) currentHeight xs
  | currentHeight <  currentTop = (poolHeight - currentHeight) + (poolsLogic (index+1) currentTop xs)
  where currentHeight = xs !! index
        poolHeight    = min currentTop (maximum (drop (index) xs))
