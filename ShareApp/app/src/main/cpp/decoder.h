//
// Created by HP on 02-04-2020.
//

#ifndef SHAREAPP_DECODER_H
#define SHAREAPP_DECODER_H

#include <unordered_map>
#include <vector>
#include <string>
#include "extstrfuns.h"

using namespace std;
class decoder {
public:
decoder(std::string *file);
std::string decode();
~decoder();
};


#endif //LOCAL_DECODER_H
