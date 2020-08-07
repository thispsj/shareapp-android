

#include "extstrfuns.h"

string* strr;

extstrfuns::extstrfuns(string* s) {
strr=s;
}
int extstrfuns::parseInt() {
    int s2int=0;
    int po=(int)strr->length(),i=0;
    while(po!=0)
    {
        int d=strtoint(strr[i]);
        s2int= static_cast<int>( s2int + pow(d, po));
        po--;
        i++;
    }

    return s2int;
}
int extstrfuns::strtoint(string str)
{   if(str=="1")
        return 1;
    if(str=="0")
        return 0;
    if(str=="2")
        return 2;
    if(str=="3")
        return 3;
    if(str=="4")
        return 4;
    if(str=="5")
        return 5;
    if(str=="6")
        return 6;
    if(str=="7")
        return 7;
    if(str=="8")
        return 8;
    if(str=="9")
        return 9;
    return -1;}



