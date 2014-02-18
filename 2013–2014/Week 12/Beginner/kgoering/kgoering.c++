#include <string>
#include <iostream>

using namespace std;

int main() {
	string s;
	while(getline(cin, s)){
		if(s.length() < 1) 
			break;
		int x = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.at(i) == '(')
				x++;
			if(s.at(i) == ')')
				x--;
		}
	
		if(x > 0 || x < 0)
			cout << "Unbalanced" << endl;
		else
			cout << "Balanced" << endl;
	}
	return 0;
}
