/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package io.netty.d;

import io.netty.d.b.a.d;
import io.netty.d.b.a.e;
import io.netty.d.l;

public final class k {
    private static final d a = e.a(k.class);

    private k() {
    }

    public static boolean a(Object object) {
        if (object instanceof l) {
            return ((l)object).release();
        }
        return false;
    }

    public static void b(Object object) {
        try {
            k.a(object);
            return;
        }
        catch (Throwable throwable) {
            a.c("Failed to release a message: {}", object, (Object)throwable);
            return;
        }
    }
}

