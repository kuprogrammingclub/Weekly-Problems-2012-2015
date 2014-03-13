(defn find-odd [index word]
  (loop [section [], left index, right index]
    (if (and (> left 0) (< right (- (count word) 1)) (= (word (- left 1)) (word (+ right 1))))
      (recur (subvec word (- left 1) (+ right 2)), (- left 1), (+ right 1))
      section)))

(defn find-even [index word]
  (if (and (< index (- (count word) 1)) (= (word index) (word (+ index 1))))
    (loop [section [], left index, right (+ index 1)]
      (if (and (> left 0) (< right (- (count word) 1)) (= (word (- left 1)) (word (+ right 1))))
        (recur (subvec word (- left 1) (+ right 2)), (- left 1), (+ right 1))
        section))
  []))

(defn palindrome [input]
  (let [word (vec input)]
    (clojure.string/join (apply max-key count (map (fn [index]
                (into (find-even index word) (find-odd index word)))
              (range 0 (count word)))))))
