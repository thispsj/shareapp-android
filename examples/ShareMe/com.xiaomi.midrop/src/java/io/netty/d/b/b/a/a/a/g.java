/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.b.a.a.a.d
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  sun.misc.Unsafe
 */
package io.netty.d.b.b.a.a.a;

import io.netty.d.b.b.a.a.a.d;
import io.netty.d.b.b.a.a.b.c;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class g<E>
extends d<E> {
    static final long h;
    protected long i;

    static {
        try {
            Field field = g.class.getDeclaredField("i");
            h = c.b.objectFieldOffset(field);
            return;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new RuntimeException((Throwable)noSuchFieldException);
        }
    }

    g() {
    }

    public final long b() {
        return c.b.getLongVolatile((Object)this, h);
    }

    final boolean b(long l2, long l3) {
        return c.b.compareAndSwapLong((Object)this, h, l2, l3);
    }
}

