#include <iostream>
#include <String.h>
#include <ctype.h>
using namespace std;


bool isPalindrome(string A)
{
    bool is = true;
    for(int i = 0;i<A.length()/2;i++)
    {
        if(toupper(A[i]) != toupper(A[A.length()-1-i]))
        {
            is = false;
            break;
        }
    }
    return is;
}

int main()
{
    while(true)
    {
        string n;
        cin >> n;
        if(isPalindrome(n))
        {
            cout << "Palindrome" << endl;
        }
        else
        {
            cout << "Not a Palindrome" << endl;
        }
        
    }
    
    
}
