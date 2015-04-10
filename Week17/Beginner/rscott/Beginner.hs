module RankVector where

import           Data.Key
import           Data.List
import qualified Data.Map as Map
import           Data.Map (Map, insertWith)
import           Data.Ord

sortDesc :: Ord a => [a] -> [a]
sortDesc = sortBy $ comparing Down

listToIndexMap :: Ord a => [a] -> Map a Int
listToIndexMap = foldlWithKey' (\indMap n a -> insertWith (\_ old -> old) a (n+1) indMap)
                               Map.empty

ranks :: (Eq a, Ord a) => [a] -> [Int]
ranks l = let indMap = listToIndexMap $ sortDesc l
           in map (indMap !) l
