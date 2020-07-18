/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.xiaomi.midrop.d.a.b$a
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.d.a;

import android.content.Context;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.d.a.b;

/*
 * Exception performing whole class analysis.
 */
public final class b {
    private static b a;
    private com.xiaomi.midrop.d.a.a b;

    public b() {
        this.b = null;
    }

    public static b a() {
        b b2 = a;
        if (b2 == null) {
            a = b2 = new b();
        }
        return b2;
    }

    public static String a(String string2) {
        com.xiaomi.midrop.d.a.a a2 = b.a().b;
        if (a2 == null) {
            a2 = b.a().a(MiDropApplication.a());
        }
        return a2.a(string2);
    }

    public final com.xiaomi.midrop.d.a.a a(Context context) {
        if (this.b == null) {
            this.b = new /* Unavailable Anonymous Inner Class!! */;
        }
        this.b.a();
        return this.b;
    }
}

