/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
package io.netty.d.b.b.a.a.a.a;

import io.netty.d.b.b.a.a.a.a.f;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class d<E>
extends f<E> {
    private static final AtomicLongFieldUpdater<d> a = AtomicLongFieldUpdater.newUpdater(d.class, (String)"g");
    protected long e;
    protected AtomicReferenceArray<E> f;
    protected volatile long g;

    d() {
    }

    public final long a() {
        return this.g;
    }

    final void c(long l2) {
        a.lazySet((Object)this, l2);
    }
}

