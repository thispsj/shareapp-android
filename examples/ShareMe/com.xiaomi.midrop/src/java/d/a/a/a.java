/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 *  java.util.Collections
 *  java.util.LinkedHashSet
 *  java.util.Set
 *  okhttp3.ab
 *  okhttp3.ad
 */
package d.a.a;

import com.a.b.h;
import com.a.b.k;
import com.a.b.s;
import d.a.a.b;
import d.a.a.c;
import d.e;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.ab;
import okhttp3.ad;

public final class a
extends e.a {
    private final s a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    public a(s s2) {
        this.a = s2;
        this.b = false;
        this.c = false;
        this.d = false;
    }

    private static Set<? extends Annotation> a(Annotation[] arrannotation) {
        int n2 = arrannotation.length;
        LinkedHashSet linkedHashSet = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            Annotation annotation = arrannotation[i2];
            if (!annotation.annotationType().isAnnotationPresent(k.class)) continue;
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
            }
            linkedHashSet.add((Object)annotation);
        }
        if (linkedHashSet != null) {
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return Collections.emptySet();
    }

    @Override
    public final e<ad, ?> a(Type type, Annotation[] arrannotation) {
        h h2 = this.a.a(type, a.a(arrannotation));
        if (this.b) {
            h2 = h2.d();
        }
        if (this.c) {
            h2 = h2.e();
        }
        if (this.d) {
            h2 = h2.b();
        }
        return new c(h2);
    }

    @Override
    public final e<?, ab> b(Type type, Annotation[] arrannotation) {
        h h2 = this.a.a(type, a.a(arrannotation));
        if (this.b) {
            h2 = h2.d();
        }
        if (this.c) {
            h2 = h2.e();
        }
        if (this.d) {
            h2 = h2.b();
        }
        return new b(h2);
    }
}

