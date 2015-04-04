/**
    infiniteMonkey.pcp

    1. Create a random string of 28 characters.
    2. Make 100 copies of the string.
    3. For each character in each of the 100 copies, with a probability of 5%, replace the
       character with a new random character.
    4. Compare each new string with METHINKS IT IS LIKE A WEASEL and give each a score (the
       number of letters in the string that are correct and in the correct position).
    5. If any of the new strings has a perfect score (28), halt. Otherwise, take the
       highest-scoring string, and go to step 2.

    Author: Stefan Mendoza
    Date: 3 April 2015
*/

#include <iostream>
#include <time.h>
using namespace std;

const char correct[] = "METHINKS IT IS LIKE A WEASEL";
const char alphabet[] = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
string conversionStr = "";
int iterations = 0;

void shakespearify(char jumbled[]) {
    cout << "Count: " << iterations << endl;
    cout << "Starts" << endl;

    int currentScore = 0;
    int maxScore = 0;
    char closest[28];
    string permutations[100];

    for(int i = 0; i < 100; i++) {
        srand(i);
        permutations[i] = jumbled;

        string test(permutations[i]);
        cout << test << endl;

        for(int j = 0; j < 28; j++) {
            permutations[i][j] = alphabet[rand() % 28];
            cout << permutations[i][j] << endl;

            if(permutations[i][j] == correct[j]) {
                currentScore++;
            }
        }

        if(currentScore > maxScore) {
            maxScore = currentScore;
            
            for(int k = 0; k < 28; k++) {
                closest[k] = permutations[i][k];
            }

            if(currentScore == 28) {
                return;
            }
        }

        currentScore = 0;
    }

    cout << "Gets here" << endl;

    for(int i = 0; i < 28; i++) {
        conversionStr += closest[i];
    }

    cout << maxScore << ": " << conversionStr << endl;
    conversionStr = "";
    cout << "Gets to end." << endl;
    iterations++;
    shakespearify(closest);
}


int main() {
    srand(time(NULL));
    char randomChars[28];

    for(int i = 0; i < 28; i++) {
        srand(rand());
        randomChars[i] = alphabet[rand() % 28];
    }

    for(int i = 0; i < 28; i++) {
        conversionStr += randomChars[i];
    }

    cout << "Initial: " << conversionStr << "\n" << endl;
    conversionStr = "";
    shakespearify(randomChars);

    return(0);
}