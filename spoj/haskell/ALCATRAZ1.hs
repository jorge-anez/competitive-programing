-- https://www.spoj.com/problems/ALCATRAZ1/

import Control.Applicative ((<$>))
import Control.Monad (replicateM)
import Data.Char(digitToInt)

getLines :: Int -> IO [String]
getLines n = replicateM n getLine

getInts :: Int -> IO [Int]
getInts n = fmap read <$> getLines n

getInt :: IO Int
getInt = fmap read getLine

sumDigits 0 = 0
sumDigits n = (mod n 10) + sumDigits (div n 10)

workProblem :: IO ()
workProblem = do
                n <- getInt
                l <- getLines n
                () <- mapM_ putStrLn $ map (\i -> show $ sum (map digitToInt i)) l
                return ()

main :: IO ()
main = workProblem