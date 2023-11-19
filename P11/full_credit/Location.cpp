#include "Location.h"

Location::Location() 
: _filename(""), _line(0) {};

Location::Location(std::string filename, int line) 
: _filename(filename), _line(line) {};

bool Location::operator==(const Location& location) const{
    return (_filename == location._filename && _line == location._line);
}

bool Location::operator!=(const Location& location) const{
    return !(_filename == location._filename && _line == location._line);
}

bool Location::operator<(const Location& location) const{
    return _line < location._line;
}

bool Location::operator>(const Location& location) const{
    return _line > location._line;
}

bool Location::operator<=(const Location& location) const{
    return (*this < location) || (*this == location);
}

bool Location::operator>=(const Location& location) const{
    return (*this > location) || (*this == location);
}

std::ostream& operator<<(std::ostream& ost, const Location& location){
    Location unaccessibleLocation = location;  // Create a copy to avoid modifying the original object

    ost << unaccessibleLocation._filename << " line " << unaccessibleLocation._line << " ";
    return ost;
}