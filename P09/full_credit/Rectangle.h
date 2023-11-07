#ifndef __RECTANGLE_H
#define __RECTANGLE_H

#include "Shape.h" 
#include <string>

class Rectangle : public Shape{
  public:
    Rectangle(double height, double width);
    virtual std::string name() override;
    virtual double area() override;
	virtual std::string to_string() override;
  private:
    double _height, _width;
};

#endif