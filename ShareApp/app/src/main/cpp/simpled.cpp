#include "simpled.h"

string arr[50];

bool simpled::checkValidity(string *tokenChk)
{
    arr[0]="home=splash";
    if(arr[0]==*tokenChk)
        return true;

    return false;
}

