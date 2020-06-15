#include <jni.h>
#include "decoder.h"

extern "C"
JNIEXPORT jstring
JNICALL
Java_com_psjbk32_locus_mumbai_LTLActivity_df(JNIEnv *env,jobject ,jstring strObj)
{
    const char* stp=env->GetStringUTFChars(strObj,NULL);
    string ptd(stp);
    decoder dc(&ptd);
    string getdf=dc.decode();
    return env->NewStringUTF(getdf.c_str());
}



