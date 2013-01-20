#lang racket
(define (% n k) ; Alias these for easier input
  (cond [(= k 0) "—"]
        [else (modulo n k)]))
(define (divide n k)
  (cond [(= k 0) "—"]
        [else (/ n k)]))
(define & bitwise-and)
(define || bitwise-ior)
(define ^^ bitwise-xor)
(define !! bitwise-not)
(define (fact n)
  (cond [(zero? n) 1]
        [(> n 0) (* n (fact (- n 1)))]
        [else (raise-argument-error 'fact "n at least 0"' n)]))
(define ! fact)
(define (comb n k)
  (cond [(< n k) (swap n k)]
        [(< n 0) (raise-argument-error 'comb "n at least 0"' n)]
        [(< k 0) (raise-argument-error 'comb "k at least 0"' k)])
        (/ (! n) (* (! (- n k)) (! k))))
(define (perm n k)
  (cond [(< n k) (swap n k)]
        [(< n 0) (raise-argument-error 'perm "n at least 0"' n)]
        [(< k 0) (raise-argument-error 'perm "k at least 0"' k)])
        (/ (! n) (! (- n k))))

(define (proc-substr proc) ; Subtring utility for extracting procedure name
  (string-replace (string-replace (~a proc) "#<procedure:" "") ">" ""))
(define-syntax-rule (swap x y) ; Swaps two values
  (let ([tmp x])
    (set! x y)
    (set! y tmp)))

(define (arith-table operator size) ; The actual program
  (cond [(< size 0) (raise-argument-error 'arith-table "Size at least 0"' size)]
        [(>= size 100) (raise-argument-error 'arith-table "Size less than 100"' size)])
  (cond [(procedure-arity-includes? operator 2)
         (display (format "|~a" (proc-substr operator)))
         (for ([i (+ size 1)])
           (display (format "|~a" i)))
         (display "\n")
         (for ([i (+ size 2)])
           (display "|:"))
         (display "\n")
         (for ([i (+ size 1)])
           (display (format "|**~a**" i))
           (for ([j (+ size 1)])
             (display (format "|~a" (operator j i))))
           (display "\n"))]
        [(procedure-arity-includes? operator 1)
         (displayln (format "|Input|~a|" (proc-substr operator)))
         (displayln "|:|:|")
         (for ([i (+ size 1)])
           (displayln (format "|**~a**|~a|" i (operator i))))]
        [else (raise-argument-error 'arithmetic-table "Operators that can accept 1 or 2 arguments"' operator)])
  )