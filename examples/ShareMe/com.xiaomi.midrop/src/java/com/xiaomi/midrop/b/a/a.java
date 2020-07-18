/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.xiaomi.midrop.b.a;

public abstract class a<Result> {
    protected a<Result> a;

    public final void a() {
        if (this.a == null) {
            return;
        }
        this.c();
        this.b();
    }

    public final void a(a<Result> a2) {
        this.a = a2;
    }

    final void a(Result Result) {
        if (this.a != null) {
            this.a.a(Result);
        }
    }

    protected abstract Result b();

    protected abstract void c();

    public static interface a<T> {
        public void a(T var1);
    }

}

