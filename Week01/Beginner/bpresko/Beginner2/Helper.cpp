/**
* @file: Helper.hpp
* @author: Bryce C Presko
* @date: 2015.09.06
* @brief: Helper template for Beginner2
*/

#include "Helper.h"

Helper::Helper(){
    m_size = 0;
}

Helper::~Helper(){
    delete[] m_orig;
    delete[] m_revs;
}

void Helper::convertToLower(){
    for(int i = 0; i < m_size; i++){
        m_orig[i] = tolower(m_orig[i]);
    }
	//std::cout << m_orig<<std::endl;
}

void Helper::reverse(){
    for(int i = 1; i <= m_size; i++){
        m_revs[i - 1] = m_orig[m_size - i];
    }
    //std::cout<<m_revs<<std::endl;
}

void Helper::setParameters(std::string word, int length){
    m_size = length;
    m_orig = new char[length + 1];
    m_orig[length] = 0;
    m_revs = new char[length + 1];
    m_revs[length] = 0;
    memcpy(m_orig, word.c_str(), word.size());
}

bool Helper::comparePalindrome(){
    for(int i = 0; i < m_size; i++){
        if(m_orig[i] != m_revs[i]){
            return(false);
        }
    }
    return(true);
}
