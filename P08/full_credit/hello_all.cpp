#include <iostream>
#include <string>

int main(){
	std::cout << "What's your name? ";
	std::string name;
	std::getline(std::cin, name);
	std::cout << "Hello, " << name << "!" << std::endl;
}
