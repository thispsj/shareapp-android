/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.a.b;

import c.d;
import com.a.b.p;
import java.io.IOException;

final class o
extends p {
    private static final String[] i = new String[128];
    private final d j;
    private String k = ":";
    private String l;

    static {
        for (int i2 = 0; i2 <= 31; ++i2) {
            String[] arrstring = i;
            Object[] arrobject = new Object[]{i2};
            arrstring[i2] = String.format((String)"\\u%04x", (Object[])arrobject);
        }
        o.i[34] = "\\\"";
        o.i[92] = "\\\\";
        o.i[9] = "\\t";
        o.i[8] = "\\b";
        o.i[10] = "\\n";
        o.i[13] = "\\r";
        o.i[12] = "\\f";
    }

    o(d d2) {
        if (d2 == null) {
            throw new NullPointerException("sink == null");
        }
        this.j = d2;
        this.a(6);
    }

    private p a(int n2, int n3, String string2) throws IOException {
        int n4 = this.f();
        if (n4 != n3 && n4 != n2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.l != null) {
            StringBuilder stringBuilder = new StringBuilder("Dangling name: ");
            stringBuilder.append(this.l);
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.a = -1 + this.a;
        this.c[this.a] = null;
        int[] arrn = this.d;
        int n5 = -1 + this.a;
        arrn[n5] = 1 + arrn[n5];
        if (n4 == n3) {
            o.super.i();
        }
        this.j.b(string2);
        return this;
    }

    private p a(int n2, String string2) throws IOException {
        o.super.j();
        this.a(n2);
        this.d[-1 + this.a] = 0;
        this.j.b(string2);
        return this;
    }

    static void a(d d2, String string2) throws IOException {
        String[] arrstring = i;
        d2.h(34);
        int n2 = string2.length();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string3;
            char c2 = string2.charAt(i2);
            if (c2 < '') {
                string3 = arrstring[c2];
                if (string3 == null) {
                    continue;
                }
            } else if (c2 == '\u2028') {
                string3 = "\\u2028";
            } else {
                if (c2 != '\u2029') continue;
                string3 = "\\u2029";
            }
            if (n3 < i2) {
                d2.b(string2, n3, i2);
            }
            d2.b(string3);
            n3 = i2 + 1;
        }
        if (n3 < n2) {
            d2.b(string2, n3, n2);
        }
        d2.h(34);
    }

    private void h() throws IOException {
        if (this.l != null) {
            int n2 = this.f();
            if (n2 == 5) {
                this.j.h(44);
            } else if (n2 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            this.i();
            this.b(4);
            o.a(this.j, this.l);
            this.l = null;
        }
    }

    private void i() throws IOException {
        if (this.e == null) {
            return;
        }
        this.j.h(10);
        int n2 = this.a;
        for (int i2 = 1; i2 < n2; ++i2) {
            this.j.b(this.e);
        }
    }

    private void j() throws IOException {
        switch (this.f()) {
            default: {
                throw new IllegalStateException("Nesting problem.");
            }
            case 7: {
                if (!this.f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            case 6: {
                this.b(7);
                return;
            }
            case 4: {
                this.j.b(this.k);
                this.b(5);
                return;
            }
            case 2: {
                this.j.h(44);
                this.i();
                return;
            }
            case 1: 
        }
        this.b(2);
        this.i();
    }

    @Override
    public final p a() throws IOException {
        this.h();
        return this.a(1, "[");
    }

    @Override
    public final p a(double d2) throws IOException {
        if (!this.f && (Double.isNaN((double)d2) || Double.isInfinite((double)d2))) {
            StringBuilder stringBuilder = new StringBuilder("Numeric values must be finite, but was ");
            stringBuilder.append(d2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.h) {
            return this.a(Double.toString((double)d2));
        }
        o.super.h();
        o.super.j();
        this.j.b(Double.toString((double)d2));
        int[] arrn = this.d;
        int n2 = -1 + this.a;
        arrn[n2] = 1 + arrn[n2];
        return this;
    }

    @Override
    public final p a(long l2) throws IOException {
        if (this.h) {
            return this.a(Long.toString((long)l2));
        }
        o.super.h();
        o.super.j();
        this.j.b(Long.toString((long)l2));
        int[] arrn = this.d;
        int n2 = -1 + this.a;
        arrn[n2] = 1 + arrn[n2];
        return this;
    }

    @Override
    public final p a(Number number) throws IOException {
        if (number == null) {
            return this.e();
        }
        String string2 = number.toString();
        if (!this.f && (string2.equals((Object)"-Infinity") || string2.equals((Object)"Infinity") || string2.equals((Object)"NaN"))) {
            StringBuilder stringBuilder = new StringBuilder("Numeric values must be finite, but was ");
            stringBuilder.append((Object)number);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.h) {
            return this.a(string2);
        }
        o.super.h();
        o.super.j();
        this.j.b(string2);
        int[] arrn = this.d;
        int n2 = -1 + this.a;
        arrn[n2] = 1 + arrn[n2];
        return this;
    }

    @Override
    public final p a(String string2) throws IOException {
        if (string2 == null) {
            throw new NullPointerException("name == null");
        }
        if (this.a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        if (this.l != null) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.l = string2;
        this.c[-1 + this.a] = string2;
        this.h = false;
        return this;
    }

    @Override
    public final p a(boolean bl) throws IOException {
        o.super.h();
        o.super.j();
        d d2 = this.j;
        String string2 = bl ? "true" : "false";
        d2.b(string2);
        int[] arrn = this.d;
        int n2 = -1 + this.a;
        arrn[n2] = 1 + arrn[n2];
        return this;
    }

    @Override
    public final p b() throws IOException {
        return this.a(1, 2, "]");
    }

    @Override
    public final p b(String string2) throws IOException {
        if (string2 == null) {
            return this.e();
        }
        if (this.h) {
            return this.a(string2);
        }
        o.super.h();
        o.super.j();
        o.a(this.j, string2);
        int[] arrn = this.d;
        int n2 = -1 + this.a;
        arrn[n2] = 1 + arrn[n2];
        return this;
    }

    @Override
    public final p c() throws IOException {
        this.h();
        return this.a(3, "{");
    }

    public final void close() throws IOException {
        this.j.close();
        int n2 = this.a;
        if (n2 <= 1 && (n2 != 1 || this.b[n2 - 1] == 7)) {
            this.a = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override
    public final p d() throws IOException {
        this.h = false;
        return this.a(3, 5, "}");
    }

    @Override
    public final p e() throws IOException {
        if (this.l != null) {
            if (this.g) {
                this.h();
            } else {
                this.l = null;
                return this;
            }
        }
        this.j();
        this.j.b("null");
        int[] arrn = this.d;
        int n2 = -1 + this.a;
        arrn[n2] = 1 + arrn[n2];
        return this;
    }

    public final void flush() throws IOException {
        if (this.a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.j.flush();
    }
}

