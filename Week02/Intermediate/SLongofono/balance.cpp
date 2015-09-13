#include <stack>
#include <cstring>

bool match(char a, char b){
	if(40==a){
		return (b-a==1);
	}
	else if(91==a||123==a){
		return (b-a==2);
	}
	return 0;
}


int main(int argc, char** argv){

	if(strlen(argv[1])==0){
		std::cout<<std::endl<<"Usage: ./bal <string to be balanced>"<<std::endl<<std::endl;
		return -1;
	}
	std::stack<int> stax;
	stax.push(argv[1][0]);
	for(int i = 1; i<=strlen(argv[1])-1; i++){
		if(stax.empty()){
			stax.push(argv[1][i]);
		}
		else if(!match(stax.top(), argv[1][i])){
			stax.push(argv[1][i]);
		}
		else{
			stax.pop();
		}
	}
	if(stax.empty()){
		std::cout<<"True"<<std::endl;
	}
	else{
		std::cout<<"False"<<std::endl;
	}
	return 0;
}
