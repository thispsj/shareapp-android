/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.netty.d.b.b.a.a.b;

public final class b {
    public static int a(int n2, int n3, String string2) {
        if (n2 >= n3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(": ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: < ");
            stringBuilder.append(n3);
            stringBuilder.append(')');
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return n2;
    }

    public static long a(long l2, String string2) {
        if (l2 <= 0L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(": ");
            stringBuilder.append(l2);
            stringBuilder.append(" (expected: > 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return l2;
    }

    public static int b(int n2, int n3, String string2) {
        if (n2 < n3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(": ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: >= ");
            stringBuilder.append(n3);
            stringBuilder.append(')');
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return n2;
    }
}

