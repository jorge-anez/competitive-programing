--https://codeforces.com/problemset/problem/1351/A

import Control.Applicative ((<$>))
import Control.Monad (replicateM)

getLines :: Int -> IO [String]
getLines n = replicateM n getLine

getInts :: Int -> IO [Int]
getInts n = fmap read <$> getLines n

getInt :: IO Int
getInt = fmap read getLine

workProblem :: [String] -> IO ()
workProblem [] = pure ()
workProblem (x:xs) = do
                    let [num1, num2] = words x
                    let a = read num1 :: Int
                    let b = read num2 :: Int
                    putStrLn $ show (a + b)
                    workProblem xs

main :: IO ()
main = do
         n <- getInt
         lines <- getLines n
         workProblem lines