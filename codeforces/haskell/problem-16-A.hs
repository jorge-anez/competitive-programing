-- https://codeforces.com/problemset/problem/16/A

import Control.Applicative ((<$>))
import Control.Monad (replicateM)
import Data.Char(digitToInt)

getLines :: Int -> IO [String]
getLines n = replicateM n getLine

readLine :: Read a => IO [a]
readLine = fmap (fmap read . words) getLine

testCols :: [Char] -> Bool
testCols [a, b] = a /= b
testCols (a:b:xs) = (a /= b) && testCols (b:xs)

workProblem :: IO ()
workProblem = do
                [n, m] <- readLine :: IO [Int]
                input <- getLines n
                let cols = map head input
                let rowTest = and $ map (\xs -> and $ map (== head xs) (tail xs)) input
                let colTest = if length cols == 1 then True else  testCols cols
                let anwser = if rowTest && colTest then "YES" else "NO"
                () <- putStrLn anwser
                return ()

main :: IO ()
main = workProblem