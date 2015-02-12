;;;; The Wikipedia article of the day happens to be
;;;; https://en.wikipedia.org/wiki/Final_Fantasy_VIII
(defn cypher
  ([offset]
   (cypher (read-line) (partial (fn [offset letter]
                                  (char (+ (mod (+ (- (int letter) 97) offset) 26) 97))) offset)))
  ([string cypher-fn]
   (println (reduce str (map cypher-fn string)))
   (cypher (read-line) cypher-fn)))
