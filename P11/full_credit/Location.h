#ifndef P11_FULL_CREDIT_LOCATION_H_
#define P11_FULL_CREDIT_LOCATION_H_

#include <iostream>
#include <iomanip>
#include <stdlib.h>

class Location{
    public:
        Location();
        Location(std::string filename, int line);
        bool operator==(const Location& location) const; 
        bool operator!=(const Location& location) const; 
        bool operator<(const Location& location) const; 
        bool operator>(const Location& location) const; 
        bool operator<=(const Location& location) const; 
        bool operator>=(const Location& location) const; 
        friend std::ostream& operator<<(std::ostream& ost, const Location& location);
    private:
        std::string _filename;
        int _line;
};

#endif