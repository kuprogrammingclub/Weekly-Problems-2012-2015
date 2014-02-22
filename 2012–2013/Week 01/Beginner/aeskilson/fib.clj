;; Creates a lazily evaluated sequence of Fibonacci numbers
(defn fib [a b]
     (lazy-seq (cons a (fib b (+ a b)))))

;; Generates Fibonacci numbers up to 4 mil, sums the even ones
(defn fibsum []
  (reduce + (for [x (take-while (partial > 4000000) (fib 0 1)) 
                  :when (even? x)]
              x)))
