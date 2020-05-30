-- https://www.spoj.com/problems/TEST/

import Control.Applicative ((<$>))
import Control.Monad (replicateM)

getLines :: Int -> IO [String]
getLines n = replicateM n getLine

getInts :: Int -> IO [Int]
getInts n = fmap read <$> getLines n

getInt :: IO Int
getInt = fmap read getLine

workProblem :: IO ()
workProblem = do
                n <- getInt
                _ <- case n of
                      42 -> return ()
                      _ -> do
                           _ <- putStrLn $ show n
                           _ <- workProblem
                           return ()
                return ()

main :: IO ()
main = workProblem