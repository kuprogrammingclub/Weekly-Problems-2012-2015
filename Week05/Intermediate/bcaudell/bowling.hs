{-# LANGUAGE GADTs, KindSignatures, DataKinds #-}
import Data.Char

data Ball :: * where
	Count :: Int -> Ball
	Spare :: Ball
	Strike :: Ball
	deriving Show
	
toBall :: Char -> Ball
toBall c 	| (isDigit c) = Count (read [c] :: Int)
			| (c == '-') = Count 0
			| (c == '/') = Spare
			| (c == 'X') = Strike
			
scoreTriple :: (Ball, Ball, Ball) -> Int
scoreTriple (Count a, Count b, _) = a + b
scoreTriple (_, Spare, Count c) = 10 + c
scoreTriple (_, Spare, Strike) = 20
scoreTriple (Strike, Count b, Count c) = 10 + b + c
scoreTriple (Strike, _, Spare) = 20
scoreTriple (Strike, Strike, Count c) = 20 + c
scoreTriple (Strike, Strike, Strike) = 30
scoreTriple (_,_,_) = 0

makeTriple :: [Ball] -> [(Ball, Ball, Ball)]
makeTriple ((Count a) : ((Count b) : rest)) 			= [(Count a, Count b, Count 0)] ++ (makeTriple rest)
makeTriple ((Count a) : ((Spare) : ((Count c) : rest))) = [(Count a, Spare, Count c)] 	++ (makeTriple ((Count c) : rest))
makeTriple ((Count a) : ((Spare) : ((Strike) : rest))) 	= [(Count a, Spare, Strike)] 	++ (makeTriple (Strike : rest))
makeTriple ((Strike) : (Count b : (Count c : rest ) )) 	= [(Strike, Count b, Count c)] 	++ (makeTriple ( Count b : (Count c : rest)))
makeTriple ((Strike) : (Count b : (Spare : rest))) 		= [(Strike, Count b, Spare)] 	++ (makeTriple (Count b : (Spare : rest)))
makeTriple (Strike : (Strike : (Count c : rest))) 		= [(Strike, Strike, Count c)] 	++ (makeTriple (Strike : (Count c : rest)))
makeTriple (Strike : (Strike : (Strike : rest))) 		= [(Strike, Strike, Strike)] 	++ (makeTriple (Strike : (Strike : rest)))
makeTriple _ = []

toBalls :: [Char] -> [Ball]
toBalls s = map toBall s

score :: [Char] -> Int
score s = sum $ map scoreTriple $ makeTriple $ toBalls s
