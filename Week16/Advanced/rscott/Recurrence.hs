module Main (main) where

import Data.Foldable (foldlM)
import Data.Functor (void)
import Data.List (foldl')
import System.Environment (getArgs)

main :: IO ()
main = getArgs >>= \args -> case args of
    opsStr:start:numTerms:_ -> do
        let ops :: [Op]
            ops = parseOps opsStr
            
            u0, un :: Int
            u0  = read start
            un  = read numTerms

            go :: Int -> Int -> IO Int
            go ui index = do
                let uiPlusOne = evalRecurrence ui ops
                putStrLn $ "Term " ++ show index ++ ": " ++ show uiPlusOne
                return uiPlusOne
        putStrLn $ "Term 0: " ++ show u0
        void $ foldlM go u0 [1..un]
    _ -> error "invalid input"

data Op = Add Int | Sub Int | Mul Int | Div Int deriving Show

parseOps :: String -> [Op]
parseOps = map operize . words
  where
    operize :: String -> Op
    operize (op:n) = getOp op $ read n
    operize _      = error "invalid format"

    getOp :: Char -> Int -> Op
    getOp '+' = Add
    getOp '-' = Sub
    getOp '*' = Mul
    getOp '/' = Div
    getOp _   = error "invalid op"

evalRecurrence :: Int -> [Op] -> Int
evalRecurrence = foldl' go
  where
    go :: Int -> Op -> Int
    go m (Add n) = m   +   n
    go m (Sub n) = m   -   n
    go m (Mul n) = m   *   n
    go m (Div n) = m `div` n
