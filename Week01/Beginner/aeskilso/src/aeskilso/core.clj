(ns aeskilso.core)

(defn hello []
  (println "What's your name?")
  (when-let [name (read-line)]
    (println (str "Hello, " name "!"))))

(defn palindrome [s]
  (if (= (clojure.string/reverse s) s)
    "Palindrome"
    "Not a palindrome"))
