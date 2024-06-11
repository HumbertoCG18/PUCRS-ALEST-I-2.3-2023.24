all: app

app: main.o
	g++ main.o -o $@

main.o: main.cpp BinaryTree.h
	g++ -c main.cpp

clean:
	@rm -f app main.o
