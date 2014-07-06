#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

// Solution by Saul Spatz 

/* Alice and Ben play a game with a number of coins of various denminations.
   Alice plays first, removing one of the two coins at the ends.  Then Ben 
   removes a coin from one of the ends.  The players alternate turns, until all
   coins are removed.  Each player's score is the total of the coins he collects,
   minus the total collected by his opponent.

   What is the maximum score Alice can guarantee herself, if Ben plays as well 
   as possible?

   Input: coins.in.
   Each problem gives the number of, then the denominations of the coins (positive integers)
   from left to right.  The file ends with a problem of zero coins.
*/

// Uncomment this line for file output
//#define DEBUG 

int main() {
	ifstream fin("coins.in");
	if ( !fin ) {
		cerr << "Couldn't open input file\n";
		exit(1);
	}
#ifdef DEBUG
    ofstream fout("coins.out"); 
    if (!fout) {
        cerr << "Couldn't open output file.\n";
        exit(2); 
    }
#endif 
	int num;
	fin >> num;
	while ( num != 0 ) {
		vector<int> coins;
		for ( int k = 0; k < num; ++k ) {
			int coin;
			fin >> coin;
			coins.push_back(coin);
		}
		vector<int> value(coins);  // value of one-coin game to first player
	
		// Now we compute the values of all j-coin games, until we eventually have the
		// value of the single num-coin game.  value[k] is the value of the j-coin game
		// starting at coin number k.  Values are computed from the point of view
		// of the first player.

		for ( int j = 2; j <= num; j+= 1 ) {
			for ( int k = 0; k < num-j+1; k++ ) 
				value[k] = max(coins[k] - value[k+1], coins[k+j-1] - value[k]);
		}
		cout << value[0] << endl;
#ifdef DEBUG
        fout << value[0] << endl;
#endif
		fin >> num;
	}
    fin.close(); 
#ifdef DEBUG
    fout.close(); 
#endif
	return 0;
}

