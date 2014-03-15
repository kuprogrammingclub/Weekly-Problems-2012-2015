;; A memoized Fibonacci summer
(defn fib [n]
  (if (< n 2) n
    (+ (fib (dec n))
       (fib (dec (dec n))))))

(defn fibSum []
  (reduce + (filter even? (take-while (partial > 10000000) 
                                      (map (memoize fib) (iterate inc 1))))))
