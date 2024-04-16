all: app

app: app.o ListSingleLinked.o Node.o
	g++ app.o ListSingleLinked.o Node.o -o $@

app.o: app.cpp
	g++ -c app.cpp

ListSingleLinked.o: ListSingleLinked.cpp
	g++ -c ListSingleLinked.cpp

Node.o: Node.cpp
	g++ -c Node.cpp

clean:
	@rm -f app ListSingleLinked.o Node.o app.o
