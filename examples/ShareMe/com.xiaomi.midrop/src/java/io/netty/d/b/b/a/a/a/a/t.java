/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
package io.netty.d.b.b.a.a.a.a;

import io.netty.d.b.b.a.a.a.a.r;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class t<E>
extends r<E> {
    public t(int n2) {
        super(n2);
    }

    @Override
    protected final int a(AtomicReferenceArray<E> atomicReferenceArray) {
        long l2 = this.j / 2L;
        int n2 = atomicReferenceArray.length();
        if ((long)n2 > l2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("buffer.length");
            stringBuilder.append(": ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: <= ");
            stringBuilder.append(l2);
            stringBuilder.append(')');
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return 1 + 2 * (-1 + atomicReferenceArray.length());
    }

    @Override
    protected final long a(long l2) {
        if (l2 + 2L == this.j) {
            l2 = this.j;
        }
        return l2;
    }
}

