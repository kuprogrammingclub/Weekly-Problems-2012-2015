#include <iostream>
#include <string>
#include <sstream>
#include <fstream>
using namespace std;
string s, type;
stringstream ss;
class StateMachine {
	enum states { 
		state0 = 0, state1 = 1, state2 = 2, 
		state3 = 3, state4 = 4, state5 = 5,
		state6 = 6, state7 = 7, state8 = 8,
		state9 = 9, state10 = 10, state11 = 11,
		state12 = 12, state13 = 13, state14 = 14
	} state;
	struct branch {
		enum states new_state;
		int check;
	};
	static struct branch the_table[15][4];
public:
	StateMachine() : state(state0) {}
	void FeedChar(int c) {
		int idx2 = (s[c] == 'a') ? 0 : (s[c] == 't') ? 1 : (s[c] == 'g') ? 2 : (s[c] == 'c') ? 3 : 4;
		struct branch *b = &the_table[state][idx2];
		state = b->new_state;
		if (b->check == 1) {
			ss.str("");
			ss << c - 1;
			type = "HaeIII " + ss.str() + " " + s.substr(c - 8, 5) + "[gg cc]" + s.substr(c + 1, 8);
			cout << type << '\n';
		}
		if (b->check == 2) {
			ss.str("");
			ss << c - 4;
			type = "HindIII " + ss.str() + " " + s.substr(c - 10, 5) + "[a agctt]" + s.substr(c + 1, 6);
			cout << type << '\n';
		}
		if (b->check == 3) { 
			ss.str("");
			ss << c - 4;
			type = "BamHI " + ss.str() + " " + s.substr(c - 10, 5) + "[g gatcc]" + s.substr(c+1,6);
			cout << type <<'\n';
		}
	}
};
struct StateMachine::branch StateMachine::the_table[15][4] = {
					/* 'a'			't'			'g'			'c'	
	/* state0 */{ { state1,0 },{ state0,0 },{ state2,0 },{ state0,0 } },
	/* state1 */{ { state3,0 },{ state0,0 },{ state2,0 },{ state0,0 } },
	/* state2 */{ { state1,0 },{ state0,0 },{ state4,0 },{ state0,0 } },
	/* state3 */{ { state3,0 },{ state0,0 },{ state5,0 },{ state0,0 } },
	/* state4 */{ { state6,0 },{ state0,0 },{ state4,0 },{ state7,0 } },
	/* state5 */{ { state1,0 },{ state0,0 },{ state4,0 },{ state8,0 } },
	/* state6 */{ { state1,0 },{ state9,0 },{ state2,0 },{ state0,0 } },
	/* state7 */{ { state1,0 },{ state0,0 },{ state2,0 },{ state10,1 } },
	/* state8 */{ { state1,0 },{ state11,0 },{ state2,0 },{ state0,0 } },
	/* state9 */{ { state1,0 },{ state0,0 },{ state2,0 },{ state12,0 } },
	/* state10*/{ { state1,0 },{ state0,0 },{ state2,0 },{ state0,0 } },
	/* state11*/{ { state1,0 },{ state13,2 },{ state2,0 },{ state0,0 } },
	/* state12*/{ { state1,0 },{ state0,0 },{ state2,0 },{ state14,3 } },
	/* state13*/{ { state1,0 },{ state0,0 },{ state2,0 },{ state0,0 } },
	/* state14*/{ { state1,0 },{ state0,0 },{ state2,0 },{ state0,0 } },
};
int main(void)
{
	string line;
	ifstream infile("DNA.txt");
	while (getline(infile, line))
	{
		string::size_type n = 0;
		n = line.find_first_not_of(" \t", n);
		n = line.find_first_of(" \t", n);
		line.erase(0, line.find_first_not_of(" \t", n));
		for (int i = 0; i<line.length(); i++)
			if (line[i] == ' ') line.erase(i, 1);
		s = s + line;
	}
	infile.close();
	int c = 0;
	StateMachine machine;
	while (c < s.length()) {
		machine.FeedChar(c);
		c++;
	}
	system("pause");
}