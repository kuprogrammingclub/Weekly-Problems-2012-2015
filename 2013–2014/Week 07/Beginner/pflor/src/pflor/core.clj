(ns pflor.core
  (:require [pflor.crop :refer [crop]])
  (:gen-class))

(defn- cast-to-int
  [s]
  (Integer. s))

(defn read-matrix-file
  "filename -> [[int]]"
  [filename]
  (->> (slurp filename)
       (re-seq #"[01]+")
       (map #(re-seq #"." %))
       (map #(map cast-to-int %))))

(defn print-matrix
  "[[int]] -> io ()"
  [matrix]
  (doseq [r matrix]
    (println (apply str r))))

(defn -main
  [& args]
  (-> (or (first args) "resources/ex1.txt")
      read-matrix-file
      crop
      print-matrix))
