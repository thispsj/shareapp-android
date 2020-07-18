/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.c.a.c$1
 *  io.netty.c.a.c$2
 *  io.netty.c.a.c$b
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.System
 *  java.util.AbstractList
 *  java.util.RandomAccess
 */
package io.netty.c.a;

import io.netty.c.a.c;
import io.netty.d.a.m;
import io.netty.d.b.l;
import java.util.AbstractList;
import java.util.RandomAccess;

final class c
extends AbstractList<Object>
implements RandomAccess {
    private static final a c = new 1();
    private static final m<b> d = new 2();
    Object[] a;
    boolean b;
    private final a e;
    private int f;

    private c(a a2, int n2) {
        this.e = a2;
        this.a = new Object[n2];
    }

    /* synthetic */ c(a a2, int n2, byte by) {
        super(a2, n2);
    }

    static c a() {
        b b2 = d.get();
        if (b2.d == 0) {
            return new c(c, 4, 0);
        }
        b2.d = -1 + b2.d;
        int n2 = -1 + b2.c & b2.b;
        c c2 = b2.a[n2];
        b2.c = n2;
        return c2;
    }

    private void a(int n2) {
        if (n2 >= this.f) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void a(int n2, Object object) {
        this.a[n2] = object;
        this.b = true;
    }

    private void c() {
        int n2 = this.a.length << 1;
        if (n2 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] arrobject = new Object[n2];
        System.arraycopy((Object)this.a, (int)0, (Object)arrobject, (int)0, (int)this.a.length);
        this.a = arrobject;
    }

    public final void add(int n2, Object object) {
        l.a(object, "element");
        c.super.a(n2);
        if (this.f == this.a.length) {
            c.super.c();
        }
        if (n2 != -1 + this.f) {
            System.arraycopy((Object)this.a, (int)n2, (Object)this.a, (int)(n2 + 1), (int)(this.f - n2));
        }
        c.super.a(n2, object);
        this.f = 1 + this.f;
    }

    /*
     * Exception decompiling
     */
    public final boolean add(Object var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl18 : ALOAD_0 : trying to set 1 previously set to 0
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

    final void b() {
        for (int i2 = 0; i2 < this.f; ++i2) {
            this.a[i2] = null;
        }
        this.f = 0;
        this.b = false;
        this.e.a(this);
    }

    public final void clear() {
        this.f = 0;
    }

    public final Object get(int n2) {
        c.super.a(n2);
        return this.a[n2];
    }

    public final Object remove(int n2) {
        int n3;
        c.super.a(n2);
        Object object = this.a[n2];
        int n4 = -1 + (this.f - n2);
        if (n4 > 0) {
            System.arraycopy((Object)this.a, (int)(n2 + 1), (Object)this.a, (int)n2, (int)n4);
        }
        Object[] arrobject = this.a;
        this.f = n3 = -1 + this.f;
        arrobject[n3] = null;
        return object;
    }

    public final Object set(int n2, Object object) {
        l.a(object, "element");
        c.super.a(n2);
        Object object2 = this.a[n2];
        c.super.a(n2, object);
        return object2;
    }

    public final int size() {
        return this.f;
    }

    private static interface a {
        public void a(c var1);
    }

}

