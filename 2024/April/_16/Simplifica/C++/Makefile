# Makefile para Linux e macOS

PROG = polygon
FONTES = main.cpp ListArrayPontos.cpp ListSingleLinkedPontos.cpp ListDoubleLinkedPontos.cpp Node.cpp NodeSingle.cpp
OBJETOS = $(FONTES:.cpp=.o)
CPPFLAGS = -Iinclude -g -O3 -DGL_SILENCE_DEPRECATION # -Wall -g  # Todas as warnings, infos de debug

UNAME = `uname`

all: $(TARGET)
	-@make $(UNAME)

Darwin: $(OBJETOS)
	g++ $(OBJETOS) -O3 -Wno-deprecated -framework OpenGL -framework Cocoa -framework GLUT -lm -o $(PROG)

Linux: $(OBJETOS)
	g++ $(OBJETOS) -O3 -lGL -lGLU -lglut -lm -o $(PROG)

clean:
	-@ rm -f $(OBJETOS) $(PROG)
