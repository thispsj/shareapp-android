/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.List
 */
package com.xiaomi.midrop.util;

import com.xiaomi.midrop.b.g;
import java.lang.ref.WeakReference;
import java.util.List;

public class ak {
    private static ak b;
    private WeakReference<List<g>> a;

    private ak() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ak a() {
        if (b != null) return b;
        Class<ak> class_ = ak.class;
        synchronized (ak.class) {
            if (b != null) return b;
            b = new ak();
            // ** MonitorExit[var1] (shouldn't be in output)
            return b;
        }
    }

    public final void a(List<g> list) {
        if (list != this.b()) {
            this.a = new WeakReference(list);
        }
    }

    public final List<g> b() {
        if (this.a == null) {
            return null;
        }
        return (List)this.a.get();
    }
}

