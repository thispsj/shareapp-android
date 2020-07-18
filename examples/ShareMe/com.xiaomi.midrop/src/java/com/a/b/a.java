/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.util.List
 *  java.util.Set
 */
package com.a.b;

import com.a.b.h;
import com.a.b.i;
import com.a.b.l;
import com.a.b.p;
import com.a.b.s;
import com.a.b.v;
import com.a.b.w;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

final class a
implements h.a {
    private final List<a> a;
    private final List<a> b;

    public a(List<a> list, List<a> list2) {
        this.a = list;
        this.b = list2;
    }

    static a a(List<a> list, Type type, Set<? extends Annotation> set) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            a a2 = list.get(i2);
            if (!a2.d.equals((Object)type) || !a2.e.equals(set)) continue;
            return a2;
        }
        return null;
    }

    static boolean a(int n2, Type[] arrtype) {
        int n3 = arrtype.length;
        while (n2 < n3) {
            if (!(arrtype[n2] instanceof ParameterizedType)) {
                return false;
            }
            if (((ParameterizedType)arrtype[n2]).getRawType() != h.class) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final h<?> a(final Type type, final Set<? extends Annotation> set, final s s2) {
        a a2;
        h<?> h2;
        a a3;
        block10 : {
            a2 = a.a(this.a, type, set);
            a3 = a.a(this.b, type, set);
            if (a2 == null && a3 == null) {
                return null;
            }
            if (a2 != null && a3 != null) {
                h2 = null;
            } else {
                try {
                    Type type2 = v.a(type);
                    int n2 = s2.b.indexOf((Object)this);
                    if (n2 == -1) {
                        StringBuilder stringBuilder = new StringBuilder("Unable to skip past unknown factory ");
                        stringBuilder.append((Object)this);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    int n3 = s2.b.size();
                    for (int i2 = n2 + 1; i2 < n3; ++i2) {
                        h2 = ((h.a)s2.b.get(i2)).a(type2, set, s2);
                        if (h2 == null) {
                            continue;
                        }
                        break block10;
                    }
                    StringBuilder stringBuilder = new StringBuilder("No next JsonAdapter for ");
                    stringBuilder.append((Object)type2);
                    stringBuilder.append(" annotated ");
                    stringBuilder.append(set);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    String string2 = a2 == null ? "@ToJson" : "@FromJson";
                    StringBuilder stringBuilder = new StringBuilder("No ");
                    stringBuilder.append(string2);
                    stringBuilder.append(" adapter for ");
                    stringBuilder.append((Object)type);
                    stringBuilder.append(" annotated ");
                    stringBuilder.append(set);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        }
        if (a2 != null) {
            a2.a(s2);
        }
        if (a3 == null) return new h<Object>(){

            @Override
            public final Object a(l l2) throws IOException {
                if (a3 == null) {
                    return h2.a(l2);
                }
                if (!a3.j && l2.f() == l.b.i) {
                    l2.j();
                    return null;
                }
                try {
                    Object object = a3.a(l2);
                    return object;
                }
                catch (InvocationTargetException invocationTargetException) {
                    Throwable throwable = invocationTargetException.getCause();
                    if (throwable instanceof IOException) {
                        throw (IOException)throwable;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((Object)throwable);
                    stringBuilder.append(" at ");
                    stringBuilder.append(l2.p());
                    throw new i(stringBuilder.toString(), throwable);
                }
            }

            @Override
            public final void a(p p2, Object object) throws IOException {
                if (a2 == null) {
                    h2.a(p2, object);
                    return;
                }
                if (!a2.j && object == null) {
                    p2.e();
                    return;
                }
                try {
                    a2.a(p2, object);
                    return;
                }
                catch (InvocationTargetException invocationTargetException) {
                    Throwable throwable = invocationTargetException.getCause();
                    if (throwable instanceof IOException) {
                        throw (IOException)throwable;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((Object)throwable);
                    stringBuilder.append(" at ");
                    stringBuilder.append(p2.g());
                    throw new i(stringBuilder.toString(), throwable);
                }
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("JsonAdapter");
                stringBuilder.append((Object)set);
                stringBuilder.append("(");
                stringBuilder.append((Object)type);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
        a3.a(s2);
        return new /* invalid duplicate definition of identical inner class */;
    }

}

