{-
  Change.hs
-}

coins = [200, 100, 50, 20, 10, 5, 2, 1]


-- attempted to make this as resuable as possible, hence target
variations [] _  _           = 0
variations (c:[]) acc target 
  | acc == target = 1
  | acc > target  = 0
  | otherwise     = variations [c] (acc+c) target  
variations (c:cs) acc target 
  | acc == target = 1 
  | acc > target  = 0
  | otherwise     = variations (c:cs) (acc+c) target +
                    variations cs acc target
