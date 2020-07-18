/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 */
package com.google.a.b.a;

import com.google.a.b.a.i;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.e;
import com.google.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class m<T>
extends r<T> {
    private final e a;
    private final r<T> b;
    private final Type c;

    m(e e2, r<T> r2, Type type) {
        this.a = e2;
        this.b = r2;
        this.c = type;
    }

    @Override
    public final T a(a a2) throws IOException {
        return this.b.a(a2);
    }

    @Override
    public final void a(c c2, T t2) throws IOException {
        r<Object> r2 = this.b;
        Type type = this.c;
        if (t2 != null && (type == Object.class || type instanceof TypeVariable || type instanceof Class)) {
            type = t2.getClass();
        }
        if (type != this.c && (r2 = this.a.a(com.google.a.c.a.a(type))) instanceof i.a && !(this.b instanceof i.a)) {
            r2 = this.b;
        }
        r2.a(c2, t2);
    }
}

