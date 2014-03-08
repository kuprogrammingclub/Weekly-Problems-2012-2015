;; Accepts a collection of space seperated text
;; Returns a two-element list of vowels and consonants
(def vowel? (set "aeiouAEIOU"))

(defn disemvowel [word]
  (loop [raw (flatten (map seq (clojure.string/split word #"\s+"))), vowels [], consons []]
    (if (seq raw)
      (if (vowel? (first raw))
        (recur (rest raw) (conj vowels (first raw)) consons)
        (recur (rest raw) vowels (conj consons (first raw))))
      [(clojure.string/join vowels) (clojure.string/join consons)])))
