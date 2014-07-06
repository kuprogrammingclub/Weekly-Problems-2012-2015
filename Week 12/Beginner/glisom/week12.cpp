#import <iostream>

using namespace std;

int main() {
    string input;
    int incr;
    while (getline(cin, input)) {
        if (input.length() <= 0) {
            return -1;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.at(i) == '(') {
                incr++;
            }
            if (input.at(i) == ')') {
                incr--;
            }
        }
        if (incr == 0) {
            cout << "Balanced\n";
        }
        else {
            cout << "Unbalanced\n";
        }
    }
    return 0;
}