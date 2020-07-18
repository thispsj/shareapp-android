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

import io.netty.d.b.b.a.a.a.o;
import io.netty.d.b.b.a.a.b.c;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class m<E>
extends o<E> {
    static final long c;
    protected long d;

    static {
        try {
            c = c.b.objectFieldOffset(m.class.getDeclaredField("d"));
            return;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new RuntimeException((Throwable)noSuchFieldException);
        }
    }

    public m(int n2) {
        super(n2);
    }

    public final long a() {
        return c.b.getLongVolatile((Object)this, c);
    }

    protected final long c() {
        return this.d;
    }
}

