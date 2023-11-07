#include <iostream>
#include <vector>

#include "Rectangle.h"
#include "Circle.h"

int main(){
  std::vector<Shape*> shapes;
  
  Rectangle rectangle(3.0, 4.0); 
  shapes.push_back(&rectangle); 
  
  Circle circle(2.0);
  shapes.push_back(&circle);
  
  Circle superior_circle(4.0);
  shapes.push_back(&superior_circle);
  
  for(const auto& shape : shapes){
    std::cout << shape->to_string() << std::endl;
  }
}
