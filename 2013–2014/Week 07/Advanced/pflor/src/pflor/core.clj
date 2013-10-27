(ns pflor.core
  (:require [pflor.word-count :refer [analyze counts]]))

(defn get-text
  "Gets the contents of a file (relative to project root) into a string.
   TODO: make this not hold on to the whole file in memory :)"
  [filepath]
  (slurp filepath))

(defn count-text
  "Returns a sorted frequency ArraySeq of words in the text (a single string)"
  [text]
  (-> text
      analyze
      counts))

(defn print-counts
  "Prints an ArraySeq of pairs, with evenly-spaced columns"
  [aseq]
  (if (seq aseq)
    (let [max-word-length (apply max (map (comp count first) aseq))]
      (doseq [[word occurences] aseq]
        (let [space-buffer (apply str (repeat (- max-word-length (count word)) \space))]
          (println word space-buffer occurences))))
    (println "No words could be found.")))

(defn -main
  [& args]
  (-> (or (first args) "resources/ex1.txt")
      get-text
      count-text
      print-counts))

