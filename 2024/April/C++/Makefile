all: app

app: app.o listarray.o
	g++ app.o listarray.o -o $@

appscores: appscores.o highscores.o listarray.o
	g++ appscores.o highscores.o listarray.o -o $@

app.o: app.cpp
	g++ -c app.cpp

appscores.o: appscores.cpp
	g++ -c appscores.cpp

listarray.o: listarray.cpp
	g++ -c listarray.cpp

highscores.o: highscores.cpp
	g++ -c highscores.cpp

clean:
	@rm -f app appscores app.o appscores.o listarray.o highscores.o
