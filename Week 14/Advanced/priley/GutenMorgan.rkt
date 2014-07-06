#lang racket
(define (invert t)
  (if (equal? t 'and)
      'or
      'and))
(define (deMorg [l (read)]) ;returns the NOT of a given statment, in list form
  (if (list? l)
      (if (equal? (car l) 'not)
          (cadr l)
          (if (null? (cdr l))
              (list 'not (car l))
              (cons (invert (car l)) (map deMorg (cdr l)))))
          (list 'not  l)))
;example input: (deMorg '(and a (not (or b c))))