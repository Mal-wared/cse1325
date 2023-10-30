#include <iostream>
#include <string>
#include <vector>
#include <cctype>
#include <algorithm>

bool compareByLength(const std::string& a, const std::string &b){
    return a.length() < b.length();
}

int main(int argc, char* argv[]){
    std::vector<std::string> caps;
    std::vector<std::string>* no_caps = new std::vector<std::string>;

    for(int i = 1; i < argc; i++){
        if(std::isupper(argv[i][0])){
            caps.push_back(std::string(argv[i]));
        }
        else{
            no_caps->push_back(std::string(argv[i]));
        }
    }

    std::sort(caps.begin(), caps.end());
    std::sort(no_caps->begin(), no_caps->end(), compareByLength);

    std::cout << "Capitalized:" << std::endl;
    for(std::string cap : caps){
        std::cout << cap << std::endl;
    }

    std::cout << "\nLower Case:" << std::endl;
    for(std::string no_cap : *no_caps){
        std::cout << no_cap << std::endl;
    }
}