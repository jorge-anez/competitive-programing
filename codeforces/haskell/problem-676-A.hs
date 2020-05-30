-- https://codeforces.com/problemset/problem/659/A

import Control.Applicative ((<$>))
import Control.Monad (replicateM)
import Data.List
import Data.Ord

getLines :: Int -> IO [String]
getLines n = replicateM n getLine

readLine :: Read a => IO [a]
readLine = fmap (fmap read . words) getLine

getInt :: IO Int
getInt = fmap read getLine

maxIndex xs = maximumBy (comparing fst) (zip xs [0..])
minIndex xs = minimumBy (comparing fst) (zip xs [0..])

main :: IO ()
main = do
        n <- getInt
        l <- readLine :: IO [Int]
        let (_, max') = maxIndex l
        let (_, min') = minIndex l
        let a = max (n - max' - 1)  max'
        let b = max (n - min' - 1)  min'
        putStrLn $ show (max a b)

