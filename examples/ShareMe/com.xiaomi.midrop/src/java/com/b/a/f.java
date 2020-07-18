/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.b.a;

public final class f {
    public String a;
    public String b;
    public String c;
    String d;
    public String e;
    public long f = 0L;
    public long g = 0L;
    long h;
    public int i = 1;
    public long j;
    public String k;
    public boolean l;
    public String m;

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof f)) {
            return false;
        }
        f f2 = (f)object;
        if (this.b != null && this.e != null) {
            return this.b.equals((Object)f2.b) && this.c.equals((Object)f2.c) && this.e.equals((Object)f2.e);
        }
        return this.c.equals((Object)f2.c);
    }

    public final int hashCode() {
        int n2 = this.b == null ? 0 : this.b.hashCode();
        return n2 + this.c.hashCode();
    }
}

