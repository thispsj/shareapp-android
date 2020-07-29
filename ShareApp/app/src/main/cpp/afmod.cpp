#include "decoder.h"
#include <jni.h>
#include <string>

extern "C"

JNIEXPORT jstring
JNICALL

Java_com_psj_shareapp_Splash_encodeToken(JNIEnv *jniEnv,jobject,jstring strObj)
{
    const char* stream=jniEnv->GetStringUTFChars(strObj,nullptr);
    string token(stream);
    return jniEnv->NewStringUTF(token.c_str());
}


