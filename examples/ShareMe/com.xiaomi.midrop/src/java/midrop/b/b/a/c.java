/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  b.e.b.a.a
 *  java.lang.Class
 *  java.lang.Object
 */
package midrop.b.b.a;

import android.content.Context;
import b.e.b.a.a;

public final class c {
    private static c c;
    b.e.b.a a;
    boolean b;

    private c(Context context) {
        this.a = a.a((Context)context.getApplicationContext());
    }

    public static c a(Context context) {
        Class<c> class_ = c.class;
        synchronized (c.class) {
            if (c == null) {
                c = new c(context);
            }
            c c2 = c;
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return c2;
        }
    }
}

