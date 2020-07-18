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
 *  sun.misc.Unsafe
 */
package io.netty.d.b.b.a.a.a;

import io.netty.d.b.b.a.a.a.b;
import io.netty.d.b.b.a.a.a.g;
import io.netty.d.b.b.a.a.a.k;
import io.netty.d.b.b.a.a.b.c;
import io.netty.d.b.b.a.a.b.d;
import java.util.Iterator;
import sun.misc.Unsafe;

public abstract class a<E>
extends b<E> {
    private static final Object j = new Object();

    public a() {
        io.netty.d.b.b.a.a.b.b.b(1024, 2, "initialCapacity");
        int n2 = io.netty.d.b.b.a.a.b.a.a(1024);
        long l2 = n2 - 1 << 1;
        Object[] arrobject = new Object[n2 + 1];
        this.d = arrobject;
        this.c = l2;
        this.f = arrobject;
        this.e = l2;
        this.b(l2);
    }

    private static E[] a(E[] arrE, long l2) {
        long l3 = a.d(l2);
        Object[] arrobject = (Object[])d.b(arrE, l3);
        d.a(arrE, l3, null);
        return arrobject;
    }

    private long b(E[] arrE, long l2) {
        this.f = arrE;
        this.e = -2 + arrE.length << 1;
        return k.a(l2, this.e);
    }

    private static long d(long l2) {
        return k.a(l2 + 2L, Long.MAX_VALUE);
    }

    protected abstract int a(E[] var1);

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
                        var2_8 = this.b;
                        var4_6 = this.b();
                        if ((var4_6 & 1L) == 1L) continue;
                        var6_7 = this.c;
                        var8_2 = this.d;
                        if (var2_8 > var4_6) break block11;
                        var9_5 = this.a();
                        var11_3 = var9_5 + this.a(var6_7);
                        if (var11_3 <= var4_6) break block12;
                        if (!c.b.compareAndSwapLong((Object)this, b.a, var2_8, var11_3)) ** GOTO lbl-1000
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
                        var15_10 = new Object[var14_9];
                        this.d = var15_10;
                        this.c = var16_11 = (long)(var14_9 - 2 << 1);
                        var18_12 = k.a(var4_6, var6_7);
                        d.a(var15_10, k.a(var4_6, var16_11), var1);
                        d.a(var8_2, a.d(var6_7), var15_10);
                        var20_13 = this.a(var4_6, this.a());
                        io.netty.d.b.b.a.a.b.b.a(var20_13, "availableInQueue");
                        this.b(var4_6 + Math.min((long)var16_11, (long)var20_13));
                        var24_14 = var4_6 + 2L;
                        c.b.putOrderedLong((Object)this, g.h, var24_14);
                        d.a(var8_2, var18_12, a.j);
                        return true;
                    }
                    case 2: 
                }
                return false;
            }
            if (this.b(var4_6, var4_6 + 2L)) break;
        } while (true);
        d.a(var8_2, k.a(var4_6, var6_7), var1);
        return true;
    }

    public E peek() {
        Object[] arrobject = this.f;
        long l2 = this.g;
        long l3 = this.e;
        long l4 = k.a(l2, l3);
        Object object = d.b(arrobject, l4);
        if (object == null && l2 != this.b()) {
            while ((object = d.b(arrobject, l4)) == null) {
            }
        }
        if (object == j) {
            Object[] arrobject2 = a.a(arrobject, l3);
            Object object2 = d.b(arrobject2, this.b(arrobject2, l2));
            if (object2 == null) {
                throw new IllegalStateException("new buffer must have at least one element");
            }
            return (E)object2;
        }
        return (E)object;
    }

    public E poll() {
        Object[] arrobject = this.f;
        long l2 = this.g;
        long l3 = this.e;
        long l4 = k.a(l2, l3);
        Object object = d.b(arrobject, l4);
        if (object == null) {
            if (l2 != this.b()) {
                while ((object = d.b(arrobject, l4)) == null) {
                }
            } else {
                return null;
            }
        }
        if (object == j) {
            long l5;
            Object[] arrobject2 = a.a(arrobject, l3);
            Object object2 = d.b(arrobject2, l5 = this.b(arrobject2, l2));
            if (object2 == null) {
                throw new IllegalStateException("new buffer must have at least one element");
            }
            d.a(arrobject2, l5, null);
            this.c(l2 + 2L);
            return (E)object2;
        }
        d.a(arrobject, l4, null);
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

