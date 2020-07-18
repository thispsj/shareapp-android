/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.netty.d.b;

public final class l {
    public static int a(int n2, String string2) {
        if (n2 <= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(": ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: > 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return n2;
    }

    public static <T> T a(T t2, String string2) {
        if (t2 == null) {
            throw new NullPointerException(string2);
        }
        return t2;
    }
}

