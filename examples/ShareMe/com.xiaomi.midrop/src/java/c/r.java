/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.lang.AssertionError
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Arrays
 */
package c;

import c.c;
import c.f;
import c.p;
import c.v;
import java.util.Arrays;

final class r
extends f {
    final transient byte[][] f;
    final transient int[] g;

    r(c c2, int n2) {
        super(null);
        v.a(c2.b, 0L, n2);
        p p2 = c2.a;
        int n3 = 0;
        p p3 = p2;
        int n4 = 0;
        int n5 = 0;
        while (n4 < n2) {
            if (p3.c == p3.b) {
                throw new AssertionError((Object)"s.limit == s.pos");
            }
            n4 += p3.c - p3.b;
            ++n5;
            p3 = p3.f;
        }
        this.f = new byte[n5][];
        this.g = new int[n5 * 2];
        p p4 = c2.a;
        int n6 = 0;
        while (n3 < n2) {
            this.f[n6] = p4.a;
            if ((n3 += p4.c - p4.b) > n2) {
                n3 = n2;
            }
            this.g[n6] = n3;
            this.g[n6 + this.f.length] = p4.b;
            p4.d = true;
            ++n6;
            p4 = p4.f;
        }
    }

    private int b(int n2) {
        int n3 = Arrays.binarySearch((int[])this.g, (int)0, (int)this.f.length, (int)(n2 + 1));
        if (n3 >= 0) {
            return n3;
        }
        return ~n3;
    }

    private f k() {
        return new f(this.i());
    }

    private Object writeReplace() {
        return this.k();
    }

    @Override
    public final byte a(int n2) {
        v.a(this.g[-1 + this.f.length], n2, 1L);
        int n3 = r.super.b(n2);
        int n4 = n3 == 0 ? 0 : this.g[n3 - 1];
        int n5 = this.g[n3 + this.f.length];
        return this.f[n3][n5 + (n2 - n4)];
    }

    @Override
    public final f a(int n2, int n3) {
        return r.super.k().a(n2, n3);
    }

    @Override
    public final String a() {
        return this.k().a();
    }

    @Override
    final void a(c c2) {
        int n2 = this.f.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = this.g[n2 + i2];
            int n5 = this.g[i2];
            p p2 = new p(this.f[i2], n4, n4 + n5 - n3);
            if (c2.a == null) {
                p2.g = p2;
                p2.f = p2;
                c2.a = p2;
            } else {
                c2.a.g.a(p2);
            }
            n3 = n5;
        }
        c2.b += (long)n3;
    }

    @Override
    public final boolean a(int n2, f f2, int n3, int n4) {
        if (this.h() - n4 < 0) {
            return false;
        }
        int n5 = r.super.b(0);
        while (n4 > 0) {
            int n6;
            int n7 = n5 == 0 ? 0 : this.g[n5 - 1];
            int n8 = this.g[n5 + this.f.length] + (n2 - n7);
            if (!f2.a(n3, this.f[n5], n8, n6 = Math.min((int)n4, (int)(n7 + (this.g[n5] - n7) - n2)))) {
                return false;
            }
            n2 += n6;
            n3 += n6;
            n4 -= n6;
            ++n5;
        }
        return true;
    }

    @Override
    public final boolean a(int n2, byte[] arrby, int n3, int n4) {
        if (n2 >= 0 && n2 <= this.h() - n4 && n3 >= 0) {
            if (n3 > arrby.length - n4) {
                return false;
            }
            int n5 = r.super.b(n2);
            while (n4 > 0) {
                int n6;
                int n7 = n5 == 0 ? 0 : this.g[n5 - 1];
                int n8 = this.g[n5 + this.f.length] + (n2 - n7);
                if (!v.a(this.f[n5], n8, arrby, n3, n6 = Math.min((int)n4, (int)(n7 + (this.g[n5] - n7) - n2)))) {
                    return false;
                }
                n2 += n6;
                n3 += n6;
                n4 -= n6;
                ++n5;
            }
            return true;
        }
        return false;
    }

    @Override
    public final String b() {
        return this.k().b();
    }

    @Override
    public final f c() {
        return this.k().c();
    }

    @Override
    public final f d() {
        return this.k().d();
    }

    @Override
    public final f e() {
        return this.k().e();
    }

    @Override
    public final boolean equals(Object object) {
        f f2;
        if (object == this) {
            return true;
        }
        return object instanceof f && (f2 = (f)object).h() == this.h() && this.a(0, f2, 0, this.h());
    }

    @Override
    public final String f() {
        return this.k().f();
    }

    @Override
    public final f g() {
        return this.k().g();
    }

    @Override
    public final int h() {
        return this.g[-1 + this.f.length];
    }

    @Override
    public final int hashCode() {
        int n2 = this.d;
        if (n2 != 0) {
            return n2;
        }
        int n3 = this.f.length;
        int n4 = 0;
        int n5 = 1;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n6;
            byte[] arrby = this.f[i2];
            int n7 = this.g[i2];
            int n8 = n6 + (n7 - n4);
            for (n6 = this.g[n3 + i2]; n6 < n8; ++n6) {
                n5 = n5 * 31 + arrby[n6];
            }
            n4 = n7;
        }
        this.d = n5;
        return n5;
    }

    @Override
    public final byte[] i() {
        byte[] arrby = new byte[this.g[-1 + this.f.length]];
        int n2 = this.f.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = this.g[n2 + i2];
            int n5 = this.g[i2];
            System.arraycopy((Object)this.f[i2], (int)n4, (Object)arrby, (int)n3, (int)(n5 - n3));
            n3 = n5;
        }
        return arrby;
    }

    @Override
    final byte[] j() {
        return this.i();
    }

    @Override
    public final String toString() {
        return this.k().toString();
    }
}

