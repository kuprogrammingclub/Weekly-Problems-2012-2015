/*
    Fibonacci.cpp
   
    @author Stefan Mendoza
    @date 8 February 2015
*/


//---------- NEED TO VERIFY THAT OUTPUT IS CORRECT ----------
// n = 134 is incorrect. Not sure about everything else. Correct up to a certain position.


#include <iostream>
using namespace std;


long fibonacci(unsigned long long prior, unsigned long long current, int position, int count) {
    if(position == 0) {
        return 0;
    }
    else if(position == 1 || count == position) {
        return current;
    }
    else {
        return fibonacci(current, prior + current, position, count + 1);
    }
}


int main() {
    for(int i = 1; i < 93; i++) {
        cout << fibonacci(0, 1, i, 1) << endl;
    }

    return(0);
}
