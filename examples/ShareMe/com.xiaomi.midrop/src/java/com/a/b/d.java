/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.AnnotatedElement
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Modifier
 *  java.lang.reflect.Type
 *  java.util.Collection
 *  java.util.Map
 *  java.util.Set
 *  java.util.TreeMap
 */
package com.a.b;

import com.a.b.c;
import com.a.b.g;
import com.a.b.h;
import com.a.b.l;
import com.a.b.p;
import com.a.b.s;
import com.a.b.v;
import com.a.b.w;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

final class d<T>
extends h<T> {
    public static final h.a a = new h.a(){

        private static void a(s s2, Type type, Map<String, a<?>> map) {
            Class<?> class_ = v.b(type);
            boolean bl = 1.a(class_);
            for (Field field : class_.getDeclaredFields()) {
                int n2 = field.getModifiers();
                boolean bl2 = !Modifier.isStatic((int)n2) && !Modifier.isTransient((int)n2) && (Modifier.isPublic((int)n2) || Modifier.isProtected((int)n2) || !bl);
                if (!bl2) continue;
                h h2 = s2.a(v.a(type, class_, field.getGenericType()), w.a((AnnotatedElement)field));
                field.setAccessible(true);
                g g2 = (g)field.getAnnotation(g.class);
                String string2 = g2 != null ? g2.a() : field.getName();
                a a2 = }
        }
        java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
        
        