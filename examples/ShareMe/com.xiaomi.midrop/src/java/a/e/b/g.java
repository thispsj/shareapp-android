/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.e.b.c
 *  a.e.b.e
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.String
 */
package a.e.b;

import a.e.b.c;
import a.e.b.e;
import a.e.b.h;
import a.g.a;

public final class g {
    private static final h a;
    private static final a[] b;

    static {
        h h2;
        h2 = null;
        try {
            h h3;
            h2 = h3 = (h)Class.forName((String)"kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        }
        catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException throwable) {}
        if (h2 == null) {
            h2 = new h();
        }
        a = h2;
        b = new a[0];
    }

    public static String a(c c2) {
        return h.a(c2);
    }

    public static String a(e e2) {
        return h.a((c)e2);
    }
}

