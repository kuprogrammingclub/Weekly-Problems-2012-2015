;function call = (Fibonacci 1 1 n) where n is nth number from the sequence being requested
(defun Fibonacci (a b n) (if (= n 1) a (Fibonacci b (+ a b) (- n 1))))