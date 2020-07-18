/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d
 *  com.a.b.o
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.a.b;

import c.d;
import com.a.b.i;
import com.a.b.m;
import com.a.b.o;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract class p
implements Closeable,
Flushable {
    int a = 0;
    final int[] b = new int[32];
    final String[] c = new String[32];
    final int[] d = new int[32];
    String e;
    boolean f;
    boolean g;
    boolean h;

    p() {
    }

    public static p a(d d2) {
        return new o(d2);
    }

    public abstract p a() throws IOException;

    public abstract p a(double var1) throws IOException;

    public abstract p a(long var1) throws IOException;

    public abstract p a(Number var1) throws IOException;

    public abstract p a(String var1) throws IOException;

    public abstract p a(boolean var1) throws IOException;

    final void a(int n2) {
        if (this.a == this.b.length) {
            StringBuilder stringBuilder = new StringBuilder("Nesting too deep at ");
            stringBuilder.append(this.g());
            stringBuilder.append(": circular reference?");
            throw new i(stringBuilder.toString());
        }
        int[] arrn = this.b;
        int n3 = this.a;
        this.a = n3 + 1;
        arrn[n3] = n2;
    }

    public abstract p b() throws IOException;

    public abstract p b(String var1) throws IOException;

    final void b(int n2) {
        this.b[-1 + this.a] = n2;
    }

    public abstract p c() throws IOException;

    public abstract p d() throws IOException;

    public abstract p e() throws IOException;

    final int f() {
        if (this.a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.b[-1 + this.a];
    }

    public final String g() {
        return m.a(this.a, this.b, this.c, this.d);
    }
}

