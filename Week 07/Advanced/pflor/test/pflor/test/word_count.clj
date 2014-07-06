(ns pflor.test.word-count
  (:use [pflor.word-count]
        [clojure.test]))

(deftest analyze-analyze
  (are [in out] (= (analyze in) out)
       "hi HO HI ho"             ["hi" "ho" "hi" "ho"]
       "I'm so-so"               ["i'm" "so-so"]
       "'quoted text'"           ["quoted" "text"]
       "Easy as 123!"            ["easy" "as" "123"]
       "===========D~"           ["d"]
       "extra-cool-word's entry" ["extra-cool-word's" "entry"]))

(deftest count-counts
  (are [word-list teh-counts] (= (counts word-list) teh-counts)
       ["4" "score" "and" "se7en"] [["4" 1]
                                    ["and" 1]
                                    ["score" 1]
                                    ["se7en" 1]]
       (shuffle
        (concat
         (repeat 12 "a")
         (repeat 13 "b")))         [["a" 12]
                                    ["b" 13]]
       ["obligatory"
        "third"
        "test"]                    [["obligatory" 1]
                                    ["test"       1]
                                    ["third"      1]]))
