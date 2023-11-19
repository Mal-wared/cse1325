#include <string>
#include <fstream>
#include <vector>
#include "Index.h"

int main(int argc, char* argv[]){
    Index userIndex;

    std::string line;
    
    for(int i = 1; i < argc; i++){
        std::ifstream file(argv[i]);
        int lineNum = 0;
        while(std::getline(file, line)){
            std::istringstream iss(line);
            std::string word;

            while(iss >> word){
                userIndex.add_word(word, argv[i], lineNum);
                lineNum++;
            }
        }
    }
    std::cout << userIndex;
}