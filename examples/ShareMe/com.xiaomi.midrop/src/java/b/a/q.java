/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package b.a;

public final class q {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    boolean e;
    public boolean f;
    public boolean g;

    public final byte a() {
        byte by = this.a;
        if (this.b) {
            by = (byte)(by | 2);
        }
        if (this.c) {
            by = (byte)(by | 4);
        }
        if (this.d) {
            by = (byte)(by | 8);
        }
        if (this.e) {
            by = (byte)(by | 16);
        }
        if (this.f) {
            by = (byte)(by | 32);
        }
        if (this.g) {
            by = (byte)(by | 64);
        }
        return by;
    }

    public final boolean a(byte by) {
        int n2 = by & 1;
        boolean bl = true;
        if (n2 != 0) {
            this.a = bl;
        }
        if ((by & 2) != 0) {
            this.b = bl;
        }
        if ((by & 4) != 0) {
            this.c = bl;
        }
        if ((by & 8) != 0) {
            this.d = bl;
        }
        if ((by & 16) != 0) {
            this.e = bl;
        }
        if ((by & 32) != 0) {
            this.f = bl;
        }
        if ((by & 64) != 0) {
            this.g = bl;
        }
        if (!(this.a || this.b || this.c || this.d || this.e || this.f)) {
            if (this.g) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }
}

