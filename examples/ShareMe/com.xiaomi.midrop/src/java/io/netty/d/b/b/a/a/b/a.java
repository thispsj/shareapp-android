/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.netty.d.b.b.a.a.b;

public final class a {
    public static int a(int n2) {
        if (n2 > 1073741824) {
            StringBuilder stringBuilder = new StringBuilder("There is no larger power of 2 int for value:");
            stringBuilder.append(n2);
            stringBuilder.append(" since it exceeds 2^31.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("Given value:");
            stringBuilder.append(n2);
            stringBuilder.append(". Expecting value >= 0.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return 1 << 32 - Integer.numberOfLeadingZeros((int)(n2 - 1));
    }
}

