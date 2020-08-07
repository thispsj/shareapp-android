#include "decoder.h"

std::string* filed;

bool isNumber(string* s);
decoder::decoder(std::string *file) { filed=file;}
std::string decoder::decode()
{
  bool ERROR= false;
  unordered_map<int,std::string> table;
  string ch ="";
  for (int i=0;i<=255;i++)
  {

    ch[0]=(char)i;
    table[i]=ch;
    ch[0]='0';
  }

  extstrfuns* strfuns;
  vector <int> fv; string no="";
  for(int i=0; i <filed->length(); i++)
  {
    string str=filed[i];
    if(str==" ")
    {
     strfuns=new extstrfuns(&no);
     int new_no=strfuns->parseInt();
     fv.push_back(new_no);
     no="";
     if (i+1==filed->length())
       delete strfuns;
    }

    else
    {
      if(!isNumber(&str))
      {ERROR= true;
        break;}
      no=no+str;
    }
  }

  int old=fv[0],n;
  string s=table[old],dec;
  string c="";
  c+=s[0];
  dec+=s;

  int count=256;

  for(int i=0;i<fv.size()-1;i++)
  {
    n=fv[i+1];
    if(table.find(n)==table.end())
    {
      s=table[old];
      s=s+c;
    }
    else
      s=table[n];
    dec+=s;
    c="";
    c+=s[0];
    table[count]=table[old]+c;
    count++;
    old=n;
  }
  if(ERROR)
  return "Error : Unexpected character encountered while decoding.";

  else
    return dec;
}

decoder::~decoder()
{
  delete filed;
}

bool isNumber(string* s)
{


      return *s == "1" || *s == "2" || *s == "3" || *s == "4" || *s == "5" || *s == "6" ||
             *s == "7" || *s == "8" || *s == "9" || *s == "0";


}