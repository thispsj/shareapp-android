/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.google.a.b.a;

import com.google.a.b.a.e;
import com.google.a.b.h;
import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.g;
import com.google.a.i;
import com.google.a.k;
import com.google.a.l;
import com.google.a.n;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class e
extends a {
    private static final Reader c = new Reader(){

        public final void close() throws IOException {
            throw new AssertionError();
        }

        public final int read(char[] arrc, int n2, int n3) throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object d = new Object();
    private Object[] e;
    private int f;
    private String[] g;
    private int[] h;

    private Object s() {
        int n2;
        Object[] arrobject = this.e;
        this.f = n2 = -1 + this.f;
        Object object = arrobject[n2];
        this.e[this.f] = null;
        return object;
    }

    private String t() {
        StringBuilder stringBuilder = new StringBuilder(" at path ");
        stringBuilder.append(this.p());
        return stringBuilder.toString();
    }

    @Override
    public final void a() throws IOException {
        this.a(b.a);
        this.a(((g)this.g()).iterator());
        this.h[-1 + this.f] = 0;
    }

    public final void a(b b2) throws IOException {
        if (this.f() != b2) {
            StringBuilder stringBuilder = new StringBuilder("Expected ");
            stringBuilder.append((Object)b2);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)this.f());
            stringBuilder.append(e.super.t());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public final void a(Object object) {
        if (this.f == this.e.length) {
            Object[] arrobject = new Object[2 * this.f];
            int[] arrn = new int[2 * this.f];
            String[] arrstring = new String[2 * this.f];
            System.arraycopy((Object)this.e, (int)0, (Object)arrobject, (int)0, (int)this.f);
            System.arraycopy((Object)this.h, (int)0, (Object)arrn, (int)0, (int)this.f);
            System.arraycopy((Object)this.g, (int)0, (Object)arrstring, (int)0, (int)this.f);
            this.e = arrobject;
            this.h = arrn;
            this.g = arrstring;
        }
        Object[] arrobject = this.e;
        int n2 = this.f;
        this.f = n2 + 1;
        arrobject[n2] = object;
    }

    @Override
    public final void b() throws IOException {
        this.a(b.b);
        this.s();
        this.s();
        if (this.f > 0) {
            int[] arrn = this.h;
            int n2 = -1 + this.f;
            arrn[n2] = 1 + arrn[n2];
        }
    }

    @Override
    public final void c() throws IOException {
        this.a(b.c);
        this.a((Object)((l)this.g()).a.entrySet().iterator());
    }

    @Override
    public final void close() throws IOException {
        Object[] arrobject = new Object[]{d};
        this.e = arrobject;
        this.f = 1;
    }

    @Override
    public final void d() throws IOException {
        this.a(b.d);
        this.s();
        this.s();
        if (this.f > 0) {
            int[] arrn = this.h;
            int n2 = -1 + this.f;
            arrn[n2] = 1 + arrn[n2];
        }
    }

    @Override
    public final boolean e() throws IOException {
        b b2 = this.f();
        return b2 != b.d && b2 != b.b;
    }

    @Override
    public final b f() throws IOException {
        Object object;
        block12 : {
            boolean bl;
            do {
                if (this.f == 0) {
                    return b.j;
                }
                object = this.g();
                if (!(object instanceof Iterator)) break block12;
                bl = this.e[-2 + this.f] instanceof l;
                Iterator iterator = (Iterator)object;
                if (!iterator.hasNext()) break;
                if (bl) {
                    return b.e;
                }
                this.a(iterator.next());
            } while (true);
            if (bl) {
                return b.d;
            }
            return b.b;
        }
        if (object instanceof l) {
            return b.c;
        }
        if (object instanceof g) {
            return b.a;
        }
        if (object instanceof n) {
            n n2 = (n)object;
            if (n2.a instanceof String) {
                return b.f;
            }
            if (n2.a instanceof Boolean) {
                return b.h;
            }
            if (n2.a instanceof Number) {
                return b.g;
            }
            throw new AssertionError();
        }
        if (object instanceof k) {
            return b.i;
        }
        if (object == d) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new AssertionError();
    }

    public final Object g() {
        return this.e[-1 + this.f];
    }

    @Override
    public final String h() throws IOException {
        String string2;
        this.a(b.e);
        Map.Entry entry = (Map.Entry)((Iterator)this.g()).next();
        this.g[-1 + this.f] = string2 = (String)entry.getKey();
        this.a(entry.getValue());
        return string2;
    }

    @Override
    public final String i() throws IOException {
        b b2 = this.f();
        if (b2 != b.f && b2 != b.g) {
            StringBuilder stringBuilder = new StringBuilder("Expected ");
            stringBuilder.append((Object)b.f);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)b2);
            stringBuilder.append(this.t());
            throw new IllegalStateException(stringBuilder.toString());
        }
        String string2 = ((n)this.s()).b();
        if (this.f > 0) {
            int[] arrn = this.h;
            int n2 = -1 + this.f;
            arrn[n2] = 1 + arrn[n2];
        }
        return string2;
    }

    @Override
    public final boolean j() throws IOException {
        this.a(b.h);
        boolean bl = ((n)this.s()).f();
        if (this.f > 0) {
            int[] arrn = this.h;
            int n2 = -1 + this.f;
            arrn[n2] = 1 + arrn[n2];
        }
        return bl;
    }

    @Override
    public final void k() throws IOException {
        this.a(b.i);
        this.s();
        if (this.f > 0) {
            int[] arrn = this.h;
            int n2 = -1 + this.f;
            arrn[n2] = 1 + arrn[n2];
        }
    }

    @Override
    public final double l() throws IOException {
        b b2 = this.f();
        if (b2 != b.g && b2 != b.f) {
            StringBuilder stringBuilder = new StringBuilder("Expected ");
            stringBuilder.append((Object)b.g);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)b2);
            stringBuilder.append(this.t());
            throw new IllegalStateException(stringBuilder.toString());
        }
        double d2 = ((n)this.g()).c();
        if (!this.a && (Double.isNaN((double)d2) || Double.isInfinite((double)d2))) {
            StringBuilder stringBuilder = new StringBuilder("JSON forbids NaN and infinities: ");
            stringBuilder.append(d2);
            throw new NumberFormatException(stringBuilder.toString());
        }
        this.s();
        if (this.f > 0) {
            int[] arrn = this.h;
            int n2 = -1 + this.f;
            arrn[n2] = 1 + arrn[n2];
        }
        return d2;
    }

    @Override
    public final long m() throws IOException {
        b b2 = this.f();
        if (b2 != b.g && b2 != b.f) {
            StringBuilder stringBuilder = new StringBuilder("Expected ");
            stringBuilder.append((Object)b.g);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)b2);
            stringBuilder.append(this.t());
            throw new IllegalStateException(stringBuilder.toString());
        }
        long l2 = ((n)this.g()).d();
        this.s();
        if (this.f > 0) {
            int[] arrn = this.h;
            int n2 = -1 + this.f;
            arrn[n2] = 1 + arrn[n2];
        }
        return l2;
    }

    @Override
    public final int n() throws IOException {
        b b2 = this.f();
        if (b2 != b.g && b2 != b.f) {
            StringBuilder stringBuilder = new StringBuilder("Expected ");
            stringBuilder.append((Object)b.g);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)b2);
            stringBuilder.append(this.t());
            throw new IllegalStateException(stringBuilder.toString());
        }
        int n2 = ((n)this.g()).e();
        this.s();
        if (this.f > 0) {
            int[] arrn = this.h;
            int n3 = -1 + this.f;
            arrn[n3] = 1 + arrn[n3];
        }
        return n2;
    }

    @Override
    public final void o() throws IOException {
        if (this.f() == b.e) {
            this.h();
            this.g[-2 + this.f] = "null";
        } else {
            this.s();
            if (this.f > 0) {
                this.g[-1 + this.f] = "null";
            }
        }
        if (this.f > 0) {
            int[] arrn = this.h;
            int n2 = -1 + this.f;
            arrn[n2] = 1 + arrn[n2];
        }
    }

    @Override
    public final String p() {
        StringBuilder stringBuilder = new StringBuilder("$");
        for (int i2 = 0; i2 < this.f; ++i2) {
            Object[] arrobject;
            if (this.e[i2] instanceof g) {
                Object[] arrobject2 = this.e;
                if (!(arrobject2[++i2] instanceof Iterator)) continue;
                stringBuilder.append('[');
                stringBuilder.append(this.h[i2]);
                stringBuilder.append(']');
                continue;
            }
            if (!(this.e[i2] instanceof l) || !((arrobject = this.e)[++i2] instanceof Iterator)) continue;
            stringBuilder.append('.');
            if (this.g[i2] == null) continue;
            stringBuilder.append(this.g[i2]);
        }
        return stringBuilder.toString();
    }

    @Override
    public final String toString() {
        return this.getClass().getSimpleName();
    }
}

