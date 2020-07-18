/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.g
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.security.SecureRandom
 *  java.util.Random
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicLong
 */
package io.netty.d.b;

import io.netty.d.b.a.d;
import io.netty.d.b.a.e;
import io.netty.d.b.g;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class v
extends Random {
    private static final d b = e.a(v.class);
    private static final AtomicLong c = new AtomicLong();
    private static volatile long d = 0L;
    private static final long serialVersionUID = -5851777807851030925L;
    boolean a = true;
    private long e;

    v() {
        super(v.d());
    }

    private static long a(long l2) {
        long l3 = -49064778989728563L * (l2 ^ l2 >>> 33);
        long l4 = -4265267296055464877L * (l3 ^ l3 >>> 33);
        return l4 ^ l4 >>> 33;
    }

    public static v a() {
        g g2 = g.b();
        v v2 = g2.i;
        if (v2 == null) {
            g2.i = v2 = new v();
        }
        return v2;
    }

    /*
     * Exception decompiling
     */
    private static long c() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl91 : LLOAD_1 : trying to set 1 previously set to 0
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

    private static long d() {
        long l2;
        long l3;
        long l4;
        long l5 = System.nanoTime();
        while (!c.compareAndSet(l2, l4 = 181783497276652981L * (l3 = (l2 = c.get()) != 0L ? l2 : v.c()))) {
        }
        if (l2 == 0L && b.b()) {
            d d2 = b;
            Object[] arrobject = new Object[]{l3, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l5)};
            d2.b(String.format((String)"-Dio.netty.initialSeedUniquifier: 0x%016x (took %d ms)", (Object[])arrobject));
        }
        return l4 ^ System.nanoTime();
    }

    protected final int next(int n2) {
        this.e = 0xFFFFFFFFFFFFL & 11L + 25214903917L * this.e;
        return (int)(this.e >>> 48 - n2);
    }

    public final void setSeed(long l2) {
        if (this.a) {
            throw new UnsupportedOperationException();
        }
        this.e = 0xFFFFFFFFFFFFL & (l2 ^ 25214903917L);
    }

}

