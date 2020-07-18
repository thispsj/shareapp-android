/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  sun.misc.Unsafe
 */
package io.netty.d.b.b.a.a.a;

import io.netty.d.b.b.a.a.a.e;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class c<E>
extends e<E> {
    private static final long a;
    protected long e;
    protected E[] f;
    protected long g;

    static {
        try {
            Field field = c.class.getDeclaredField("g");
            a = io.netty.d.b.b.a.a.b.c.b.objectFieldOffset(field);
            return;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new RuntimeException((Throwable)noSuchFieldException);
        }
    }

    c() {
    }

    public final long a() {
        return io.netty.d.b.b.a.a.b.c.b.getLongVolatile((Object)this, a);
    }

    final void c(long l2) {
        io.netty.d.b.b.a.a.b.c.b.putOrderedLong((Object)this, a, l2);
    }
}

