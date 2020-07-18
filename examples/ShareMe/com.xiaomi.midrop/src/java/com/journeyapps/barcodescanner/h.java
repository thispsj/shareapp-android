/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Message
 *  android.util.Log
 *  com.google.zxing.client.android.R
 *  com.google.zxing.client.android.R$id
 *  com.google.zxing.j
 *  com.google.zxing.n
 *  com.google.zxing.q
 *  com.journeyapps.barcodescanner.e
 *  com.journeyapps.barcodescanner.h$2
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package com.journeyapps.barcodescanner;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.google.zxing.client.android.R;
import com.google.zxing.j;
import com.google.zxing.n;
import com.google.zxing.q;
import com.journeyapps.barcodescanner.a.b;
import com.journeyapps.barcodescanner.a.k;
import com.journeyapps.barcodescanner.c;
import com.journeyapps.barcodescanner.e;
import com.journeyapps.barcodescanner.h;
import com.journeyapps.barcodescanner.o;
import com.journeyapps.barcodescanner.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class h {
    static final String a = "h";
    HandlerThread b;
    Handler c;
    e d;
    Rect e;
    boolean f = false;
    final Object g = new Object();
    final Handler.Callback h;
    private b i;
    private Handler j;
    private final k k;

    public h(b b2, e e2, Handler handler) {
        this.h = new Handler.Callback(){

            public final boolean handleMessage(Message message) {
                if (message.what == R.id.zxing_decode) {
                    h.a(h.this, (o)message.obj);
                } else if (message.what == R.id.zxing_preview_failed) {
                    h.this.a();
                }
                return true;
            }
        };
        this.k = new 2((h)this);
        p.a();
        this.i = b2;
        this.d = e2;
        this.j = handler;
    }

    static /* synthetic */ void a(h h2, o o2) {
        block21 : {
            Message message;
            block22 : {
                block20 : {
                    long l2;
                    n n2;
                    block14 : {
                        byte[] arrby;
                        block18 : {
                            byte[] arrby2;
                            block15 : {
                                byte[] arrby3;
                                block19 : {
                                    int n3;
                                    int n4;
                                    int n5;
                                    block16 : {
                                        block17 : {
                                            block13 : {
                                                l2 = System.currentTimeMillis();
                                                o2.f = h2.e;
                                                if (h2.e != null) break block13;
                                                n2 = null;
                                                break block14;
                                            }
                                            int n6 = o2.e;
                                            arrby2 = o2.a;
                                            n3 = o2.b;
                                            n4 = o2.c;
                                            if (n6 == 0) break block15;
                                            if (n6 == 90) break block16;
                                            if (n6 == 180) break block17;
                                            if (n6 != 270) break block15;
                                            int n7 = n3 * n4;
                                            byte[] arrby4 = new byte[n7];
                                            int n8 = n7 - 1;
                                            for (n5 = 0; n5 < n3; ++n5) {
                                                for (int i2 = n4 - 1; i2 >= 0; --i2) {
                                                    arrby4[n8] = arrby2[n5 + i2 * n3];
                                                    --n8;
                                                }
                                            }
                                            arrby = arrby4;
                                            break block18;
                                        }
                                        int n9 = n3 * n4;
                                        arrby3 = new byte[n9];
                                        int n10 = n9 - 1;
                                        while (n5 < n9) {
                                            arrby3[n10] = arrby2[n5];
                                            --n10;
                                            ++n5;
                                        }
                                        break block19;
                                    }
                                    arrby3 = new byte[n3 * n4];
                                    int n11 = 0;
                                    while (n5 < n3) {
                                        for (int i3 = n4 - 1; i3 >= 0; --i3) {
                                            arrby3[n11] = arrby2[n5 + i3 * n3];
                                            ++n11;
                                        }
                                        ++n5;
                                    }
                                }
                                arrby = arrby3;
                                break block18;
                            }
                            arrby = arrby2;
                        }
                        if (o2.a()) {
                            int n12 = o2.c;
                            int n13 = o2.b;
                            int n14 = o2.f.left;
                            int n15 = o2.f.top;
                            int n16 = o2.f.width();
                            int n17 = o2.f.height();
                            n2 = new n(arrby, n12, n13, n14, n15, n16, n17);
                        } else {
                            int n18 = o2.b;
                            int n19 = o2.c;
                            int n20 = o2.f.left;
                            int n21 = o2.f.top;
                            int n22 = o2.f.width();
                            int n23 = o2.f.height();
                            n2 = new n(arrby, n18, n19, n20, n21, n22, n23);
                        }
                    }
                    q q2 = null;
                    if (n2 != null) {
                        q2 = h2.d.a(n2);
                    }
                    if (q2 == null) break block20;
                    long l3 = System.currentTimeMillis();
                    String string2 = a;
                    StringBuilder stringBuilder = new StringBuilder("Found barcode in ");
                    stringBuilder.append(l3 - l2);
                    stringBuilder.append(" ms");
                    Log.d((String)string2, (String)stringBuilder.toString());
                    if (h2.j == null) break block21;
                    c c2 = new c(q2, o2);
                    message = Message.obtain((Handler)h2.j, (int)R.id.zxing_decode_succeeded, (Object)c2);
                    message.setData(new Bundle());
                    break block22;
                }
                if (h2.j == null) break block21;
                message = Message.obtain((Handler)h2.j, (int)R.id.zxing_decode_failed);
            }
            message.sendToTarget();
        }
        if (h2.j != null) {
            ArrayList arrayList = new ArrayList((Collection)h2.d.a);
            Message.obtain((Handler)h2.j, (int)R.id.zxing_possible_result_points, (Object)arrayList).sendToTarget();
        }
        h2.a();
    }

    static /* synthetic */ Object b(h h2) {
        return h2.g;
    }

    static /* synthetic */ boolean c(h h2) {
        return h2.f;
    }

    static /* synthetic */ Handler d(h h2) {
        return h2.c;
    }

    final void a() {
        b b2 = this.i;
        k k2 = this.k;
        b2.g.post(new Runnable(k2){
            final /* synthetic */ k a;
            {
                this.a = k2;
            }

            public final void run() {
                if (!b.this.e) {
                    Log.d((String)i, (String)"Camera is closed, not requesting preview");
                    return;
                }
                b.this.j.a(new Runnable(){

                    public final void run() {
                        com.journeyapps.barcodescanner.a.c c2 = b.this.b;
                        k k2 = 2.this.a;
                        android.hardware.Camera camera = c2.b;
                        if (camera != null && c2.f) {
                            c2.m.a = k2;
                            camera.setOneShotPreviewCallback((android.hardware.Camera$PreviewCallback)c2.m);
                        }
                    }
                });
            }

        });
    }

}

