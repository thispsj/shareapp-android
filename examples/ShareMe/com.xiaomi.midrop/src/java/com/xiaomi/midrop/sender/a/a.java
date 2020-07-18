/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 */
package com.xiaomi.midrop.sender.a;

public final class a
extends Enum<a> {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    private static final /* synthetic */ int[] e;

    static {
        int[] arrn = new int[]{a, b, c, d};
        e = arrn;
    }

    public static int[] a() {
        return (int[])e.clone();
    }
}

