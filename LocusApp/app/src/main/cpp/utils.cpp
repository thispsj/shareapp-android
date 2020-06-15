#include <jni.h>
#include <string>
extern "C"
JNIEXPORT jstring
JNICALL
Java_com_psjbk32_local_Mumbai_MainActivity_MystringFromJNI(JNIEnv *env,jobject)
{
    std::string hello="Hello From JNI!";
    return env->NewStringUTF(hello.c_str());
}
