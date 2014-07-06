(defn gcd [a b]
  (if (= (mod a b) 0)
    b
    (gcd b (mod a b))))
