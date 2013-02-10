//
//  PerfectNumber.cpp
//  
//
//  Created by Alec White on 2/10/13.
//

#include <iostream>
#include <string.h>

using namespace std;

string numberType(int number)
{
    int sum = 0;
    
    for(int i = 1; i <= number / 2; i++) {
        if(number % i == 0) {
            sum += i;
        }
    }
    
    if(number == sum) {
        return "PERFECT";
    }
    else if(number <= sum) {
        return "ABUNDANT";
    }
    else if(number >= sum) {
        return "DEFICIENT";
    }
}

int main(int argc, char* argv[])
{
    int n;
    bool loop = true;
    
    cout << "PERFECTION OUTPUT" << endl;
    
    while(loop) {
        cin >> n;
        if(n == 0){
            break;
        }
        else {
            cout << n << " " << numberType(n) <<  endl;
        }
    }
    
    cout << "END OF OUTPUT" << endl;
    
    return 0;
}
