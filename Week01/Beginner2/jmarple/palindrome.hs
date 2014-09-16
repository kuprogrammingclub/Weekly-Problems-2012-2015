isPalindrome x = palHelper (show x)

palHelper :: String -> Bool
palHelper x = (if (length x == 0 || length x == 1) 
    then True
    else 
        if (head x == last x)
            then palHelper (init (tail x))
            else False)
