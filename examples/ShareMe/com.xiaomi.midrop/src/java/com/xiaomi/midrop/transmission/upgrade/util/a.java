/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.transmission.upgrade.util;

import android.text.TextUtils;
import com.xiaomi.midrop.sender.c.b;
import java.util.ArrayList;
import java.util.List;

public class a
extends b<com.xiaomi.midrop.transmission.upgrade.a.a> {
    private static a f;
    public List<com.xiaomi.midrop.transmission.upgrade.a.a> e = new ArrayList();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a e() {
        if (f != null) return f;
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (f != null) return f;
            f = new a();
            // ** MonitorExit[var1] (shouldn't be in output)
            return f;
        }
    }

    public final void a(String string2) {
        if (this.e == null) {
            return;
        }
        for (com.xiaomi.midrop.transmission.upgrade.a.a a2 : this.e) {
            if (a2.i && TextUtils.equals((CharSequence)a2.g, (CharSequence)string2)) {
                a2.i = false;
                for (int i2 = -1 + this.d.size(); i2 >= 0; --i2) {
                    ((a)this.d.get(i2)).a(a2);
                }
                return;
            }
            a2.i = false;
        }
    }

    public static interface a
    extends b.a<com.xiaomi.midrop.transmission.upgrade.a.a> {
        public void a(com.xiaomi.midrop.transmission.upgrade.a.a var1);
    }

}

