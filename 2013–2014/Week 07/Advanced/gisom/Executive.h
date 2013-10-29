/**
 * @file Executive.h
 * @author Grant Isom <grantisom@ku.edu>
 * @date September 24, 2013
 * @version 1.0
 *
 * @section DESCRIPTION
 *
 * This is the header for the class that starts the execution of the file and gets things where they need to be. The method defintions are in the .c++ file.
 *
 */

#ifndef EXECUTIVE_H
#define EXECUTIVE_H

#include "CountList.h"
#include "Count.h"

class Executive
{
private:

    CountList<std::string> strList;

    template <typename T>
    static void print(CountList<T> lst); // lst MUST be passed by value

    template <typename T>
    static void read(std::istream& is, CountList<T>& lst);
	
public:

    Executive(std::istream& stringFile);

    void print() const;
}; //end of header file

#endif
