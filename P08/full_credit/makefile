#Nicholas Nhat Tran 1002027150 

SRC1 = hello.cpp
OBJ1 = $(SRC1:.cpp=.o)
EXE = a.out

CXX = g++ 
CFLAGS = -g

all : $(EXE)
 
$(EXE): $(OBJ1)
	$(CXX) $(CXXFLAGS) $(OBJ1) -o $(EXE)
$(OBJ1) : $(SRC1)
	$(CXX) -c $(CXXFLAGS) $(SRC1) 

clean :
	rm -f $(OBJ1) $(EXE)

