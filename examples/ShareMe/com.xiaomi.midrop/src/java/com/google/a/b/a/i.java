/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.AccessibleObject
 *  java.lang.reflect.Field
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 */
package com.google.a.b.a;

import com.google.a.b.a.m;
import com.google.a.b.c;
import com.google.a.b.d;
import com.google.a.b.j;
import com.google.a.e;
import com.google.a.p;
import com.google.a.r;
import com.google.a.s;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class i
implements s {
    private final c a;
    private final com.google.a.d b;
    private final d c;
    private final com.google.a.b.a.d d;
    private final com.google.a.b.b.b e = com.google.a.b.b.b.a();

    public i(c c2, com.google.a.d d2, d d3, com.google.a.b.a.d d4) {
        this.a = c2;
        this.b = d2;
        this.c = d3;
        this.d = d4;
    }

    private List<String> a(Field field) {
        com.google.a.a.c c2 = (com.google.a.a.c)field.getAnnotation(com.google.a.a.c.class);
        if (c2 == null) {
            return Collections.singletonList((Object)this.b.a(field));
        }
        String string2 = c2.a();
        String[] arrstring = c2.b();
        if (arrstring.length == 0) {
            return Collections.singletonList((Object)string2);
        }
        ArrayList arrayList = new ArrayList(1 + arrstring.length);
        arrayList.add((Object)string2);
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add((Object)arrstring[i2]);
        }
        return arrayList;
    }

    private Map<String, b> a(e e2, com.google.a.c.a<?> a2, Class<?> class_) {
        void var4_4 = this;
        e e3 = e2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (class_.isInterface()) {
            return linkedHashMap;
        }
        Type type = a2.b;
        Object object = class_;
        com.google.a.c.a<?> a3 = a2;
        while (object != Object.class) {
            Field[] arrfield = object.getDeclaredFields();
            int n2 = arrfield.length;
            int n3 = 0;
            while (n3 < n2) {
                Object object2;
                com.google.a.c.a<?> a4;
                Type type2;
                int n4;
                int n5;
                Field[] arrfield2;
                final Field field = arrfield[n3];
                boolean bl = i.super.a(field, true);
                boolean bl2 = i.super.a(field, false);
                if (!bl && !bl2) {
                    n5 = n3;
                    n4 = n2;
                    arrfield2 = arrfield;
                    a4 = a3;
                    type2 = type;
                    object2 = object;
                } else {
                    var4_4.e.a((AccessibleObject)field);
                    Type type3 = com.google.a.b.b.a(a3.b, object, field.getGenericType());
                    List<String> list = i.super.a(field);
                    int n6 = list.size();
                    boolean bl3 = bl;
                    object2 = object;
                    b b2 = null;
                    int n7 = 0;
                    while (n7 < n6) {
                        Field[] arrfield3;
                        Object object3 = list.get(n7);
                        Type type4 = type;
                        String string2 = (String)object3;
                        if (n7 != 0) {
                            arrfield3 = arrfield;
                            bl3 = false;
                        } else {
                            arrfield3 = arrfield;
                        }
                        final com.google.a.c.a<?> a5 = com.google.a.c.a.a(type3);
                        final boolean bl4 = j.a(a5.a);
                        com.google.a.a.b b3 = (com.google.a.a.b)field.getAnnotation(com.google.a.a.b.class);
                        r<?> r2 = b3 != null ? com.google.a.b.a.d.a(var4_4.a, e3, a5, b3) : null;
                        boolean bl5 = r2 != null;
                        if (r2 == null) {
                            r2 = e3.a(a5);
                        }
                        final r<?> r3 = r2;
                        int n8 = n7;
                        int n9 = n6;
                        void var48_28 = var4_4;
                        List<String> list2 = list;
                        Type type5 = type3;
                        boolean bl6 = bl3;
                        Field field2 = field;
                        int n10 = n3;
                        final boolean bl7 = bl5;
                        int n11 = n2;
                        final e e4 = e3;
                        com.google.a.c.a<?> a6 = a3;
                        b b4 = new b(string2, bl6, bl2){

                            @Override
                            final void a(com.google.a.d.a a2, Object object) throws IOException, IllegalAccessException {
                                Object t2 = r3.a(a2);
                                if (t2 != null || !bl4) {
                                    field.set(object, t2);
                                }
                            }

                            @Override
                            final void a(com.google.a.d.c c2, Object object) throws IOException, IllegalAccessException {
                                Object object2 = field.get(object);
                                m<Object> m2 = bl7 ? r3 : new m<Object>(e4, r3, a5.b);
                                ((r)m2).a(c2, object2);
                            }

                            @Override
                            public final boolean a(Object object) throws IOException, IllegalAccessException {
                                if (!this.i) {
                                    return false;
                                }
                                return field.get(object) != object;
                            }
                        };
                        b b5 = linkedHashMap.put((Object)string2, (Object)b4);
                        if (b2 == null) {
                            b2 = b5;
                        }
                        n7 = n8 + 1;
                        a3 = a6;
                        type = type4;
                        arrfield = arrfield3;
                        n2 = n11;
                        n6 = n9;
                        list = list2;
                        type3 = type5;
                        field = field2;
                        n3 = n10;
                        var4_4 = this;
                        e3 = e2;
                    }
                    n5 = n3;
                    n4 = n2;
                    arrfield2 = arrfield;
                    a4 = a3;
                    Type type6 = type;
                    if (b2 != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append((Object)type6);
                        stringBuilder.append(" declares multiple JSON fields named ");
                        stringBuilder.append(b2.h);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    type2 = type6;
                }
                n3 = n5 + 1;
                type = type2;
                a3 = a4;
                object = object2;
                arrfield = arrfield2;
                n2 = n4;
                var4_4 = this;
                e3 = e2;
            }
            com.google.a.c.a<?> a7 = a3;
            Class<?> class_2 = object;
            a3 = com.google.a.c.a.a(com.google.a.b.b.a(a7.b, class_2, class_2.getGenericSuperclass()));
            object = a3.a;
            var4_4 = this;
            e3 = e2;
        }
        return linkedHashMap;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean a(Field field, boolean bl) {
        block6 : {
            d d2;
            block7 : {
                d2 = this.c;
                if (d2.a(field.getType())) return false;
                if (d2.a(bl)) {
                    return false;
                }
                boolean bl2 = false;
                if (bl2) return false;
                if ((d2.c & field.getModifiers()) != 0) return false;
                if (d2.b != -1.0 && !d2.a((com.google.a.a.d)field.getAnnotation(com.google.a.a.d.class), (com.google.a.a.e)field.getAnnotation(com.google.a.a.e.class)) || field.isSynthetic()) break block6;
                if (!d2.e) break block7;
                com.google.a.a.a a2 = (com.google.a.a.a)field.getAnnotation(com.google.a.a.a.class);
                if (a2 == null) return false;
                if (!bl ? !a2.b() : !a2.a()) break block6;
            }
            if (!(!d2.d && d.c(field.getType()) || d.b(field.getType()))) {
                List<com.google.a.a> list = bl ? d2.f : d2.g;
                if (list.isEmpty()) return true;
                new com.google.a.b(field);
                Iterator iterator = list.iterator();
                do {
                    if (!iterator.hasNext()) return true;
                } while (!((com.google.a.a)iterator.next()).a());
            }
        }
        return false;
    }

    @Override
    public final <T> r<T> a(e e2, com.google.a.c.a<T> a2) {
        Class class_ = a2.a;
        if (!Object.class.isAssignableFrom(class_)) {
            return null;
        }
        return new a<T>(this.a.a(a2), i.super.a(e2, a2, class_));
    }

    public static final class a<T>
    extends r<T> {
        private final com.google.a.b.i<T> a;
        private final Map<String, b> b;

        a(com.google.a.b.i<T> i2, Map<String, b> map) {
            this.a = i2;
            this.b = map;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public final T a(com.google.a.d.a a2) throws IOException {
            if (a2.f() == com.google.a.d.b.i) {
                a2.k();
                return null;
            }
            T t2 = this.a.a();
            try {
                a2.c();
                while (a2.e()) {
                    String string2 = a2.h();
                    b b2 = this.b.get((Object)string2);
                    if (b2 != null && b2.j) {
                        b2.a(a2, t2);
                        continue;
                    }
                    a2.o();
                }
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new AssertionError((Object)illegalAccessException);
            }
            catch (IllegalStateException illegalStateException) {
                throw new p(illegalStateException);
            }
            a2.d();
            return t2;
        }

        @Override
        public final void a(com.google.a.d.c c2, T t2) throws IOException {
            if (t2 == null) {
                c2.e();
                return;
            }
            c2.c();
            try {
                for (b b2 : this.b.values()) {
                    if (!b2.a(t2)) continue;
                    c2.a(b2.h);
                    b2.a(c2, t2);
                }
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new AssertionError((Object)illegalAccessException);
            }
            c2.d();
        }
    }

}

