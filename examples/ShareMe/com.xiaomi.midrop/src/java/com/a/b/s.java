/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.a.b.a
 *  com.a.b.a$2
 *  com.a.b.a$3
 *  com.a.b.a$4
 *  com.a.b.a$5
 *  com.a.b.b
 *  com.a.b.d
 *  com.a.b.e
 *  com.a.b.r
 *  com.a.b.s$b
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.AnnotatedElement
 *  java.lang.reflect.Method
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.a.b;

import com.a.b.a;
import com.a.b.d;
import com.a.b.e;
import com.a.b.f;
import com.a.b.h;
import com.a.b.l;
import com.a.b.p;
import com.a.b.r;
import com.a.b.s;
import com.a.b.t;
import com.a.b.u;
import com.a.b.v;
import com.a.b.w;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Exception performing whole class analysis.
 */
public final class s {
    static final List<h.a> a;
    final List<h.a> b;
    private final ThreadLocal<List<b<?>>> c;
    private final Map<Object, h<?>> d;

    static {
        ArrayList arrayList;
        a = arrayList = new ArrayList(5);
        arrayList.add((Object)t.a);
        a.add((Object)e.a);
        a.add((Object)r.a);
        a.add((Object)com.a.b.b.a);
        a.add((Object)d.a);
    }

    public s(a a2) {
        this.c = new ThreadLocal();
        this.d = new LinkedHashMap();
        ArrayList arrayList = new ArrayList(a2.a.size() + a.size());
        arrayList.addAll(a2.a);
        arrayList.addAll(a);
        this.b = Collections.unmodifiableList((List)arrayList);
    }

    public final <T> h<T> a(Type type) {
        return this.a(type, w.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final <T> h<T> a(Type type, Set<? extends Annotation> set) {
        int n2;
        Map<Object, h<?>> map;
        Type type2 = v.a(type);
        boolean bl = set.isEmpty();
        int n3 = 0;
        Object object = bl ? type2 : Arrays.asList((Object[])new Object[]{type2, set});
        Map<Object, h<?>> map2 = map = this.d;
        synchronized (map2) {
            h h2 = (h)this.d.get(object);
            if (h2 != null) {
                return h2;
            }
        }
        List list = (List)this.c.get();
        if (list == null) {
            list = new ArrayList();
            this.c.set((Object)list);
        } else {
            int n4 = list.size();
            for (int i2 = 0; i2 < n4; ++i2) {
                b b2 = list.get(i2);
                if (!b2.a.equals(object)) continue;
                return b2;
            }
        }
        b b3 = new /* Unavailable Anonymous Inner Class!! */;
        list.add((Object)b3);
        try {
            n2 = this.b.size();
        }
        catch (Throwable throwable) {
            list.remove(list.size() - 1);
            if (list.isEmpty()) {
                this.c.remove();
            }
            throw throwable;
        }
        while (n3 < n2) {
            h<?> h3 = ((h.a)this.b.get(n3)).a(type2, set, (s)this);
            if (h3 != null) {
                Map<Object, h<?>> map3;
                b3.b = h3;
                b3.a = null;
                Map<Object, h<?>> map4 = map3 = this.d;
                synchronized (map4) {
                    this.d.put(object, h3);
                }
                list.remove(list.size() - 1);
                if (list.isEmpty()) {
                    this.c.remove();
                }
                return h3;
            }
            ++n3;
        }
        list.remove(list.size() - 1);
        if (list.isEmpty()) {
            this.c.remove();
        }
        StringBuilder stringBuilder = new StringBuilder("No JsonAdapter for ");
        stringBuilder.append((Object)type2);
        stringBuilder.append(" annotated ");
        stringBuilder.append(set);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static final class a {
        final List<h.a> a = new ArrayList();

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public final a a(Object var1) {
            var2_2 = new ArrayList();
            var3_3 = new ArrayList();
            var4_4 = var1.getClass();
            do {
                if (var4_4 != Object.class) {
                    var9_30 = var4_4.getDeclaredMethods();
                    var10_35 = var9_30.length;
                } else {
                    if (var2_2.isEmpty() && var3_3.isEmpty()) {
                        var7_40 = new StringBuilder("Expected at least one @ToJson or @FromJson method on ");
                        var7_40.append(var1.getClass().getName());
                        throw new IllegalArgumentException(var7_40.toString());
                    }
                    var5_41 = new com.a.b.a((List)var2_2, (List)var3_3);
                    this.a.add((Object)var5_41);
                    return this;
                }
                for (var11_6 = 0; var11_6 < var10_35; ++var11_6) {
                    block15 : {
                        block14 : {
                            block13 : {
                                block12 : {
                                    var12_34 = var9_30[var11_6];
                                    if (!var12_34.isAnnotationPresent(u.class)) ** GOTO lbl54
                                    var12_34.setAccessible(true);
                                    var33_7 = var12_34.getGenericReturnType();
                                    var34_27 = var12_34.getGenericParameterTypes();
                                    var35_33 = var12_34.getParameterAnnotations();
                                    if (var34_27.length < 2 || var34_27[0] != p.class || var33_7 != Void.TYPE || !com.a.b.a.a((int)2, (Type[])var34_27)) break block12;
                                    var52_16 = w.a(var35_33[1]);
                                    var54_13 = var34_27[1];
                                    var55_17 = var34_27.length;
                                    var45_5 = var53_8;
                                    var45_5(var54_13, var52_16, var1, var12_34, var55_17);
                                    var13_24 = var12_34;
                                    ** GOTO lbl41
                                }
                                if (var34_27.length == 1 && var33_7 != Void.TYPE) {
                                    var39_28 = w.a((AnnotatedElement)var12_34);
                                    var40_31 = w.a(var35_33[0]);
                                    var41_12 = w.b(var35_33[0]);
                                    var43_26 = var34_27[0];
                                    var44_23 = var34_27.length;
                                    var45_5 = var42_15;
                                    var13_24 = var12_34;
                                    super(var43_26, var40_31, var1, var12_34, var44_23, var41_12, var33_7, var39_28);
lbl41: // 2 sources:
                                    var46_19 = com.a.b.a.a((List)var2_2, (Type)var45_5.d, var45_5.e);
                                    if (var46_19 != null) {
                                        var47_36 = new StringBuilder("Conflicting @ToJson methods:\n    ");
                                        var47_36.append((Object)var46_19.g);
                                        var47_36.append("\n    ");
                                        var47_36.append((Object)var45_5.g);
                                        throw new IllegalArgumentException(var47_36.toString());
                                    }
                                    var2_2.add((Object)var45_5);
                                } else {
                                    var36_37 = new StringBuilder("Unexpected signature for ");
                                    var36_37.append((Object)var12_34);
                                    var36_37.append(".\n@ToJson method signatures may have one of the following structures:\n    <any access modifier> void toJson(JsonWriter writer, T value) throws <any>;\n    <any access modifier> R toJson(T value) throws <any>;\n");
                                    throw new IllegalArgumentException(var36_37.toString());
lbl54: // 1 sources:
                                    var13_24 = var12_34;
                                }
                                if (!var13_24.isAnnotationPresent(f.class)) continue;
                                var13_24.setAccessible(true);
                                var14_20 = var13_24.getGenericReturnType();
                                var15_9 = w.a((AnnotatedElement)var13_24);
                                var16_22 = var13_24.getGenericParameterTypes();
                                var17_18 = var13_24.getParameterAnnotations();
                                if (var16_22.length <= 0 || var16_22[0] != l.class || var14_20 == Void.TYPE || !com.a.b.a.a((int)1, (Type[])var16_22)) break block13;
                                var32_29 = var16_22.length;
                                var25_14 = new a.4(var14_20, var15_9, var1, var13_24, var32_29);
                                break block14;
                            }
                            if (var16_22.length != 1 || var14_20 == Void.TYPE) break block15;
                            var21_21 = w.a(var17_18[0]);
                            var22_25 = w.b(var17_18[0]);
                            var23_11 = var16_22.length;
                            var24_32 = new a.5(var14_20, var15_9, var1, var13_24, var23_11, var22_25, var16_22, var21_21);
                            var25_14 = var24_32;
                        }
                        var26_10 = com.a.b.a.a((List)var3_3, (Type)var25_14.d, var25_14.e);
                        if (var26_10 != null) {
                            var27_38 = new StringBuilder("Conflicting @FromJson methods:\n    ");
                            var27_38.append((Object)var26_10.g);
                            var27_38.append("\n    ");
                            var27_38.append((Object)var25_14.g);
                            throw new IllegalArgumentException(var27_38.toString());
                        }
                        var3_3.add((Object)var25_14);
                        continue;
                    }
                    var18_39 = new StringBuilder("Unexpected signature for ");
                    var18_39.append((Object)var13_24);
                    var18_39.append(".\n@FromJson method signatures may have one of the following structures:\n    <any access modifier> void fromJson(JsonReader jsonReader) throws <any>;\n    <any access modifier> R fromJson(T value) throws <any>;\n");
                    throw new IllegalArgumentException(var18_39.toString());
                }
                var4_4 = var4_4.getSuperclass();
            } while (true);
        }
    }

}

