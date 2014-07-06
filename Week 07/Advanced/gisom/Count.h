/**
 * @file Count.h
 * @author Grant Isom <grantisom@ku.edu>
 * @date September 24th, 2013
 * @version 1.0
 *
 * @section DESCRIPTION
 *
 * This is the header file for the Count.c++ file, which is where the Count is described and declared. The .c++ file has descriptions on each of the methods actions.
 *
 */

#include <iostream>
#include <fstream>
#include <string>

#ifndef COUNT_H
#define COUNT_H

template <typename T>
class Count
{

private:
    T item;
    int count;

public:
   Count();
   Count(T t);
   void increment();
   T getItem();
   int getCount();
 }; //end of header file

#include "Count.c++"

#endif
