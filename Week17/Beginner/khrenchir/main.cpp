#include <iostream>

int main(int argc, char** argv)
{
	int* origArray = new int[argc-1];

	for(int i = 0; i < argc-1; i++){
		origArray[i] = std::stoi (argv[i+1]);
	}
	int* rankArray = new int[argc-1];

	int largest = 0;

	//outer loop looks for the largest values, then the second largest, etc
	for(int j = 1; j < argc; j++) {
		//finds the next largest value after rank 1, etc, values have been determined
		for(int i =0; i < argc-1; i++){
			if(origArray[i] != -1) {
				largest = origArray[0];
			}
		}		

		for(int i = 0; i< argc -1; i++) {
			if(origArray[i] > largest) {
				largest = origArray[i];
			}
		}
		
		//replaces null in the rankArray with the rank for the number(s) in the current j tier
		for(int i = 0; i < argc -1; i++) {
			if(rankArray[i] == 0 && origArray[i]>= largest) {
				rankArray[i] = j;
				origArray[i] = -1;
			}
		}
	}

	for(int i = 0; i < argc-1; i++){
		std::cout<<rankArray[i] << " ";
	}
	std::cout<<"\n";

	return(0);
}
