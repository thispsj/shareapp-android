/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.System
 *  javax.annotation.Nullable
 */
package c;

import javax.annotation.Nullable;

final class p {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    p f;
    p g;

    p() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    p(byte[] arrby, int n2, int n3) {
        this.a = arrby;
        this.b = n2;
        this.c = n3;
        this.d = true;
        this.e = false;
    }

    final p a() {
        this.d = true;
        return new p(this.a, this.b, this.c);
    }

    public final p a(p p2) {
        p2.g = this;
        p2.f = this.f;
        this.f.g = p2;
        this.f = p2;
        return p2;
    }

    public final void a(p p2, int n2) {
        if (!p2.e) {
            throw new IllegalArgumentException();
        }
        if (n2 + p2.c > 8192) {
            if (p2.d) {
                throw new IllegalArgumentException();
            }
            if (n2 + p2.c - p2.b > 8192) {
                throw new IllegalArgumentException();
            }
            System.arraycopy((Object)p2.a, (int)p2.b, (Object)p2.a, (int)0, (int)(p2.c - p2.b));
            p2.c -= p2.b;
            p2.b = 0;
        }
        System.arraycopy((Object)this.a, (int)this.b, (Object)p2.a, (int)p2.c, (int)n2);
        p2.c = n2 + p2.c;
        this.b = n2 + this.b;
    }

    @Nullable
    public final p b() {
        p p2 = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return p2;
    }
}

