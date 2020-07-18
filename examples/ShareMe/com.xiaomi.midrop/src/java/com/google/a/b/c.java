/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.b.c$1
 *  com.google.a.b.c$10
 *  com.google.a.b.c$11
 *  com.google.a.b.c$12
 *  com.google.a.b.c$13
 *  com.google.a.b.c$14
 *  com.google.a.b.c$2
 *  com.google.a.b.c$3
 *  com.google.a.b.c$4
 *  com.google.a.b.c$5
 *  com.google.a.b.c$6
 *  com.google.a.b.c$7
 *  com.google.a.b.c$8
 *  com.google.a.b.c$9
 *  java.lang.Class
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.AccessibleObject
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.Map
 *  java.util.Queue
 *  java.util.Set
 *  java.util.SortedMap
 *  java.util.SortedSet
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.ConcurrentNavigableMap
 */
package com.google.a.b;

import com.google.a.b.b.b;
import com.google.a.b.c;
import com.google.a.b.i;
import com.google.a.c.a;
import com.google.a.f;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

public final class c {
    private final Map<Type, f<?>> a;
    private final b b = b.a();

    public c(Map<Type, f<?>> map) {
        this.a = map;
    }

    private <T> i<T> a(Class<? super T> class_) {
        try {
            Constructor constructor = class_.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible()) {
                this.b.a((AccessibleObject)constructor);
            }
            8 var3_3 = new 8((c)this, constructor);
            return var3_3;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
    }

    public final <T> i<T> a(a<T> a2) {
        Type type = a2.b;
        Class class_ = a2.a;
        f f2 = (f)this.a.get((Object)type);
        if (f2 != null) {
            return new 1((c)this, f2, type);
        }
        f f3 = (f)this.a.get(class_);
        if (f3 != null) {
            return new 7((c)this, f3, type);
        }
        i i2 = c.super.a(class_);
        if (i2 != null) {
            return i2;
        }
        Object object = Collection.class.isAssignableFrom(class_) ? (SortedSet.class.isAssignableFrom(class_) ? new 9((c)this) : (EnumSet.class.isAssignableFrom(class_) ? new 10((c)this, type) : (Set.class.isAssignableFrom(class_) ? new 11((c)this) : (Queue.class.isAssignableFrom(class_) ? new 12((c)this) : new 13((c)this))))) : (Map.class.isAssignableFrom(class_) ? (ConcurrentNavigableMap.class.isAssignableFrom(class_) ? new 14((c)this) : (ConcurrentMap.class.isAssignableFrom(class_) ? new 2((c)this) : (SortedMap.class.isAssignableFrom(class_) ? new 3((c)this) : (type instanceof ParameterizedType && !String.class.isAssignableFrom(a.a((Type)((ParameterizedType)type).getActualTypeArguments()[0]).a) ? new 4((c)this) : new 5((c)this))))) : null);
        if (object != null) {
            return object;
        }
        return new 6((c)this, class_, type);
    }

    public final String toString() {
        return this.a.toString();
    }
}

