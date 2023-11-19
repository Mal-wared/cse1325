#include "Index.h"

Index::Index() 
: _index(std::map<Word, Locations>()) {}

void Index::add_word(Word word, std::string filename, int line){
    _index[word].insert(Location(filename, line));
    
}

std::ostream& operator<<(std::ostream& ost, const Index& index){
    for(const auto& [word, locations] : index._index){
        std::cout << word << " : ";
        for(const auto& location : locations){
            std::cout << location;
        }
        std::cout << std::endl;
    }
    return ost;
}