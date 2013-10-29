/**
 * @file Main.c++
 * @author Grant Isom <grantisom@ku.edu>
 * @date September 24th, 2013
 * @version 1.0
 *
 * @section DESCRIPTION
 *
 * This is the main method that takes in the input from a text file and passes the parameters to the other class files which then manipulate the linked lists.
 *
 */

#include <iostream>
#include <fstream>
#include "Executive.h"

int main(int argc, char* argv[])
{
std::ifstream s1;

//files are read in.

s1.open(argv[1]);
if (!s1.is_open())
{
	std::cout << "Error: The file did not open 1\n";
	return -1;
}

Executive exe(s1);

//print is executed, which then is followed by the rest of the execution.

exe.print();
s1.close();


return 0;
}

