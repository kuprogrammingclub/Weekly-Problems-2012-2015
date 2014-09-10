(use '[clojure.string :only (reverse)])

(defn palindrome? [word]
  (if (= (reverse word) word)
         true
         false))
