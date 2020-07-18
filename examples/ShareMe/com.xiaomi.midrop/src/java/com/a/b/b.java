/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Array
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Set
 */
package com.a.b;

import com.a.b.h;
import com.a.b.l;
import com.a.b.p;
import com.a.b.s;
import com.a.b.v;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

final class b
extends h<Object> {
    public static final h.a a = new h.a(){

        @Override
        public final h<?> a(Type type, Set<? extends Annotation> set, s s2) {
            Type type2 = v.e(type);
            if (type2 == null) {
                return null;
            }
            if (!set.isEmpty()) {
                return null;
            }
            return new b(v.b(type2), s2.a(type2)).c();
        }
    };
    private final Class<?> b;
    private final h<Object> c;

    b(Class<?> class_, h<Object> h2) {
        this.b = class_;
        this.c = h2;
    }

    @Override
    public final Object a(l l2) throws IOException {
        ArrayList arrayList = new ArrayList();
        l2.a();
        while (l2.e()) {
            arrayList.add(this.c.a(l2));
        }
        l2.b();
        Object object = Array.newInstance(this.b, (int)arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            Array.set((Object)object, (int)i2, (Object)arrayList.get(i2));
        }
        return object;
    }

    @Override
    public final void a(p p2, Object object) throws IOException {
        p2.a();
        int n2 = Array.getLength((Object)object);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.c.a(p2, Array.get((Object)object, (int)i2));
        }
        p2.b();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(".array()");
        return stringBuilder.toString();
    }

}

