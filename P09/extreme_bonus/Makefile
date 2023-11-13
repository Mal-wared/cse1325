CXXFLAGS += --std=c++17 $(shell pkg-config --cflags gtkmm-3.0)
LDFLAGS += $(shell pkg-config --libs gtkmm-3.0)

shapes: Shapes.o Shape.o Circle.o Rectangle.o
	$(CXX) $(CXXFLAGS) $(LDFLAGS) Shapes.o Shape.o Circle.o Rectangle.o -o shapes

Circle.o: Circle.cpp *.h
	$(CXX) $(CXXFLAGS) -c Circle.cpp -o Circle.o

Rectangle.o: Rectangle.cpp *.h
	$(CXX) $(CXXFLAGS) -c Rectangle.cpp -o Rectangle.o

Shapes.o: Shapes.cpp *.h
	$(CXX) $(CXXFLAGS) -c Shapes.cpp -o Shapes.o
	
clean:
	rm -f *.o *.gch *~ a.out shapes
