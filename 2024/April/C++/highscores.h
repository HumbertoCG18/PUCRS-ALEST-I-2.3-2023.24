#ifndef HIGHSCORES_H
#define HIGHSCORES_H

#include "listarray.h"

class HighScores
{
public:
    void insereScore(int score);
    void listaScores();

private:
    ListArray scores;
};

#endif