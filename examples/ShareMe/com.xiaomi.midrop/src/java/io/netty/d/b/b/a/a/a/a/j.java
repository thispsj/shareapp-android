/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
package io.netty.d.b.b.a.a.a.a;

import io.netty.d.b.b.a.a.a.a.k;
import io.netty.d.b.b.a.a.a.a.n;
import io.netty.d.b.b.a.a.a.a.p;
import io.netty.d.b.b.a.a.a.a.q;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class j<E>
extends n<E> {
    public j(int n2) {
        super(n2);
    }

    public final boolean offer(E e2) {
        long l2;
        long l3;
        if (e2 == null) {
            throw new NullPointerException();
        }
        int n2 = this.b;
        long l4 = this.g;
        do {
            if ((l2 = this.b()) < l4) continue;
            l4 = 1L + (this.a() + (long)n2);
            if (l2 >= l4) {
                return false;
            }
            q.f.lazySet((Object)this, l4);
        } while (!p.e.compareAndSet((Object)this, l2, l3 = l2 + 1L));
        int n3 = n2 & (int)l2;
        this.a.lazySet(n3, e2);
        return true;
    }

    public final E peek() {
        AtomicReferenceArray atomicReferenceArray = this.a;
        long l2 = this.c();
        int n2 = this.a(l2);
        Object object = atomicReferenceArray.get(n2);
        if (object == null) {
            if (l2 != this.b()) {
                Object object2;
                while ((object2 = atomicReferenceArray.get(n2)) == null) {
                }
                return (E)object2;
            }
            return null;
        }
        return (E)object;
    }

    public final E poll() {
        AtomicReferenceArray atomicReferenceArray = this.a;
        long l2 = this.c();
        int n2 = this.a(l2);
        Object object = atomicReferenceArray.get(n2);
        if (object == null) {
            if (l2 != this.b()) {
                while ((object = atomicReferenceArray.get(n2)) == null) {
                }
            } else {
                return null;
            }
        }
        atomicReferenceArray.lazySet(n2, null);
        long l3 = l2 + 1L;
        k.c.lazySet((Object)this, l3);
        return (E)object;
    }
}

