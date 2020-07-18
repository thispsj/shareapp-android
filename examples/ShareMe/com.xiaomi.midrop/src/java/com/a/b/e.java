/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.a.b.e$2
 *  com.a.b.e$3
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 *  java.util.Collection
 *  java.util.List
 *  java.util.Set
 */
package com.a.b;

import com.a.b.e;
import com.a.b.h;
import com.a.b.l;
import com.a.b.p;
import com.a.b.s;
import com.a.b.v;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Set;

abstract class e<C extends Collection<T>, T>
extends h<C> {
    public static final h.a a = new h.a(){

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public final h<?> a(Type type, Set<? extends Annotation> set, s s2) {
            h h2;
            Class<?> class_ = v.b(type);
            if (!set.isEmpty()) {
                return null;
            }
            if (class_ != List.class && class_ != Collection.class) {
                if (class_ != Set.class) return null;
                h2 = e.b(type, s2);
                do {
                    return h2.c();
                    break;
                } while (true);
            }
            h2 = e.a(type, s2);
            return h2.c();
        }
    };
    private final h<T> b;

    private e(h<T> h2) {
        this.b = h2;
    }

    /* synthetic */ e(h h2, byte by) {
        super(h2);
    }

    static <T> h<Collection<T>> a(Type type, s s2) {
        return new 2(s2.a(v.a(type, Collection.class)));
    }

    static <T> h<Set<T>> b(Type type, s s2) {
        return new 3(s2.a(v.a(type, Collection.class)));
    }

    @Override
    public /* synthetic */ Object a(l l2) throws IOException {
        return this.b(l2);
    }

    abstract C a();

    @Override
    public final void a(p p2, C c2) throws IOException {
        p2.a();
        for (Object object : c2) {
            this.b.a(p2, object);
        }
        p2.b();
    }

    public final C b(l l2) throws IOException {
        C c2 = this.a();
        l2.a();
        while (l2.e()) {
            c2.add(this.b.a(l2));
        }
        l2.b();
        return c2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append(".collection()");
        return stringBuilder.toString();
    }

}

