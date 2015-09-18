--Single-digit sum of three inputs
digitSum a b c = (a + b + c) `mod` 10

--Gets the carry digit from a sum of three numbers
carry a b c = ((a + b + c) - digitSum a b c) `div` 10
zippedCarry a (b, c) = carry a b c
   
--Gets the output carry digit from summing over two lists
finalCarry xs ys = foldl zippedCarry 0 (zip xs ys)
zippedFinalCarry (xs, ys) = finalCarry xs ys

--Append and remove a trailing zero
appendZero xs = xs ++ [0]
removeTrailingZero xs
   | last xs == 0 = init xs
   | otherwise = xs

--Takes two lists and appends 0's to the shorter one to make them the same length
makeSameLength xs ys
   | length xs > length ys = (xs, ys ++ (replicate ((length xs) - (length ys)) 0))
   | length xs < length ys = (xs ++ (replicate ((length ys) - (length xs)) 0), ys)
   | otherwise = (xs, ys)
   
--Creates a list of possible sublists, all of which start from the head
possibleStartingSublists xs = [take i xs | i <- [1..length xs]]

--Finds the carry digits that will be passed into each digit addition
carryList xs ys = 0 : map zippedFinalCarry (map unzip (possibleStartingSublists (zip xs ys)))

--Calculates the sum of two numbers as lists
sumLists xs ys = sumEvenLists a b where (a,b) = makeSameLength xs ys
sumEvenLists xs ys = removeTrailingZero (zipWith3 digitSum (carryList xs ys) (appendZero xs) (appendZero ys))