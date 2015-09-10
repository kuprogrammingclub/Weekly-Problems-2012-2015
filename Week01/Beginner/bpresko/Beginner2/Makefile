Beginner2: Beginner2.o Helper.o
	g++ -Wall -std=c++11 -g Beginner2.o Helper.o -o Beginner2
Beginner2.o: Beginner2.cpp Helper.h
	g++ -Wall -std=c++11 -g -c Beginner2.cpp
Helper.o: Helper.cpp Helper.h
	g++ -Wall -std=c++11 -g -c Helper.cpp
clean:
	rm *.o Beginner2
	echo clean done
