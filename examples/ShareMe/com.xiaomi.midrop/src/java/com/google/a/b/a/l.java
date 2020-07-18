/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
package com.google.a.b.a;

import com.google.a.d.c;
import com.google.a.e;
import com.google.a.h;
import com.google.a.i;
import com.google.a.k;
import com.google.a.o;
import com.google.a.r;
import com.google.a.s;
import java.io.IOException;

public final class l<T>
extends r<T> {
    final e a;
    private final o<T> b;
    private final h<T> c;
    private final com.google.a.c.a<T> d;
    private final s e;
    private final l<T> f;
    private r<T> g;

    public l(o<T> o2, h<T> h2, e e2, com.google.a.c.a<T> a2) {
        this.f = new Object((l)this, 0){
            final /* synthetic */ l a;
            {
                this.a = l2;
            }
        };
        this.b = o2;
        this.c = h2;
        this.a = e2;
        this.d = a2;
        this.e = null;
    }

    private r<T> b() {
        r<T> r2 = this.g;
        if (r2 != null) {
            return r2;
        }
        r<T> r3 = this.a.a(this.e, this.d);
        this.g = r3;
        return r3;
    }

    @Override
    public final T a(com.google.a.d.a a2) throws IOException {
        if (this.c == null) {
            return l.super.b().a(a2);
        }
        if (com.google.a.b.k.a(a2) instanceof k) {
            return null;
        }
        return this.c.a();
    }

    @Override
    public final void a(c c2, T t2) throws IOException {
        if (this.b == null) {
            l.super.b().a(c2, t2);
            return;
        }
        if (t2 == null) {
            c2.e();
            return;
        }
        com.google.a.b.k.a(this.b.a(), c2);
    }

}

