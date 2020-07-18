/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.a.g
 *  io.netty.d.b.a.i
 *  io.netty.d.b.a.l
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package io.netty.d.b.a;

import io.netty.d.b.a.d;
import io.netty.d.b.a.g;
import io.netty.d.b.a.i;
import io.netty.d.b.a.l;

public abstract class e {
    private static volatile e a;

    public static d a(Class<?> class_) {
        return e.a(class_.getName());
    }

    public static d a(String string2) {
        if (a == null) {
            a = e.c(e.class.getName());
        }
        return a.b(string2);
    }

    private static e c(String string2) {
        try {
            l l2 = new l(0);
            l2.b(string2).b("Using SLF4J as the default logging framework");
            return l2;
        }
        catch (Throwable throwable) {
            try {
                e e2 = i.a;
                e2.b(string2).b("Using Log4J as the default logging framework");
                return e2;
            }
            catch (Throwable throwable2) {
                e e3 = g.a;
                e3.b(string2).b("Using java.util.logging as the default logging framework");
                return e3;
            }
        }
    }

    protected abstract d b(String var1);
}

