/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Array
 *  java.lang.reflect.GenericArrayType
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 */
package com.google.a.b.a;

import com.google.a.b.a.m;
import com.google.a.b.b;
import com.google.a.d.c;
import com.google.a.e;
import com.google.a.r;
import com.google.a.s;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class a<E>
extends r<Object> {
    public static final s a = new s(){

        @Override
        public final <T> r<T> a(e e2, com.google.a.c.a<T> a2) {
            Type type = a2.b;
            if (!(type instanceof GenericArrayType || type instanceof Class && ((Class)type).isArray())) {
                return null;
            }
            Type type2 = b.d(type);
            return new a(e2, e2.a(com.google.a.c.a.a(type2)), b.b(type2));
        }
    };
    private final Class<E> b;
    private final r<E> c;

    public a(e e2, r<E> r2, Class<E> class_) {
        this.c = new m<E>(e2, r2, (Type)class_);
        this.b = class_;
    }

    @Override
    public final Object a(com.google.a.d.a a2) throws IOException {
        if (a2.f() == com.google.a.d.b.i) {
            a2.k();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        a2.a();
        while (a2.e()) {
            arrayList.add(this.c.a(a2));
        }
        a2.b();
        int n2 = arrayList.size();
        Object object = Array.newInstance(this.b, (int)n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            Array.set((Object)object, (int)i2, (Object)arrayList.get(i2));
        }
        return object;
    }

    @Override
    public final void a(c c2, Object object) throws IOException {
        if (object == null) {
            c2.e();
            return;
        }
        c2.a();
        int n2 = Array.getLength((Object)object);
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2 = Array.get((Object)object, (int)i2);
            this.c.a(c2, object2);
        }
        c2.b();
    }

}

