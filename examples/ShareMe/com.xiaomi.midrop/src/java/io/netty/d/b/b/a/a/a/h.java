/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.b.a.a.a.i
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 */
package io.netty.d.b.b.a.a.a;

import io.netty.d.b.b.a.a.a.i;
import io.netty.d.b.b.a.a.a.j;
import io.netty.d.b.b.a.a.b.a;
import io.netty.d.b.b.a.a.b.d;
import java.util.Iterator;

public abstract class h<E>
extends i<E> {
    protected final long a;
    protected final E[] b;

    public h(int n2) {
        int n3 = a.a(n2);
        this.a = n3 - 1;
        this.b = new Object[n3];
    }

    protected static long a(long l2, long l3) {
        return d.a + ((l2 & l3) << d.b);
    }

    protected final long a(long l2) {
        return h.a(l2, this.a);
    }

    public void clear() {
        while (this.poll() != null) {
        }
    }

    public final boolean isEmpty() {
        return j.b((j.a)((Object)this));
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        return j.a((j.a)((Object)this));
    }

    public String toString() {
        return this.getClass().getName();
    }
}

