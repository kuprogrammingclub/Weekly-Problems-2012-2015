#include <iostream>
#include <string>
int main(){
    std::string x;
    std::cout<<"What is your name? " << std::endl;
    std::cin >> x;
    std::cout << "[friendly] Hello, " << x << "!";
}
