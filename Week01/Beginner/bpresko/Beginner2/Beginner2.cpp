/**
* @file: Beginner2.cplusplus
* @author: Bryce C Presko
* @date: 2015.09.06
* @brief: Beginner weekly problems for Programming Club #1
*/

#include "Helper.h"


int main(){
    int count = 0;
    char check;
    std::string word;
    bool end = false;
    std::cout<<"\nProgram will loop 3 times each before prompting to end!\n";
    while(!end){
        Helper* palindrome = new Helper();
        std::cout<<"\nEnter a word to check if it is a palindrome\n";
        std::cin>>word;
        palindrome->setParameters(word, word.length());
        palindrome->convertToLower();
        palindrome->reverse();
        if(palindrome->comparePalindrome() == true){
            std::cout<<"> Palindrome\n";
        }
        else{
            std::cout<<"> Not a palindrome\n";
        }
        delete palindrome;
        count++;
        if(count%3 == 0){
            std::cout<<"Again?[(y)es/(n)o]\n";
            std::cin>>check;
            if(check == 'y' || check == 'Y'){
                end = false;
            }
            else if(check == 'n' || check == 'N'){
                end = true;
            }
        }
    }
    return(0);
}
