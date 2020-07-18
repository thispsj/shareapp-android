/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.netty.d.b.b.a.a.a.a;

import io.netty.d.b.b.a.a.a.a.b;
import io.netty.d.b.b.a.a.b.a;

abstract class s<E>
extends b<E> {
    protected final long j;

    public s(int n2) {
        io.netty.d.b.b.a.a.b.b.b(n2, 4, "maxCapacity");
        io.netty.d.b.b.a.a.b.b.a(a.a(1024), a.a(n2), "initialCapacity");
        this.j = (long)a.a(n2) << 1;
    }
}

