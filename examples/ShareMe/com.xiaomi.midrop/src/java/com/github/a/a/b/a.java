/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.a.a.b;

public final class a {
    public final StringBuilder a = new StringBuilder(1024);

    a() {
    }

    public final a a() {
        this.a.setLength(0);
        return this;
    }

    public final a a(char c2) {
        this.a.append(c2);
        return this;
    }

    public final String b() {
        String string2 = this.a.toString();
        this.a();
        return string2;
    }

    public final a c() {
        if (this.a.length() > 0) {
            this.a.setLength(-1 + this.a.length());
        }
        return this;
    }
}

