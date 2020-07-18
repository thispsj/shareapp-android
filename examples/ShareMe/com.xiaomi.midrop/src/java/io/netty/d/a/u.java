/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.b
 *  io.netty.d.a.j
 *  io.netty.d.a.q
 *  io.netty.d.a.y
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.System
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 */
package io.netty.d.a;

import io.netty.d.a.b;
import io.netty.d.a.i;
import io.netty.d.a.j;
import io.netty.d.a.p;
import io.netty.d.a.q;
import io.netty.d.a.y;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class u
extends b {
    private final j[] a;
    private final AtomicInteger b;
    private final AtomicInteger c;
    private final y<?> d;
    private final a e;

    /*
     * Exception decompiling
     */
    protected /* varargs */ u(int var1, ThreadFactory var2, Object ... var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl139 : ALOAD : trying to set 0 previously set to 1
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

    static /* synthetic */ AtomicInteger d(u u2) {
        return u2.b;
    }

    public /* varargs */ abstract j a(ThreadFactory var1, Object ... var2) throws Exception;

    public final p<?> a(long l2, long l3, TimeUnit timeUnit) {
        j[] arrj = this.a;
        int n2 = arrj.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrj[i2].a(l2, l3, timeUnit);
        }
        return this.d;
    }

    public ThreadFactory a() {
        return new i(this.getClass());
    }

    public boolean awaitTermination(long l2, TimeUnit timeUnit) throws InterruptedException {
        long l3 = System.nanoTime() + timeUnit.toNanos(l2);
        block0 : for (j j2 : this.a) {
            long l4;
            while ((l4 = l3 - System.nanoTime()) > 0L) {
                if (!j2.awaitTermination(l4, TimeUnit.NANOSECONDS)) continue;
                continue block0;
            }
            break block0;
        }
        return this.isTerminated();
    }

    public j b() {
        return this.e.a();
    }

    public boolean isShutdown() {
        j[] arrj = this.a;
        int n2 = arrj.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrj[i2].isShutdown()) continue;
            return false;
        }
        return true;
    }

    public boolean isTerminated() {
        j[] arrj = this.a;
        int n2 = arrj.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrj[i2].isTerminated()) continue;
            return false;
        }
        return true;
    }

    public Iterator<j> iterator() {
        Set set = Collections.newSetFromMap((Map)new LinkedHashMap());
        Collections.addAll((Collection)set, (Object[])this.a);
        return set.iterator();
    }

    public final p<?> l() {
        return this.d;
    }

    @Deprecated
    public void shutdown() {
        j[] arrj = this.a;
        int n2 = arrj.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrj[i2].shutdown();
        }
    }

}

