/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.journeyapps.barcodescanner.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

class f {
    private static final String e = "f";
    private static f f;
    Handler a;
    HandlerThread b;
    int c = 0;
    final Object d = new Object();

    private f() {
    }

    public static f a() {
        if (f == null) {
            f = new f();
        }
        return f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final void a(Runnable runnable) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            Object object3;
            Object object4 = object3 = this.d;
            synchronized (object4) {
                if (this.a == null) {
                    if (this.c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    this.b = new HandlerThread("CameraThread");
                    this.b.start();
                    this.a = new Handler(this.b.getLooper());
                }
            }
            this.a.post(runnable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final void b(Runnable runnable) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            this.c = 1 + this.c;
            this.a(runnable);
            return;
        }
    }
}

