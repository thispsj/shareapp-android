/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Camera
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$PreviewCallback
 *  android.hardware.Camera$Size
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  com.google.zxing.client.android.a
 *  com.google.zxing.client.android.a.a
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 */
package com.journeyapps.barcodescanner.a;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import com.journeyapps.barcodescanner.a.d;
import com.journeyapps.barcodescanner.a.h;
import com.journeyapps.barcodescanner.a.k;
import com.journeyapps.barcodescanner.a.l;
import com.journeyapps.barcodescanner.n;
import com.journeyapps.barcodescanner.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class c {
    static final String a = "c";
    Camera b;
    Camera.CameraInfo c;
    com.journeyapps.barcodescanner.a.a d;
    com.google.zxing.client.android.a e;
    boolean f;
    public d g = new d();
    public h h;
    n i;
    n j;
    int k = -1;
    Context l;
    final a m;
    private String n;

    public c(Context context) {
        this.l = context;
        this.m = (c)this.new a();
    }

    private static List<n> a(Camera.Parameters parameters) {
        List list = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            Camera.Size size = parameters.getPreviewSize();
            if (size != null) {
                arrayList.add((Object)new n(size.width, size.height));
            }
            return arrayList;
        }
        for (Camera.Size size : list) {
            arrayList.add((Object)new n(size.width, size.height));
        }
        return arrayList;
    }

    static /* synthetic */ String b() {
        return a;
    }

    final void a(boolean bl) {
        List<n> list;
        Camera.Parameters parameters = this.b.getParameters();
        if (this.n == null) {
            this.n = parameters.flatten();
        } else {
            parameters.unflatten(this.n);
        }
        if (parameters == null) {
            Log.w((String)a, (String)"Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String string2 = a;
        StringBuilder stringBuilder = new StringBuilder("Initial camera parameters: ");
        stringBuilder.append(parameters.flatten());
        Log.i((String)string2, (String)stringBuilder.toString());
        if (bl) {
            Log.w((String)a, (String)"In camera config safe mode -- most settings will not be honored");
        }
        com.google.zxing.client.android.a.a.a((Camera.Parameters)parameters, (int)this.g.h, (boolean)bl);
        if (!bl) {
            com.google.zxing.client.android.a.a.a((Camera.Parameters)parameters, (boolean)false);
            if (this.g.b) {
                com.google.zxing.client.android.a.a.f((Camera.Parameters)parameters);
            }
            if (this.g.c) {
                com.google.zxing.client.android.a.a.e((Camera.Parameters)parameters);
            }
            if (this.g.d && Build.VERSION.SDK_INT >= 15) {
                com.google.zxing.client.android.a.a.d((Camera.Parameters)parameters);
                com.google.zxing.client.android.a.a.b((Camera.Parameters)parameters);
                com.google.zxing.client.android.a.a.c((Camera.Parameters)parameters);
            }
        }
        if ((list = c.a(parameters)).size() == 0) {
            this.i = null;
        } else {
            h h2 = this.h;
            boolean bl2 = this.a();
            n n2 = h2.a == null ? null : (bl2 ? h2.a.a() : h2.a);
            l l2 = h2.c;
            if (n2 != null) {
                Collections.sort(list, (Comparator)new Comparator<n>(l2, n2){
                    final /* synthetic */ n a;
                    final /* synthetic */ l b;
                    {
                        this.b = l2;
                        this.a = n2;
                    }

                    public final /* synthetic */ int compare(Object object, Object object2) {
                        n n2 = (n)object;
                        n n3 = (n)object2;
                        float f2 = this.b.a(n2, this.a);
                        return java.lang.Float.compare((float)this.b.a(n3, this.a), (float)f2);
                    }
                });
            }
            String string3 = l.a;
            StringBuilder stringBuilder2 = new StringBuilder("Viewfinder size: ");
            stringBuilder2.append((Object)n2);
            Log.i((String)string3, (String)stringBuilder2.toString());
            String string4 = l.a;
            StringBuilder stringBuilder3 = new StringBuilder("Preview in order of preference: ");
            stringBuilder3.append(list);
            Log.i((String)string4, (String)stringBuilder3.toString());
            this.i = (n)list.get(0);
            parameters.setPreviewSize(this.i.a, this.i.b);
        }
        if (Build.DEVICE.equals((Object)"glass-1")) {
            com.google.zxing.client.android.a.a.a((Camera.Parameters)parameters);
        }
        String string5 = a;
        StringBuilder stringBuilder4 = new StringBuilder("Final camera parameters: ");
        stringBuilder4.append(parameters.flatten());
        Log.i((String)string5, (String)stringBuilder4.toString());
        this.b.setParameters(parameters);
    }

    public final boolean a() {
        if (this.k == -1) {
            throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
        }
        return this.k % 180 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(boolean bl) {
        boolean bl2;
        block7 : {
            block8 : {
                if (this.b != null) {
                    try {
                        Camera.Parameters parameters = this.b.getParameters();
                        bl2 = false;
                        if (parameters == null) break block7;
                        String string2 = parameters.getFlashMode();
                        bl2 = false;
                        if (string2 == null) break block7;
                        if ("on".equals((Object)string2)) break block8;
                        boolean bl3 = "torch".equals((Object)string2);
                        bl2 = false;
                        if (!bl3) break block7;
                        break block8;
                    }
                    catch (RuntimeException runtimeException) {
                        Log.e((String)a, (String)"Failed to set torch", (Throwable)runtimeException);
                    }
                }
                return;
            }
            bl2 = true;
        }
        if (bl != bl2) {
            if (this.d != null) {
                this.d.b();
            }
            Camera.Parameters parameters = this.b.getParameters();
            com.google.zxing.client.android.a.a.a((Camera.Parameters)parameters, (boolean)bl);
            if (this.g.f) {
                com.google.zxing.client.android.a.a.b((Camera.Parameters)parameters, (boolean)bl);
            }
            this.b.setParameters(parameters);
            if (this.d != null) {
                this.d.a();
            }
        }
    }

    private final class a
    implements Camera.PreviewCallback {
        k a;
        n b;

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public final void onPreviewFrame(byte[] var1, Camera var2_2) {
            block2 : {
                var3_3 = this.b;
                var4_4 = this.a;
                if (var3_3 == null || var4_4 == null) break block2;
                if (var1 != null) ** GOTO lbl7
                try {
                    throw new NullPointerException("No preview data received");
lbl7: // 1 sources:
                    var7_5 = var2_2.getParameters().getPreviewFormat();
                    var8_6 = new o(var1, var3_3.a, var3_3.b, var7_5, c.this.k);
                    var4_4.a(var8_6);
                    return;
                }
                catch (RuntimeException var9_7) {}
            }
            Log.d((String)c.b(), (String)"Got preview callback, but no handler or resolution available");
            if (var4_4 == null) return;
            new Exception("No resolution available");
            var4_4.a();
            return;
            Log.e((String)c.b(), (String)"Camera preview failed", (Throwable)var9_7);
            var4_4.a();
        }
    }

}

