/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Message
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 */
package com.xiaomi.midrop.b;

import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a {
    private static a b;
    public HashMap<String, WeakReference<a>> a = new HashMap();

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public final void a(String string2) {
        this.a.remove((Object)string2);
    }

    public final void a(String string2, Message message) {
        if (this.a.get((Object)string2) == null) {
            return;
        }
        ((a)((WeakReference)this.a.get((Object)string2)).get()).a(message);
    }

    public final void a(String string2, a a2) {
        if (a2 == null) {
            return;
        }
        this.a.put((Object)string2, (Object)new WeakReference((Object)a2));
    }

    public static interface a {
        public void a(Message var1);
    }

}

