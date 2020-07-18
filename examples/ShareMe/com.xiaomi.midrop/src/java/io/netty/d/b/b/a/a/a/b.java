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

import io.netty.d.b.b.a.a.a.f;
import io.netty.d.b.b.a.a.b.c;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class b<E>
extends f<E> {
    static final long a;
    volatile long b;
    protected long c;
    protected E[] d;

    static {
        try {
            Field field = b.class.getDeclaredField("b");
            a = c.b.objectFieldOffset(field);
            return;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new RuntimeException((Throwable)noSuchFieldException);
        }
    }

    b() {
    }

    final void b(long l2) {
        c.b.putOrderedLong((Object)this, a, l2);
    }
}

