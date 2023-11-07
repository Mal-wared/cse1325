#include "Circle.h"

Circle::Circle(double radius)
  : _radius(radius) {}

std::string Circle::name(){
  return "Circle with radius " + std::to_string(_radius);
}

double Circle::area(){
  return M_PI * std::pow(_radius, 2);
}

std::string Circle::to_string(){
  return name() + " with area " + std::to_string(area());
}