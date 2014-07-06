(defn dieRoll [x d]
  (loop [result [] x x d d]
   (if (= x 0) result
    (recur (conj result (+ (rand-int d) 1)) (- x 1) d))))

(defn roller [rollStr]
  (let [parsed (map #(Integer/parseInt %) (clojure.string/split rollStr #"d"))]
    (dieRoll  (first parsed) (second parsed))))
