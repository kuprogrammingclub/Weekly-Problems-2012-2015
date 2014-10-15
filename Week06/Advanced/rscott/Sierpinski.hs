import Diagrams.Prelude
import Diagrams.Backend.Cairo.CmdLine

type Engine = Cairo

main :: IO ()
main = defaultMain example

-- This code taken from http://projects.haskell.org/diagrams/gallery/Sierpinski.html

sierpinski :: Int -> Diagram Engine R2
sierpinski 1 = eqTriangle 1
sierpinski n =     s
                  ===
               (s ||| s) # centerX
  where s = sierpinski (n-1)

example :: Diagram Engine R2
example = pad 1.1 $ sierpinski 7 # centerXY # lw none # fc white
                  `atop` square 70 # fc darkslategray