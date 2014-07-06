(ns pflor.word-count
  (:require [clojure.string :refer [lower-case]]))

;; Notice these are all pure functions. Clojure has immutable core
;; data structures, such that we can be assured of no side effects
;; from this namespace in Clojure-land. Can't prove it as in Haskell,
;; however.

(defn analyze
  "Return a seq of the words in a text. Pretty dumb regex to start."
  [text]
  ;; The double stabby is a threading macro; they are used to reduce
  ;; excessive s-expression nesting/indenting and un-reverse its
  ;; reversed reading-vs-execution ordering. Without threading, this
  ;; would be:
  ;; (map lowercase
  ;;      (map first
  ;;           (re-seq #"\w((\-|')?[\w]+)*" text)))
  ;; this is a marginal improvement; it gets better with more s-exps.
  (->> text
       (re-seq #"\w((\-|')?[\w]+)*")  ;; Anyone come up with a better
                                      ;;   word regexp?
       (map first)                    ;; Whole match only, not groups
       (map lower-case)))             ;; Up to you whether or not to
                                      ;;   ignore capitaliztion; I did

(defn counts
  "Return a sorted ArraySeq of word -> count for a given seq of words"
  [word-list]
  ;; single-stabby inserts first exp as first element of following
  ;; sexp, first making non-list forms into lists. double-stabby
  ;; inserts as /last/ one. Think of it as stack evaluation with
  ;; partial functions, if you wish.
  (-> word-list
      frequencies
      sort))

(defn count-text
  "Returns a sorted frequency ArraySeq of words in a text (a single string)"
  [text]
  ;; A pretty simple combinator
  (-> text
      analyze
      counts))
