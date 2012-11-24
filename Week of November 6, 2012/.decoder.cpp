#include <iostream>
#include <stdlib.h>
#include <string>
using namespace std;

void decoder(string prev, string tail)
{
	int len = tail.length();
	if(len > 1 && atoi(tail.substr(0, 2)) < 27) {
		decoder(prev + tail.substr(0, 1), tail.substr(1));
		decoder(prev + tail.substr(0, 2), tail.substr(2));
	} else if (len == 1) {
		decoder(prev + tail.substr(0, 1), tail.substr(1, len - 1));
	} else {
		cout << prev << (char)(atoi(tail) + '`') << endl;
	}
}

int main(int argc, char* argv[])
{
	decoder("", argv[1]);
}