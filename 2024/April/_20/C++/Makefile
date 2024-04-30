all: app

app: app.o ListDoubleLinked.o Node.o
	g++ app.o ListDoubleLinked.o Node.o -o $@

app.o: app.cpp
	g++ -c app.cpp

ListDoubleLinked.o: ListDoubleLinked.cpp
	g++ -c ListDoubleLinked.cpp

Node.o: Node.cpp
	g++ -c Node.cpp

clean:
	@rm -f app ListDoubleLinked.o Node.o app.o
