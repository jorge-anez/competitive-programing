--https://codeforces.com/problemset/problem/4/A

import Control.Applicative ((<$>))
import Control.Monad (replicateM)

getLines :: Int -> IO [String]
getLines n = replicateM n getLine

getInts :: Int -> IO [Int]
getInts n = fmap read <$> getLines n

getInt :: IO Int
getInt = fmap read getLine

main :: IO ()
main = do
         n <- getInt
         let answer = if(n > 2 && mod n  2 == 0) then "YES" else "NO"
         putStrLn answer