module Bogopalooza where

import Control.Monad.Random
import Data.List
import System.Random.Shuffle -- This is totally cheating

bogosort :: (MonadRandom m, Ord a) => [a] -> m [a]
bogosort l = if sorted l then return l else shuffleM l >>= bogosort

sorted :: Ord a => [a] -> Bool
sorted (x:xs@(y:_)) = x <= y && sorted xs
sorted _            = True