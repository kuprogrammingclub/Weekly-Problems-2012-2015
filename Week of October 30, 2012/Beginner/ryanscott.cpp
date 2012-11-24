#include <iostream>
using namespace std;

long int fib(unsigned int index);

int main()
{
  long int sum = 0;
  long int storage;
  for(unsigned int i = 1; true; i++) {
    if(i%3 != 2) //Indexes that don't meet this criterion aren't even, so skip calculating them
      continue;
    if((storage = fib(i)) > 4000000) //Put storage in fib(i) to avoid repeating expensive calculations
      break;
    sum += storage;
  }
  cout << sum << endl;
}

long int fib(unsigned int index) {
  if(index < 1)
    cout << "You done goofed." << endl;
  else if(index == 1)
    return 1;
  else if(index == 2)
    return 2;
  else
    return fib(index-2) + fib(index-1);
}