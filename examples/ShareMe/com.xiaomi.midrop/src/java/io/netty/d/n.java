/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.n$a
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package io.netty.d;

import io.netty.d.b.a.d;
import io.netty.d.b.a.e;
import io.netty.d.m;
import io.netty.d.n;

/*
 * Exception performing whole class analysis.
 */
public abstract class n {
    static final d a;
    private static volatile n b;

    static {
        a = e.a(n.class);
        b = new /* Unavailable Anonymous Inner Class!! */;
    }

    public static n a() {
        return b;
    }

    @Deprecated
    public abstract <T> m<T> a(Class<T> var1);

    public <T> m<T> b(Class<T> class_) {
        return this.a(class_);
    }
}

