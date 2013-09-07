#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <list>
using namespace std;

// Solution by Saul Spatz, UMKC 

/* Problem: 
String s is called unique if all the characters of s are different.
String s2 is producible from string s1, if we can remove some characters of s1 to obtain s2. 
String s1 is more beautiful than string s2 if length of s1 is more than length of s2 or 
they have equal length and s1 is lexicographically greater than s2.
 Given a string s find the most beautiful unique string that is producible from s.
*/

/* Solution:
Obvioulsy we want exactly one representative of each character in the input.
Suppose for concreteness that the alphabet is a-z.  We must pick the last 'a' in the string.
If there is a 'b' before the 'a' that we pick, we must pick the last such.  Otherwise, pick 
the last 'b' in the string.  Having chosen k letters, they divide the original string into
k+1 subtrings.  For the (k+1)st letter choose the last occurrence in the first of the 
substrings in which it appears.
*/

/* We will take the non-whitespace printable ASCII characters as the alphabet.  These are
 ! (hex 21) through ~ (hex 7E).*/


string beaut(string input) {
    vector<int> index[0x7F];
    list<int> found;

    found.push_back(input.size());

    for ( size_t k = 0; k < input.size(); k++ )
        index[input[k]].push_back(k);

    for (char seek = '!' ; seek <= '~'; seek++ ) {
        if ( index[seek].empty() ) continue;
        list<int>::iterator p = found.begin();
        while (  *p < index[seek][0] ) p++; 
        // Now *p is the right hand endpoint of the first sub-interval containing seek
        // so we want the largest element of index[seek] that is less than *p
        size_t k = 0;
        for (; k < index[seek].size(); k++ )
            if ( index[seek][k] > *p ) break;
        found.insert(p, index[seek][k-1]);       
    }
    string answer;
    list<int>::iterator p = found.begin();
    while ( *p != input.size() ) {
        answer.push_back(input[*p]);
        p++;
    }
     return answer;
}

// Uncomment this line for file output
//#define DEBUG

int main() {
    ifstream fin("beautiful.in");
    int N; 
    if ( !fin ) {
        cerr << "Couldn't open input file\n";
        return(1);
    }
#ifdef DEBUG
    ofstream fout("beautiful.out");
    if ( !fout ) {
        cerr << "Couldn't open output file\n";
        return(1);
    }
#endif
    string input;
    fin >> N; 
    for (int j = 0; j < N; j++)
    {
        fin >> input; 
#ifdef DEBUG
        fout << beaut(input) << endl; 
#endif
        cout << beaut(input) << endl; 
    }
    fin.close(); 
#ifdef DEBUG
    fout.close(); 
#endif
    return 0;
}