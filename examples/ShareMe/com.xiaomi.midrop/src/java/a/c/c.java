/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package a.c;

public final class c {
    private static final int a(int n2, int n3) {
        int n4 = n2 % n3;
        if (n4 >= 0) {
            return n4;
        }
        return n4 + n3;
    }

    public static final int a(int n2, int n3, int n4) {
        return c.a(c.a(n2, n4) - c.a(n3, n4), n4);
    }
}

