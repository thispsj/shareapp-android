/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 */
package c;

import c.c;
import c.e;
import c.f;
import c.m;
import c.s;
import c.t;
import c.u;
import c.v;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class o
implements e {
    public final c a = new c();
    public final t b;
    boolean c;

    o(t t2) {
        if (t2 == null) {
            throw new NullPointerException("source == null");
        }
        this.b = t2;
    }

    private long a(byte by, long l2, long l3) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (l3 >= 0L) {
            while (l2 < l3) {
                long l4 = this.a.a(by, l2, l3);
                if (l4 != -1L) {
                    return l4;
                }
                long l5 = this.a.b;
                if (l5 >= l3) break;
                if (this.b.a(this.a, 8192L) == -1L) {
                    return -1L;
                }
                l2 = Math.max((long)l2, (long)l5);
            }
            return -1L;
        }
        Object[] arrobject = new Object[]{0L, l3};
        throw new IllegalArgumentException(String.format((String)"fromIndex=%s toIndex=%s", (Object[])arrobject));
    }

    @Override
    public final int a(m m2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        do {
            int n2;
            if ((n2 = this.a.b(m2)) == -1) {
                return -1;
            }
            long l2 = m2.a[n2].h();
            if (l2 > this.a.b) continue;
            this.a.i(l2);
            return n2;
        } while (this.b.a(this.a, 8192L) != -1L);
        return -1;
    }

    @Override
    public final long a(c c2, long l2) throws IOException {
        if (c2 == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (l2 < 0L) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b == 0L && this.b.a(this.a, 8192L) == -1L) {
            return -1L;
        }
        long l3 = Math.min((long)l2, (long)this.a.b);
        return this.a.a(c2, l3);
    }

    @Override
    public final long a(s s2) throws IOException {
        if (s2 == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long l2 = 0L;
        while (this.b.a(this.a, 8192L) != -1L) {
            long l3 = this.a.d();
            if (l3 <= 0L) continue;
            long l4 = l2 + l3;
            s2.a_(this.a, l3);
            l2 = l4;
        }
        if (this.a.b > 0L) {
            long l5 = l2 + this.a.b;
            s2.a_(this.a, this.a.b);
            l2 = l5;
        }
        return l2;
    }

    @Override
    public final u a() {
        return this.b.a();
    }

    @Override
    public final String a(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.a.a(this.b);
        return this.a.a(charset);
    }

    @Override
    public final void a(long l2) throws IOException {
        if (!this.b(l2)) {
            throw new EOFException();
        }
    }

    @Override
    public final void a(byte[] arrby) throws IOException {
        try {
            this.a(arrby.length);
        }
        catch (EOFException eOFException) {
            int n2 = 0;
            while (this.a.b > 0L) {
                int n3 = this.a.a(arrby, n2, (int)this.a.b);
                if (n3 == -1) {
                    throw new AssertionError();
                }
                n2 += n3;
            }
            throw eOFException;
        }
        this.a.a(arrby);
    }

    @Override
    public final long b(f f2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long l2 = 0L;
        long l3;
        while ((l3 = this.a.a(f2, l2)) == -1L) {
            long l4 = this.a.b;
            if (this.b.a(this.a, 8192L) == -1L) {
                return -1L;
            }
            l2 = Math.max((long)l2, (long)l4);
        }
        return l3;
    }

    @Override
    public final c b() {
        return this.a;
    }

    @Override
    public final boolean b(long l2) throws IOException {
        if (l2 < 0L) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (this.a.b < l2) {
            if (this.b.a(this.a, 8192L) != -1L) continue;
            return false;
        }
        return true;
    }

    @Override
    public final boolean c() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.a.c() && this.b.a(this.a, 8192L) == -1L;
    }

    @Override
    public final boolean c(f f2) throws IOException {
        int n2 = f2.h();
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (n2 >= 0) {
            if (f2.h() - 0 < n2) {
                return false;
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                long l2 = 0L + (long)i2;
                if (!this.b(l2 + 1L)) {
                    return false;
                }
                if (this.a.c(l2) == f2.a(i2 + 0)) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public final void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.p();
    }

    @Override
    public final f d(long l2) throws IOException {
        this.a(l2);
        return this.a.d(l2);
    }

    @Override
    public final byte e() throws IOException {
        this.a(1L);
        return this.a.e();
    }

    @Override
    public final String f(long l2) throws IOException {
        if (l2 < 0L) {
            StringBuilder stringBuilder = new StringBuilder("limit < 0: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        long l3 = l2 == Long.MAX_VALUE ? Long.MAX_VALUE : l2 + 1L;
        long l4 = o.super.a((byte)10, 0L, l3);
        if (l4 != -1L) {
            return this.a.g(l4);
        }
        if (l3 < Long.MAX_VALUE && this.b(l3) && this.a.c(l3 - 1L) == 13 && this.b(l3 + 1L) && this.a.c(l3) == 10) {
            return this.a.g(l3);
        }
        c c2 = new c();
        this.a.a(c2, 0L, Math.min((long)32L, (long)this.a.b));
        StringBuilder stringBuilder = new StringBuilder("\\n not found: limit=");
        stringBuilder.append(Math.min((long)this.a.b, (long)l2));
        stringBuilder.append(" content=");
        stringBuilder.append(c2.l().f());
        stringBuilder.append('\u2026');
        throw new EOFException(stringBuilder.toString());
    }

    @Override
    public final short f() throws IOException {
        this.a(2L);
        return this.a.f();
    }

    @Override
    public final int g() throws IOException {
        this.a(4L);
        return this.a.g();
    }

    @Override
    public final short h() throws IOException {
        this.a(2L);
        return v.a(this.a.f());
    }

    @Override
    public final byte[] h(long l2) throws IOException {
        this.a(l2);
        return this.a.h(l2);
    }

    @Override
    public final int i() throws IOException {
        this.a(4L);
        return v.a(this.a.g());
    }

    @Override
    public final void i(long l2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (l2 > 0L) {
            if (this.a.b == 0L && this.b.a(this.a, 8192L) == -1L) {
                throw new EOFException();
            }
            long l3 = Math.min((long)l2, (long)this.a.b);
            this.a.i(l3);
            l2 -= l3;
        }
    }

    public final boolean isOpen() {
        return !this.c;
    }

    @Override
    public final long j() throws IOException {
        int n2;
        this.a(1L);
        int n3 = 0;
        while (this.b(n2 = n3 + 1)) {
            byte by = this.a.c((long)n3);
            if (by >= 48 && by <= 57 || n3 == 0 && by == 45) {
                n3 = n2;
                continue;
            }
            if (n3 != 0) break;
            Object[] arrobject = new Object[]{by};
            throw new NumberFormatException(String.format((String)"Expected leading [0-9] or '-' character but was %#x", (Object[])arrobject));
        }
        return this.a.j();
    }

    @Override
    public final long k() throws IOException {
        int n2;
        this.a(1L);
        int n3 = 0;
        while (this.b(n2 = n3 + 1)) {
            byte by = this.a.c((long)n3);
            if (by >= 48 && by <= 57 || by >= 97 && by <= 102 || by >= 65 && by <= 70) {
                n3 = n2;
                continue;
            }
            if (n3 != 0) break;
            Object[] arrobject = new Object[]{by};
            throw new NumberFormatException(String.format((String)"Expected leading [0-9a-fA-F] character but was %#x", (Object[])arrobject));
        }
        return this.a.k();
    }

    @Override
    public final String n() throws IOException {
        return this.f(Long.MAX_VALUE);
    }

    @Override
    public final long q() throws IOException {
        return this.a((byte)0, 0L, Long.MAX_VALUE);
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.a.b == 0L && this.b.a(this.a, 8192L) == -1L) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("buffer(");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

