/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.b.h$a$1
 *  com.google.a.b.h$b$1
 *  java.io.ObjectStreamException
 *  java.io.Serializable
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Comparable
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.AbstractMap
 *  java.util.AbstractSet
 *  java.util.Comparator
 *  java.util.ConcurrentModificationException
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NoSuchElementException
 *  java.util.Set
 */
package com.google.a.b;

import com.google.a.b.h;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class h<K, V>
extends AbstractMap<K, V>
implements Serializable {
    static final /* synthetic */ boolean f = true;
    private static final Comparator<Comparable> g = new Comparator<Comparable>(){

        public final /* synthetic */ int compare(Object object, Object object2) {
            return ((Comparable)object).compareTo((Object)((Comparable)object2));
        }
    };
    Comparator<? super K> a;
    d<K, V> b;
    int c = 0;
    int d = 0;
    final d<K, V> e = new d();
    private h<K, V> h;
    private h<K, V> i;

    public h() {
        this(g);
    }

    private h(Comparator<? super K> comparator) {
        if (comparator == null) {
            comparator = g;
        }
        this.a = comparator;
    }

    private d<K, V> a(K k2, boolean bl) {
        int n2;
        d<K, V> d2;
        Comparator<? super K> comparator = this.a;
        d<K, V> d3 = this.b;
        if (d3 != null) {
            Comparable comparable = comparator == g ? (Comparable)k2 : null;
            do {
                if ((n2 = comparable != null ? comparable.compareTo(d3.f) : comparator.compare(k2, d3.f)) == 0) {
                    return d3;
                }
                d d4 = n2 < 0 ? d3.b : d3.c;
                if (d4 != null) {
                    d3 = d4;
                    continue;
                }
                break;
            } while (true);
        } else {
            n2 = 0;
        }
        if (!bl) {
            return null;
        }
        d<K, V> d5 = this.e;
        if (d3 == null) {
            if (comparator == g && !(k2 instanceof Comparable)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(k2.getClass().getName());
                stringBuilder.append(" is not Comparable");
                throw new ClassCastException(stringBuilder.toString());
            }
            d2 = new d<K, V>(d3, k2, d5, d5.e);
            this.b = d2;
        } else {
            d2 = new d<K, V>(d3, k2, d5, d5.e);
            if (n2 < 0) {
                d3.b = d2;
            } else {
                d3.c = d2;
            }
            h.super.b(d3, true);
        }
        this.c = 1 + this.c;
        this.d = 1 + this.d;
        return d2;
    }

    private void a(d<K, V> d2) {
        d d3 = d2.b;
        d d4 = d2.c;
        d d5 = d4.b;
        d d6 = d4.c;
        d2.c = d5;
        if (d5 != null) {
            d5.a = d2;
        }
        h.super.a(d2, d4);
        d4.b = d2;
        d2.a = d4;
        int n2 = d3 != null ? d3.h : 0;
        int n3 = d5 != null ? d5.h : 0;
        int n4 = d2.h = 1 + Math.max((int)n2, (int)n3);
        int n5 = 0;
        if (d6 != null) {
            n5 = d6.h;
        }
        d4.h = 1 + Math.max((int)n4, (int)n5);
    }

    private void a(d<K, V> d2, d<K, V> d3) {
        d d4 = d2.a;
        d2.a = null;
        if (d3 != null) {
            d3.a = d4;
        }
        if (d4 != null) {
            if (d4.b == d2) {
                d4.b = d3;
                return;
            }
            if (!f && d4.c != d2) {
                throw new AssertionError();
            }
            d4.c = d3;
            return;
        }
        this.b = d3;
    }

    /*
     * Exception decompiling
     */
    private d<K, V> b(Object var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl10.1 : ACONST_NULL : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    private void b(d<K, V> d2) {
        d d3 = d2.b;
        d d4 = d2.c;
        d d5 = d3.b;
        d d6 = d3.c;
        d2.b = d6;
        if (d6 != null) {
            d6.a = d2;
        }
        h.super.a(d2, d3);
        d3.c = d2;
        d2.a = d3;
        int n2 = d4 != null ? d4.h : 0;
        int n3 = d6 != null ? d6.h : 0;
        int n4 = d2.h = 1 + Math.max((int)n2, (int)n3);
        int n5 = 0;
        if (d5 != null) {
            n5 = d5.h;
        }
        d3.h = 1 + Math.max((int)n4, (int)n5);
    }

    private void b(d<K, V> d2, boolean bl) {
        while (d2 != null) {
            int n2;
            d d3;
            d d4 = d2.b;
            int n3 = d4 != null ? d4.h : 0;
            int n4 = n3 - (n2 = (d3 = d2.c) != null ? d3.h : 0);
            if (n4 == -2) {
                int n5;
                d d5 = d3.b;
                d d6 = d3.c;
                int n6 = d6 != null ? d6.h : 0;
                int n7 = 0;
                if (d5 != null) {
                    n7 = d5.h;
                }
                if ((n5 = n7 - n6) != -1 && (n5 != 0 || bl)) {
                    if (!f && n5 != 1) {
                        throw new AssertionError();
                    }
                    h.super.b(d3);
                }
                h.super.a(d2);
                if (bl) break;
            } else if (n4 == 2) {
                int n8;
                d d7 = d4.b;
                d d8 = d4.c;
                int n9 = d8 != null ? d8.h : 0;
                int n10 = 0;
                if (d7 != null) {
                    n10 = d7.h;
                }
                if ((n8 = n10 - n9) != 1 && (n8 != 0 || bl)) {
                    if (!f && n8 != -1) {
                        throw new AssertionError();
                    }
                    h.super.a(d4);
                }
                h.super.b(d2);
                if (bl) break;
            } else if (n4 == 0) {
                d2.h = n3 + 1;
                if (bl) {
                    return;
                }
            } else {
                if (!f && n4 != -1 && n4 != 1) {
                    throw new AssertionError();
                }
                d2.h = 1 + Math.max((int)n3, (int)n2);
                if (!bl) break;
            }
            d2 = d2.a;
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap((Map)this);
    }

    final d<K, V> a(Object object) {
        d<K, V> d2 = h.super.b(object);
        if (d2 != null) {
            this.a(d2, true);
        }
        return d2;
    }

    final d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> d2;
        boolean bl;
        block5 : {
            block4 : {
                d2 = h.super.b(entry.getKey());
                bl = true;
                if (d2 == null) break block4;
                Object v2 = d2.g;
                Object object = entry.getValue();
                boolean bl2 = v2 == object || v2 != null && v2.equals(object);
                if (bl2) break block5;
            }
            bl = false;
        }
        if (bl) {
            return d2;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    final void a(d<K, V> var1, boolean var2_2) {
        block16 : {
            block15 : {
                if (var2_2) {
                    var1.e.d = var1.d;
                    var1.d.e = var1.e;
                }
                var3_3 = var1.b;
                var4_4 = var1.c;
                var5_5 = var1.a;
                if (var3_3 == null || var4_4 == null) break block15;
                if (var3_3.h <= var4_4.h) break block16;
                do {
                    var11_6 = var3_3.c;
                    var4_4 = var3_3;
                    var3_3 = var11_6;
                    if (var3_3 != null) {
                        continue;
                    }
                    ** GOTO lbl33
                    break;
                } while (true);
            }
            if (var3_3 != null) {
                h.super.a(var1, var3_3);
                var1.b = null;
            } else if (var4_4 != null) {
                h.super.a(var1, var4_4);
                var1.c = null;
            } else {
                h.super.a(var1, null);
            }
            h.super.b(var5_5, false);
            this.c = -1 + this.c;
            this.d = 1 + this.d;
            return;
        }
        do {
            block17 : {
                if ((var6_7 = var4_4.b) != null) break block17;
lbl33: // 2 sources:
                this.a(var4_4, false);
                var7_8 = var1.b;
                if (var7_8 != null) {
                    var8_9 = var7_8.h;
                    var4_4.b = var7_8;
                    var7_8.a = var4_4;
                    var1.b = null;
                } else {
                    var8_9 = 0;
                }
                var9_10 = var1.c;
                var10_11 = 0;
                if (var9_10 != null) {
                    var10_11 = var9_10.h;
                    var4_4.c = var9_10;
                    var9_10.a = var4_4;
                    var1.c = null;
                }
                var4_4.h = 1 + Math.max((int)var8_9, (int)var10_11);
                h.super.a(var1, var4_4);
                return;
            }
            var4_4 = var6_7;
        } while (true);
    }

    public final void clear() {
        this.b = null;
        this.c = 0;
        this.d = 1 + this.d;
        d<K, V> d2 = this.e;
        d2.e = d2;
        d2.d = d2;
    }

    public final boolean containsKey(Object object) {
        return h.super.b(object) != null;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        h<K, V> h2 = this.h;
        if (h2 != null) {
            return h2;
        }
        a a2 = new a();
        this.h = a2;
        return a2;
    }

    public final V get(Object object) {
        d<K, V> d2 = h.super.b(object);
        if (d2 != null) {
            return d2.g;
        }
        return null;
    }

    public final Set<K> keySet() {
        h<K, V> h2 = this.i;
        if (h2 != null) {
            return h2;
        }
        b b2 = new b();
        this.i = b2;
        return b2;
    }

    public final V put(K k2, V v2) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        d<K, V> d2 = h.super.a(k2, true);
        Object v3 = d2.g;
        d2.g = v2;
        return v3;
    }

    public final V remove(Object object) {
        d<K, V> d2 = this.a(object);
        if (d2 != null) {
            return d2.g;
        }
        return null;
    }

    public final int size() {
        return this.c;
    }

    final class a
    extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        public final void clear() {
            h.this.clear();
        }

        public final boolean contains(Object object) {
            return object instanceof Map.Entry && h.this.a((Map.Entry)object) != null;
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new 1(this);
        }

        public final boolean remove(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            d d2 = h.this.a((Map.Entry)object);
            if (d2 == null) {
                return false;
            }
            h.this.a(d2, true);
            return true;
        }

        public final int size() {
            return h.this.c;
        }
    }

    final class b
    extends AbstractSet<K> {
        b() {
        }

        public final void clear() {
            h.this.clear();
        }

        public final boolean contains(Object object) {
            return h.this.containsKey(object);
        }

        public final Iterator<K> iterator() {
            return new 1(this);
        }

        public final boolean remove(Object object) {
            return h.this.a(object) != null;
        }

        public final int size() {
            return h.this.c;
        }
    }

    private abstract class c<T>
    implements Iterator<T> {
        d<K, V> b;
        d<K, V> c;
        int d;

        c() {
            this.b = h.this.e.d;
            this.c = null;
            this.d = h.this.d;
        }

        final d<K, V> a() {
            d<K, V> d2 = this.b;
            if (d2 == h.this.e) {
                throw new NoSuchElementException();
            }
            if (h.this.d != this.d) {
                throw new ConcurrentModificationException();
            }
            this.b = d2.d;
            this.c = d2;
            return d2;
        }

        public final boolean hasNext() {
            return this.b != h.this.e;
        }

        public final void remove() {
            if (this.c == null) {
                throw new IllegalStateException();
            }
            h.this.a(this.c, true);
            this.c = null;
            this.d = h.this.d;
        }
    }

    static final class d<K, V>
    implements Map.Entry<K, V> {
        d<K, V> a;
        d<K, V> b;
        d<K, V> c;
        d<K, V> d;
        d<K, V> e;
        final K f;
        V g;
        int h;

        d() {
            this.f = null;
            this.e = this;
            this.d = this;
        }

        d(d<K, V> d2, K k2, d<K, V> d3, d<K, V> d4) {
            this.a = d2;
            this.f = k2;
            this.h = 1;
            this.d = d3;
            this.e = d4;
            d4.d = this;
            d3.e = this;
        }

        public final boolean equals(Object object) {
            if (object instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry)object;
                if ((this.f == null ? entry.getKey() == null : this.f.equals(entry.getKey())) && (this.g == null ? entry.getValue() == null : this.g.equals(entry.getValue()))) {
                    return true;
                }
            }
            return false;
        }

        public final K getKey() {
            return this.f;
        }

        public final V getValue() {
            return this.g;
        }

        public final int hashCode() {
            int n2 = this.f == null ? 0 : this.f.hashCode();
            int n3 = this.g == null ? 0 : this.g.hashCode();
            return n2 ^ n3;
        }

        public final V setValue(V v2) {
            V v3 = this.g;
            this.g = v2;
            return v3;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f);
            stringBuilder.append("=");
            stringBuilder.append(this.g);
            return stringBuilder.toString();
        }
    }

}

