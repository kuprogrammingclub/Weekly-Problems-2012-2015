module Main where

import           Control.Applicative
import           Control.Monad

import           Data.Char
import           Data.Either
import           Data.Maybe

import           Numeric

import           System.FilePath

import           Text.Parsec hiding ((<|>))
import           Text.Parsec.Char
import           Text.Parsec.Language
import           Text.Parsec.String
import qualified Text.Parsec.Token as P
import           Text.Parsec.Token (TokenParser)

main :: IO ()
main = do
    lf <- readFile lakesFile
    let values :: [Double]
        values = catMaybes . rights $ map (parse lakeSize "") (lines lf)
        
        len :: Int
        len = length values
    forM_ [1..9] $ \dig -> do
        let beginsWithDig :: [Int]
            beginsWithDig = filter (==dig) $ map (digitToInt . head . show) values
            
            percent :: Double
            percent = 100*(fromIntegral $ length beginsWithDig)/(fromIntegral len)
            
        putStrLn $ show dig ++ ": " ++ showFFloat (Just 2) percent "" ++ "%"

lakesFile :: FilePath
lakesFile = ".." </> "lakes" <.> "csv"

lexer :: TokenParser a
lexer = P.makeTokenParser emptyDef

stringLiteral :: Parser String
stringLiteral = P.stringLiteral lexer

lakeSize :: Parser (Maybe Double)
lakeSize = (try (string "\"COUNTY: ") >> return Nothing)
       <|> (try (string "\"LAKE\",") >> return Nothing)
       <|> (try (string "\"Return to the top\"") >> return Nothing)
       <|> (do stringLiteral
               char ','
               stringLiteral
               char ','
               d <- many1 (satisfy (/= ','))
               return . Just $ read d
           )