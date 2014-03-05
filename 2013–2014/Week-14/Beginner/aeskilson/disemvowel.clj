(defn disemvowel [word]
  (let [word-seq (clojure.string/lower-case (.replaceAll word "\\s+" ""))]
    ((fn [word-seq]
      (loop [word-seq word-seq vowels '() consons '()]
        (if (not (nil? (seq word-seq)))
          (if (re-find #"[aeiou]" (first word-seq))
            (conj (first word-seq) vowels)
            (conj (first word-seq) consons))
          (recur (rest word-seq) vowels consons))))
     word-seq)
    (println vowels consons)))
