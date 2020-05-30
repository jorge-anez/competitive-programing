-- https://codeforces.com/problemset/problem/659/A

import Control.Applicative ((<$>))
import Control.Monad (replicateM)
import Data.Char(digitToInt)

getLines :: Int -> IO [String]
getLines n = replicateM n getLine

readLine :: Read a => IO [a]
readLine = fmap (fmap read . words) getLine

main :: IO ()
main = do
        [n, a, b] <- readLine :: IO [Int]
        let b' = mod (abs b) n
        let aws = if b > 0 then  mod (a + b') n else  if a > b' then a - b' else n + a - b'
        let result = if aws == 0 then n else aws
        putStrLn $ show result