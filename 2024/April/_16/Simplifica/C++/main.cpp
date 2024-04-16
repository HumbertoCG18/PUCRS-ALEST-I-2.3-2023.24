#include <iostream>
#include <cstdlib>
#include <cmath>
#include <string>
#include <fstream>

#ifdef WIN32
#include <windows.h>    // Apenas para Windows
#endif

#ifdef __APPLE__
#include <OpenGL/gl.h>
#include <OpenGL/glu.h>
#include <GLUT/glut.h>
#else
#include <GL/gl.h>     // Funções da OpenGL
#include <GL/glu.h>    // Funções da GLU
#include <GL/glut.h>   // Funções da FreeGLUT
#endif

#include "ListArrayPontos.h"

using namespace std;

int sel = 0; // modo: 0-ListArray, 1-Single, 2-Double
ListArrayPontos pontos;
int divisor; // valor para dividir o total de pontos
ListTADPontos* tad = NULL;
// Ponto pontos[2200];
float xmin,xmax,ymin,ymax; // limites do mapa
void load(char *filename);

const char* modos[] = { "Array", "Single", "Double" };

// Funções da interface gráfica e OpenGL
void init();
void draw();
void keyboard(unsigned char key, int x, int y);
void simplifica(char estrutura);

// Largura e altura da janela
int width, height;

void load(char *filename) {
    ifstream arq;
    arq.open(filename, ios::in);
    if(!arq.is_open())
    {
        cout << "Error opening file!" << endl;
        exit(1);
    }
    float x,y;
    xmin=ymin=1e5;
    xmax=ymax=-1e5; 
    while(arq >> x >> y) {
        Ponto p = { x, y };
        pontos.add(p);
        if(x > xmax) xmax = x;
        if(y > ymax) ymax = y;
        if(x < xmin) xmin = x;
        if(y < ymin) ymin = y;
    }
    cout << xmin << " " << ymin << " " << xmax << " " << ymax << endl;
    arq.close();

}

int main(int argc, char** argv)
{
    if(argc < 1) {
        printf("polygon [arq. entrada]\n");
        exit(1);
    }

    load(argv[1]); // carrega os pontos
	glutInit(&argc,argv);

	// Define do modo de operacao da GLUT
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);

    width = 500;
    height = 500;

	// Especifica o tamanho inicial em pixels da janela GLUT
	glutInitWindowSize(width, height);

	// Cria a janela passando como argumento o titulo da mesma
	glutCreateWindow("Simplificacao de Poligonos");

	// Registra a funcao callback de redesenho da janela de visualizacao
	glutDisplayFunc(draw);

	// Registra a funcao callback para tratamento das teclas ASCII
	glutKeyboardFunc (keyboard);

	// Define a janela de visualizacao 2D
	glMatrixMode(GL_PROJECTION);
	gluOrtho2D(xmin,xmax,ymin,ymax);
	glMatrixMode(GL_MODELVIEW);

	// Entra no loop de eventos, não retorna
    glutMainLoop();
}

// Gerencia eventos de teclado
void keyboard(unsigned char key, int x, int y)
{
    if(key==27) {
      // ESC: libera memória e finaliza
      if(tad)
        delete tad;
      exit(1);
    }
    if(key >= '1' && key <= '4') {
        divisor = key-'0'; // número de 1 a 4 (divisor)
    }
    else if(key=='s' || key=='a' || key == 'd') {
        simplifica(key);
    }
    glutPostRedisplay();
}

// Callback de redesenho da tela
void draw()
{
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);  // Preto
    glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);

    // Para outras cores, veja exemplos em /etc/X11/Pixel.txt

    glColor3ub(255, 255, 255);  // branco

	if(tad == NULL)
        simplifica('a'); // default: array

    glBegin(GL_LINE_LOOP);

	for(int i=0; i<tad->size(); i++) {
        Ponto p = tad->get(i);
        glVertex2f(p.x,p.y);
    }

    glEnd();

    // Exibe a imagem
    glutSwapBuffers();
}

void simplifica(char estrutura)
{
    cout << "Simplificando..." << endl;
    if(tad)
        delete tad;
    tad = new ListArrayPontos();
    // Por enquanto só faz uma cópia da lista original
    // (implemente aqui o algoritmo de simplificação)
    for(int i=0; i<pontos.size(); i++) {
        tad->add(pontos.get(i));
    }
    // Mostra o total de pontos resultante
    cout << "Total de pontos: " << tad->size() << endl;
}