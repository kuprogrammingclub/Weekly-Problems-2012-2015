;;;; The Wikipedia article of the day happens to be
;;;; https://en.wikipedia.org/wiki/Final_Fantasy_VIII
(use 'clojure.string)
(defn cypher [offset]
  (let [cypher-char (partial (fn [offset letter]
                               (char (+ (mod (+ (- (int letter) 97) offset) 26) 97))) offset)]
    (println "This is like talking to a wall:")
    (when-let [string (read-line)]
      (reduce str
              (map cypher-char (seq (lower-case string)))))))
