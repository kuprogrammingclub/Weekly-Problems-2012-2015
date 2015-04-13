#include <iostream>
#include <random>
#include <string>
#include <ctime>
using namespace std;

static const char alphanum[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
int stringLength = sizeof(alphanum) - 1;

//  Function prototypes
string random_string(int size);
char genRandom();


int main() {
  string answer = "METHINKS IT IS LIKE A WEASEL";
  int string_length = answer.size();
  string rando = random_string(string_length);
  int no_of_copies = 100;
  string copies[no_of_copies];
  clock_t start, end;
  double duration;

  //  Random generator
  default_random_engine generator;
  uniform_int_distribution<int> distribution(1, 20);
  srand(time(0));

  //  Score stats
  int high_score, high_score_index, count;
  high_score = high_score_index = count = 0;

  //  Initialize empty score array
  int scores[no_of_copies];

  start = clock();
  while(high_score != string_length) {

    //  Populate 100 copies to array
    for(int i = 0; i < no_of_copies; i++) {
      copies[i] = rando;
    }

    //  Reset scores
    for(int i = 0; i < no_of_copies; i++) {
      scores[i] = 0;
    }

    //  Replace characters
    for(int a = 0; a < no_of_copies; a++) {
      for(int b = 0; b < string_length; b++) {
        if(distribution(generator) == 1) {
            char c = genRandom();
            copies[a][b] = c;
        }
      }
    }

    //  Score each strin
    high_score = high_score_index = 0;
    for(int a = 0; a < no_of_copies; a++) {
      for(int b = 0; b < string_length; b++) {
        if(copies[a][b] == answer[b]) {
          scores[a]++;
        }
      }
      //  Find new high score
      if(scores[a] > high_score) {
        high_score = scores[a];
        high_score_index = a;
        if(high_score == string_length) {
          break;
        }
      }
    }
    //  Print results
    cout << "High score: " << high_score << endl
    << "String: " << copies[high_score_index] << endl;

    //  Reassign random string
    rando = copies[high_score_index];
    count++;
  }// End while

  //  Get time
  end = clock() - start;
  duration = end / (double) CLOCKS_PER_SEC;

  //  Output stats
  cout << "Count: " << count << endl
  << "Duration: " << duration << " s" << endl;
  return 0;
}// End main

/*
return    : char
returns a random char out of array
*/
char genRandom() {
    return alphanum[rand() % stringLength];
}

/*
size      : int
return    : string
returns a random string of size
*/
string random_string(int size) {
  string str;
  for(int i = 0; i < size; i++) {
    str += genRandom();
  }
  return str;
}
