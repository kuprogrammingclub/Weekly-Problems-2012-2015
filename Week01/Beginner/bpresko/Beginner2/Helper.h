/**
* @file: Helper.h
* @author: Bryce C Presko
* @date: 2015.09.06
* @brief: Helper header for Beginner2
*/

#ifndef HELPER_H
#define HELPER_H

#include <iostream>
#include <string>
#include <string.h>
#include <stdio.h>
#include <ctype.h>

class Helper{
public:
    Helper();
    ~Helper();
    void convertToLower();
    void reverse();
    void setParameters(std::string word, int length);
    bool comparePalindrome();
private:
    char* m_orig;
    char* m_revs;
    int m_size;
};

#endif
