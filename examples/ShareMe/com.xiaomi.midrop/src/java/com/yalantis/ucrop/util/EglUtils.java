/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.opengl.EGL14
 *  android.opengl.EGLConfig
 *  android.opengl.EGLContext
 *  android.opengl.EGLDisplay
 *  android.opengl.EGLSurface
 *  android.opengl.GLES10
 *  android.opengl.GLES20
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 *  javax.microedition.khronos.egl.EGLSurface
 */
package com.yalantis.ucrop.util;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.GLES10;
import android.opengl.GLES20;
import android.os.Build;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class EglUtils {
    private static final String TAG = "EglUtils";

    private EglUtils() {
    }

    @TargetApi(value=14)
    private static int getMaxTextureEgl10() {
        EGL10 eGL10 = (EGL10)javax.microedition.khronos.egl.EGLContext.getEGL();
        EGLDisplay eGLDisplay = eGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        eGL10.eglInitialize(eGLDisplay, new int[2]);
        int[] arrn = new int[]{12351, 12430, 12329, 0, 12339, 1, 12344};
        javax.microedition.khronos.egl.EGLConfig[] arreGLConfig = new javax.microedition.khronos.egl.EGLConfig[1];
        int[] arrn2 = new int[1];
        eGL10.eglChooseConfig(eGLDisplay, arrn, arreGLConfig, 1, arrn2);
        if (arrn2[0] == 0) {
            return 0;
        }
        javax.microedition.khronos.egl.EGLConfig eGLConfig = arreGLConfig[0];
        EGLSurface eGLSurface = eGL10.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344});
        int[] arrn3 = new int[]{12440, 1, 12344};
        javax.microedition.khronos.egl.EGLContext eGLContext = eGL10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, arrn3);
        eGL10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
        int[] arrn4 = new int[1];
        GLES10.glGetIntegerv((int)3379, (int[])arrn4, (int)0);
        eGL10.eglMakeCurrent(eGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        eGL10.eglDestroySurface(eGLDisplay, eGLSurface);
        eGL10.eglDestroyContext(eGLDisplay, eGLContext);
        eGL10.eglTerminate(eGLDisplay);
        return arrn4[0];
    }

    @TargetApi(value=17)
    private static int getMaxTextureEgl14() {
        android.opengl.EGLDisplay eGLDisplay = EGL14.eglGetDisplay((int)0);
        int[] arrn = new int[2];
        EGL14.eglInitialize((android.opengl.EGLDisplay)eGLDisplay, (int[])arrn, (int)0, (int[])arrn, (int)1);
        int[] arrn2 = new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344};
        EGLConfig[] arreGLConfig = new EGLConfig[1];
        int[] arrn3 = new int[1];
        EGL14.eglChooseConfig((android.opengl.EGLDisplay)eGLDisplay, (int[])arrn2, (int)0, (EGLConfig[])arreGLConfig, (int)0, (int)1, (int[])arrn3, (int)0);
        if (arrn3[0] == 0) {
            return 0;
        }
        EGLConfig eGLConfig = arreGLConfig[0];
        android.opengl.EGLSurface eGLSurface = EGL14.eglCreatePbufferSurface((android.opengl.EGLDisplay)eGLDisplay, (EGLConfig)eGLConfig, (int[])new int[]{12375, 64, 12374, 64, 12344}, (int)0);
        int[] arrn4 = new int[]{12440, 2, 12344};
        EGLContext eGLContext = EGL14.eglCreateContext((android.opengl.EGLDisplay)eGLDisplay, (EGLConfig)eGLConfig, (EGLContext)EGL14.EGL_NO_CONTEXT, (int[])arrn4, (int)0);
        EGL14.eglMakeCurrent((android.opengl.EGLDisplay)eGLDisplay, (android.opengl.EGLSurface)eGLSurface, (android.opengl.EGLSurface)eGLSurface, (EGLContext)eGLContext);
        int[] arrn5 = new int[1];
        GLES20.glGetIntegerv((int)3379, (int[])arrn5, (int)0);
        EGL14.eglMakeCurrent((android.opengl.EGLDisplay)eGLDisplay, (android.opengl.EGLSurface)EGL14.EGL_NO_SURFACE, (android.opengl.EGLSurface)EGL14.EGL_NO_SURFACE, (EGLContext)EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface((android.opengl.EGLDisplay)eGLDisplay, (android.opengl.EGLSurface)eGLSurface);
        EGL14.eglDestroyContext((android.opengl.EGLDisplay)eGLDisplay, (EGLContext)eGLContext);
        EGL14.eglTerminate((android.opengl.EGLDisplay)eGLDisplay);
        return arrn5[0];
    }

    public static int getMaxTextureSize() {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                return EglUtils.getMaxTextureEgl14();
            }
            int n2 = EglUtils.getMaxTextureEgl10();
            return n2;
        }
        catch (Exception exception) {
            Log.d((String)TAG, (String)"getMaxTextureSize: ", (Throwable)exception);
            return 0;
        }
    }
}

