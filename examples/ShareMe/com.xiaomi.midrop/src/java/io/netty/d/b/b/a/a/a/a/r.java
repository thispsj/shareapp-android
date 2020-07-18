/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
package io.netty.d.b.b.a.a.a.a;

import io.netty.d.b.b.a.a.a.a.s;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class r<E>
extends s<E> {
    public r(int n2) {
        super(n2);
    }

    @Override
    protected int a(AtomicReferenceArray<E> atomicReferenceArray) {
        return atomicReferenceArray.length();
    }

    @Override
    protected long a(long l2) {
        return l2;
    }

    @Override
    protected final long a(long l2, long l3) {
        return this.j - (l2 - l3);
    }
}

