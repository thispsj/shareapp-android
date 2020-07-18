/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Type
 *  java.util.Collection
 */
package com.google.a.b.a;

import com.google.a.b.a.m;
import com.google.a.b.c;
import com.google.a.b.i;
import com.google.a.e;
import com.google.a.r;
import com.google.a.s;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class b
implements s {
    private final c a;

    public b(c c2) {
        this.a = c2;
    }

    @Override
    public final <T> r<T> a(e e2, com.google.a.c.a<T> a2) {
        Type type = a2.b;
        Class class_ = a2.a;
        if (!Collection.class.isAssignableFrom(class_)) {
            return null;
        }
        Type type2 = com.google.a.b.b.a(type, class_);
        return new a(e2, type2, e2.a(com.google.a.c.a.a(type2)), this.a.a(a2));
    }

    private static final class a<E>
    extends r<Collection<E>> {
        private final r<E> a;
        private final i<? extends Collection<E>> b;

        public a(e e2, Type type, r<E> r2, i<? extends Collection<E>> i2) {
            this.a = new m<E>(e2, r2, type);
            this.b = i2;
        }

        @Override
        public final /* synthetic */ Object a(com.google.a.d.a a2) throws IOException {
            if (a2.f() == com.google.a.d.b.i) {
                a2.k();
                return null;
            }
            Collection<E> collection = this.b.a();
            a2.a();
            while (a2.e()) {
                collection.add(this.a.a(a2));
            }
            a2.b();
            return collection;
        }

        @Override
        public final /* synthetic */ void a(com.google.a.d.c c2, Object object) throws IOException {
            Collection collection = (Collection)object;
            if (collection == null) {
                c2.e();
                return;
            }
            c2.a();
            for (Object object2 : collection) {
                this.a.a(c2, object2);
            }
            c2.b();
        }
    }

}

