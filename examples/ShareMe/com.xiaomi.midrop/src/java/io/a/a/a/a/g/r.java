/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package io.a.a.a.a.g;

public final class r
extends Enum<r> {
    public static final /* enum */ r a = new r();
    public static final /* enum */ r b = new r();
    public static final /* enum */ r c = new r();
    private static final /* synthetic */ r[] d;

    static {
        r[] arrr = new r[]{a, b, c};
        d = arrr;
    }

    public static r valueOf(String string2) {
        return (r)Enum.valueOf(r.class, (String)string2);
    }

    public static r[] values() {
        return (r[])d.clone();
    }
}

