/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.journeyapps.barcodescanner;

public final class n
implements Comparable<n> {
    public final int a;
    public final int b;

    public n(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public final n a() {
        return new n(this.b, this.a);
    }

    public final n a(n n2) {
        if (this.a * n2.b >= n2.a * this.b) {
            return new n(n2.a, this.b * n2.a / this.a);
        }
        return new n(this.a * n2.b / this.b, n2.b);
    }

    public final n b(n n2) {
        if (this.a * n2.b <= n2.a * this.b) {
            return new n(n2.a, this.b * n2.a / this.a);
        }
        return new n(this.a * n2.b / this.b, n2.b);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            n n2 = (n)object;
            if (this.a == n2.a && this.b == n2.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return 31 * this.a + this.b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("x");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}

