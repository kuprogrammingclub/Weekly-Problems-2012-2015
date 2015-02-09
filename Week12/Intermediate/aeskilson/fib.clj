;; Memoized
(def fibm
  (memoize 
    (fn [n] 
      (if (>= 1 n) 
        n 
        (+ (fibm (- n 1)) (fibm (- n 2)))))))

;; Unmemoized
(defn fibu [n]
  (if (>= 1 n)
    n
    (+ (fibu (- n 1)) (fibu (- n 2)))))
