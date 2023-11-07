#include "Rectangle.h"

Rectangle::Rectangle(double height, double width)
  : _height(height), _width(width) {}

std::string Rectangle::name(){
  return "Rectangle with height " + std::to_string(_height) + " and width " + std::to_string(_width);
}

double Rectangle::area(){
  return _height * _width;
}

std::string Rectangle::to_string(){
  return name() + " with area " + std::to_string(area());
}