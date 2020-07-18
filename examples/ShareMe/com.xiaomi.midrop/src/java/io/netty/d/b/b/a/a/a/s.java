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

import io.netty.d.b.b.a.a.a.q;
import io.netty.d.b.b.a.a.b.c;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class s<E>
extends q<E> {
    static final long f;
    volatile long g;

    static {
        try {
            f = c.b.objectFieldOffset(s.class.getDeclaredField("g"));
            return;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new RuntimeException((Throwable)noSuchFieldException);
        }
    }

    public s(int n2) {
        super(n2);
        this.g = n2;
    }
}

