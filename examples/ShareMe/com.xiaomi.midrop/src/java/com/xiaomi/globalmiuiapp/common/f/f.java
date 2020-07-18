/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.xiaomi.globalmiuiapp.common.f;

public abstract class f<T> {
    private volatile T a;

    public abstract T a();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final T b() {
        if (this.a != null) return this.a;
        f f2 = this;
        synchronized (f2) {
            if (this.a != null) return this.a;
            this.a = this.a();
            return this.a;
        }
    }
}

