/*
    CodeCipher.cpp
    
    @author Stefan Mendoza
    @date 8 February 2015
*/

#include <iostream>
using namespace std;


string encode(string phrase, int shift) {
    string result = "";

    for(int i = 0; i < phrase.length(); i++) {
        int numericalValue = (int)phrase[i];

        if(numericalValue > 64 && numericalValue < 91) {
            if(numericalValue + shift > 90) {
                result += (char)(64 + (shift - (90 - numericalValue)));
            }
            else {
                result += (char)(numericalValue + shift);
            }
        }
        else if((int)phrase[i] > 96 && (int)phrase[i] < 123) {
            if(numericalValue + shift > 122) {
                result += (char)(96 + (shift - (122 - numericalValue)));
            }
            else {
                result += (char)(numericalValue + shift);
            }
        }
        else {
            result += phrase[i];
        }
    }

    return result;
}


int main() {
    cout << "\nPlease enter the word or phrase to encode: ";
    string userInput;
    getline(cin, userInput);

    int shiftVal = 13;
    
    cout << "Would you like to use the default cipher? (Y/N): ";
    string choice;
    getline(cin, choice);

    if(choice == "NO" || toupper(choice[0]) == 'N') {
        cout << "\nEnter the value you want to shift by (not greater than 26): ";
        cin >> shiftVal;

        if(shiftVal < 0) {
            cout << "Can't shift backwards. Using default shift." << endl;
            shiftVal = 13;
        }
        
        if(shiftVal > 26) {
            cout << "Can't shift by a number greater than 26. Using default shift." << endl;
            shiftVal = 13;
        }
    }

    cout << "\nOriginal: " << userInput << endl;
    cout << "Encrypted: " << encode(userInput, shiftVal) << "\n" << endl;


    return(0);
}
