/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.a.a;

public final class a
extends Enum<a> {
    public static final /* enum */ a a = new a();
    public static final /* enum */ a b = new a();
    private static final /* synthetic */ a[] c;

    static {
        a[] arra = new a[]{a, b};
        c = arra;
    }

    public static a valueOf(String string2) {
        return (a)Enum.valueOf(a.class, (String)string2);
    }

    public static a[] values() {
        return (a[])c.clone();
    }
}

