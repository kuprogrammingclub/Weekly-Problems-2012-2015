{-# LANGUAGE NoMonomorphismRestriction #-}
module Main (main) where

import Diagrams.Backend.Cairo.CmdLine
import Diagrams.Prelude

k :: Diagram Cairo R2
k = let n      = 25
        s      = square n # fc blue
        sRow n = s ||| strutX n ||| s
     in vcat (map sRow [3*n, 2*n, n, 0, n, 2*n, 3*n]) # centerXY

main :: IO ()
main = defaultMain $ pad 1.1 k
