/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.j
 *  java.lang.Object
 *  java.lang.Throwable
 */
package io.netty.d.a;

import io.netty.d.a.f;
import io.netty.d.a.j;
import io.netty.d.a.p;
import io.netty.d.b.n;

public final class l<V>
extends f<V> {
    private final Throwable a;

    public l(j j2, Throwable throwable) {
        super(j2);
        this.a = throwable;
    }

    public final V d() {
        return null;
    }

    public final Throwable g() {
        return this.a;
    }

    public final boolean h() {
        return false;
    }

    @Override
    public final p<V> p_() {
        n.a(this.a);
        return this;
    }
}

