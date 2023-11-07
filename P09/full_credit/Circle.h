#ifndef __CIRCLE_H
#define __CIRCLE_H

#include "Shape.h" 
#include <string>
#include <cmath>

class Circle : public Shape{
  public:
    Circle(double radius);
    virtual std::string name() override;
    virtual double area() override;
  private:
    double _radius;
};

#endif