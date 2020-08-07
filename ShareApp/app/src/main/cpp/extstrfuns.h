

#ifndef SHAREAPP_EXTSTRFUNS_H
#define SHAREAPP_EXTSTRFUNS_H

#include <string>
#include <math.h>

using namespace std;
class extstrfuns {
public:
extstrfuns(string* s);
int parseInt();
private:
int strtoint(string str);

};


#endif //LOCAL_EXTSTRFUNS_H
