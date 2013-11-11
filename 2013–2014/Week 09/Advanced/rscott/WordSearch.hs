module WordSearch where

import qualified Data.MultiMap as M
import qualified Data.Vector as V

-- Each character maps to zero or more coordinates
type CoordMap = M.MultiMap Char Coords
type Coords = (Int, Int)
-- A direction needs a way of changing a set of coordinates (using a Coords -> Coords function) as well as a name for the direction
type Dir = (Coords -> Coords, String)
-- Use vectors for a grid because they have constant-time access, unlike regular Haskell lists, which have linear-time access
type Grid = V.Vector (V.Vector Char)

-- Using a special dash character (Compose - - . on Linux) to avoid conflicting with Haskell's unary - operator
(–) :: Num a => a -> a -> a
a – b = subtract b a

dirs :: [Dir]
dirs = applyMap [(id, (–1), "up"), ((+1), (–1), "up right"), ((+1), id, "right"), ((+1), (+1), "down right"), (id, (+1), "down"), ((–1), (+1), "down left"), ((–1), id, "left"), ((–1), (–1), "up left")]
	where apply xDir yDir = \ (x, y) -> (xDir x, yDir y)
	      applyMap [] = []
	      applyMap ((d1, d2, s):t) = (apply d1 d2, s) : applyMap t

wordBank :: [String]
wordBank = ["ITALY", "HOLLAND", "POLAND", "SPAIN", "FRANCE", "JAPAN", "TOGO", "PERU"]

grid :: Grid
grid = V.fromList $ map V.fromList [	"FYYHNRD",
					"RLJCINU",
					"AAWAAHR",
					"NTKLPNE",
					"CILFSAP",
					"EOGOTPN",
					"HPOLAND"]

-- Map each character in the grid to the coordinates of its locations (e.g, 'F' -> [(0,0),(3,4)]
mapGridIndices :: Grid -> CoordMap
mapGridIndices = V.ifoldr (\ y w m -> V.ifoldr (\ x c -> M.insert c (x, y)) m w) M.empty

solveWordSearch :: Grid -> [String] -> [String]
solveWordSearch g = let cm = mapGridIndices g
		    in concatMap $ \ s -> map (mkResult s) $ findWord s cm g
	where mkResult s ((x, y), d) = s ++ " row " ++ show (y+1) ++ " column " ++ show (x+1) ++ " " ++ snd d

-- If a word is in the grid, return the initial coordinates and direction of all occurrences of the word in the grid
findWord :: String -> CoordMap -> Grid -> [(Coords, Dir)]
findWord w cm g = let css = M.lookup (head w) cm
		  in [(cs, d) | cs <- css, d <- dirs, checkDir w g cs d]

-- Check if a word can be found at a particular starting location on the grid in a certain direction
checkDir :: String -> Grid -> Coords -> Dir -> Bool
checkDir [] _ _ _ = True
checkDir (s:ss) g cs d = let cs' = fst d $ cs
			 in if hasChar s g cs then checkDir ss g cs' d else False

-- Check if a character can be found at a certain location in the grid
hasChar :: Char -> Grid -> Coords -> Bool
hasChar s g (x, y) = let mc = g V.!? y >>= \ row -> row V.!? x >>= \ s' -> Just (s == s')
		     in case mc of Nothing -> False; Just b -> b

main :: IO ()
main = mapM_ putStrLn $ solveWordSearch grid wordBank