/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 */
package io.netty.d.b.b.a.a.a.a;

import io.netty.d.b.b.a.a.a.a.m;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class k<E>
extends m<E> {
    static final AtomicLongFieldUpdater<k> c = AtomicLongFieldUpdater.newUpdater(k.class, (String)"d");
    protected volatile long d;

    public k(int n2) {
        super(n2);
    }

    public final long a() {
        return this.d;
    }

    protected final long c() {
        return this.d;
    }
}

