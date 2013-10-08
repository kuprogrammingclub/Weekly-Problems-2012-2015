(declare cc)
(declare first-denomination)

(defn count-change [amount]
  (cc amount 8))


(defn cc [amount kinds-of-coins]
  (cond
        (= amount 0) 1
        (or (< amount 0) (= kinds-of-coins 0)) 0
        :else (+ (cc amount (- kinds-of-coins 1))
                 (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins))))

(defn first-denomination [kinds-of-coins]
  (cond
        (= kinds-of-coins 1) 1
        (= kinds-of-coins 2) 2
        (= kinds-of-coins 3) 5
        (= kinds-of-coins 4) 10
        (= kinds-of-coins 5) 20
        (= kinds-of-coins 6) 50
        (= kinds-of-coins 7) 100
        :else 200)) 
