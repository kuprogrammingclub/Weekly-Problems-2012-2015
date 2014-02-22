;; Finds divisors of a given number, sums to check property
(defn num-checker [num]
  (let [divisors (for [x (range 1 num)
                        :when (= (mod num x) 0)]
                    x)]
    (cond
        (> (reduce + divisors) num) "Abundant"
        (< (reduce + divisors) num) "Deficient"
        :else "Perfect")))

(defn exec [num-list]
  (interleave num-list (map num-checker num-list)))
