#include <iostream>
#include <string>
#include <vector>


int main(int argc, char* argv[]){
    std::vector<std::string> caps;
    std::vector<std::string>* no_caps = new std::vector<std::string>;

    for(int i = 0; i < argc; ++i){
        caps.push_back(std::string(argv[i]));
        no_caps->push_back(std::string(argv[i]));
    }

    std::cout << "Capitalized:" << std::endl;
    for(std::string cap : caps){
        std::cout << cap << std::endl;
    }

    std::cout << "Lower Case:" << std::endl;
    for(std::string no_cap : *no_caps){
        std::cout << no_cap << std::endl;
    }
}