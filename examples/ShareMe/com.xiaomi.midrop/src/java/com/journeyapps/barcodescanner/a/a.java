/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$AutoFocusCallback
 *  android.hardware.Camera$Parameters
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 */
package com.journeyapps.barcodescanner.a;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.journeyapps.barcodescanner.a.d;
import java.util.ArrayList;
import java.util.Collection;

public final class a {
    private static final String a = "a";
    private static final Collection<String> h;
    private boolean b;
    private boolean c;
    private final boolean d;
    private final Camera e;
    private Handler f;
    private int g;
    private final Handler.Callback i;
    private final Camera.AutoFocusCallback j;

    static {
        ArrayList arrayList;
        h = arrayList = new ArrayList(2);
        arrayList.add((Object)"auto");
        h.add((Object)"macro");
    }

    public a(Camera camera, d d2) {
        int n2;
        this.g = n2 = 1;
        this.i = new Handler.Callback(){

            public final boolean handleMessage(Message message) {
                if (message.what == a.this.g) {
                    a.this.d();
                    return true;
                }
                return false;
            }
        };
        this.j = new Camera.AutoFocusCallback(){

            public final void onAutoFocus(boolean bl, Camera camera) {
                a.this.f.post(new Runnable(){

                    public final void run() {
                        a.this.c = false;
                        a.this.c();
                    }
                });
            }

        };
        this.f = new Handler(this.i);
        this.e = camera;
        String string2 = camera.getParameters().getFocusMode();
        if (!d2.e || !h.contains((Object)string2)) {
            n2 = 0;
        }
        this.d = n2;
        String string3 = a;
        StringBuilder stringBuilder = new StringBuilder("Current focus mode '");
        stringBuilder.append(string2);
        stringBuilder.append("'; use auto focus? ");
        stringBuilder.append(this.d);
        Log.i((String)string3, (String)stringBuilder.toString());
        this.a();
    }

    private void c() {
        a a2 = this;
        synchronized (a2) {
            if (!this.b && !this.f.hasMessages(this.g)) {
                this.f.sendMessageDelayed(this.f.obtainMessage(this.g), 2000L);
            }
            return;
        }
    }

    private void d() {
        if (this.d && !this.b && !this.c) {
            try {
                this.e.autoFocus(this.j);
                this.c = true;
                return;
            }
            catch (RuntimeException runtimeException) {
                Log.w((String)a, (String)"Unexpected exception while focusing", (Throwable)runtimeException);
                this.c();
            }
        }
    }

    public final void a() {
        this.b = false;
        this.d();
    }

    public final void b() {
        this.b = true;
        this.c = false;
        this.f.removeMessages(this.g);
        if (this.d) {
            try {
                this.e.cancelAutoFocus();
                return;
            }
            catch (RuntimeException runtimeException) {
                Log.w((String)a, (String)"Unexpected exception while cancelling focusing", (Throwable)runtimeException);
            }
        }
    }

}

