(ns pflor.core
  (:require [pflor.word-count :refer [count-text]]))

;; I stuck the side-effecty stuff in with main.

(defn get-text
  "Gets the contents of a file (relative to project root) into a string.
   TODO: make this not hold on to the whole file in memory :)"
  ;; NOTE: the way to do so is with java buffery readery things.
  [filepath]
  ;; A more concise way of defining this function: (def get-text slurp)
  (slurp filepath))

(defn print-counts
  "Prints an ArraySeq of pairs, with evenly-spaced columns"
  [aseq]
  ;; This is screaming "insert some carriage returns and refactor me!"
  ;; Clojure should very rarely look this horizontal.
  (if (seq aseq)
    (let [max-word-length (apply max (map (comp count first) aseq))]
      (doseq [[word occurences] aseq]  ;; destructuring; not as
                                       ;; powerful as generalized
                                       ;; pattern matching.
        (let [space-buffer (apply str (repeat (- max-word-length (count word)) \space))]
          (println word space-buffer occurences))))
    (println "No words could be found.")))

(defn -main
  [& args]
  (-> (or (first args) "resources/ex1.txt") ;; first of an empty list?
                                            ;; Clojure and honey
                                            ;; badger don't care.
      get-text
      count-text
      print-counts))

