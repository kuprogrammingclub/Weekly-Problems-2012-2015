(ns pflor.crop)

;; crop and helpers ;;;;;;;;;;;;;;;;;;;;;;;;

(def trim
  (partial drop-while #(every? zero? %)))

(defn transpose
  [matrix]
  (if (seq matrix)
    (apply mapv vector matrix)
    [[]]))

(defn crop
  "The human way: cut, flip, cut, flip-rotate, cut, flip, cut, flip-rotate."
  [matrix]
  (->> matrix
       trim
       reverse trim
       transpose trim
       reverse trim
       transpose))
