/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.AnnotatedElement
 *  java.util.Collections
 *  java.util.LinkedHashSet
 *  java.util.Set
 */
package com.a.b;

import com.a.b.k;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

final class w {
    public static final Set<Annotation> a = Collections.emptySet();

    public static Set<? extends Annotation> a(AnnotatedElement annotatedElement) {
        return w.a(annotatedElement.getAnnotations());
    }

    public static Set<? extends Annotation> a(Annotation[] arrannotation) {
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
        return a;
    }

    public static boolean b(Annotation[] arrannotation) {
        int n2 = arrannotation.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!arrannotation[i2].annotationType().getSimpleName().equals((Object)"Nullable")) continue;
            return true;
        }
        return false;
    }
}

