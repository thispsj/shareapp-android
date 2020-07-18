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

import io.netty.d.b.b.a.a.a.a.g;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class c<E>
extends g<E> {
    static final AtomicLongFieldUpdater<c> a = AtomicLongFieldUpdater.newUpdater(c.class, (String)"b");
    protected volatile long b;
    protected long c;
    protected AtomicReferenceArray<E> d;

    c() {
    }

    final void b(long l2) {
        a.lazySet((Object)this, l2);
    }

    final long c() {
        return this.b;
    }
}

