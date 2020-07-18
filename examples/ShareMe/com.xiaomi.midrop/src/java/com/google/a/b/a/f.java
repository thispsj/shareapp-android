/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package com.google.a.b.a;

import com.google.a.b.a.f;
import com.google.a.d.c;
import com.google.a.g;
import com.google.a.i;
import com.google.a.k;
import com.google.a.l;
import com.google.a.n;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class f
extends c {
    private static final Writer h = new Writer(){

        public final void close() throws IOException {
            throw new java.lang.AssertionError();
        }

        public final void flush() throws IOException {
            throw new java.lang.AssertionError();
        }

        public final void write(char[] arrc, int n2, int n3) {
            throw new java.lang.AssertionError();
        }
    };
    private static final n i = new n("closed");
    public final List<i> a = new ArrayList();
    public i b = k.a;
    private String j;

    public f() {
        super(h);
    }

    private void a(i i2) {
        if (this.j != null) {
            if (!(i2 instanceof k) || this.g) {
                ((l)f.super.f()).a(this.j, i2);
            }
            this.j = null;
            return;
        }
        if (this.a.isEmpty()) {
            this.b = i2;
            return;
        }
        i i3 = f.super.f();
        if (i3 instanceof g) {
            ((g)i3).a(i2);
            return;
        }
        throw new IllegalStateException();
    }

    private i f() {
        return (i)this.a.get(-1 + this.a.size());
    }

    @Override
    public final c a() throws IOException {
        g g2 = new g();
        this.a(g2);
        this.a.add((Object)g2);
        return this;
    }

    @Override
    public final c a(long l2) throws IOException {
        f.super.a(new n(l2));
        return this;
    }

    @Override
    public final c a(Boolean bl) throws IOException {
        if (bl == null) {
            return this.e();
        }
        f.super.a(new n(bl));
        return this;
    }

    @Override
    public final c a(Number number) throws IOException {
        double d2;
        if (number == null) {
            return this.e();
        }
        if (!this.e && (Double.isNaN((double)(d2 = number.doubleValue())) || Double.isInfinite((double)d2))) {
            StringBuilder stringBuilder = new StringBuilder("JSON forbids NaN and infinities: ");
            stringBuilder.append((Object)number);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        f.super.a(new n(number));
        return this;
    }

    @Override
    public final c a(String string2) throws IOException {
        if (!this.a.isEmpty() && this.j == null) {
            if (f.super.f() instanceof l) {
                this.j = string2;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override
    public final c a(boolean bl) throws IOException {
        f.super.a(new n(bl));
        return this;
    }

    @Override
    public final c b() throws IOException {
        if (!this.a.isEmpty() && this.j == null) {
            if (this.f() instanceof g) {
                this.a.remove(-1 + this.a.size());
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override
    public final c b(String string2) throws IOException {
        if (string2 == null) {
            return this.e();
        }
        f.super.a(new n(string2));
        return this;
    }

    @Override
    public final c c() throws IOException {
        l l2 = new l();
        this.a(l2);
        this.a.add((Object)l2);
        return this;
    }

    @Override
    public final void close() throws IOException {
        if (!this.a.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.a.add((Object)i);
    }

    @Override
    public final c d() throws IOException {
        if (!this.a.isEmpty() && this.j == null) {
            if (this.f() instanceof l) {
                this.a.remove(-1 + this.a.size());
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override
    public final c e() throws IOException {
        this.a(k.a);
        return this;
    }

    @Override
    public final void flush() throws IOException {
    }
}

