/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
package io.netty.d.b.b.a.a.a.a;

import io.netty.d.b.b.a.a.a.a.c;
import io.netty.d.b.b.a.a.a.a.h;
import io.netty.d.b.b.a.a.a.a.i;
import io.netty.d.b.b.a.a.b.a;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

public abstract class b<E>
extends c<E> {
    private static final Object j = new Object();

    public b() {
        AtomicReferenceArray atomicReferenceArray;
        io.netty.d.b.b.a.a.b.b.b(1024, 2, "initialCapacity");
        int n2 = a.a(1024);
        long l2 = n2 - 1 << 1;
        this.d = atomicReferenceArray = i.a(n2 + 1);
        this.c = l2;
        this.f = atomicReferenceArray;
        this.e = l2;
        this.b(l2);
    }

    private static AtomicReferenceArray<E> a(AtomicReferenceArray<E> atomicReferenceArray, long l2) {
        int n2 = b.d(l2);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray)atomicReferenceArray.get(n2);
        atomicReferenceArray.lazySet(n2, null);
        return atomicReferenceArray2;
    }

    private int b(AtomicReferenceArray<E> atomicReferenceArray, long l2) {
        this.f = atomicReferenceArray;
        this.e = -2 + atomicReferenceArray.length() << 1;
        return (int)(l2 & this.e) >> 1;
    }

    private static int d(long l2) {
        return (int)(Long.MAX_VALUE & l2 + 2L) >> 1;
    }

    protected abstract int a(AtomicReferenceArray<E> var1);

    protected abstract long a(long var1);

    protected abstract long a(long var1, long var3);

    public final boolean isEmpty() {
        return this.a() == this.b();
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean offer(E var1) {
        if (var1 == null) {
            throw new NullPointerException();
        }
        block5 : do {
            block11 : {
                block13 : {
                    block12 : {
                        var2_8 = this.c();
                        var4_6 = this.b();
                        if ((var4_6 & 1L) == 1L) continue;
                        var6_7 = this.c;
                        var8_2 = this.d;
                        if (var2_8 > var4_6) break block11;
                        var9_5 = this.a();
                        var11_3 = var9_5 + this.a(var6_7);
                        if (var11_3 <= var4_6) break block12;
                        if (!c.a.compareAndSet((Object)this, var2_8, var11_3)) ** GOTO lbl-1000
                        var13_4 = 0;
                        break block13;
                    }
                    if (this.a(var4_6, var9_5) <= 0L) {
                        var13_4 = 2;
                    } else if (this.b(var4_6, var4_6 + 1L)) {
                        var13_4 = 3;
                    } else lbl-1000: // 2 sources:
                    {
                        var13_4 = 1;
                    }
                }
                switch (var13_4) {
                    case 1: {
                        continue block5;
                    }
                    default: {
                        ** break;
                    }
                    case 3: {
                        var14_9 = this.a(var8_2);
                        this.d = var15_10 = i.a(var14_9);
                        this.c = var16_11 = (long)(var14_9 - 2 << 1);
                        var18_12 = (int)(var4_6 & var6_7) >> 1;
                        var15_10.lazySet((int)(var4_6 & var16_11) >> 1, var1);
                        var8_2.lazySet(b.d(var6_7), var15_10);
                        var19_13 = this.a(var4_6, this.a());
                        io.netty.d.b.b.a.a.b.b.a(var19_13, "availableInQueue");
                        this.b(var4_6 + Math.min((long)var16_11, (long)var19_13));
                        var23_14 = var4_6 + 2L;
                        h.h.lazySet((Object)this, var23_14);
                        var8_2.lazySet(var18_12, b.j);
                        return true;
                    }
                    case 2: 
                }
                return false;
            }
            if (this.b(var4_6, var4_6 + 2L)) break;
        } while (true);
        var8_2.lazySet((int)(var4_6 & var6_7) >> 1, var1);
        return true;
    }

    public E peek() {
        AtomicReferenceArray atomicReferenceArray = this.f;
        long l2 = this.g;
        long l3 = this.e;
        int n2 = (int)(l2 & l3) >> 1;
        Object object = atomicReferenceArray.get(n2);
        if (object == null && l2 != this.b()) {
            while ((object = atomicReferenceArray.get(n2)) == null) {
            }
        }
        if (object == j) {
            AtomicReferenceArray<E> atomicReferenceArray2 = b.a(atomicReferenceArray, l3);
            Object object2 = atomicReferenceArray2.get(this.b(atomicReferenceArray2, l2));
            if (object2 == null) {
                throw new IllegalStateException("new buffer must have at least one element");
            }
            return (E)object2;
        }
        return (E)object;
    }

    public E poll() {
        AtomicReferenceArray atomicReferenceArray = this.f;
        long l2 = this.g;
        long l3 = this.e;
        int n2 = (int)(l2 & l3) >> 1;
        Object object = atomicReferenceArray.get(n2);
        if (object == null) {
            if (l2 != this.b()) {
                while ((object = atomicReferenceArray.get(n2)) == null) {
                }
            } else {
                return null;
            }
        }
        if (object == j) {
            int n3;
            AtomicReferenceArray<E> atomicReferenceArray2 = b.a(atomicReferenceArray, l3);
            Object object2 = atomicReferenceArray2.get(n3 = this.b(atomicReferenceArray2, l2));
            if (object2 == null) {
                throw new IllegalStateException("new buffer must have at least one element");
            }
            atomicReferenceArray2.lazySet(n3, null);
            this.c(l2 + 2L);
            return (E)object2;
        }
        atomicReferenceArray.lazySet(n2, null);
        this.c(l2 + 2L);
        return (E)object;
    }

    public final int size() {
        long l2 = this.a();
        do {
            long l3 = this.b();
            long l4 = this.a();
            if (l2 == l4) {
                long l5 = l3 - l4 >> 1;
                if (l5 > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                return (int)l5;
            }
            l2 = l4;
        } while (true);
    }

    public String toString() {
        return this.getClass().getName();
    }
}

