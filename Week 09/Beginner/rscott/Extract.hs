import Data.List

extract :: String -> (String, String)
extract s = let gs = group s in (map head gs, concatMap tail gs)