#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void solve(vector<int> &inpt, const unsigned int k) {
    vector<int>::iterator it  = inpt.begin();
    vector<int>::iterator end = inpt.end();

    while(it < end) {

        reverse(it, (it + k < end) ? it + k : end); 

        it += k;
    }
}

template<typename T>
void printVector(vector<T> v) {
    cout << "{ ";

    for(auto e : v) {
        cout << e << " ";
    }

    cout << "}\n";
}

int main () {
    vector<int> inpt = { 1, 2, 3, 4, 5, 6, 7, 8 };

    solve(inpt, 3);

    printVector(inpt);

    return 0;
}
