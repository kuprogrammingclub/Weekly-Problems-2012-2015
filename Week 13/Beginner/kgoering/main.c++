#include <iostream>

using namespace std;

int main() {
	int n;
	while(cin >> n) {
		char box[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				cin.get(box[i][j]);
				if(box[i][j] == '\n') {
					j--;
				}
			}
		}

		cout << endl;

		for(int i = 0; i < n; i++) {
			int fallIndex = n - 1;
			for(int j = n - 1; j > -1; j--) {
				if(box[j][i] == '#') {
					fallIndex = j - 1;
				}else if(box[j][i] == '.') {
					if(j != fallIndex) {
						box[fallIndex][i] = '.';
						box[j][i] = ' ';
						fallIndex--;
					} else {
						fallIndex--;
					}
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				cout << box[i][j];
			}
		cout << endl;
	
		}
	}
}
