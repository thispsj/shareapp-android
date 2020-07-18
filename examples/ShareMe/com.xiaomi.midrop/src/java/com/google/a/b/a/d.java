/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.annotation.Annotation
 */
package com.google.a.b.a;

import com.google.a.a.b;
import com.google.a.b.a.l;
import com.google.a.b.c;
import com.google.a.b.i;
import com.google.a.c.a;
import com.google.a.e;
import com.google.a.h;
import com.google.a.o;
import com.google.a.r;
import com.google.a.s;
import java.lang.annotation.Annotation;

public final class d
implements s {
    private final c a;

    public d(c c2) {
        this.a = c2;
    }

    static r<?> a(c c2, e e2, a<?> a2, b b2) {
        r<?> r2;
        Object obj = c2.a(a.a(b2.a())).a();
        if (obj instanceof r) {
            r2 = (r<?>)obj;
        } else if (obj instanceof s) {
            r2 = ((s)obj).a(e2, a2);
        } else {
            boolean bl = obj instanceof o;
            if (!bl && !(obj instanceof h)) {
                StringBuilder stringBuilder = new StringBuilder("Invalid attempt to bind an instance of ");
                stringBuilder.append(obj.getClass().getName());
                stringBuilder.append(" as a @JsonAdapter for ");
                stringBuilder.append(a2.toString());
                stringBuilder.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            o o2 = bl ? (o)obj : null;
            boolean bl2 = obj instanceof h;
            h h2 = null;
            if (bl2) {
                h2 = (h)obj;
            }
            r2 = new l(o2, h2, e2, a2);
        }
        if (r2 != null && b2.b()) {
            r2 = r2.a();
        }
        return r2;
    }

    @Override
    public final <T> r<T> a(e e2, a<T> a2) {
        b b2 = (b)a2.a.getAnnotation(b.class);
        if (b2 == null) {
            return null;
        }
        return d.a(this.a, e2, a2, b2);
    }
}

