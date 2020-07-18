/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 */
package c;

import c.c;
import c.d;
import c.f;
import c.s;
import c.u;
import c.v;
import java.io.IOException;
import java.nio.ByteBuffer;

final class n
implements d {
    public final c a = new c();
    public final s b;
    boolean c;

    n(s s2) {
        if (s2 == null) {
            throw new NullPointerException("sink == null");
        }
        this.b = s2;
    }

    @Override
    public final u a() {
        return this.b.a();
    }

    @Override
    public final void a_(c c2, long l2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a_(c2, l2);
        this.s();
    }

    @Override
    public final c b() {
        return this.a;
    }

    @Override
    public final d b(String string) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(string);
        return this.s();
    }

    @Override
    public final d b(String string, int n2, int n3) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(string, n2, n3);
        return this.s();
    }

    @Override
    public final d c(byte[] arrby) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(arrby);
        return this.s();
    }

    @Override
    public final d c(byte[] arrby, int n2, int n3) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(arrby, n2, n3);
        return this.s();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void close() throws IOException {
        Throwable throwable;
        block7 : {
            if (this.c) {
                return;
            }
            try {
                long l2 = this.a.b LCMP 0L;
                throwable = null;
                if (l2 > 0) {
                    this.b.a_(this.a, this.a.b);
                    throwable = null;
                }
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
            try {
                this.b.close();
            }
            catch (Throwable throwable3) {
                if (throwable != null) break block7;
                throwable = throwable3;
            }
        }
        this.c = true;
        if (throwable != null) {
            v.a(throwable);
        }
    }

    @Override
    public final d d(f f2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(f2);
        return this.s();
    }

    @Override
    public final d f(int n2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.d(n2);
        return this.s();
    }

    @Override
    public final void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b > 0L) {
            this.b.a_(this.a, this.a.b);
        }
        this.b.flush();
    }

    @Override
    public final d g(int n2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(n2);
        return this.s();
    }

    @Override
    public final d h(int n2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(n2);
        return this.s();
    }

    public final boolean isOpen() {
        return !this.c;
    }

    @Override
    public final d l(long l2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.k(l2);
        return this.s();
    }

    @Override
    public final d m(long l2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.j(l2);
        return this.s();
    }

    @Override
    public final d s() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long l2 = this.a.d();
        if (l2 > 0L) {
            this.b.a_(this.a, l2);
        }
        return this;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("buffer(");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        int n2 = this.a.write(byteBuffer);
        this.s();
        return n2;
    }
}

