(defn gattaca [s]
  (println (str s "\n" (apply str (map #(cond
                                          (= \A %) \T
                                          (= \T %) \A
                                          (= \G %) \C
                                          (= \C %) \G
                                          :else %)
                                       s)))))      
