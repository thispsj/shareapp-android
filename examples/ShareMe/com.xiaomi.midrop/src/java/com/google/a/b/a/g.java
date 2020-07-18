/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.google.a.b.a;

import com.google.a.b.a.m;
import com.google.a.b.a.n;
import com.google.a.b.b;
import com.google.a.b.c;
import com.google.a.b.f;
import com.google.a.e;
import com.google.a.i;
import com.google.a.k;
import com.google.a.l;
import com.google.a.p;
import com.google.a.r;
import com.google.a.s;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
implements s {
    final boolean a;
    private final c b;

    public g(c c2) {
        this.b = c2;
        this.a = false;
    }

    @Override
    public final <T> r<T> a(e e2, com.google.a.c.a<T> a2) {
        Type type = a2.b;
        if (!Map.class.isAssignableFrom(a2.a)) {
            return null;
        }
        Type[] arrtype = b.b(type, b.b(type));
        Type type2 = arrtype[0];
        r<Object> r2 = type2 != Boolean.TYPE && type2 != Boolean.class ? e2.a(com.google.a.c.a.a(type2)) : n.f;
        r<Boolean> r3 = r2;
        r<?> r4 = e2.a(com.google.a.c.a.a(arrtype[1]));
        com.google.a.b.i<T> i2 = this.b.a(a2);
        a a3 = (g)this.new a(e2, arrtype[0], r3, arrtype[1], r4, i2);
        return a3;
    }

    private final class a<K, V>
    extends r<Map<K, V>> {
        private final r<K> b;
        private final r<V> c;
        private final com.google.a.b.i<? extends Map<K, V>> d;

        public a(e e2, Type type, r<K> r2, Type type2, r<V> r3, com.google.a.b.i<? extends Map<K, V>> i2) {
            this.b = new m<K>(e2, r2, type);
            this.c = new m<V>(e2, r3, type2);
            this.d = i2;
        }

        @Override
        public final /* synthetic */ Object a(com.google.a.d.a a2) throws IOException {
            com.google.a.d.b b2 = a2.f();
            if (b2 == com.google.a.d.b.i) {
                a2.k();
                return null;
            }
            Map<K, V> map = this.d.a();
            if (b2 == com.google.a.d.b.a) {
                a2.a();
                while (a2.e()) {
                    a2.a();
                    K k2 = this.b.a(a2);
                    if (map.put(k2, this.c.a(a2)) != null) {
                        StringBuilder stringBuilder = new StringBuilder("duplicate key: ");
                        stringBuilder.append(k2);
                        throw new p(stringBuilder.toString());
                    }
                    a2.b();
                }
                a2.b();
                return map;
            }
            a2.c();
            while (a2.e()) {
                f.a.a(a2);
                K k3 = this.b.a(a2);
                if (map.put(k3, this.c.a(a2)) == null) continue;
                StringBuilder stringBuilder = new StringBuilder("duplicate key: ");
                stringBuilder.append(k3);
                throw new p(stringBuilder.toString());
            }
            a2.d();
            return map;
        }

        @Override
        public final /* synthetic */ void a(com.google.a.d.c c2, Object object) throws IOException {
            Map map = (Map)object;
            if (map == null) {
                c2.e();
                return;
            }
            if (!g.this.a) {
                c2.c();
                for (Map.Entry entry : map.entrySet()) {
                    c2.a(String.valueOf((Object)entry.getKey()));
                    this.c.a(c2, entry.getValue());
                }
                c2.d();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            Iterator iterator = map.entrySet().iterator();
            int n2 = 0;
            boolean bl = false;
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                i i2 = this.b.a(entry.getKey());
                arrayList.add((Object)i2);
                arrayList2.add(entry.getValue());
                boolean bl2 = i2 instanceof com.google.a.g || i2 instanceof l;
                bl |= bl2;
            }
            if (bl) {
                c2.a();
                int n3 = arrayList.size();
                while (n2 < n3) {
                    c2.a();
                    com.google.a.b.k.a((i)arrayList.get(n2), c2);
                    this.c.a(c2, arrayList2.get(n2));
                    c2.b();
                    ++n2;
                }
                c2.b();
                return;
            }
            c2.c();
            int n4 = arrayList.size();
            while (n2 < n4) {
                block15 : {
                    String string2;
                    block12 : {
                        i i3;
                        block10 : {
                            block14 : {
                                com.google.a.n n5;
                                block13 : {
                                    block11 : {
                                        i3 = (i)arrayList.get(n2);
                                        if (!(i3 instanceof com.google.a.n)) break block10;
                                        n5 = i3.g();
                                        if (!(n5.a instanceof Number)) break block11;
                                        string2 = String.valueOf((Object)n5.a());
                                        break block12;
                                    }
                                    if (!(n5.a instanceof Boolean)) break block13;
                                    string2 = Boolean.toString((boolean)n5.f());
                                    break block12;
                                }
                                if (!(n5.a instanceof String)) break block14;
                                string2 = n5.b();
                                break block12;
                            }
                            throw new AssertionError();
                        }
                        if (!(i3 instanceof k)) break block15;
                        string2 = "null";
                    }
                    c2.a(string2);
                    this.c.a(c2, arrayList2.get(n2));
                    ++n2;
                    continue;
                }
                throw new AssertionError();
            }
            c2.d();
        }
    }

}

