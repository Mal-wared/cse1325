#include "Shapes.h"
#include <iostream>
#include "Rectangle.h"
#include "Circle.h"

int main(){
  Rectangle rectangle(3.0, 4.0);
  Circle circle(2.0);
  std::cout << rectangle.to_string() << std::endl;
  std::cout << circle.to_string() << std::endl;
}
