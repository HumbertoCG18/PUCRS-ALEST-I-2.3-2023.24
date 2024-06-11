all: app

app: main.o
	g++ main.o -o $@

main.o: main.cpp BinarySearchTree.h
	g++ -c main.cpp

clean:
	@rm -f app main.o
