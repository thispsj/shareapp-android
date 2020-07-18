/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.ByteBuffer
 *  java.nio.channels.ByteChannel
 *  java.nio.charset.Charset
 *  javax.annotation.Nullable
 */
package c;

import c.d;
import c.e;
import c.f;
import c.m;
import c.p;
import c.q;
import c.r;
import c.s;
import c.t;
import c.u;
import c.v;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public final class c
implements d,
e,
Cloneable,
ByteChannel {
    private static final byte[] c = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable
    p a;
    public long b;

    private String a(long l2, Charset charset) throws EOFException {
        v.a(this.b, 0L, l2);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (l2 > Integer.MAX_VALUE) {
            StringBuilder stringBuilder = new StringBuilder("byteCount > Integer.MAX_VALUE: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (l2 == 0L) {
            return "";
        }
        p p2 = this.a;
        if (l2 + (long)p2.b > (long)p2.c) {
            return new String(this.h(l2), charset);
        }
        String string = new String(p2.a, p2.b, (int)l2, charset);
        p2.b = (int)(l2 + (long)p2.b);
        this.b -= l2;
        if (p2.b == p2.c) {
            this.a = p2.b();
            q.a(p2);
        }
        return string;
    }

    private static boolean a(p p2, int n2, f f2, int n3) {
        int n4 = p2.c;
        byte[] arrby = p2.a;
        p p3 = p2;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (n2 == n4) {
                p p4 = p3.f;
                byte[] arrby2 = p4.a;
                int n5 = p4.b;
                int n6 = p4.c;
                p3 = p4;
                n2 = n5;
                arrby = arrby2;
                n4 = n6;
            }
            if (arrby[n2] != f2.a(i2)) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    @Override
    public final int a(m m2) {
        p p2 = this.a;
        if (p2 == null) {
            return m2.indexOf((Object)f.b);
        }
        f[] arrf = m2.a;
        int n2 = arrf.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            f f2 = arrf[i2];
            if (this.b < (long)f2.h() || !c.a(p2, p2.b, f2, f2.h())) continue;
            try {
                this.i(f2.h());
                return i2;
            }
            catch (EOFException eOFException) {
                throw new AssertionError((Object)eOFException);
            }
        }
        return -1;
    }

    public final int a(byte[] arrby, int n2, int n3) {
        v.a(arrby.length, n2, n3);
        p p2 = this.a;
        if (p2 == null) {
            return -1;
        }
        int n4 = Math.min((int)n3, (int)(p2.c - p2.b));
        System.arraycopy((Object)p2.a, (int)p2.b, (Object)arrby, (int)n2, (int)n4);
        p2.b = n4 + p2.b;
        this.b -= (long)n4;
        if (p2.b == p2.c) {
            this.a = p2.b();
            q.a(p2);
        }
        return n4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final long a(byte by, long l2, long l3) {
        long l4;
        p p2;
        long l5 = 0L;
        if (l2 >= l5 && l3 >= l2) {
            l4 = l3 > this.b ? this.b : l3;
            if (l2 == l4) {
                return -1L;
            }
            p2 = this.a;
            if (p2 == null) {
                return -1L;
            }
            if (this.b - l2 < l2) {
                for (l5 = this.b; l5 > l2; l5 -= (long)(p2.c - p2.b)) {
                    p2 = p2.g;
                }
            } else {
                long l6;
                while ((l6 = l5 + (long)(p2.c - p2.b)) < l2) {
                    p2 = p2.f;
                    l5 = l6;
                }
            }
        } else {
            Object[] arrobject = new Object[]{this.b, l2, l3};
            throw new IllegalArgumentException(String.format((String)"size=%s fromIndex=%s toIndex=%s", (Object[])arrobject));
        }
        long l7 = l2;
        while (l5 < l4) {
            byte[] arrby = p2.a;
            int n2 = (int)Math.min((long)p2.c, (long)(l4 + (long)p2.b - l5));
            for (int i2 = (int)(l7 + (long)p2.b - l5); i2 < n2; ++i2) {
                if (arrby[i2] != by) continue;
                return l5 + (long)(i2 - p2.b);
            }
            long l8 = l5 + (long)(p2.c - p2.b);
            p2 = p2.f;
            l5 = l7 = l8;
        }
        return -1L;
    }

    @Override
    public final long a(c c2, long l2) {
        if (c2 == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (l2 < 0L) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.b == 0L) {
            return -1L;
        }
        if (l2 > this.b) {
            l2 = this.b;
        }
        c2.a_((c)this, l2);
        return l2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final long a(f f2, long l2) {
        int n2;
        long l3 = 0L;
        if (l2 < l3) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        p p2 = this.a;
        if (p2 == null) {
            return -1L;
        }
        if (this.b - l2 < l2) {
            for (l3 = this.b; l3 > l2; l3 -= (long)(p2.c - p2.b)) {
                p2 = p2.g;
            }
        } else {
            long l4;
            while ((l4 = l3 + (long)(p2.c - p2.b)) < l2) {
                p2 = p2.f;
                l3 = l4;
            }
        }
        if (f2.h() == 2) {
            byte by = f2.a(0);
            byte by2 = f2.a(1);
            while (l3 < this.b) {
                byte[] arrby = p2.a;
                int n3 = p2.c;
                for (n2 = (int)(l2 + (long)p2.b - l3); n2 < n3; ++n2) {
                    byte by3 = arrby[n2];
                    if (by3 == by) return l3 + (long)(n2 - p2.b);
                    if (by3 != by2) continue;
                    return l3 + (long)(n2 - p2.b);
                }
                long l5 = l3 + (long)(p2.c - p2.b);
                p2 = p2.f;
                l3 = l2 = l5;
            }
            return -1L;
        }
        byte[] arrby = f2.j();
        block4 : while (l3 < this.b) {
            byte[] arrby2 = p2.a;
            n2 = (int)(l2 + (long)p2.b - l3);
            int n4 = p2.c;
            do {
                int n5;
                byte by;
                if (n2 < n4) {
                    by = arrby2[n2];
                    n5 = arrby.length;
                } else {
                    long l6 = l3 + (long)(p2.c - p2.b);
                    p2 = p2.f;
                    l3 = l2 = l6;
                    continue block4;
                }
                for (int i2 = 0; i2 < n5; ++i2) {
                    if (by != arrby[i2]) continue;
                    return l3 + (long)(n2 - p2.b);
                }
                ++n2;
            } while (true);
            break;
        }
        return -1L;
    }

    @Override
    public final long a(s s2) throws IOException {
        long l2 = this.b;
        if (l2 > 0L) {
            s2.a_((c)this, l2);
        }
        return l2;
    }

    public final long a(t t2) throws IOException {
        long l2;
        if (t2 == null) {
            throw new IllegalArgumentException("source == null");
        }
        long l3 = 0L;
        while ((l2 = t2.a((c)this, 8192L)) != -1L) {
            l3 += l2;
        }
        return l3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final c a(int n2) {
        if (n2 >= 128) {
            int n3;
            if (n2 < 2048) {
                n3 = 192 | n2 >> 6;
            } else {
                int n4;
                if (n2 < 65536) {
                    if (n2 >= 55296 && n2 <= 57343) {
                        this.b(63);
                        return this;
                    }
                    n4 = 224 | n2 >> 12;
                } else {
                    if (n2 > 1114111) {
                        StringBuilder stringBuilder = new StringBuilder("Unexpected code point: ");
                        stringBuilder.append(Integer.toHexString((int)n2));
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    this.b(240 | n2 >> 18);
                    n4 = 128 | 63 & n2 >> 12;
                }
                this.b(n4);
                n3 = 128 | 63 & n2 >> 6;
            }
            this.b(n3);
            n2 = 128 | n2 & 63;
        }
        this.b(n2);
        return this;
    }

    public final c a(c c2, long l2, long l3) {
        if (c2 == null) {
            throw new IllegalArgumentException("out == null");
        }
        v.a(this.b, l2, l3);
        if (l3 == 0L) {
            return this;
        }
        c2.b = l3 + c2.b;
        p p2 = this.a;
        while (l2 >= (long)(p2.c - p2.b)) {
            long l4 = l2 - (long)(p2.c - p2.b);
            p2 = p2.f;
            l2 = l4;
        }
        while (l3 > 0L) {
            p p3 = p2.a();
            p3.b = (int)(l2 + (long)p3.b);
            p3.c = Math.min((int)(p3.b + (int)l3), (int)p3.c);
            if (c2.a == null) {
                p3.g = p3;
                p3.f = p3;
                c2.a = p3;
            } else {
                c2.a.g.a(p3);
            }
            long l5 = l3 - (long)(p3.c - p3.b);
            p2 = p2.f;
            l2 = 0L;
            l3 = l5;
        }
        return this;
    }

    public final c a(f f2) {
        if (f2 == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        f2.a((c)this);
        return this;
    }

    public final c a(String string) {
        return this.a(string, 0, string.length());
    }

    /*
     * Enabled aggressive block sorting
     */
    public final c a(String string, int n2, int n3) {
        if (string == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("beginIndex < 0: ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n3 < n2) {
            StringBuilder stringBuilder = new StringBuilder("endIndex < beginIndex: ");
            stringBuilder.append(n3);
            stringBuilder.append(" < ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n3 > string.length()) {
            StringBuilder stringBuilder = new StringBuilder("endIndex > string.length: ");
            stringBuilder.append(n3);
            stringBuilder.append(" > ");
            stringBuilder.append(string.length());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        while (n2 < n3) {
            int n4;
            char c2 = string.charAt(n2);
            if (c2 < '') {
                char c3;
                p p2 = this.e(1);
                byte[] arrby = p2.a;
                int n5 = p2.c - n2;
                int n6 = Math.min((int)n3, (int)(8192 - n5));
                int n7 = n2 + 1;
                arrby[n2 + n5] = (byte)c2;
                while ((n2 = n7) < n6 && (c3 = string.charAt(n2)) < '') {
                    n7 = n2 + 1;
                    arrby[n2 + n5] = (byte)c3;
                }
                int n8 = n5 + n2 - p2.c;
                p2.c = n8 + p2.c;
                this.b += (long)n8;
                continue;
            }
            if (c2 < '\u0800') {
                n4 = 192 | c2 >> 6;
            } else {
                if (c2 >= '\ud800' && c2 <= '\udfff') {
                    int n9 = n2 + 1;
                    char c4 = n9 < n3 ? string.charAt(n9) : (char)'\u0000';
                    if (c2 <= '\udbff' && c4 >= '\udc00' && c4 <= '\udfff') {
                        int n10 = 65536 + ((c2 & -55297) << 10 | -56321 & c4);
                        this.b(240 | n10 >> 18);
                        this.b(128 | 63 & n10 >> 12);
                        this.b(128 | 63 & n10 >> 6);
                        this.b(128 | n10 & 63);
                        n2 += 2;
                        continue;
                    }
                    this.b(63);
                    n2 = n9;
                    continue;
                }
                this.b(224 | c2 >> 12);
                n4 = 128 | 63 & c2 >> 6;
            }
            this.b(n4);
            this.b(128 | c2 & 63);
            ++n2;
        }
        return this;
    }

    @Override
    public final u a() {
        return u.c;
    }

    @Override
    public final String a(Charset charset) {
        try {
            String string = c.super.a(this.b, charset);
            return string;
        }
        catch (EOFException eOFException) {
            throw new AssertionError((Object)eOFException);
        }
    }

    @Override
    public final void a(long l2) throws EOFException {
        if (this.b < l2) {
            throw new EOFException();
        }
    }

    @Override
    public final void a(byte[] arrby) throws EOFException {
        int n2;
        for (int i2 = 0; i2 < arrby.length; i2 += n2) {
            n2 = this.a(arrby, i2, arrby.length - i2);
            if (n2 != -1) continue;
            throw new EOFException();
        }
    }

    @Override
    public final void a_(c c2, long l2) {
        if (c2 == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (c2 == this) {
            throw new IllegalArgumentException("source == this");
        }
        v.a(c2.b, 0L, l2);
        while (l2 > 0L) {
            if (l2 < (long)(c2.a.c - c2.a.b)) {
                int n2;
                long l3;
                p p2 = this.a != null ? this.a.g : null;
                if (p2 != null && p2.e && (l3 = l2 + (long)p2.c) - (long)(n2 = p2.d ? 0 : p2.b) <= 8192L) {
                    c2.a.a(p2, (int)l2);
                    c2.b -= l2;
                    this.b = l2 + this.b;
                    return;
                }
                p p3 = c2.a;
                int n3 = (int)l2;
                if (n3 > 0 && n3 <= p3.c - p3.b) {
                    p p4;
                    if (n3 >= 1024) {
                        p4 = p3.a();
                    } else {
                        p4 = q.a();
                        System.arraycopy((Object)p3.a, (int)p3.b, (Object)p4.a, (int)0, (int)n3);
                    }
                    p4.c = n3 + p4.b;
                    p3.b = n3 + p3.b;
                    p3.g.a(p4);
                    c2.a = p4;
                } else {
                    throw new IllegalArgumentException();
                }
            }
            p p5 = c2.a;
            long l4 = p5.c - p5.b;
            c2.a = p5.b();
            if (this.a == null) {
                p p6;
                p p7 = this.a = p5;
                p p8 = this.a;
                p8.g = p6 = this.a;
                p7.f = p6;
            } else {
                int n4;
                int n5;
                int n6;
                p p9 = this.a.g.a(p5);
                if (p9.g == p9) {
                    throw new IllegalStateException();
                }
                if (p9.g.e && (n5 = p9.c - p9.b) <= (n4 = 8192 - p9.g.c) + (n6 = p9.g.d ? 0 : p9.g.b)) {
                    p9.a(p9.g, n5);
                    p9.b();
                    q.a(p9);
                }
            }
            c2.b -= l4;
            this.b = l4 + this.b;
            l2 -= l4;
        }
    }

    final int b(m m2) {
        p p2 = this.a;
        f[] arrf = m2.a;
        int n2 = arrf.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            f f2 = arrf[i2];
            int n3 = (int)Math.min((long)this.b, (long)f2.h());
            if (n3 != 0) {
                if (!c.a(p2, p2.b, f2, n3)) continue;
                return i2;
            }
            return i2;
        }
        return -1;
    }

    @Override
    public final long b(f f2) {
        return this.a(f2, 0L);
    }

    @Override
    public final c b() {
        return this;
    }

    public final c b(int n2) {
        p p2 = this.e(1);
        byte[] arrby = p2.a;
        int n3 = p2.c;
        p2.c = n3 + 1;
        arrby[n3] = (byte)n2;
        this.b = 1L + this.b;
        return this;
    }

    public final c b(byte[] arrby) {
        if (arrby == null) {
            throw new IllegalArgumentException("source == null");
        }
        return this.b(arrby, 0, arrby.length);
    }

    public final c b(byte[] arrby, int n2, int n3) {
        if (arrby == null) {
            throw new IllegalArgumentException("source == null");
        }
        long l2 = arrby.length;
        long l3 = n2;
        long l4 = n3;
        v.a(l2, l3, l4);
        int n4 = n3 + n2;
        while (n2 < n4) {
            p p2 = this.e(1);
            int n5 = Math.min((int)(n4 - n2), (int)(8192 - p2.c));
            System.arraycopy((Object)arrby, (int)n2, (Object)p2.a, (int)p2.c, (int)n5);
            n2 += n5;
            p2.c = n5 + p2.c;
        }
        this.b = l4 + this.b;
        return this;
    }

    @Override
    public final /* synthetic */ d b(String string) throws IOException {
        return this.a(string);
    }

    @Override
    public final /* synthetic */ d b(String string, int n2, int n3) throws IOException {
        return this.a(string, n2, n3);
    }

    @Override
    public final boolean b(long l2) {
        return this.b >= l2;
    }

    public final byte c(long l2) {
        v.a(this.b, l2, 1L);
        if (this.b - l2 > l2) {
            p p2 = this.a;
            do {
                long l3;
                if (l2 < (l3 = (long)(p2.c - p2.b))) {
                    return p2.a[p2.b + (int)l2];
                }
                long l4 = l2 - l3;
                p2 = p2.f;
                l2 = l4;
            } while (true);
        }
        long l5 = l2 - this.b;
        p p3 = this.a.g;
        long l6;
        while ((l6 = l5 + (long)(p3.c - p3.b)) < 0L) {
            p3 = p3.g;
            l5 = l6;
        }
        return p3.a[p3.b + (int)l6];
    }

    public final c c(int n2) {
        p p2 = this.e(2);
        byte[] arrby = p2.a;
        int n3 = p2.c;
        int n4 = n3 + 1;
        arrby[n3] = (byte)(255 & n2 >>> 8);
        int n5 = n4 + 1;
        arrby[n4] = (byte)(n2 & 255);
        p2.c = n5;
        this.b = 2L + this.b;
        return this;
    }

    @Override
    public final /* synthetic */ d c(byte[] arrby) throws IOException {
        return this.b(arrby);
    }

    @Override
    public final /* synthetic */ d c(byte[] arrby, int n2, int n3) throws IOException {
        return this.b(arrby, n2, n3);
    }

    @Override
    public final boolean c() {
        return this.b == 0L;
    }

    @Override
    public final boolean c(f f2) {
        int n2 = f2.h();
        if (n2 >= 0 && this.b - 0L >= (long)n2) {
            if (f2.h() - 0 < n2) {
                return false;
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this.c(0L + (long)i2) == f2.a(i2 + 0)) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.r();
    }

    @Override
    public final void close() {
    }

    public final long d() {
        long l2 = this.b;
        if (l2 == 0L) {
            return 0L;
        }
        p p2 = this.a.g;
        if (p2.c < 8192 && p2.e) {
            l2 -= (long)(p2.c - p2.b);
        }
        return l2;
    }

    public final c d(int n2) {
        p p2 = this.e(4);
        byte[] arrby = p2.a;
        int n3 = p2.c;
        int n4 = n3 + 1;
        arrby[n3] = (byte)(255 & n2 >>> 24);
        int n5 = n4 + 1;
        arrby[n4] = (byte)(255 & n2 >>> 16);
        int n6 = n5 + 1;
        arrby[n5] = (byte)(255 & n2 >>> 8);
        int n7 = n6 + 1;
        arrby[n6] = (byte)(n2 & 255);
        p2.c = n7;
        this.b = 4L + this.b;
        return this;
    }

    @Override
    public final /* synthetic */ d d(f f2) throws IOException {
        return this.a(f2);
    }

    @Override
    public final f d(long l2) throws EOFException {
        return new f(this.h(l2));
    }

    @Override
    public final byte e() {
        if (this.b == 0L) {
            throw new IllegalStateException("size == 0");
        }
        p p2 = this.a;
        int n2 = p2.b;
        int n3 = p2.c;
        byte[] arrby = p2.a;
        int n4 = n2 + 1;
        byte by = arrby[n2];
        --this.b;
        if (n4 == n3) {
            this.a = p2.b();
            q.a(p2);
            return by;
        }
        p2.b = n4;
        return by;
    }

    final p e(int n2) {
        if (n2 > 0 && n2 <= 8192) {
            if (this.a == null) {
                p p2;
                p p3 = this.a = q.a();
                p p4 = this.a;
                p4.g = p2 = this.a;
                p3.f = p2;
                return p2;
            }
            p p5 = this.a.g;
            if (n2 + p5.c > 8192 || !p5.e) {
                p5 = p5.a(q.a());
            }
            return p5;
        }
        throw new IllegalArgumentException();
    }

    public final String e(long l2) throws EOFException {
        return c.super.a(l2, v.a);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof c)) {
            return false;
        }
        c c2 = (c)object;
        if (this.b != c2.b) {
            return false;
        }
        long l2 = this.b;
        long l3 = 0L;
        if (l2 == l3) {
            return true;
        }
        p p2 = this.a;
        p p3 = c2.a;
        int n2 = p2.b;
        int n3 = p3.b;
        while (l3 < this.b) {
            long l4 = Math.min((int)(p2.c - n2), (int)(p3.c - n3));
            int n4 = n3;
            int n5 = n2;
            int n6 = 0;
            while ((long)n6 < l4) {
                byte[] arrby = p2.a;
                int n7 = n5 + 1;
                byte by = arrby[n5];
                byte[] arrby2 = p3.a;
                int n8 = n4 + 1;
                if (by != arrby2[n4]) {
                    return false;
                }
                ++n6;
                n5 = n7;
                n4 = n8;
            }
            if (n5 == p2.c) {
                p2 = p2.f;
                n2 = p2.b;
            } else {
                n2 = n5;
            }
            if (n4 == p3.c) {
                p3 = p3.f;
                n3 = p3.b;
            } else {
                n3 = n4;
            }
            l3 += l4;
        }
        return true;
    }

    @Override
    public final /* synthetic */ d f(int n2) throws IOException {
        return this.d(n2);
    }

    @Override
    public final String f(long l2) throws EOFException {
        if (l2 < 0L) {
            StringBuilder stringBuilder = new StringBuilder("limit < 0: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        long l3 = Long.MAX_VALUE;
        if (l2 != l3) {
            l3 = l2 + 1L;
        }
        long l4 = this.a((byte)10, 0L, l3);
        if (l4 != -1L) {
            return this.g(l4);
        }
        if (l3 < this.b && this.c(l3 - 1L) == 13 && this.c(l3) == 10) {
            return this.g(l3);
        }
        c c2 = new c();
        this.a(c2, 0L, Math.min((long)32L, (long)this.b));
        StringBuilder stringBuilder = new StringBuilder("\\n not found: limit=");
        stringBuilder.append(Math.min((long)this.b, (long)l2));
        stringBuilder.append(" content=");
        stringBuilder.append(c2.l().f());
        stringBuilder.append('\u2026');
        throw new EOFException(stringBuilder.toString());
    }

    @Override
    public final short f() {
        if (this.b < 2L) {
            StringBuilder stringBuilder = new StringBuilder("size < 2: ");
            stringBuilder.append(this.b);
            throw new IllegalStateException(stringBuilder.toString());
        }
        p p2 = this.a;
        int n2 = p2.c;
        int n3 = p2.b;
        if (n2 - n3 < 2) {
            return (short)((255 & this.e()) << 8 | 255 & this.e());
        }
        byte[] arrby = p2.a;
        int n4 = n3 + 1;
        int n5 = (255 & arrby[n3]) << 8;
        int n6 = n4 + 1;
        int n7 = n5 | 255 & arrby[n4];
        this.b -= 2L;
        if (n6 == n2) {
            this.a = p2.b();
            q.a(p2);
        } else {
            p2.b = n6;
        }
        return (short)n7;
    }

    @Override
    public final void flush() {
    }

    @Override
    public final int g() {
        if (this.b < 4L) {
            StringBuilder stringBuilder = new StringBuilder("size < 4: ");
            stringBuilder.append(this.b);
            throw new IllegalStateException(stringBuilder.toString());
        }
        p p2 = this.a;
        int n2 = p2.c;
        int n3 = p2.b;
        if (n2 - n3 < 4) {
            return (255 & this.e()) << 24 | (255 & this.e()) << 16 | (255 & this.e()) << 8 | 255 & this.e();
        }
        byte[] arrby = p2.a;
        int n4 = n3 + 1;
        int n5 = (255 & arrby[n3]) << 24;
        int n6 = n4 + 1;
        int n7 = n5 | (255 & arrby[n4]) << 16;
        int n8 = n6 + 1;
        int n9 = n7 | (255 & arrby[n6]) << 8;
        int n10 = n8 + 1;
        int n11 = n9 | 255 & arrby[n8];
        this.b -= 4L;
        if (n10 == n2) {
            this.a = p2.b();
            q.a(p2);
            return n11;
        }
        p2.b = n10;
        return n11;
    }

    @Override
    public final /* synthetic */ d g(int n2) throws IOException {
        return this.c(n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    final String g(long l2) throws EOFException {
        long l3;
        String string;
        long l4 = l2 LCMP 0L;
        long l5 = 1L;
        if (l4 > 0 && this.c(l3 = l2 - l5) == 13) {
            string = this.e(l3);
            l5 = 2L;
        } else {
            string = this.e(l2);
        }
        this.i(l5);
        return string;
    }

    @Override
    public final /* synthetic */ d h(int n2) throws IOException {
        return this.b(n2);
    }

    @Override
    public final short h() {
        return v.a(this.f());
    }

    @Override
    public final byte[] h(long l2) throws EOFException {
        v.a(this.b, 0L, l2);
        if (l2 > Integer.MAX_VALUE) {
            StringBuilder stringBuilder = new StringBuilder("byteCount > Integer.MAX_VALUE: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        byte[] arrby = new byte[(int)l2];
        this.a(arrby);
        return arrby;
    }

    public final int hashCode() {
        p p2 = this.a;
        if (p2 == null) {
            return 0;
        }
        int n2 = 1;
        do {
            int n3 = p2.c;
            for (int i2 = p2.b; i2 < n3; ++i2) {
                n2 = n2 * 31 + p2.a[i2];
            }
        } while ((p2 = p2.f) != this.a);
        return n2;
    }

    @Override
    public final int i() {
        return v.a(this.g());
    }

    @Override
    public final void i(long l2) throws EOFException {
        while (l2 > 0L) {
            if (this.a == null) {
                throw new EOFException();
            }
            int n2 = (int)Math.min((long)l2, (long)(this.a.c - this.a.b));
            long l3 = this.b;
            long l4 = n2;
            this.b = l3 - l4;
            long l5 = l2 - l4;
            p p2 = this.a;
            p2.b = n2 + p2.b;
            if (this.a.b == this.a.c) {
                p p3 = this.a;
                this.a = p3.b();
                q.a(p3);
            }
            l2 = l5;
        }
    }

    public final boolean isOpen() {
        return true;
    }

    @Override
    public final long j() {
        if (this.b == 0L) {
            throw new IllegalStateException("size == 0");
        }
        long l2 = -7L;
        int n2 = 0;
        long l3 = 0L;
        boolean bl = false;
        boolean bl2 = false;
        do {
            int n3;
            int n4;
            p p2;
            block10 : {
                p p3 = this.a;
                byte[] arrby = p3.a;
                n3 = p3.b;
                n4 = p3.c;
                while (n3 < n4) {
                    byte by;
                    block16 : {
                        byte[] arrby2;
                        block15 : {
                            block11 : {
                                block12 : {
                                    int n5;
                                    block14 : {
                                        block13 : {
                                            by = arrby[n3];
                                            if (by < 48 || by > 57) break block11;
                                            n5 = 48 - by;
                                            if (l3 < -922337203685477580L) break block12;
                                            if (l3 != -922337203685477580L) break block13;
                                            p2 = p3;
                                            arrby2 = arrby;
                                            if ((long)n5 >= l2) break block14;
                                            break block12;
                                        }
                                        p2 = p3;
                                        arrby2 = arrby;
                                    }
                                    l3 = l3 * 10L + (long)n5;
                                    break block15;
                                }
                                c c2 = new c().j(l3).b(by);
                                if (!bl) {
                                    c2.e();
                                }
                                StringBuilder stringBuilder = new StringBuilder("Number too large: ");
                                stringBuilder.append(c2.m());
                                throw new NumberFormatException(stringBuilder.toString());
                            }
                            p2 = p3;
                            arrby2 = arrby;
                            if (by != 45 || n2 != 0) break block16;
                            --l2;
                            bl = true;
                        }
                        ++n3;
                        ++n2;
                        p3 = p2;
                        arrby = arrby2;
                        continue;
                    }
                    if (n2 == 0) {
                        StringBuilder stringBuilder = new StringBuilder("Expected leading [0-9] or '-' character but was 0x");
                        stringBuilder.append(Integer.toHexString((int)by));
                        throw new NumberFormatException(stringBuilder.toString());
                    }
                    bl2 = true;
                    break block10;
                }
                p2 = p3;
            }
            if (n3 == n4) {
                p p4 = p2;
                this.a = p4.b();
                q.a(p4);
                continue;
            }
            p2.b = n3;
        } while (!bl2 && this.a != null);
        this.b -= (long)n2;
        if (bl) {
            return l3;
        }
        return -l3;
    }

    public final c j(long l2) {
        if (l2 == 0L) {
            return this.b(48);
        }
        long l3 = l2 LCMP 0L;
        int n2 = 1;
        boolean bl = false;
        if (l3 < 0) {
            if ((l2 = -l2) < 0L) {
                return this.a("-9223372036854775808");
            }
            bl = true;
        }
        if (l2 < 100000000L) {
            if (l2 < 10000L) {
                if (l2 < 100L) {
                    if (l2 >= 10L) {
                        n2 = 2;
                    }
                } else {
                    n2 = l2 < 1000L ? 3 : 4;
                }
            } else {
                n2 = l2 < 1000000L ? (l2 < 100000L ? 5 : 6) : (l2 < 10000000L ? 7 : 8);
            }
        } else {
            n2 = l2 < 1000000000000L ? (l2 < 10000000000L ? (l2 < 1000000000L ? 9 : 10) : (l2 < 100000000000L ? 11 : 12)) : (l2 < 1000000000000000L ? (l2 < 10000000000000L ? 13 : (l2 < 100000000000000L ? 14 : 15)) : (l2 < 100000000000000000L ? (l2 < 10000000000000000L ? 16 : 17) : (l2 < 1000000000000000000L ? 18 : 19)));
        }
        if (bl) {
            ++n2;
        }
        p p2 = this.e(n2);
        byte[] arrby = p2.a;
        int n3 = n2 + p2.c;
        while (l2 != 0L) {
            int n4 = (int)(l2 % 10L);
            arrby[--n3] = c[n4];
            l2 /= 10L;
        }
        if (bl) {
            arrby[n3 - 1] = 45;
        }
        p2.c = n2 + p2.c;
        this.b += (long)n2;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final long k() {
        if (this.b == 0L) {
            throw new IllegalStateException("size == 0");
        }
        int n2 = 0;
        long l2 = 0L;
        boolean bl = false;
        do {
            int n3;
            p p2 = this.a;
            byte[] arrby = p2.a;
            int n4 = p2.c;
            for (n3 = p2.b; n3 < n4; ++n3, ++n2) {
                byte by;
                block13 : {
                    int n5;
                    block10 : {
                        int n6;
                        block12 : {
                            block11 : {
                                block9 : {
                                    by = arrby[n3];
                                    if (by < 48 || by > 57) break block9;
                                    n5 = by - 48;
                                    break block10;
                                }
                                if (by < 97 || by > 102) break block11;
                                n6 = by - 97;
                                break block12;
                            }
                            if (by < 65 || by > 70) break block13;
                            n6 = by - 65;
                        }
                        n5 = n6 + 10;
                    }
                    if ((l2 & -1152921504606846976L) != 0L) {
                        c c2 = new c().k(l2).b(by);
                        StringBuilder stringBuilder = new StringBuilder("Number too large: ");
                        stringBuilder.append(c2.m());
                        throw new NumberFormatException(stringBuilder.toString());
                    }
                    long l3 = l2 << 4 | (long)n5;
                    l2 = l3;
                    continue;
                }
                if (n2 == 0) {
                    StringBuilder stringBuilder = new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
                    stringBuilder.append(Integer.toHexString((int)by));
                    throw new NumberFormatException(stringBuilder.toString());
                }
                bl = true;
                break;
            }
            if (n3 == n4) {
                this.a = p2.b();
                q.a(p2);
                continue;
            }
            p2.b = n3;
        } while (!bl && this.a != null);
        this.b -= (long)n2;
        return l2;
    }

    public final c k(long l2) {
        if (l2 == 0L) {
            return this.b(48);
        }
        int n2 = 1 + Long.numberOfTrailingZeros((long)Long.highestOneBit((long)l2)) / 4;
        p p2 = this.e(n2);
        byte[] arrby = p2.a;
        int n3 = p2.c;
        for (int i2 = -1 + (n2 + p2.c); i2 >= n3; --i2) {
            arrby[i2] = c[(int)(l2 & 15L)];
            l2 >>>= 4;
        }
        p2.c = n2 + p2.c;
        this.b += (long)n2;
        return this;
    }

    @Override
    public final /* synthetic */ d l(long l2) throws IOException {
        return this.k(l2);
    }

    public final f l() {
        return new f(this.o());
    }

    @Override
    public final /* synthetic */ d m(long l2) throws IOException {
        return this.j(l2);
    }

    public final String m() {
        try {
            String string = this.a(this.b, v.a);
            return string;
        }
        catch (EOFException eOFException) {
            throw new AssertionError((Object)eOFException);
        }
    }

    @Override
    public final String n() throws EOFException {
        return this.f(Long.MAX_VALUE);
    }

    public final byte[] o() {
        try {
            byte[] arrby = this.h(this.b);
            return arrby;
        }
        catch (EOFException eOFException) {
            throw new AssertionError((Object)eOFException);
        }
    }

    public final void p() {
        try {
            this.i(this.b);
            return;
        }
        catch (EOFException eOFException) {
            throw new AssertionError((Object)eOFException);
        }
    }

    @Override
    public final long q() {
        return this.a((byte)0, 0L, Long.MAX_VALUE);
    }

    public final c r() {
        p p2;
        c c2 = new c();
        if (this.b == 0L) {
            return c2;
        }
        p p3 = c2.a = this.a.a();
        p p4 = c2.a;
        p4.g = p2 = c2.a;
        p3.f = p2;
        p p5 = this.a;
        while ((p5 = p5.f) != this.a) {
            c2.a.g.a(p5.a());
        }
        c2.b = this.b;
        return c2;
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        p p2 = this.a;
        if (p2 == null) {
            return -1;
        }
        int n2 = Math.min((int)byteBuffer.remaining(), (int)(p2.c - p2.b));
        byteBuffer.put(p2.a, p2.b, n2);
        p2.b = n2 + p2.b;
        this.b -= (long)n2;
        if (p2.b == p2.c) {
            this.a = p2.b();
            q.a(p2);
        }
        return n2;
    }

    public final String toString() {
        if (this.b > Integer.MAX_VALUE) {
            StringBuilder stringBuilder = new StringBuilder("size > Integer.MAX_VALUE: ");
            stringBuilder.append(this.b);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int n2 = (int)this.b;
        f f2 = n2 == 0 ? f.b : new r(this, n2);
        return f2.toString();
    }

    public final int write(ByteBuffer byteBuffer) throws IOException {
        int n2;
        int n3;
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        for (int i2 = n3 = byteBuffer.remaining(); i2 > 0; i2 -= n2) {
            p p2 = this.e(1);
            n2 = Math.min((int)i2, (int)(8192 - p2.c));
            byteBuffer.get(p2.a, p2.c, n2);
            p2.c = n2 + p2.c;
        }
        this.b += (long)n3;
        return n3;
    }
}

