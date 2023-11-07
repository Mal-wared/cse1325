#ifndef __CIRCLE_H
#define __CIRCLE_H

#include "Shape.h" 
#include <string>
#include <cmath>

class Circle : public Shape{
  public:
    Circle(double radius);
    std::string name();
    double area();
    std::string to_string() override;
  private:
    double _radius;
};

#endif