/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.a.b.q$c$1
 *  com.a.b.q$d$1
 *  java.io.ObjectStreamException
 *  java.io.Serializable
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Comparable
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.AbstractMap
 *  java.util.AbstractSet
 *  java.util.Arrays
 *  java.util.Comparator
 *  java.util.ConcurrentModificationException
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NoSuchElementException
 *  java.util.Set
 */
package com.a.b;

import com.a.b.q;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

final class q<K, V>
extends AbstractMap<K, V>
implements Serializable {
    static final /* synthetic */ boolean g = true;
    private static final Comparator<Comparable> h = new Comparator<Comparable>(){

        public final /* synthetic */ int compare(Object object, Object object2) {
            return ((Comparable)object).compareTo((Object)((Comparable)object2));
        }
    };
    Comparator<? super K> a = h;
    f<K, V>[] b = new f[16];
    final f<K, V> c = new f();
    int d = 0;
    int e = 0;
    int f = this.b.length / 2 + this.b.length / 4;
    private q<K, V> i;
    private q<K, V> j;

    public q() {
        this(0);
    }

    private q(byte by) {
    }

    private f<K, V> a(K k2, boolean bl) {
        f<K, V> f2;
        int n2;
        f<K, V> f3;
        Comparator<? super K> comparator = this.a;
        f<K, V>[] arrf = this.b;
        int n3 = k2.hashCode();
        int n4 = n3 ^ (n3 >>> 20 ^ n3 >>> 12);
        int n5 = n4 ^ n4 >>> 7 ^ n4 >>> 4;
        int n6 = n5 & arrf.length - 1;
        f<K, V> f4 = arrf[n6];
        if (f4 != null) {
            int n7;
            Comparable comparable = comparator == h ? (Comparable)k2 : null;
            do {
                if ((n7 = comparable != null ? comparable.compareTo(f4.f) : comparator.compare(k2, f4.f)) == 0) {
                    return f4;
                }
                f f5 = n7 < 0 ? f4.b : f4.c;
                if (f5 == null) break;
                f4 = f5;
            } while (true);
            f2 = f4;
            n2 = n7;
        } else {
            f2 = f4;
            n2 = 0;
        }
        if (!bl) {
            return null;
        }
        f<K, V> f6 = this.c;
        if (f2 == null) {
            if (comparator == h && !(k2 instanceof Comparable)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(k2.getClass().getName());
                stringBuilder.append(" is not Comparable");
                throw new ClassCastException(stringBuilder.toString());
            }
            f f7 = f6.e;
            f3 = new f<K, V>(f2, k2, n5, f6, f7);
            arrf[n6] = f3;
        } else {
            f f8 = f6.e;
            f3 = new f<K, V>(f2, k2, n5, f6, f8);
            if (n2 < 0) {
                f2.b = f3;
            } else {
                f2.c = f3;
            }
            q.super.b(f2, true);
        }
        int n8 = this.d;
        this.d = n8 + 1;
        if (n8 > this.f) {
            this.b = q.a(this.b);
            this.f = this.b.length / 2 + this.b.length / 4;
        }
        this.e = 1 + this.e;
        return f3;
    }

    private void a(f<K, V> f2) {
        f f3 = f2.b;
        f f4 = f2.c;
        f f5 = f4.b;
        f f6 = f4.c;
        f2.c = f5;
        if (f5 != null) {
            f5.a = f2;
        }
        q.super.a(f2, f4);
        f4.b = f2;
        f2.a = f4;
        int n2 = f3 != null ? f3.i : 0;
        int n3 = f5 != null ? f5.i : 0;
        int n4 = f2.i = 1 + Math.max((int)n2, (int)n3);
        int n5 = 0;
        if (f6 != null) {
            n5 = f6.i;
        }
        f4.i = 1 + Math.max((int)n4, (int)n5);
    }

    private void a(f<K, V> f2, f<K, V> f3) {
        f f4 = f2.a;
        f2.a = null;
        if (f3 != null) {
            f3.a = f4;
        }
        if (f4 != null) {
            if (f4.b == f2) {
                f4.b = f3;
                return;
            }
            if (!g && f4.c != f2) {
                throw new AssertionError();
            }
            f4.c = f3;
            return;
        }
        int n2 = f2.g & -1 + this.b.length;
        this.b[n2] = f3;
    }

    private static <K, V> f<K, V>[] a(f<K, V>[] arrf) {
        int n2 = arrf.length;
        f[] arrf2 = new f[n2 * 2];
        b<K, V> b2 = new b<K, V>();
        a a2 = new a();
        a a3 = new a();
        for (int i2 = 0; i2 < n2; ++i2) {
            f f2;
            f f3;
            f<K, V> f4 = arrf[i2];
            if (f4 == null) continue;
            b2.a(f4);
            int n3 = 0;
            int n4 = 0;
            while ((f2 = b2.a()) != null) {
                if ((n2 & f2.g) == 0) {
                    ++n3;
                    continue;
                }
                ++n4;
            }
            a2.a(n3);
            a3.a(n4);
            b2.a(f4);
            while ((f3 = b2.a()) != null) {
                if ((n2 & f3.g) == 0) {
                    a2.a(f3);
                    continue;
                }
                a3.a(f3);
            }
            f f5 = n3 > 0 ? a2.a() : null;
            arrf2[i2] = f5;
            int n5 = i2 + n2;
            f f6 = null;
            if (n4 > 0) {
                f6 = a3.a();
            }
            arrf2[n5] = f6;
        }
        return arrf2;
    }

    /*
     * Exception decompiling
     */
    private f<K, V> b(Object var1) {
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

    private void b(f<K, V> f2) {
        f f3 = f2.b;
        f f4 = f2.c;
        f f5 = f3.b;
        f f6 = f3.c;
        f2.b = f6;
        if (f6 != null) {
            f6.a = f2;
        }
        q.super.a(f2, f3);
        f3.c = f2;
        f2.a = f3;
        int n2 = f4 != null ? f4.i : 0;
        int n3 = f6 != null ? f6.i : 0;
        int n4 = f2.i = 1 + Math.max((int)n2, (int)n3);
        int n5 = 0;
        if (f5 != null) {
            n5 = f5.i;
        }
        f3.i = 1 + Math.max((int)n4, (int)n5);
    }

    private void b(f<K, V> f2, boolean bl) {
        while (f2 != null) {
            int n2;
            f f3;
            f f4 = f2.b;
            int n3 = f4 != null ? f4.i : 0;
            int n4 = n3 - (n2 = (f3 = f2.c) != null ? f3.i : 0);
            if (n4 == -2) {
                int n5;
                f f5 = f3.b;
                f f6 = f3.c;
                int n6 = f6 != null ? f6.i : 0;
                int n7 = 0;
                if (f5 != null) {
                    n7 = f5.i;
                }
                if ((n5 = n7 - n6) != -1 && (n5 != 0 || bl)) {
                    if (!g && n5 != 1) {
                        throw new AssertionError();
                    }
                    q.super.b(f3);
                }
                q.super.a(f2);
                if (bl) break;
            } else if (n4 == 2) {
                int n8;
                f f7 = f4.b;
                f f8 = f4.c;
                int n9 = f8 != null ? f8.i : 0;
                int n10 = 0;
                if (f7 != null) {
                    n10 = f7.i;
                }
                if ((n8 = n10 - n9) != 1 && (n8 != 0 || bl)) {
                    if (!g && n8 != -1) {
                        throw new AssertionError();
                    }
                    q.super.a(f4);
                }
                q.super.b(f2);
                if (bl) break;
            } else if (n4 == 0) {
                f2.i = n3 + 1;
                if (bl) {
                    return;
                }
            } else {
                if (!g && n4 != -1 && n4 != 1) {
                    throw new AssertionError();
                }
                f2.i = 1 + Math.max((int)n3, (int)n2);
                if (!bl) break;
            }
            f2 = f2.a;
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap((Map)this);
    }

    final f<K, V> a(Object object) {
        f<K, V> f2 = q.super.b(object);
        if (f2 != null) {
            this.a(f2, true);
        }
        return f2;
    }

    final f<K, V> a(Map.Entry<?, ?> entry) {
        f<K, V> f2;
        boolean bl;
        block5 : {
            block4 : {
                f2 = q.super.b(entry.getKey());
                bl = true;
                if (f2 == null) break block4;
                Object v2 = f2.h;
                Object object = entry.getValue();
                boolean bl2 = v2 == object || v2 != null && v2.equals(object);
                if (bl2) break block5;
            }
            bl = false;
        }
        if (bl) {
            return f2;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    final void a(f<K, V> var1, boolean var2_2) {
        block16 : {
            block15 : {
                if (var2_2) {
                    var1.e.d = var1.d;
                    var1.d.e = var1.e;
                    var1.e = null;
                    var1.d = null;
                }
                var3_3 = var1.b;
                var4_4 = var1.c;
                var5_5 = var1.a;
                if (var3_3 == null || var4_4 == null) break block15;
                if (var3_3.i <= var4_4.i) break block16;
                do {
                    var11_6 = var3_3.c;
                    var4_4 = var3_3;
                    var3_3 = var11_6;
                    if (var3_3 != null) {
                        continue;
                    }
                    ** GOTO lbl35
                    break;
                } while (true);
            }
            if (var3_3 != null) {
                q.super.a(var1, var3_3);
                var1.b = null;
            } else if (var4_4 != null) {
                q.super.a(var1, var4_4);
                var1.c = null;
            } else {
                q.super.a(var1, null);
            }
            q.super.b(var5_5, false);
            this.d = -1 + this.d;
            this.e = 1 + this.e;
            return;
        }
        do {
            block17 : {
                if ((var6_7 = var4_4.b) != null) break block17;
lbl35: // 2 sources:
                this.a(var4_4, false);
                var7_8 = var1.b;
                if (var7_8 != null) {
                    var8_9 = var7_8.i;
                    var4_4.b = var7_8;
                    var7_8.a = var4_4;
                    var1.b = null;
                } else {
                    var8_9 = 0;
                }
                var9_10 = var1.c;
                var10_11 = 0;
                if (var9_10 != null) {
                    var10_11 = var9_10.i;
                    var4_4.c = var9_10;
                    var9_10.a = var4_4;
                    var1.c = null;
                }
                var4_4.i = 1 + Math.max((int)var8_9, (int)var10_11);
                q.super.a(var1, var4_4);
                return;
            }
            var4_4 = var6_7;
        } while (true);
    }

    public final void clear() {
        Arrays.fill((Object[])this.b, null);
        this.d = 0;
        this.e = 1 + this.e;
        f<K, V> f2 = this.c;
        f f3 = f2.d;
        while (f3 != f2) {
            f f4 = f3.d;
            f3.e = null;
            f3.d = null;
            f3 = f4;
        }
        f2.e = f2;
        f2.d = f2;
    }

    public final boolean containsKey(Object object) {
        return q.super.b(object) != null;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        q<K, V> q2 = this.i;
        if (q2 != null) {
            return q2;
        }
        c c2 = new c();
        this.i = c2;
        return c2;
    }

    public final V get(Object object) {
        f<K, V> f2 = q.super.b(object);
        if (f2 != null) {
            return f2.h;
        }
        return null;
    }

    public final Set<K> keySet() {
        q<K, V> q2 = this.j;
        if (q2 != null) {
            return q2;
        }
        d d2 = new d();
        this.j = d2;
        return d2;
    }

    public final V put(K k2, V v2) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        f<K, V> f2 = q.super.a(k2, true);
        Object v3 = f2.h;
        f2.h = v2;
        return v3;
    }

    public final V remove(Object object) {
        f<K, V> f2 = this.a(object);
        if (f2 != null) {
            return f2.h;
        }
        return null;
    }

    public final int size() {
        return this.d;
    }

    static final class a<K, V> {
        private f<K, V> a;
        private int b;
        private int c;
        private int d;

        a() {
        }

        final f<K, V> a() {
            f<K, V> f2 = this.a;
            if (f2.a != null) {
                throw new IllegalStateException();
            }
            return f2;
        }

        final void a(int n2) {
            this.b = -1 + 2 * Integer.highestOneBit((int)n2) - n2;
            this.d = 0;
            this.c = 0;
            this.a = null;
        }

        /*
         * Enabled aggressive block sorting
         */
        final void a(f<K, V> f2) {
            f2.c = null;
            f2.a = null;
            f2.b = null;
            f2.i = 1;
            if (this.b > 0 && (1 & this.d) == 0) {
                this.d = 1 + this.d;
                --this.b;
                this.c = 1 + this.c;
            }
            f2.a = this.a;
            this.a = f2;
            this.d = 1 + this.d;
            if (this.b > 0 && (1 & this.d) == 0) {
                this.d = 1 + this.d;
                --this.b;
                this.c = 1 + this.c;
            }
            int n2 = 4;
            do {
                block8 : {
                    block10 : {
                        block9 : {
                            block7 : {
                                int n3;
                                int n4;
                                if (((n4 = this.d) & (n3 = n2 - 1)) != n3) {
                                    return;
                                }
                                if (this.c != 0) break block7;
                                f<K, V> f3 = this.a;
                                f f4 = f3.a;
                                f f5 = f4.a;
                                f4.a = f5.a;
                                this.a = f4;
                                f4.b = f5;
                                f4.c = f3;
                                f4.i = 1 + f3.i;
                                f5.a = f4;
                                f3.a = f4;
                                break block8;
                            }
                            if (this.c != 1) break block9;
                            f<K, V> f6 = this.a;
                            f f7 = f6.a;
                            this.a = f7;
                            f7.c = f6;
                            f7.i = 1 + f6.i;
                            f6.a = f7;
                            break block10;
                        }
                        if (this.c != 2) break block8;
                    }
                    this.c = 0;
                }
                n2 *= 2;
            } while (true);
        }
    }

    static final class b<K, V> {
        private f<K, V> a;

        b() {
        }

        public final f<K, V> a() {
            f f2;
            f<K, V> f3 = this.a;
            if (f3 == null) {
                return null;
            }
            f f4 = f3.a;
            f3.a = null;
            f f5 = f3.c;
            do {
                f2 = f4;
                f4 = f5;
                if (f4 == null) break;
                f4.a = f2;
                f5 = f4.b;
            } while (true);
            this.a = f2;
            return f3;
        }

        final void a(f<K, V> f2) {
            f<K, V> f3;
            f<K, V> f4 = null;
            do {
                f3 = f4;
                f4 = f2;
                if (f4 == null) break;
                f4.a = f3;
                f2 = f4.b;
            } while (true);
            this.a = f3;
        }
    }

    final class c
    extends AbstractSet<Map.Entry<K, V>> {
        c() {
        }

        public final void clear() {
            q.this.clear();
        }

        public final boolean contains(Object object) {
            return object instanceof Map.Entry && q.this.a((Map.Entry)object) != null;
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new 1(this);
        }

        public final boolean remove(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            f f2 = q.this.a((Map.Entry)object);
            if (f2 == null) {
                return false;
            }
            q.this.a(f2, true);
            return true;
        }

        public final int size() {
            return q.this.d;
        }
    }

    final class d
    extends AbstractSet<K> {
        d() {
        }

        public final void clear() {
            q.this.clear();
        }

        public final boolean contains(Object object) {
            return q.this.containsKey(object);
        }

        public final Iterator<K> iterator() {
            return new 1(this);
        }

        public final boolean remove(Object object) {
            return q.this.a(object) != null;
        }

        public final int size() {
            return q.this.d;
        }
    }

    abstract class e<T>
    implements Iterator<T> {
        f<K, V> b;
        f<K, V> c;
        int d;

        e() {
            this.b = q.this.c.d;
            this.c = null;
            this.d = q.this.e;
        }

        final f<K, V> a() {
            f<K, V> f2 = this.b;
            if (f2 == q.this.c) {
                throw new NoSuchElementException();
            }
            if (q.this.e != this.d) {
                throw new ConcurrentModificationException();
            }
            this.b = f2.d;
            this.c = f2;
            return f2;
        }

        public final boolean hasNext() {
            return this.b != q.this.c;
        }

        public final void remove() {
            if (this.c == null) {
                throw new IllegalStateException();
            }
            q.this.a(this.c, true);
            this.c = null;
            this.d = q.this.e;
        }
    }

    static final class f<K, V>
    implements Map.Entry<K, V> {
        f<K, V> a;
        f<K, V> b;
        f<K, V> c;
        f<K, V> d;
        f<K, V> e;
        final K f;
        final int g;
        V h;
        int i;

        f() {
            this.f = null;
            this.g = -1;
            this.e = this;
            this.d = this;
        }

        f(f<K, V> f2, K k2, int n2, f<K, V> f3, f<K, V> f4) {
            this.a = f2;
            this.f = k2;
            this.g = n2;
            this.i = 1;
            this.d = f3;
            this.e = f4;
            f4.d = this;
            f3.e = this;
        }

        public final boolean equals(Object object) {
            if (object instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry)object;
                if ((this.f == null ? entry.getKey() == null : this.f.equals(entry.getKey())) && (this.h == null ? entry.getValue() == null : this.h.equals(entry.getValue()))) {
                    return true;
                }
            }
            return false;
        }

        public final K getKey() {
            return this.f;
        }

        public final V getValue() {
            return this.h;
        }

        public final int hashCode() {
            int n2 = this.f == null ? 0 : this.f.hashCode();
            int n3 = this.h == null ? 0 : this.h.hashCode();
            return n2 ^ n3;
        }

        public final V setValue(V v2) {
            V v3 = this.h;
            this.h = v2;
            return v3;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f);
            stringBuilder.append("=");
            stringBuilder.append(this.h);
            return stringBuilder.toString();
        }
    }

}

