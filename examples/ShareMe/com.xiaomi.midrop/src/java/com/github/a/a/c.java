/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.a.a;

import com.github.a.a.b;

public final class c {
    public String a;
    public String b;
    public b c;
    public String d;

    public c() {
        this(0);
    }

    private c(byte by) {
        super('\u0000');
    }

    private c(char c2) {
        super(new b());
    }

    private c(b b2) {
        this.a = null;
        this.b = null;
        this.c = b2;
        this.d = null;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        c c2 = (c)object;
        if (this.a == null ? c2.a != null : !this.a.equals((Object)c2.a)) {
            return false;
        }
        if (this.b == null ? c2.b != null : !this.b.equals((Object)c2.b)) {
            return false;
        }
        if (this.c == null ? c2.c != null : !this.c.equals(c2.c)) {
            return false;
        }
        return !(this.d == null ? c2.d != null : !this.d.equals((Object)c2.d));
    }

    public final int hashCode() {
        int n2 = this.a == null ? 0 : this.a.hashCode();
        int n3 = 31 * (n2 + 31);
        int n4 = this.b == null ? 0 : this.b.hashCode();
        int n5 = 31 * (n3 + n4);
        int n6 = this.c == null ? 0 : this.c.hashCode();
        int n7 = 31 * (n5 + n6);
        int n8 = this.d == null ? 0 : this.d.hashCode();
        return n7 + n8;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("VObjectProperty [group=");
        stringBuilder.append(this.a);
        stringBuilder.append(", name=");
        stringBuilder.append(this.b);
        stringBuilder.append(", parameters=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", value=");
        stringBuilder.append(this.d);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

