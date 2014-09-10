(defn palindrome? [word]
  (if (= (reverse word) (seq word))
         true
         false))
