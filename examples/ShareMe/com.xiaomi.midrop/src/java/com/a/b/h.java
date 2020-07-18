/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.a.b.h$1
 *  com.a.b.h$2
 *  com.a.b.h$3
 *  com.a.b.h$4
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 *  java.util.Set
 */
package com.a.b;

import com.a.b.h;
import com.a.b.l;
import com.a.b.p;
import com.a.b.s;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

public abstract class h<T> {
    public abstract T a(l var1) throws IOException;

    public abstract void a(p var1, T var2) throws IOException;

    public final h<T> b() {
        return new 1(this, this);
    }

    public final h<T> c() {
        return new 2(this, this);
    }

    public final h<T> d() {
        return new 3(this, this);
    }

    public final h<T> e() {
        return new 4(this, this);
    }

    public static interface a {
        public h<?> a(Type var1, Set<? extends Annotation> var2, s var3);
    }

}

