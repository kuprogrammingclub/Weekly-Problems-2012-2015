/*
    Fibonacci.cpp
    Purpose: Computes the value at the given position in the Fibonacci sequence without using
             assingment within the Fibonacci calculation.
    
    @author Stefan Mendoza
    @date 8 February 2015
*/

#include <iostream>
using namespace std;


long fibonacci(long prior, long current, int position, int count) {
    if(position == 0) {
        return 0;
    }
    else if(position == 1) {
        return 1;
    }
    else if(count == position) {
        return current;
    }
    else {
        return fibonacci(current, prior + current, position, count + 1);
    }
}


int main() {
    cout << "\nDemonstration of the algorithm without input (first 20 values):" << endl;
    for(int i = 1; i < 21; i++) {
        cout << fibonacci(0, 1, i, 1) << " ";

        if(i == 20) {
            cout << endl;
        }
    }

    cout << "\nEnter a number to compute the Fibonacci sequence for: ";
    long input;
    cin >> input;

    if(input > 134) {
        cout<< "That's too big of a number!" << endl;
    }
    else {
        cout << "The value at that place in the Fibonacci sequence is " << fibonacci(0, 1, input, 1) << ".\n" << endl;
    }

    return(0);
}