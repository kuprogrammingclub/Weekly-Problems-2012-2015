cycleConsonants([Head|Rest], [Head|Rest]) :-
	isVowel(Head).
cycleConsonants([Head|Rest], [NewHead|NewRest]) :-
	not(isVowel(Head)),
	append(Rest, [Head], [NextHead|NextRest]),
	cycleConsonants([NextHead|NextRest], [NewHead|NewRest]).

pigLatinateWord([Head|Rest], ResultStr) :-
	not(isVowel(Head)),
	cycleConsonants([Head|Rest], AlteredStr),
	append(AlteredStr,"ay",UnformattedFinal),
	format(atom(ResultStr),'~s',[UnformattedFinal]).
pigLatinateWord([Head|Rest], ResultStr) :-
	isVowel(Head),
	append("y", [Head|Rest], PreformattedStr),
	pigLatinateWord(PreformattedStr, ResultStr).

pigLatinatePhrase([First|[]],[ResultStr]) :-
	pigLatinateWord(First,ResultStr).
pigLatinatePhrase([First|Rest],[FirstResult|RestResults]) :-
	pigLatinateWord(First,FirstResult),
	pigLatinatePhrase(Rest,RestResults).

isVowel(Char) :-
	[Char] = "a";
	[Char] = "e";
	[Char] = "i";
	[Char] = "o";
	[Char] = "u".
charEncodeList([First|Rest],[First|Rest]) :-
	not(atom(First)).
charEncodeList([First|Rest],[NewFirst|NewRest]) :-
	atom(First),
	atom_codes(First,EncodedFirst),
	append(Rest,[EncodedFirst],[NextFirst|NextRest]),
	charEncodeList([NextFirst|NextRest],[NewFirst|NewRest]).
writeAll([]).
writeAll([First|Rest]) :-
	write(First),
	write(' '),
	writeAll(Rest).

main :-
	write('Enter a word, mortal!'),
	nl,
	read(Y),
	atomic_list_concat([First|Rest],' ',Y),
	charEncodeList([First|Rest],L),
	pigLatinatePhrase(L,Result),
	writeAll(Result).
