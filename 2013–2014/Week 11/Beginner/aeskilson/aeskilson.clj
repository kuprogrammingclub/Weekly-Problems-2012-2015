(defn block-split [block k]
  (map reverse (partition k block)))
