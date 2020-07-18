/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
package io.netty.d.b.b.a.a.a.a;

import io.netty.d.b.b.a.a.a.a.b;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class u<E>
extends b<E> {
    @Override
    protected final int a(AtomicReferenceArray<E> atomicReferenceArray) {
        return atomicReferenceArray.length();
    }

    @Override
    protected final long a(long l2) {
        return l2;
    }

    @Override
    protected final long a(long l2, long l3) {
        return Integer.MAX_VALUE;
    }
}

