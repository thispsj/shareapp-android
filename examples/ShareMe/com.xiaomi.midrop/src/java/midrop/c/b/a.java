/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.util.Log
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.c.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import midrop.c.b.a.b;
import midrop.c.c.e;
import midrop.c.c.f;

public final class a {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static midrop.c.a.e a(Context var0) {
        var1_1 = null;
        try {
            var3_2 = var0.getResources().getAssets().open("device/ddd_MidropDevice.xml");
            var1_1 = null;
            ** if (var3_2 == null) goto lbl-1000
        }
        catch (Exception var2_3) {
            var2_3.printStackTrace();
            var3_2 = null;
        }
lbl-1000: // 1 sources:
        {
            var1_1 = b.a(var3_2);
        }
lbl-1000: // 2 sources:
        {
        }
        if (var3_2 == null) return var1_1;
        try {
            var3_2.close();
            return var1_1;
        }
        catch (IOException var4_4) {
            Log.e((String)"DeviceFactory", (String)var4_4.toString());
        }
        return var1_1;
    }

    public static midrop.c.a.e a(Context context, midrop.c.e.a a2) {
        midrop.c.a.e e2 = a.a(context);
        if (e2 != null) {
            e2.a(a2.a());
            byte by = (Byte)a2.a.b(midrop.c.e.b.b);
            e2.b.b(midrop.c.a.f.b, by);
            e2.b((String)a2.a.b(midrop.c.e.b.c));
            e2.c(a2.l());
            boolean bl = (Boolean)a2.a.b(midrop.c.e.b.e);
            e2.b.b(midrop.c.a.f.i, bl);
            e2.a(a2.b());
            boolean bl2 = (Boolean)a2.a.b(midrop.c.e.b.e);
            e2.b.b(midrop.c.a.f.k, bl2);
            e2.c(a2.c());
            e2.a(a2.d());
            e2.b((Boolean)a2.a.b(midrop.c.e.b.o));
            e2.c((Boolean)a2.a.b(midrop.c.e.b.p));
            e2.d(a2.j());
            e2.g(a2.e());
            e2.f(a2.k());
            e2.h((Boolean)a2.a.b(midrop.c.e.b.u));
            e2.i((Boolean)a2.a.b(midrop.c.e.b.v));
        }
        return e2;
    }
}

