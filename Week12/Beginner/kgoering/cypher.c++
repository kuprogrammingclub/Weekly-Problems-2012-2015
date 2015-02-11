#include <iostream>
#include <string>

using namespace std;

int main() {
	cout << "Are we encoding(E) or decoding(D) messages?" << endl;
	char c;
	cin >> c;
	if(c == 'E') {
		cout << "Enter the shift number: ";
		int n;
		cin >> n;
		n = n % 26;
		cout << "Enter the string to be encoded: ";
		string s;
		cin >> s;
		string ans;
		for(int i = 0; i < s.length(); i++) {
			if(s.at(i) != ' ') {
				if (s.at(i) > 'Z') {
					if((s.at(i) + n) > 122) {
						ans += (char)((s.at(i) + n) - ('z' + 1) + 'a');
					} else 
						ans += (char)(s.at(i) + n);
				} else {
					if((s.at(i) + n) > 90) {
						ans += (char)((s.at(i) + n) - ('Z' + 1) + 'A');
					} else 
						ans += (char)(s.at(i) + n);
				}
			}
		}
		cout << "The encoded string is " << ans << endl;
	} else {
		cout << "Enter the shift number: ";
		int n;
		cin >> n;
		n = n % 26;
		cout << "Enter the string to be decoded: ";
		string s;
		cin >> s;
		string ans;
		for(int i = 0; i < s.length(); i++) {
			if(s.at(i) != ' ') {
				if (s.at(i) > 'Z') {
					if((s.at(i) - n) < 97) {
						ans += (char)('z' - ('a' - (s.at(i) - n) - 1));
					} else 
						ans += (char)(s.at(i) - n);
				} else {
					if((s.at(i) - n) < 65) {
						ans += (char)('Z' - ('A' - (s.at(i) - n) - 1));
					} else 
						ans += (char)(s.at(i) - n);
				}
			}
		}
		cout << "The decoded string is " << ans << endl;
	}

	return 0;
}