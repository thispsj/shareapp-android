/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 */
package io.netty.d.b.a;

public final class c
extends Enum<c> {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    private static final /* synthetic */ int[] f;

    static {
        int[] arrn = new int[]{a, b, c, d, e};
        f = arrn;
    }

    public static int[] a() {
        return (int[])f.clone();
    }
}

