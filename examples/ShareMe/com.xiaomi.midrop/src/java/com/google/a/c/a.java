/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 */
package com.google.a.c;

import com.google.a.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class a<T> {
    public final Class<? super T> a;
    public final Type b;
    final int c;

    protected a() {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        this.b = b.a(((ParameterizedType)type).getActualTypeArguments()[0]);
        this.a = b.b(this.b);
        this.c = this.b.hashCode();
    }

    private a(Type type) {
        this.b = b.a(com.google.a.b.a.a(type));
        this.a = b.b(this.b);
        this.c = this.b.hashCode();
    }

    public static <T> a<T> a(Class<T> class_) {
        return new a<T>((Type)class_);
    }

    public static a<?> a(Type type) {
        return new a<T>(type);
    }

    public final boolean equals(Object object) {
        return object instanceof a && b.a(this.b, ((a)object).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return b.c(this.b);
    }
}

