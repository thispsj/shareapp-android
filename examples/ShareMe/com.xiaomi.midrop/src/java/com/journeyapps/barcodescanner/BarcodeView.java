/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.AttributeSet
 *  com.google.zxing.e
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.journeyapps.barcodescanner;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import com.journeyapps.barcodescanner.BarcodeView;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.a.b;
import com.journeyapps.barcodescanner.e;
import com.journeyapps.barcodescanner.f;
import com.journeyapps.barcodescanner.g;
import com.journeyapps.barcodescanner.h;
import com.journeyapps.barcodescanner.i;
import com.journeyapps.barcodescanner.p;
import java.util.HashMap;
import java.util.Map;

public class BarcodeView
extends CameraPreview {
    private int c = a.a;
    private com.journeyapps.barcodescanner.a d = null;
    private h e;
    private f f;
    private Handler g;
    private final Handler.Callback h;

    public BarcodeView(Context context) {
        super(context);
        this.h = new Handler.Callback((BarcodeView)this){
            final /* synthetic */ BarcodeView a;
            {
                this.a = barcodeView;
            }

            public final boolean handleMessage(android.os.Message message) {
                if (message.what == com.google.zxing.client.android.R$id.zxing_decode_succeeded) {
                    com.journeyapps.barcodescanner.c c2 = (com.journeyapps.barcodescanner.c)message.obj;
                    if (c2 != null && BarcodeView.a(this.a) != null && BarcodeView.b(this.a) != a.a) {
                        BarcodeView.a(this.a).a(c2);
                        if (BarcodeView.b(this.a) == a.b) {
                            this.a.a();
                        }
                    }
                    return true;
                }
                if (message.what == com.google.zxing.client.android.R$id.zxing_decode_failed) {
                    return true;
                }
                if (message.what == com.google.zxing.client.android.R$id.zxing_possible_result_points) {
                    java.util.List list = (java.util.List)message.obj;
                    if (BarcodeView.a(this.a) != null && BarcodeView.b(this.a) != a.a) {
                        BarcodeView.a(this.a).a((java.util.List<com.google.zxing.s>)list);
                    }
                    return true;
                }
                return false;
            }
        };
        BarcodeView.super.g();
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new /* invalid duplicate definition of identical inner class */;
        BarcodeView.super.g();
    }

    public BarcodeView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.h = new /* invalid duplicate definition of identical inner class */;
        BarcodeView.super.g();
    }

    static /* synthetic */ com.journeyapps.barcodescanner.a a(BarcodeView barcodeView) {
        return barcodeView.d;
    }

    static /* synthetic */ int b(BarcodeView barcodeView) {
        return barcodeView.c;
    }

    private void g() {
        this.f = new i();
        this.g = new Handler(this.h);
    }

    private e h() {
        e e2;
        if (this.f == null) {
            this.f = new i();
        }
        g g2 = new g();
        HashMap hashMap = new HashMap();
        hashMap.put((Object)com.google.zxing.e.j, (Object)g2);
        g2.a = e2 = this.f.a((Map<com.google.zxing.e, ?>)hashMap);
        return e2;
    }

    private void i() {
        this.j();
        if (this.c != a.a && this.b) {
            this.e = new h(this.getCameraInstance(), this.h(), this.g);
            this.e.e = this.getPreviewFramingRect();
            h h2 = this.e;
            p.a();
            h2.b = new HandlerThread(h.a);
            h2.b.start();
            h2.c = new Handler(h2.b.getLooper(), h2.h);
            h2.f = true;
            h2.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j() {
        if (this.e != null) {
            Object object;
            h h2 = this.e;
            p.a();
            Object object2 = object = h2.g;
            synchronized (object2) {
                h2.f = false;
                h2.c.removeCallbacksAndMessages(null);
                h2.b.quit();
            }
            this.e = null;
            return;
        }
    }

    public final void a() {
        this.c = a.a;
        this.d = null;
        this.j();
    }

    public final void a(com.journeyapps.barcodescanner.a a2) {
        this.c = a.b;
        this.d = a2;
        BarcodeView.super.i();
    }

    @Override
    protected final void b() {
        super.b();
        this.i();
    }

    @Override
    public final void c() {
        this.j();
        super.c();
    }

    public f getDecoderFactory() {
        return this.f;
    }

    public void setDecoderFactory(f f2) {
        p.a();
        this.f = f2;
        if (this.e != null) {
            this.e.d = BarcodeView.super.h();
        }
    }

}

