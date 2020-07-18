/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  midrop.c.a.b.c
 */
package midrop.c.a.a;

import android.util.Log;
import midrop.c.a.a.d;
import midrop.c.a.b.c;
import midrop.c.a.e;
import midrop.c.a.i;

public class f {
    private static final String a = "f";

    public static d a(i i2) {
        e e2 = i2.a;
        if (i2 == null) {
            Log.d((String)a, (String)"device is null");
            return null;
        }
        d d2 = new d();
        String string2 = e2.a();
        d2.a(midrop.c.a.a.e.a, string2);
        String string3 = i2.a();
        d2.a(midrop.c.a.a.e.c, string3);
        String string4 = i2.b.toString();
        d2.a(midrop.c.a.a.e.b, string4);
        return d2;
    }
}

