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

import io.netty.d.b.b.a.a.a.n;
import io.netty.d.b.b.a.a.b.c;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class r<E>
extends n<E> {
    static final long e;
    private volatile long c;

    static {
        try {
            e = c.b.objectFieldOffset(r.class.getDeclaredField("c"));
            return;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new RuntimeException((Throwable)noSuchFieldException);
        }
    }

    public r(int n2) {
        super(n2);
    }

    public final long b() {
        return this.c;
    }
}

