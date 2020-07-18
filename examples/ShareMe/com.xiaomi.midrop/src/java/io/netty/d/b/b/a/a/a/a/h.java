/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.b.a.a.a.a.e
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 */
package io.netty.d.b.b.a.a.a.a;

import io.netty.d.b.b.a.a.a.a.e;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class h<E>
extends e<E> {
    static final AtomicLongFieldUpdater<h> h = AtomicLongFieldUpdater.newUpdater(h.class, (String)"i");
    protected volatile long i;

    h() {
    }

    public final long b() {
        return this.i;
    }

    final boolean b(long l2, long l3) {
        return h.compareAndSet((Object)this, l2, l3);
    }
}

