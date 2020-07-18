/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.zip.CRC32
 *  java.util.zip.Inflater
 */
package c;

import c.c;
import c.e;
import c.k;
import c.l;
import c.p;
import c.t;
import c.u;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class j
implements t {
    private int a = 0;
    private final e b;
    private final Inflater c;
    private final k d;
    private final CRC32 e = new CRC32();

    public j(t t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.c = new Inflater(true);
        this.b = l.a(t2);
        this.d = new k(this.b, this.c);
    }

    private void a(c c2, long l2, long l3) {
        p p2 = c2.a;
        while (l2 >= (long)(p2.c - p2.b)) {
            long l4 = l2 - (long)(p2.c - p2.b);
            p2 = p2.f;
            l2 = l4;
        }
        while (l3 > 0L) {
            int n2 = (int)(l2 + (long)p2.b);
            int n3 = (int)Math.min((long)(p2.c - n2), (long)l3);
            this.e.update(p2.a, n2, n3);
            long l5 = l3 - (long)n3;
            p2 = p2.f;
            l2 = 0L;
            l3 = l5;
        }
    }

    private static void a(String string2, int n2, int n3) throws IOException {
        if (n3 != n2) {
            Object[] arrobject = new Object[]{string2, n3, n2};
            throw new IOException(String.format((String)"%s: actual 0x%08x != expected 0x%08x", (Object[])arrobject));
        }
    }

    @Override
    public final long a(c c2, long l2) throws IOException {
        if (l2 < 0L) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (l2 == 0L) {
            return 0L;
        }
        if (this.a == 0) {
            this.b.a(10L);
            byte by = this.b.b().c(3L);
            boolean bl = (1 & by >> 1) == 1;
            if (bl) {
                j.super.a(this.b.b(), 0L, 10L);
            }
            j.a("ID1ID2", 8075, this.b.f());
            this.b.i(8L);
            if ((1 & by >> 2) == 1) {
                long l3;
                this.b.a(2L);
                if (bl) {
                    j.super.a(this.b.b(), 0L, 2L);
                }
                short s2 = this.b.b().h();
                e e2 = this.b;
                long l4 = s2;
                e2.a(l4);
                if (bl) {
                    c c3 = this.b.b();
                    l3 = l4;
                    j.super.a(c3, 0L, l4);
                } else {
                    l3 = l4;
                }
                this.b.i(l3);
            }
            if ((1 & by >> 3) == 1) {
                long l5 = this.b.q();
                if (l5 == -1L) {
                    throw new EOFException();
                }
                if (bl) {
                    j.super.a(this.b.b(), 0L, l5 + 1L);
                }
                this.b.i(l5 + 1L);
            }
            if ((1 & by >> 4) == 1) {
                long l6 = this.b.q();
                if (l6 == -1L) {
                    throw new EOFException();
                }
                if (bl) {
                    j.super.a(this.b.b(), 0L, l6 + 1L);
                }
                this.b.i(l6 + 1L);
            }
            if (bl) {
                j.a("FHCRC", this.b.h(), (short)this.e.getValue());
                this.e.reset();
            }
            this.a = 1;
        }
        if (this.a == 1) {
            long l7 = c2.b;
            long l8 = this.d.a(c2, l2);
            if (l8 != -1L) {
                j.super.a(c2, l7, l8);
                return l8;
            }
            this.a = 2;
        }
        if (this.a == 2) {
            j.a("CRC", this.b.i(), (int)this.e.getValue());
            j.a("ISIZE", this.b.i(), (int)this.c.getBytesWritten());
            this.a = 3;
            if (!this.b.c()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override
    public final u a() {
        return this.b.a();
    }

    @Override
    public final void close() throws IOException {
        this.d.close();
    }
}

