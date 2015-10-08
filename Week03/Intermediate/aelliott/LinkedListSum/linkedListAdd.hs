-- linkedListAdd.hs

import Data.List
import Data.Tuple
import Data.Function

newtype LL = LL [Int]

instance Show LL where
	 show (LL (x:y:xs)) = show x ++ " -> " ++ show (LL (y:xs))
	 show (LL [x])	  = show x
	 show (LL [])	  = ""

unLL (LL xs) = xs

addLL = (LL .) . addCarry 0 `on` unLL
      	where addCarry c (x:xs) (y:ys) = let (carry, sum) = (c + x + y) `divMod` 10
	      	       	 	       	 in sum : addCarry carry xs ys
	      addCarry c (x:xs) []     = propagateCarry c (x:xs)
	      addCarry c []	(y:ys) = propagateCarry c (y:ys)
	      addCarry 0 []	[]     = []
	      addCarry c []	[]     = [c]
	      propagateCarry 0 xs = xs
	      propagateCarry c [] = [c]
	      propagateCarry c (x:xs) = let (carry, sum) = (c + x) `divMod` 10
	      		       	      	in sum : propagateCarry carry xs

eval :: LL -> Int
eval = foldr (\x y -> 10 * y + x) 0 . unLL

instance Num LL where
	 fromInteger = LL . unfoldr (\x -> if x == 0 then Nothing else Just $ swap (x `divMod` 10)) . fromInteger
	 (+) = addLL