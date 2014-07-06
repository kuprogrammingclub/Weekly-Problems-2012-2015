#include <iostream>
#include <fstream>
#include <string>
#include "Executive.h"
#include "Count.h"
#include "CountList.h"
/**
 * Prints the functions out nicely
 */

template<typename T>
void Executive::print(CountList<T> lst)
{
    lst.print();
}

/**
 *
 * Reads in the files as type of Count
 */

template<typename T>
void Executive::read(std::istream& is, CountList<T>& lst)
{
	int counter = 0;
	T temp;
	
	while (is >> temp) {
		lst.bumpCount(temp);
		counter++;
		if(counter == 5)
		{
			std::cout << "\nCurrent count of five most recent read in.\n" << "\n";
			
			print(lst);
			counter = 0;
		}
		
	};
}

/**
 * Takes the files into read().
 */

Executive::Executive(std::istream& stringFile)
{
	read(stringFile, strList);
}
/**
 * The print command executed by Main.c++
 */

void Executive::print() const
{
	std::cout << "\nString list: \n" << "\n";
	print(strList);

}




