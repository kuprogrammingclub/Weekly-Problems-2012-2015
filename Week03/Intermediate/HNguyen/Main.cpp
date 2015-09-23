#include <iostream>
#include <bitset>
#include <string>
#include <set>

using namespace std;
set<string> list;
void hyperbinary(string b) {
	size_t pos1 = b.find("10", 0);
	size_t pos2 = b.find("20", 0);
	list.insert(b);
	while (pos1 != string::npos) {
		hyperbinary(b.substr(0, pos1) + "02" + b.substr(pos1 + 2, b.length()));
		pos1 = b.find("10", pos1 + 1);
	}
	while (pos2 != string::npos) {
		hyperbinary(b.substr(0, pos2) + "12" + b.substr(pos2 + 2, b.length()));
		pos2 = b.find("20", pos2 + 1);
	}
}
int main() {
	unsigned int num;
	cin >> num;
	bitset<32> bits(num);
	string binary = bits.to_string();
	size_t first1 = binary.find_first_not_of("0");
	hyperbinary(binary.substr(first1, binary.length()));
	set<string>::iterator iter;
	for (iter = list.begin(); iter != list.end(); ++iter) {
		cout<<(*iter)<<'\n';
	}
	system("pause");
}
