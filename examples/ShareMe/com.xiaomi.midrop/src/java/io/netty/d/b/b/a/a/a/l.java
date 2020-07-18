/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  sun.misc.Unsafe
 */
package io.netty.d.b.b.a.a.a;

import io.netty.d.b.b.a.a.a.m;
import io.netty.d.b.b.a.a.a.p;
import io.netty.d.b.b.a.a.a.r;
import io.netty.d.b.b.a.a.a.s;
import io.netty.d.b.b.a.a.b.c;
import io.netty.d.b.b.a.a.b.d;
import sun.misc.Unsafe;

public final class l<E>
extends p<E> {
    public l(int n2) {
        super(n2);
    }

    public final boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException();
        }
        long l2 = this.a;
        long l3 = this.g;
        do {
            long l4;
            long l5;
            if ((l5 = this.b()) >= l3) {
                l4 = 1L + (l2 + this.a());
                if (l5 >= l4) {
                    return false;
                }
                c.b.putOrderedLong((Object)this, s.f, l4);
            } else {
                l4 = l3;
            }
            long l6 = l5 + 1L;
            if (c.b.compareAndSwapLong((Object)this, r.e, l5, l6)) {
                long l7 = l.a(l5, l2);
                d.a(this.b, l7, e2);
                return true;
            }
            l3 = l4;
        } while (true);
    }

    public final E peek() {
        Object[] arrobject = this.b;
        long l2 = this.c();
        long l3 = this.a(l2);
        Object object = d.b(arrobject, l3);
        if (object == null) {
            if (l2 != this.b()) {
                Object object2;
                while ((object2 = d.b(arrobject, l3)) == null) {
                }
                return (E)object2;
            }
            return null;
        }
        return (E)object;
    }

    public final E poll() {
        Object[] arrobject = this.b;
        long l2 = this.c();
        long l3 = this.a(l2);
        Object object = d.b(arrobject, l3);
        if (object == null) {
            if (l2 != this.b()) {
                while ((object = d.b(arrobject, l3)) == null) {
                }
            } else {
                return null;
            }
        }
        d.a(arrobject, l3);
        long l4 = l2 + 1L;
        c.b.putOrderedLong((Object)this, m.c, l4);
        return (E)object;
    }
}

