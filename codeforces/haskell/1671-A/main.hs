--https://codeforces.com/contest/1671/problem/A

import Data.List
import Control.Applicative ((<$>))
import Control.Monad (replicateM)

getLines :: Int -> IO [String]
getLines n = replicateM n getLine

getInt :: IO Int
getInt = fmap read getLine

main :: IO ()
main = do
         n <- getInt
         input <- getLines n
         let a = map (\ e -> foldr (&&) True $ map (\ s -> length s > 1) $ group e) input
         let r = map (\x -> if x then "YES" else "NO") a
         putStr $ unlines r