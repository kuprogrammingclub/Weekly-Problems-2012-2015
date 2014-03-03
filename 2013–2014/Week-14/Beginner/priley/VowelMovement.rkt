#lang racket
(struct CharSplit (consnt vowel))
(define (classifyChar c)
  (let ([vow? (or (eqv? c #\a) (eqv? c #\e) (eqv? c #\i) (eqv? c #\o) (eqv? c #\u))] [cstr (if (eqv? c #\space) "" (list->string (list c)))])
    (CharSplit (if vow? "" cstr) (if vow? cstr ""))))
(define (disemvowel str)
  (let ([CSlist (map classifyChar (string->list str))])
  (format "Remains: ~a\nEntrails: ~a" (string-join (map CharSplit-consnt CSlist) "") (string-join (map CharSplit-vowel CSlist) ""))))
;use: (display (disemvowel <ENTER_STRING_HERE>))