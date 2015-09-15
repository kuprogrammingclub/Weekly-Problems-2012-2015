#include <iostream>
#include <queue>
#include <string>

using namespace std;
string s;

int main() {
	while (cin >> s) {
		deque<char> q;
		for (int i = 0; i < s.length(); i++) {
			if (!q.empty()) {
				if ((q.front() == '(' && s[i] == ')')
					|| (q.front() == '{' && s[i] == '}')
					|| (q.front() == '[' && s[i] == ']')) {
					q.pop_front();
				}
				else {
					q.push_front(s[i]);
				}
			}
			else {
				q.push_front(s[i]);
			}

		}
		if (q.empty()) {
			cout << "yes" << '\n';
		}
		else {
			cout << "no" << '\n';
		}
	}
}