/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  sun.misc.Unsafe
 */
package io.netty.d.b.b.a.a.b;

import io.netty.d.b.b.a.a.b.c;
import sun.misc.Unsafe;

public final class d {
    public static final long a;
    public static final int b;

    /*
     * Enabled aggressive block sorting
     */
    static {
        int n2;
        int n3 = c.b.arrayIndexScale(Object[].class);
        if (4 == n3) {
            n2 = 2;
        } else {
            if (8 != n3) {
                throw new IllegalStateException("Unknown pointer size");
            }
            n2 = 3;
        }
        b = n2;
        a = c.b.arrayBaseOffset(Object[].class);
    }

    public static <E> void a(E[] arrE, long l2) {
        c.b.putObject(arrE, l2, null);
    }

    public static <E> void a(E[] arrE, long l2, E e2) {
        c.b.putOrderedObject(arrE, l2, e2);
    }

    public static <E> E b(E[] arrE, long l2) {
        return (E)c.b.getObjectVolatile(arrE, l2);
    }
}

