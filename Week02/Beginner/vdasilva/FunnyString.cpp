
/// VICTOR BERGER, SUBMISSION FOR KU ACM PROGRAMMING CLUB -- FUNNY STRING

#include <iostream>
#include <string>
#include <cmath>

int main()
{
	
	while(1)
	{
	    	std::cout<<"Enter word"<<std::endl;
	    	std::string word;
	    	std::cin>> word;	
	
	    	char letters[word.length()];
		char opposite[word.length()];
	
		for (int i=0; i<(word.length()); i++)
		{
	    		letters[i] = word[i];
			opposite[i] = word[(word.length()-i-1)];

		}

		bool funny = 1;

		for (int i=0; i<(word.length()-1); i++)
		{
			if (abs(letters[i+1]-letters[i])!=abs(opposite[i+1]-opposite[i]))
				funny = 0;
		}

		if (funny)
			std::cout<<"Funny"<<std::endl; 
		else
			std::cout<<"Not Funny"<<std::endl; 

		std::cout<<" "<<std::endl;

	}

   	return(0);
}
