/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package a.f;

import a.f.f;

public class g
extends f {
    public static final int a(int n2, int n3) {
        if (n2 < n3) {
            return n3;
        }
        return n2;
    }

    public static final int a(int n2, int n3, int n4) {
        if (n3 > n4) {
            StringBuilder stringBuilder = new StringBuilder("Cannot coerce value to an empty range: maximum ");
            stringBuilder.append(n4);
            stringBuilder.append(" is less than minimum ");
            stringBuilder.append(n3);
            stringBuilder.append('.');
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
        }
        if (n2 < n3) {
            return n3;
        }
        if (n2 > n4) {
            return n4;
        }
        return n2;
    }

    public static final long a(long l2, long l3) {
        if (l2 < l3) {
            return l3;
        }
        return l2;
    }

    public static final int b(int n2, int n3) {
        if (n2 > n3) {
            return n3;
        }
        return n2;
    }

    public static final long b(long l2, long l3) {
        if (l2 > l3) {
            return l3;
        }
        return l2;
    }
}

