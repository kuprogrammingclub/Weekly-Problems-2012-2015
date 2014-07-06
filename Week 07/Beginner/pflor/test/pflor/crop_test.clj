(ns pflor.crop-test
  (:require [clojure.test :refer :all]
            [pflor.crop :refer :all]))

(deftest crop-crops-like-crop-should-crop
  (are [in out] (= (crop in) out)
       [[0 0 0]
        [0 0 0]
        [0 0 0]]      [[]]

       [[1 1 1]
        [1 1 1]
        [1 1 1]]      [[1 1 1]
                       [1 1 1]
                       [1 1 1]]

       [[0 1 0]
        [1 1 1]
        [0 1 0]]      [[0 1 0]
                       [1 1 1]
                       [0 1 0]]

       [[0 0 0]
        [1 1 1]
        [1 1 1]]      [[1 1 1]
                       [1 1 1]]

        #_ad-infinitum))
