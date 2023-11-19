#ifndef P11_FULL_CREDIT_INDEX_H_
#define P11_FULL_CREDIT_INDEX_H_

#include <iostream>
#include <map>
#include "Locations.h"
#include "Word.h"

class Index{
    public:
        Index();
        void add_word(Word word, std::string filename, int line);
        friend std::ostream& operator<<(std::ostream& ost, const Index& index);
    private:
        std::map<Word, Locations> _index;
};

#endif