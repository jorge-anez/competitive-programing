-- https://codeforces.com/problemset/problem/1283/A

import Control.Applicative ((<$>))
import Control.Monad (replicateM)
import Data.Char(digitToInt)

getLines :: Int -> IO [String]
getLines n = replicateM n getLine

getInts :: Int -> IO [Int]
getInts n = fmap read <$> getLines n

getInt :: IO Int
getInt = fmap read getLine

readLine :: Read a => IO [a]
readLine = fmap (fmap read . words) getLine

solve :: [Int] -> String
solve [h, m] = show $ (23 - h) * 60 + (60 - m)

workProblem :: IO ()
workProblem = do
                n <- getInt
                input <- replicateM n (readLine :: IO [Int])
                () <- mapM_ putStrLn $ map solve input
                return ()

main :: IO ()
main = workProblem