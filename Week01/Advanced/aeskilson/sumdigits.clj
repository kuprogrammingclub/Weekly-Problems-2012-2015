(defn digsum [x]
  (reduce + ((fn [x]
              (loop [num x digs []]
                (if (= 0 num)
                  digs
                  (recur (quot num 10) (conj digs (mod num 10))))) 
              ) x)))
