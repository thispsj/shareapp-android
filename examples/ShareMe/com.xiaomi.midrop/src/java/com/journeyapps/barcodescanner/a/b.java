/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.hardware.Camera
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.Camera$PreviewCallback
 *  android.hardware.Sensor
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Message
 *  android.util.Log
 *  android.view.SurfaceHolder
 *  com.google.zxing.client.android.R
 *  com.google.zxing.client.android.R$id
 *  com.google.zxing.client.android.a
 *  com.google.zxing.client.android.a.a.a
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.journeyapps.barcodescanner.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.a.a;
import com.journeyapps.barcodescanner.a.c;
import com.journeyapps.barcodescanner.a.d;
import com.journeyapps.barcodescanner.a.e;
import com.journeyapps.barcodescanner.a.f;
import com.journeyapps.barcodescanner.a.h;
import com.journeyapps.barcodescanner.a.k;
import com.journeyapps.barcodescanner.n;
import com.journeyapps.barcodescanner.p;

public class b {
    private static final String i = "b";
    public e a;
    public c b;
    public Handler c;
    public h d;
    public boolean e = false;
    public boolean f = true;
    public Handler g;
    public d h = new d();
    private f j;
    private Runnable k;
    private Runnable l;
    private Runnable m;
    private Runnable n;

    public b(Context context) {
        this.k = new Runnable(){

            public final void run() {
                try {
                    Log.d((String)i, (String)"Opening camera");
                    c c2 = b.this.b;
                    c2.b = com.google.zxing.client.android.a.a.a.b((int)c2.g.a);
                    if (c2.b == null) {
                        throw new RuntimeException("Failed to open camera");
                    }
                    int n2 = com.google.zxing.client.android.a.a.a.a((int)c2.g.a);
                    c2.c = new Camera.CameraInfo();
                    Camera.getCameraInfo((int)n2, (Camera.CameraInfo)c2.c);
                    return;
                }
                catch (Exception exception) {
                    b.a(b.this, exception);
                    Log.e((String)i, (String)"Failed to open camera", (Throwable)exception);
                    return;
                }
            }
        };
        this.l = new Runnable(){

            /*
             * Exception decompiling
             */
            public final void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl92 : ALOAD : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
                // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
                // org.benf.cfr.reader.b.a(Driver.java:128)
                // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
                // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
                // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
                // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
                // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
                // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
                // java.lang.Thread.run(Thread.java:818)
                throw new IllegalStateException("Decompilation failed");
            }
        };
        this.m = new Runnable(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final void run() {
                Camera camera;
                c c2;
                try {
                    Log.d((String)i, (String)"Starting preview");
                    c c3 = b.this.b;
                    e e2 = b.this.a;
                    Camera camera2 = c3.b;
                    if (e2.a != null) {
                        camera2.setPreviewDisplay(e2.a);
                    } else {
                        camera2.setPreviewTexture(e2.b);
                    }
                    c2 = b.this.b;
                    camera = c2.b;
                    if (camera == null) return;
                }
                catch (Exception exception) {
                    b.a(b.this, exception);
                    Log.e((String)i, (String)"Failed to start preview", (Throwable)exception);
                    return;
                }
                if (c2.f) return;
                camera.startPreview();
                c2.f = true;
                c2.d = new a(c2.b, c2.g);
                com.google.zxing.client.android.a a2 = c2.e = new com.google.zxing.client.android.a(c2.l, c2, c2.g);
                if (!a2.a.g) return;
                SensorManager sensorManager = (SensorManager)a2.c.getSystemService("sensor");
                a2.b = sensorManager.getDefaultSensor(5);
                if (a2.b == null) return;
                sensorManager.registerListener((SensorEventListener)a2, a2.b, 3);
            }
        };
        this.n = new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final void run() {
                Object object;
                try {
                    Log.d((String)i, (String)"Closing camera");
                    c c2 = b.this.b;
                    if (c2.d != null) {
                        c2.d.b();
                        c2.d = null;
                    }
                    if (c2.e != null) {
                        com.google.zxing.client.android.a a2 = c2.e;
                        if (a2.b != null) {
                            ((SensorManager)a2.c.getSystemService("sensor")).unregisterListener((SensorEventListener)a2);
                            a2.b = null;
                        }
                        c2.e = null;
                    }
                    if (c2.b != null && c2.f) {
                        c2.b.stopPreview();
                        c2.m.a = null;
                        c2.f = false;
                    }
                    c c3 = b.this.b;
                    if (c3.b != null) {
                        c3.b.release();
                        c3.b = null;
                    }
                }
                catch (Exception exception) {
                    Log.e((String)i, (String)"Failed to close camera", (Throwable)exception);
                }
                b.this.f = true;
                b.this.c.sendEmptyMessage(R.id.zxing_camera_closed);
                f f2 = b.this.j;
                Object object2 = object = f2.d;
                synchronized (object2) {
                    f2.c = -1 + f2.c;
                    if (f2.c == 0) {
                        Object object3;
                        Object object4 = object3 = f2.d;
                        synchronized (object4) {
                            f2.b.quit();
                            f2.b = null;
                            f2.a = null;
                        }
                    }
                    return;
                }
            }
        };
        p.a();
        this.j = f.a();
        this.b = new c(context);
        this.b.g = this.h;
        this.g = new Handler();
    }

    static /* synthetic */ void a(b b2, Exception exception) {
        if (b2.c != null) {
            b2.c.obtainMessage(R.id.zxing_camera_error, (Object)exception).sendToTarget();
        }
    }

    static /* synthetic */ n e(b b2) {
        c c2 = b2.b;
        if (c2.j == null) {
            return null;
        }
        if (c2.a()) {
            return c2.j.a();
        }
        return c2.j;
    }

    private void f() {
        if (!this.e) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    public final void a() {
        p.a();
        this.e = true;
        this.f = false;
        this.j.b(this.k);
    }

    public final void a(final boolean bl) {
        p.a();
        if (this.e) {
            this.j.a(new Runnable(){

                public final void run() {
                    b.this.b.b(bl);
                }
            });
        }
    }

    public final void b() {
        p.a();
        this.f();
        this.j.a(this.l);
    }

    public final void c() {
        p.a();
        this.f();
        this.j.a(this.m);
    }

    public final void d() {
        p.a();
        if (this.e) {
            this.j.a(this.n);
        } else {
            this.f = true;
        }
        this.e = false;
    }

}

