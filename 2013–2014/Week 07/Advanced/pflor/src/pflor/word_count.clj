(ns pflor.word-count
  (:require [clojure.string :refer [lower-case]]))

(defn analyze
  "Return a seq of the words in a text. Pretty dumb regex to start."
  [text]
  (->> text
       (re-seq #"\w((\-|')?[\w]+)*")
       (map first)
       (map lower-case)))

(defn counts
  "Return a sorted ArraySeq of word -> count for a given seq of words"
  [word-list]
  (-> word-list
      frequencies
      sort))

(defn count-text
  "Returns a sorted frequency ArraySeq of words in a text (a single string)"
  [text]
  (-> text
      analyze
      counts))
