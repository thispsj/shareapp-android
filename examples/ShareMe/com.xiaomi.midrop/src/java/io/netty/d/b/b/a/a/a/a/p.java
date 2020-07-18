/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 */
package io.netty.d.b.b.a.a.a.a;

import io.netty.d.b.b.a.a.a.a.l;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class p<E>
extends l<E> {
    static final AtomicLongFieldUpdater<p> e = AtomicLongFieldUpdater.newUpdater(p.class, (String)"c");
    private volatile long c;

    public p(int n2) {
        super(n2);
    }

    public final long b() {
        return this.c;
    }
}

