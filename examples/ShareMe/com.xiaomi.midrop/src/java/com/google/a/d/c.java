/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.google.a.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class c
implements Closeable,
Flushable {
    private static final String[] a = new String[128];
    private static final String[] b;
    public String c;
    public String d;
    public boolean e;
    public boolean f;
    public boolean g;
    private final Writer h;
    private int[] i = new int[32];
    private int j = 0;
    private String k;

    static {
        for (int i2 = 0; i2 <= 31; ++i2) {
            String[] arrstring = a;
            Object[] arrobject = new Object[]{i2};
            arrstring[i2] = String.format((String)"\\u%04x", (Object[])arrobject);
        }
        c.a[34] = "\\\"";
        c.a[92] = "\\\\";
        c.a[9] = "\\t";
        c.a[8] = "\\b";
        c.a[10] = "\\n";
        c.a[13] = "\\r";
        c.a[12] = "\\f";
        String[] arrstring = (String[])a.clone();
        b = arrstring;
        arrstring[60] = "\\u003c";
        c.b[62] = "\\u003e";
        c.b[38] = "\\u0026";
        c.b[61] = "\\u003d";
        c.b[39] = "\\u0027";
    }

    public c(Writer writer) {
        c.super.a(6);
        this.d = ":";
        this.g = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.h = writer;
    }

    private c a(int n2, int n3, String string2) throws IOException {
        int n4 = c.super.f();
        if (n4 != n3 && n4 != n2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.k != null) {
            StringBuilder stringBuilder = new StringBuilder("Dangling name: ");
            stringBuilder.append(this.k);
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.j = -1 + this.j;
        if (n4 == n3) {
            c.super.h();
        }
        this.h.write(string2);
        return this;
    }

    private c a(int n2, String string2) throws IOException {
        c.super.i();
        c.super.a(n2);
        this.h.write(string2);
        return this;
    }

    private void a(int n2) {
        if (this.j == this.i.length) {
            int[] arrn = new int[2 * this.j];
            System.arraycopy((Object)this.i, (int)0, (Object)arrn, (int)0, (int)this.j);
            this.i = arrn;
        }
        int[] arrn = this.i;
        int n3 = this.j;
        this.j = n3 + 1;
        arrn[n3] = n2;
    }

    private void b(int n2) {
        this.i[-1 + this.j] = n2;
    }

    private void c(String string2) throws IOException {
        String[] arrstring = this.f ? b : a;
        this.h.write("\"");
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
                this.h.write(string2, n3, i2 - n3);
            }
            this.h.write(string3);
            n3 = i2 + 1;
        }
        if (n3 < n2) {
            this.h.write(string2, n3, n2 - n3);
        }
        this.h.write("\"");
    }

    private int f() {
        if (this.j == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.i[-1 + this.j];
    }

    private void g() throws IOException {
        if (this.k != null) {
            int n2 = this.f();
            if (n2 == 5) {
                this.h.write(44);
            } else if (n2 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            this.h();
            this.b(4);
            this.c(this.k);
            this.k = null;
        }
    }

    private void h() throws IOException {
        if (this.c == null) {
            return;
        }
        this.h.write("\n");
        int n2 = this.j;
        for (int i2 = 1; i2 < n2; ++i2) {
            this.h.write(this.c);
        }
    }

    private void i() throws IOException {
        switch (this.f()) {
            default: {
                throw new IllegalStateException("Nesting problem.");
            }
            case 7: {
                if (!this.e) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            case 6: {
                this.b(7);
                return;
            }
            case 4: {
                this.h.append((CharSequence)this.d);
                this.b(5);
                return;
            }
            case 2: {
                this.h.append(',');
                this.h();
                return;
            }
            case 1: 
        }
        this.b(2);
        this.h();
    }

    public c a() throws IOException {
        this.g();
        return this.a(1, "[");
    }

    public c a(long l2) throws IOException {
        c.super.g();
        c.super.i();
        this.h.write(Long.toString((long)l2));
        return this;
    }

    public c a(Boolean bl) throws IOException {
        if (bl == null) {
            return this.e();
        }
        c.super.g();
        c.super.i();
        Writer writer = this.h;
        String string2 = bl != false ? "true" : "false";
        writer.write(string2);
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return this.e();
        }
        c.super.g();
        String string2 = number.toString();
        if (!this.e && (string2.equals((Object)"-Infinity") || string2.equals((Object)"Infinity") || string2.equals((Object)"NaN"))) {
            StringBuilder stringBuilder = new StringBuilder("Numeric values must be finite, but was ");
            stringBuilder.append((Object)number);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        c.super.i();
        this.h.append((CharSequence)string2);
        return this;
    }

    public c a(String string2) throws IOException {
        if (string2 == null) {
            throw new NullPointerException("name == null");
        }
        if (this.k != null) {
            throw new IllegalStateException();
        }
        if (this.j == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.k = string2;
        return this;
    }

    public c a(boolean bl) throws IOException {
        c.super.g();
        c.super.i();
        Writer writer = this.h;
        String string2 = bl ? "true" : "false";
        writer.write(string2);
        return this;
    }

    public c b() throws IOException {
        return this.a(1, 2, "]");
    }

    public c b(String string2) throws IOException {
        if (string2 == null) {
            return this.e();
        }
        c.super.g();
        c.super.i();
        c.super.c(string2);
        return this;
    }

    public c c() throws IOException {
        this.g();
        return this.a(3, "{");
    }

    public void close() throws IOException {
        this.h.close();
        int n2 = this.j;
        if (n2 <= 1 && (n2 != 1 || this.i[n2 - 1] == 7)) {
            this.j = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public c d() throws IOException {
        return this.a(3, 5, "}");
    }

    public c e() throws IOException {
        if (this.k != null) {
            if (this.g) {
                this.g();
            } else {
                this.k = null;
                return this;
            }
        }
        this.i();
        this.h.write("null");
        return this;
    }

    public void flush() throws IOException {
        if (this.j == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.h.flush();
    }
}

