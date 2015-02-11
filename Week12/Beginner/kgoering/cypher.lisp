(defun encrypt (char key)
  (let*
    ((c  (char-code  char))
     (la (char-code #\a)) (lz (char-code #\z))
     (ua (char-code #\A)) (uz (char-code #\Z))
     (base (cond 
            ((and (>= c la) (<= c lz)) la) 
            ((and (>= c ua) (<= c uz)) ua) 
            (t nil))))
     (if base (code-char (+ (mod (+ (- c base) key) 26) base)) char)))
 

 ;'E for encrypting 'D for decrypting
(defun cypher (str key type)
    (if (eq type 'D) (setf key (* -1 key)) '())
    (map 'string #'(lambda (c) (encrypt c key)) str))
