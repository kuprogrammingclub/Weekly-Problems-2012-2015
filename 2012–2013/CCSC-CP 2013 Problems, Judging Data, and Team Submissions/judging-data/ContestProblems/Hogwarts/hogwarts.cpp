/* Hogwarts.cpp 
Sorting hat problem. 
Problem suggested by Carol Spradling 
Solution by Brian Hare 

Classify incoming wizards into one of 4 houses (if possible) based on 
characters in their name: 
Gryffindor: G, Y, O
Slytherin: S, B, E
Hufflepuff: H, F, U
Ravenclaw: R, V, A

Upper/lower case is irrelevant. Count characters from each house; highest 
count decides. If tie, or all counts 0, sorting hat must decide. 

*/ 

#include <iostream>
#include <fstream> 
#include <string> 
using namespace std; 
// Uncomment this line to get file output. 
//#define DEBUG 

int main()
{
    ifstream fin("hogwarts.in"); 
#ifdef DEBUG 
    ofstream fout("hogwarts.out"); 
#endif 
    int Gryff, Slyth, Huff, Raven; 
    int NWizards; 
    string first, last, temp, out; 

    fin >> NWizards; 
    for (int count = 0; count < NWizards; count++)
    {
        fin >> first >> last; 
        temp = first + last; 
        for (int j = 0; j < temp.length(); j++)
            temp[j] = toupper(temp[j]); 
        Gryff = Slyth = Huff = Raven = 0; 
        for (int j = 0; j < temp.length(); j++)
        {
            switch(temp[j]) 
            {
            case 'G':
            case 'Y':
            case 'O':
                Gryff += 1; break; 
            case 'S':
            case 'B':
            case 'E':
                Slyth += 1; break; 
            case 'H': 
            case 'F':
            case 'U':
                Huff += 1; break; 
            case 'R':
            case 'V':
            case 'A':
                Raven += 1; break;
            // else do nothing 
            }
        }
#ifdef DEBUG
        cerr << temp << endl; 
        cerr << "Gryff="<<Gryff <<" \tSlyth=" << Slyth
             << " \tHuff="<<Huff<<" \tRaven="<<Raven<<endl; 
#endif 
        // We've got the counts. Now find out which is the highest. This is brute force. 
        if ((Gryff > Slyth) &&(Gryff > Huff) && (Gryff > Raven))
            out = "Gryffindor"; 
        else if ( (Slyth > Gryff) && (Slyth > Huff) && (Slyth > Raven))
            out = "Slytherin";
        else if ( (Huff > Gryff) && (Huff > Slyth) && (Huff > Raven))
            out = "Hufflepuff";
        else if ( (Raven>Gryff) && (Raven>Slyth) && (Raven>Huff))
            out = "Ravenclaw"; 
        else // we've got a tie, or all are 0 (which is still a tie) 
            out = "The Sorting Hat Must Decide."; 
        cout << out << endl; 
#ifdef DEBUG
        fout << out << endl; 
#endif 
    }
    fin.close(); 
#ifdef DEBUG 
    fout.close(); 
#endif 
    return 0; 
}


