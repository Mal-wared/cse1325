#include <string>
#include <fstream>
#include <vector>
#include <cctype>
#include "Index.h"

int main(int argc, char* argv[]){
    Index userIndex;
    for(int i = 1; i < argc; i++){
        std::ifstream file(argv[i]);
        int lineNum = 1;

        std::string line;
        while(std::getline(file, line)){
            std::istringstream iss(line);
            std::string word;

            while(iss >> word){
                if(!std::isalpha(word.back())){
                    word.pop_back();
                }

                for(char& c : word){
                    c = std::tolower(c);
                }

                userIndex.add_word(word, argv[i], lineNum);
            }
            lineNum++;
        }
    }
    std::cout << userIndex;
}