/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.c
 *  io.netty.d.a.j
 *  java.lang.InterruptedException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.concurrent.TimeUnit
 */
package io.netty.d.a;

import io.netty.d.a.c;
import io.netty.d.a.h;
import io.netty.d.a.j;
import io.netty.d.a.p;
import io.netty.d.a.r;
import java.util.concurrent.TimeUnit;

public abstract class f<V>
extends c<V> {
    private final j a;

    protected f(j j2) {
        this.a = j2;
    }

    public final boolean a() {
        return true;
    }

    public final boolean a(long l2, TimeUnit timeUnit) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return true;
    }

    public p<V> b(r<? extends p<? super V>> r2) {
        if (r2 == null) {
            throw new NullPointerException("listener");
        }
        h.a(this.s_(), this, r2);
        return this;
    }

    public p<V> c() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return this;
    }

    public boolean cancel(boolean bl) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public p<V> p_() {
        return this;
    }

    protected j s_() {
        return this.a;
    }
}

