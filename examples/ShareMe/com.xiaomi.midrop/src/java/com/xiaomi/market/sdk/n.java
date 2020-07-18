/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.xiaomi.market.sdk;

public abstract class n<T> {
    private T a;

    protected abstract T a();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final T b() {
        n n2 = this;
        synchronized (n2) {
            if (this.a == null) {
                this.a = this.a();
            }
            T t2 = this.a;
            return t2;
        }
    }
}

