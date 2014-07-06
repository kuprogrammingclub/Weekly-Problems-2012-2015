import Data.Char

leetify :: [Char] -> [Char]
leetify [] = "!!!!!1"
leetify (x:xs) = (coolsauce x) : (leetify xs)
  where
    coolsauce char = case (toLower char) of
	'a' -> '4'
	'b' -> '8'
	'c' -> '('
	'e' -> '3'
	'g' -> '9'
	'i' -> '!'
	'l' -> '1'
	'o' -> '0'
	's' -> '$'
	't' -> '7'
	_ -> x