#ifndef __RECTANGLE_H
#define __RECTANGLE_H

#include "Shape.h" 
#include <string>

class Rectangle : public Shape{
  public:
    Rectangle(double height, double width);
    std::string name();
    double area();
    std::string to_string() override;
  private:
    double _height, _width;
};

#endif