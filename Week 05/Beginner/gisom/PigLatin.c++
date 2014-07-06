#include <iostream>
#include <fstream>
#include <string>

int main(int argc, char *argv[])
{
    std::ifstream inp("input.txt");
    std::string curWord;
    char *letters;
    while (inp >> curWord)
    {
        letters=new char[curWord.size()+3];
        letters[curWord.size()]=0;
        memcpy(letters,curWord.c_str(),curWord.size());
        char temp = letters[0];
        if (letters[0] != 'a')
        {
            for (int i =1; i < curWord.size()+1; i++)
            {
                letters[i-1] = letters[i];
                std::cout << letters[i];
            }
            std::cout << temp << "ay" << "\n";
        } else
        {
            for (int i=0; i < curWord.size()+1; i++)
            {
                std::cout << letters[i];
            }
            std::cout << temp << "yay" << "\n";
        }
    }
        
    
}