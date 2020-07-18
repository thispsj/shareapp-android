/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.a.b;

import com.a.b.h;
import com.a.b.i;
import com.a.b.l;
import com.a.b.p;
import com.a.b.q;
import com.a.b.s;
import com.a.b.v;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

final class r<K, V>
extends h<Map<K, V>> {
    public static final h.a a = new h.a(){

        @Override
        public final h<?> a(Type type, Set<? extends Annotation> set, s s2) {
            if (!set.isEmpty()) {
                return null;
            }
            Class<?> class_ = v.b(type);
            if (class_ != Map.class) {
                return null;
            }
            Type[] arrtype = v.b(type, class_);
            return new r(s2, arrtype[0], arrtype[1]).c();
        }
    };
    private final h<K> b;
    private final h<V> c;

    public r(s s2, Type type, Type type2) {
        this.b = s2.a(type);
        this.c = s2.a(type2);
    }

    @Override
    public final /* synthetic */ Object a(l l2) throws IOException {
        q<K, V> q2 = new q<K, V>();
        l2.c();
        while (l2.e()) {
            V v2;
            l2.q();
            K k2 = this.b.a(l2);
            Object v3 = q2.put(k2, v2 = this.c.a(l2));
            if (v3 == null) continue;
            StringBuilder stringBuilder = new StringBuilder("Map key '");
            stringBuilder.append(k2);
            stringBuilder.append("' has multiple values at path ");
            stringBuilder.append(l2.p());
            stringBuilder.append(": ");
            stringBuilder.append(v3);
            stringBuilder.append(" and ");
            stringBuilder.append(v2);
            throw new i(stringBuilder.toString());
        }
        l2.d();
        return q2;
    }

    @Override
    public final /* synthetic */ void a(p p2, Object object) throws IOException {
        Map map = (Map)object;
        p2.c();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() == null) {
                StringBuilder stringBuilder = new StringBuilder("Map key is null at ");
                stringBuilder.append(p2.g());
                throw new i(stringBuilder.toString());
            }
            int n2 = p2.f();
            if (n2 != 5 && n2 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            p2.h = true;
            this.b.a(p2, entry.getKey());
            this.c.a(p2, entry.getValue());
        }
        p2.d();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("JsonAdapter(");
        stringBuilder.append(this.b);
        stringBuilder.append("=");
        stringBuilder.append(this.c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

}

