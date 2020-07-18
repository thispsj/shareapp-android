/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ClassLoader
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Void
 *  java.lang.ref.ReferenceQueue
 *  java.lang.ref.WeakReference
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package io.netty.d.b;

import io.netty.d.a.o;
import io.netty.d.b.d;
import io.netty.d.b.l;
import io.netty.d.b.u;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class k {
    static final String a;
    private static final int b;
    private static final Set<a> c;
    private static final ReferenceQueue<Object> d;
    private static final AtomicBoolean e;
    private static final Runnable f;

    static {
        b = Math.max((int)500, (int)u.a("io.netty.util.internal.ObjectCleaner.refQueuePollTimeout", 10000));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k.class.getSimpleName());
        stringBuilder.append("Thread");
        a = stringBuilder.toString();
        c = new d();
        d = new ReferenceQueue();
        e = new AtomicBoolean(false);
        f = new Runnable(){

            /*
             * Exception decompiling
             */
            public final void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl3 : INVOKESTATIC : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
        };
    }

    private k() {
    }

    public static void a(Object object, Runnable runnable) {
        a a2 = new a(object, l.a(runnable, "cleanupTask"));
        c.add((Object)a2);
        if (e.compareAndSet(false, true)) {
            final o o2 = new o(f);
            o2.setPriority(1);
            AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<Void>(){

                public final /* synthetic */ Object run() {
                    o2.setContextClassLoader(null);
                    return null;
                }
            });
            o2.setName(a);
            o2.setDaemon(true);
            o2.start();
        }
    }

    static /* synthetic */ int b() {
        return b;
    }

    static /* synthetic */ AtomicBoolean d() {
        return e;
    }

    private static final class a
    extends WeakReference<Object> {
        final Runnable a;

        a(Object object, Runnable runnable) {
            super(object, d);
            this.a = runnable;
        }

        public final void clear() {
            c.remove((Object)this);
            super.clear();
        }
    }

}

