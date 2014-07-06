coins(0,1) :- !.
coins(X,Y) :- nonvar(X), Ai is X//2, Bi is X//3, Ci is X//4, coins(Ai,A), coins(Bi,B), coins(Ci,C), Y is A+B+C.