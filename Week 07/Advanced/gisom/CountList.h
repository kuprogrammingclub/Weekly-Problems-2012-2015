/**
 * @file CountList.h
 * @author Grant Isom <grantisom@ku.edu>
 * @date Septemeber 24, 2013
 * @version 1.0
 *
 * @section DESCRIPTION
 *
 * This is the header for CountList that originizes and creates the linked list of type count using Node. Method descriptions are in the .c++ file.
 *
 */

#include "Count.h"
#include <iostream>
#include <fstream>
#include <string>
#include "Node.h"

#ifndef COUNTLIST_H
#define COUNTLIST_H

template <typename T>
class CountList
{
private:
    Node<Count<T> >* head;
    int arraySize; // initially: 10
    int numItemsStored;
    
public:
    CountList();
    CountList(const CountList<T>& countLst);
    ~CountList();
    Node<Count<T> >* checkAndSet(Node<Count<T> >* head, T t, bool& found);
    void bumpCount(T t);
    int getNumItemsStored() const;
    Count<T> getItem(int whichItem) const;
    Count<T> newCount(T t) const;
    void print();
}; //end of the header file

#include "CountList.c++"

#endif
