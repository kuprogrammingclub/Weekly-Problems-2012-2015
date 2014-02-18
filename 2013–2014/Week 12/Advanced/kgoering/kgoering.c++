#include <string>
#include <iostream>
#include <algorithm>

using namespace std;

void reset(bool b[][7]) {
	for(int i = 0; i < 7; i++) {
		b[0][i] = false;
		b[1][i] = false;
	}
}

void readNotes(string s, bool b[][7]) {
	reverse(s.begin(), s.end());
	for(int i = 0; i < s.length(); ) {
		if(s.at(i) == '#') {
			i++;
			switch(s.at(i)) {
			case 'A':	b[0][4] = true;
						break;
			case 'B':	b[0][6] = true;
						break;
			case 'C':	b[0][1] = true;
						break;
			case 'D':	b[0][3] = true;
						break;
			case 'E':	b[0][5] = true;
						break;
			case 'F':	b[0][0] = true;
						break;
			case 'G':	b[0][2] = true;
						break;
			}
			i += 2;
		} else if (s.at(i) == 'b') {
			i++;
			switch(s.at(i)) {
			case 'A':	b[1][2] = true;
						break;
			case 'B':	b[1][0] = true;
						break;
			case 'C':	b[1][5] = true;
						break;
			case 'D':	b[1][3] = true;
						break;
			case 'E':	b[1][1] = true;
						break;
			case 'F':	b[1][6] = true;
						break;
			case 'G':	b[1][4] = true;
						break;
			}
			i += 2;
		} else if(s.at(i) == 'r') 
			i++;
		else 
			i += 2;
	}			
}

string findScale(bool b [][7]) {
	bool found = false;
	int i = 0;
	int j = 6;
	for(j; j >= 0; j--) {
		if(b[i][j]){
			found = true;
			break;
		}else if(b[++i][j]) {
			found = true;
			break;
		}
		i = 0;
	}	
	if(!found)
		return "C major";

	switch (i) {
	case 0:	switch(j) {
			case 6: return "C# major";
			case 5:	return "F# major";
			case 4: return "B major";
			case 3: return "E major";
			case 2: return "A major";
			case 1: return "D major";
			case 0: return "G major";
			}
	case 1:	switch(j) {
			case 6: return "Cb major";
			case 5:	return "Gb major";
			case 4: return "Db major";
			case 3: return "Ab major";
			case 2: return "Eb major";
			case 1: return "Bb major";
			case 0: return "F major";
			}
	}
}

int main() {
	bool notes[2][7];
	reset(notes);
	string s;
	while(getline(cin, s)) {
		if(s.length() < 1) 
			break;
		readNotes(s, notes);
		string scale = findScale(notes);
		cout << scale << endl;
		reset(notes);
	}
	return 0;
}