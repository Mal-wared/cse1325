#ifndef __SHAPE_H
#define __SHAPE_H

#include <string>

class Shape{
  public:
    std::string name();
    double area();
    virtual std::string to_string();
};

#endif