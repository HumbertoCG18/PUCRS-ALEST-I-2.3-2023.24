#include <stdio.h>
#include <string.h>

int palindromo(char str[]);
int palindromoRec(char str[], int pos);

int palindromo(char str[])
{
    return palindromoRec(str, 0);
}

int palindromoRec(char str[], int pos)
{
    int len = strlen(str);
    if(pos == len/2)
        return 1;
    if(str[pos] != str[len-pos-1])
        return 0;
    return palindromoRec(str, pos+1);
}

int main()
{
    char s[] = "ABCCBA";
    printf("%s é palíndromo: %d\n",s,palindromo(s));
}
