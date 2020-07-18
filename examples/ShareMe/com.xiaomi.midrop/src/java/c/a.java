/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.concurrent.TimeUnit
 *  javax.annotation.Nullable
 */
package c;

import c.c;
import c.p;
import c.s;
import c.t;
import c.u;
import c.v;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class a
extends u {
    private static final long a = TimeUnit.SECONDS.toMillis(60L);
    @Nullable
    static a b;
    private static final long d;
    private boolean e;
    @Nullable
    private a f;
    private long g;

    static {
        d = TimeUnit.MILLISECONDS.toNanos(a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(a a2, long l2, boolean bl) {
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
                new Thread(){
                    {
                        this.setDaemon(true);
                    }

                    /*
                     * Exception decompiling
                     */
                    public final void run() {
                        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
                        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
                        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
                        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
                        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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
                }.start();
            }
            long l3 = System.nanoTime();
            if (l2 != 0L && bl) {
                a2.g = l3 + Math.min((long)l2, (long)(a2.c() - l3));
            } else if (l2 != 0L) {
                a2.g = l3 + l2;
            } else {
                if (!bl) {
                    throw new AssertionError();
                }
                a2.g = a2.c();
            }
            long l4 = a2.g - l3;
            a a3 = b;
            while (a3.f != null && l4 >= a3.f.g - l3) {
                a3 = a3.f;
            }
            a2.f = a3.f;
            a3.f = a2;
            if (a3 == b) {
                a.class.notify();
                // ** MonitorExit[var10_3] (shouldn't be in output)
                return;
            }
            // ** MonitorExit[var10_3] (shouldn't be in output)
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a(a a2) {
        Class<a> class_ = a.class;
        synchronized (a.class) {
            a a3 = b;
            while (a3 != null) {
                block6 : {
                    if (a3.f != a2) break block6;
                    a3.f = a2.f;
                    a2.f = null;
                    return false;
                }
                a3 = a3.f;
            }
            return true;
        }
    }

    @Nullable
    static a e() throws InterruptedException {
        a a2 = a.b.f;
        if (a2 == null) {
            long l2 = System.nanoTime();
            a.class.wait(a);
            if (a.b.f == null && System.nanoTime() - l2 >= d) {
                return b;
            }
            return null;
        }
        long l3 = System.nanoTime();
        long l4 = a2.g - l3;
        if (l4 > 0L) {
            long l5 = l4 / 1000000L;
            a.class.wait(l5, (int)(l4 - 1000000L * l5));
            return null;
        }
        a.b.f = a2.f;
        a2.f = null;
        return a2;
    }

    protected IOException a(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause((Throwable)iOException);
        }
        return interruptedIOException;
    }

    protected void a() {
    }

    final void a(boolean bl) throws IOException {
        if (this.z_() && bl) {
            throw this.a(null);
        }
    }

    final IOException b(IOException iOException) throws IOException {
        if (!this.z_()) {
            return iOException;
        }
        return this.a(iOException);
    }

    public final void y_() {
        if (this.e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long l2 = this.A_();
        boolean bl = this.B_();
        if (l2 == 0L && !bl) {
            return;
        }
        this.e = true;
        a.a(this, l2, bl);
    }

    public final boolean z_() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        return a.a(this);
    }

}

