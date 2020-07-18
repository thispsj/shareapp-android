/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.netty.d.b.b.a.a.a;

import io.netty.d.b.b.a.a.a.a;
import io.netty.d.b.b.a.a.b.b;

abstract class u<E>
extends a<E> {
    protected final long j;

    public u(int n2) {
        b.b(n2, 4, "maxCapacity");
        b.a(io.netty.d.b.b.a.a.b.a.a(1024), io.netty.d.b.b.a.a.b.a.a(n2), "initialCapacity");
        this.j = (long)io.netty.d.b.b.a.a.b.a.a(n2) << 1;
    }
}

