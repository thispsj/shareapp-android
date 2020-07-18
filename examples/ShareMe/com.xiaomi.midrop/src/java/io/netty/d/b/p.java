/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.y
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package io.netty.d.b;

import io.netty.d.a.y;
import io.netty.d.b.a.d;
import io.netty.d.b.w;

public final class p {
    public static void a(y<?> y2, Throwable throwable, d d2) {
        if (!y2.b(throwable) && d2 != null) {
            Throwable throwable2 = y2.g();
            if (throwable2 == null) {
                d2.c("Failed to mark a promise as failure because it has succeeded already: {}", (Object)y2, (Object)throwable);
                return;
            }
            Object[] arrobject = new Object[]{y2, w.a(throwable2), throwable};
            d2.b("Failed to mark a promise as failure because it has failed already: {}, unnotified cause: {}", arrobject);
        }
    }
}

