/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.b.a.a
 *  com.google.a.b.a.b
 *  com.google.a.b.a.c
 *  com.google.a.b.a.d
 *  com.google.a.b.a.g
 *  com.google.a.b.a.h
 *  com.google.a.b.a.i
 *  com.google.a.b.a.j
 *  com.google.a.b.a.k
 *  com.google.a.b.d
 *  com.google.a.c
 *  com.google.a.e$1
 *  com.google.a.e$2
 *  com.google.a.e$3
 *  com.google.a.e$4
 *  com.google.a.e$5
 *  com.google.a.e$a
 *  com.google.a.j
 *  com.google.a.p
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.atomic.AtomicLong
 *  java.util.concurrent.atomic.AtomicLongArray
 */
package com.google.a;

import com.google.a.b.a.c;
import com.google.a.b.a.d;
import com.google.a.b.a.g;
import com.google.a.b.a.h;
import com.google.a.b.a.i;
import com.google.a.b.a.j;
import com.google.a.b.a.k;
import com.google.a.b.a.n;
import com.google.a.d.b;
import com.google.a.e;
import com.google.a.f;
import com.google.a.p;
import com.google.a.q;
import com.google.a.r;
import com.google.a.s;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/*
 * Exception performing whole class analysis.
 */
public final class e {
    private static final com.google.a.c.a<?> r;
    final List<s> a;
    final com.google.a.b.d b;
    final com.google.a.d c;
    final Map<Type, f<?>> d;
    final boolean e;
    final boolean f;
    final boolean g;
    final boolean h;
    final boolean i;
    final boolean j;
    final boolean k;
    final String l;
    final int m;
    final int n;
    final q o;
    final List<s> p;
    final List<s> q;
    private final ThreadLocal<Map<com.google.a.c.a<?>, a<?>>> s;
    private final Map<com.google.a.c.a<?>, r<?>> t;
    private final com.google.a.b.c u;
    private final d v;

    static {
        r = com.google.a.c.a.a(Object.class);
    }

    public e() {
        this(com.google.a.b.d.a, (com.google.a.d)com.google.a.c.a, Collections.emptyMap(), q.a, (List<s>)Collections.emptyList(), (List<s>)Collections.emptyList(), (List<s>)Collections.emptyList());
    }

    private e(com.google.a.b.d d2, com.google.a.d d3, Map<Type, f<?>> map, q q2, List<s> list, List<s> list2, List<s> list3) {
        this.s = new ThreadLocal();
        this.t = new ConcurrentHashMap();
        this.b = d2;
        this.c = d3;
        this.d = map;
        this.u = new com.google.a.b.c(map);
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = false;
        this.o = q2;
        this.l = null;
        this.m = 2;
        this.n = 2;
        this.p = list;
        this.q = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)n.Y);
        arrayList.add((Object)h.a);
        arrayList.add((Object)d2);
        arrayList.addAll(list3);
        arrayList.add((Object)n.D);
        arrayList.add((Object)n.m);
        arrayList.add((Object)n.g);
        arrayList.add((Object)n.i);
        arrayList.add((Object)n.k);
        3 var18_9 = q2 == q.a ? n.t : new 3();
        arrayList.add((Object)n.a(Long.TYPE, Long.class, var18_9));
        arrayList.add((Object)n.a(Double.TYPE, Double.class, new 1(this)));
        arrayList.add((Object)n.a(Float.TYPE, Float.class, new 2(this)));
        arrayList.add((Object)n.x);
        arrayList.add((Object)n.o);
        arrayList.add((Object)n.q);
        arrayList.add((Object)n.a(AtomicLong.class, new 4((r)var18_9).a()));
        arrayList.add((Object)n.a(AtomicLongArray.class, new 5((r)var18_9).a()));
        arrayList.add((Object)n.s);
        arrayList.add((Object)n.z);
        arrayList.add((Object)n.F);
        arrayList.add((Object)n.H);
        arrayList.add((Object)n.a(BigDecimal.class, n.B));
        arrayList.add((Object)n.a(BigInteger.class, n.C));
        arrayList.add((Object)n.J);
        arrayList.add((Object)n.L);
        arrayList.add((Object)n.P);
        arrayList.add((Object)n.R);
        arrayList.add((Object)n.W);
        arrayList.add((Object)n.N);
        arrayList.add((Object)n.d);
        arrayList.add((Object)c.a);
        arrayList.add((Object)n.U);
        arrayList.add((Object)k.a);
        arrayList.add((Object)j.a);
        arrayList.add((Object)n.S);
        arrayList.add((Object)com.google.a.b.a.a.a);
        arrayList.add((Object)n.b);
        arrayList.add((Object)new com.google.a.b.a.b(this.u));
        arrayList.add((Object)new g(this.u));
        this.v = new d(this.u);
        arrayList.add((Object)this.v);
        arrayList.add((Object)n.Z);
        arrayList.add((Object)new i(this.u, d3, d2, this.v));
        this.a = Collections.unmodifiableList((List)arrayList);
    }

    /*
     * Exception decompiling
     */
    private <T> T a(com.google.a.d.a var1, Type var2_2) throws com.google.a.j, p {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    static void a(double d2) {
        if (!Double.isNaN((double)d2) && !Double.isInfinite((double)d2)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d2);
        stringBuilder.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final <T> r<T> a(com.google.a.c.a<T> a2) {
        a a3;
        Map<com.google.a.c.a<?>, r<?>> map = this.t;
        com.google.a.c.a<Object> a4 = a2 == null ? r : a2;
        r r2 = (r)map.get(a4);
        if (r2 != null) {
            return r2;
        }
        Map map2 = (Map)this.s.get();
        boolean bl = false;
        if (map2 == null) {
            map2 = new HashMap();
            this.s.set((Object)map2);
            bl = true;
        }
        if ((a3 = map2.get(a2)) != null) {
            return a3;
        }
        try {
            a a5 = new /* Unavailable Anonymous Inner Class!! */;
            map2.put(a2, (Object)a5);
            Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                r<T> r3 = ((s)iterator.next()).a((e)this, a2);
                if (r3 == null) continue;
                if (a5.a != null) {
                    throw new AssertionError();
                }
                a5.a = r3;
                this.t.put(a2, r3);
                return r3;
            }
            StringBuilder stringBuilder = new StringBuilder("GSON (2.8.5) cannot handle ");
            stringBuilder.append(a2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        finally {
            map2.remove(a2);
            if (bl) {
                this.s.remove();
            }
        }
    }

    public final <T> r<T> a(s s2, com.google.a.c.a<T> a2) {
        if (!this.a.contains((Object)s2)) {
            s2 = this.v;
        }
        boolean bl = false;
        for (s s3 : this.a) {
            if (!bl) {
                if (s3 != s2) continue;
                bl = true;
                continue;
            }
            r<T> r2 = s3.a((e)this, a2);
            if (r2 == null) continue;
            return r2;
        }
        StringBuilder stringBuilder = new StringBuilder("GSON cannot serialize ");
        stringBuilder.append(a2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final <T> r<T> a(Class<T> class_) {
        return this.a(com.google.a.c.a.a(class_));
    }

    public final <T> T a(String string2, Type type) throws p {
        if (string2 == null) {
            return null;
        }
        com.google.a.d.a a2 = new com.google.a.d.a((Reader)new StringReader(string2));
        a2.a = this.j;
        T t2 = e.super.a(a2, type);
        if (t2 != null) {
            try {
                if (a2.f() != b.j) {
                    throw new com.google.a.j("JSON document was not fully consumed.");
                }
            }
            catch (IOException iOException) {
                throw new com.google.a.j((Throwable)iOException);
            }
            catch (com.google.a.d.d d2) {
                throw new p((Throwable)((Object)d2));
            }
        }
        return t2;
    }

    /*
     * Exception decompiling
     */
    public final String a(Object var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[CATCHBLOCK]], but top level block is 3[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("{serializeNulls:");
        stringBuilder.append(this.e);
        stringBuilder.append(",factories:");
        stringBuilder.append(this.a);
        stringBuilder.append(",instanceCreators:");
        stringBuilder.append((Object)this.u);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

