/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 */
package io.netty.d.b.b.a.a.a.a;

import io.netty.d.b.b.a.a.a.a.o;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class q<E>
extends o<E> {
    static final AtomicLongFieldUpdater<q> f = AtomicLongFieldUpdater.newUpdater(q.class, (String)"g");
    volatile long g;

    public q(int n2) {
        super(n2);
        this.g = n2;
    }
}

