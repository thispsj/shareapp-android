/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Integer
 *  java.lang.Object
 */
package io.netty.d.b;

public final class j {
    static final /* synthetic */ boolean a = true;

    private j() {
    }

    public static int a(int n2) {
        if (n2 <= 0) {
            return 1;
        }
        if (n2 >= 1073741824) {
            return 1073741824;
        }
        if (!(a || n2 > Integer.MIN_VALUE && n2 < 1073741824)) {
            throw new AssertionError();
        }
        return 1 << 32 - Integer.numberOfLeadingZeros((int)(n2 - 1));
    }

    public static boolean a(int n2, int n3, int n4) {
        int n5 = n2 | n3;
        int n6 = n2 + n3;
        return (n5 | n6 | n4 - n6) < 0;
    }
}

