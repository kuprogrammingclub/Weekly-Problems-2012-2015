(def raw (ref []))

(defn find-palin [start-left, start-right]
  (loop [section [], left start-left, right start-right]
    (if (and (> left 0) (< right (- (count @raw) 1)) (= (@raw left) (@raw right)))
      (recur (subvec @raw (- left 1) (+ right 1)), (- left 1), (+ right 1))
      section)))

(defn palindrome [word]
  (dosync
    (ref-set raw (vec word))
    (vec (map (fn [start-pos]
               (concat (find-palin start-pos (+ start-pos 1)) (find-palin start-pos start-pos)))
              (range 0 (count @raw))))))
