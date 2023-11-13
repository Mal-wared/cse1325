#include <iostream>
#include <vector>
#include <gtkmm.h>

#include "Rectangle.h"
#include "Circle.h"

class MyDrawing : public Gtk::DrawingArea {
protected:
    bool on_draw(const Cairo::RefPtr<Cairo::Context>& cr) override {
        // Call base on_draw method
        Gtk::DrawingArea::on_draw(cr);

        // Set the color for the rectangle
        cr->set_source_rgb(0.5, 0.0, 0.5); // Set color (RGB)

        // Draw a rectangle at position (x=50, y=50) with a width and height of 100
        cr->rectangle(50, 50, 100, 100);
        cr->fill(); // Fill the rectangle

        return true;
    }
};


int main(int argc, char* argv[]){
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
  
  auto app = Gtk::Application::create(argc, argv, "org.gtkmm.example");

    Gtk::Window window;
    window.set_default_size(300, 200);

    MyDrawing drawing;
    window.add(drawing);
    drawing.show();

    return app->run(window);
}


