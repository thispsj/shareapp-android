/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package io.netty.c.b;

import io.netty.d.b.a.c;

public final class a
extends Enum<a> {
    public static final /* enum */ a a = new a(c.a);
    public static final /* enum */ a b = new a(c.b);
    public static final /* enum */ a c = new a(c.c);
    public static final /* enum */ a d = new a(c.d);
    public static final /* enum */ a e = new a(c.e);
    private static final /* synthetic */ a[] g;
    final int f;

    static {
        a[] arra = new a[]{a, b, c, d, e};
        g = arra;
    }

    private a(int n3) {
        this.f = n3;
    }

    public static a valueOf(String string2) {
        return (a)Enum.valueOf(a.class, (String)string2);
    }

    public static a[] values() {
        return (a[])g.clone();
    }
}

