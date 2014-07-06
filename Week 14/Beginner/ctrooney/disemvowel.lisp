(defun vowelguts (x) 
    (cond ((null x) ())
          ((vowelp (first x) (coerce "aeiouAEIOU " 'list)) (vowelguts (rest x))) 
          (t (cons (first x) (vowelguts (rest x))))))

(defun disemvowel (x)
    (cond ((equal (type-of x) 'CONS) (vowelguts x))
          (t (coerce (vowelguts (coerce x 'list)) 'string))))

(defun vowelp (x vowels)
    (cond ((null vowels) nil)
          ((equal x (first vowels)) t)
          (t (vowelp x (rest vowels)))))

(print (disemvowel "greetings to the ku acm and competitive programming club!"))
