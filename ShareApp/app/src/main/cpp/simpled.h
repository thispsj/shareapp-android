//
// Created by HP on 08-05-2020.
//

#ifndef SHAREAPP_SIMPLED_H
#define SHAREAPP_SIMPLED_H

#include <string>

using namespace std;

class simpled {
public:
    simpled();

private:
   bool checkValidity(string *tokenChk);
   string dcr(string msg);
   string ecr(string msg);
};


#endif //LOCUS_SIMPLED_H
