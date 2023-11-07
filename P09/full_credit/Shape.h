#ifndef __SHAPE_H
#define __SHAPE_H

#include <string>

class Shape{
  public:
    virtual std::string name() = 0;
    virtual double area() = 0;
    virtual std::string to_string() = 0;
};

#endif