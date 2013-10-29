lab4:Main.o Executive.o
	g++ Main.o Executive.o -o lab4

Executive.o:Executive.c++ Executive.h Count.c++ Count.h CountList.c++ CountList.h 
	g++ -c -g Executive.c++

Main.o:Main.c++
	g++ -c -g Main.c++

clean:
	rm *.h~ *.c++~ *.o ./lab4
