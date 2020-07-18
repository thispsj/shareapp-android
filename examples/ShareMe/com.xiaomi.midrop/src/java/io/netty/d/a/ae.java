/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.ae$a
 *  io.netty.d.a.j
 *  io.netty.d.a.y
 *  java.lang.AssertionError
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Queue
 *  java.util.Set
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.Future
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.Semaphore
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 */
package io.netty.d.a;

import io.netty.d.a.aa;
import io.netty.d.a.ad;
import io.netty.d.a.ae;
import io.netty.d.a.af;
import io.netty.d.a.d;
import io.netty.d.a.h;
import io.netty.d.a.j;
import io.netty.d.a.k;
import io.netty.d.a.p;
import io.netty.d.a.t;
import io.netty.d.a.v;
import io.netty.d.a.y;
import io.netty.d.b.a.e;
import io.netty.d.b.l;
import io.netty.d.b.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/*
 * Exception performing whole class analysis.
 */
public abstract class ae
extends d
implements v {
    private static final io.netty.d.b.a.d a;
    private static final Runnable b;
    private static final AtomicIntegerFieldUpdater<ae> c;
    static final int g = 0;
    protected static final long i = 0L;
    static final /* synthetic */ boolean j = true;
    private final k d;
    long h;
    private final Queue<Runnable> k;
    private final Thread l;
    private final af m;
    private final Semaphore n;
    private final Set<Runnable> o;
    private final boolean p;
    private final int q;
    private final aa r;
    private volatile int s;
    private volatile long t;
    private volatile long u;
    private long v;
    private final y<?> w;

    static {
        g = Math.max((int)16, (int)u.a("io.netty.eventexecutor.maxPendingTasks", Integer.MAX_VALUE));
        a = e.a(ae.class);
        b = new Runnable(){

            public final void run() {
            }
        };
        c = AtomicIntegerFieldUpdater.newUpdater(ae.class, (String)"s");
        i = TimeUnit.SECONDS.toNanos(1L);
    }

    protected ae(k k2, ThreadFactory threadFactory, int n2, aa aa2) {
        this.n = new Semaphore(0);
        this.o = new LinkedHashSet();
        this.s = 1;
        this.w = new h(t.a);
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory");
        }
        this.d = k2;
        this.p = false;
        this.l = threadFactory.newThread(new Runnable((ae)this){
            final /* synthetic */ ae a;
            {
                this.a = ae2;
            }

            /*
             * Exception decompiling
             */
            public final void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // java.lang.IndexOutOfBoundsException: Invalid index 1, size is 1
                // java.util.ArrayList.throwIndexOutOfBoundsException(ArrayList.java:260)
                // java.util.ArrayList.get(ArrayList.java:313)
                // org.benf.cfr.reader.b.a.a.b.ap.a(ReturnRewriter.java:19)
                // org.benf.cfr.reader.b.a.a.b.ap.a(ReturnRewriter.java:40)
                // org.benf.cfr.reader.b.a.a.b.ai.c(Op03Rewriters.java:32)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:448)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.a(Method.java:474)
                // org.benf.cfr.reader.entities.c.d.a(ClassFileDumperAnonymousInner.java:87)
                // org.benf.cfr.reader.b.a.b.a.x.b(ConstructorInvokationAnonymousInner.java:73)
                // org.benf.cfr.reader.b.a.b.a.c.a(AbstractExpression.java:119)
                // org.benf.cfr.reader.b.a.b.a.c.a(AbstractExpression.java:80)
                // org.benf.cfr.reader.b.a.e.s.a(MethodPrototype.java:473)
                // org.benf.cfr.reader.b.a.b.a.ag.b(MemberFunctionInvokation.java:62)
                // org.benf.cfr.reader.b.a.b.a.c.a(AbstractExpression.java:119)
                // org.benf.cfr.reader.b.a.b.a.c.a(AbstractExpression.java:80)
                // org.benf.cfr.reader.util.output.t.a(StreamDumper.java:146)
                // org.benf.cfr.reader.b.a.d.b.g.a(StructuredAssignment.java:59)
                // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:204)
                // org.benf.cfr.reader.b.a.d.b.e.a(Block.java:543)
                // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:204)
                // org.benf.cfr.reader.entities.attributes.f.a(AttributeCode.java:141)
                // org.benf.cfr.reader.util.output.t.a(StreamDumper.java:146)
                // org.benf.cfr.reader.entities.g.a(Method.java:493)
                // org.benf.cfr.reader.entities.c.g.a(ClassFileDumperNormal.java:87)
                // org.benf.cfr.reader.entities.d.a(ClassFile.java:1000)
                // org.benf.cfr.reader.b.a(Driver.java:134)
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
        });
        this.m = new /* Unavailable Anonymous Inner Class!! */;
        this.q = Math.max((int)16, (int)n2);
        this.k = this.a(this.q);
        this.r = l.a(aa2, "rejectedHandler");
    }

    static /* synthetic */ long a(ae ae2) {
        return ae2.v;
    }

    private void a(String string2) {
        if (this.a(Thread.currentThread())) {
            StringBuilder stringBuilder = new StringBuilder("Calling ");
            stringBuilder.append(string2);
            stringBuilder.append(" from within the EventLoop is not allowed");
            throw new RejectedExecutionException(stringBuilder.toString());
        }
    }

    static /* synthetic */ Semaphore b(ae ae2) {
        return ae2.n;
    }

    static /* synthetic */ Queue c(ae ae2) {
        return ae2.k;
    }

    private void c(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        if (this.isShutdown()) {
            ae.t();
        }
        if (!this.k.offer((Object)runnable)) {
            this.r.a();
        }
    }

    static /* synthetic */ y d(ae ae2) {
        return ae2.w;
    }

    private boolean f() {
        Runnable runnable;
        long l2 = ad.f();
        while ((runnable = this.a(l2)) != null) {
            if (this.k.offer((Object)runnable)) continue;
            this.i().add((Object)((ad)runnable));
            return false;
        }
        return true;
    }

    static /* synthetic */ io.netty.d.b.a.d q() {
        return a;
    }

    static /* synthetic */ AtomicIntegerFieldUpdater r() {
        return c;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private boolean s() {
        boolean bl = false;
        block4 : do {
            if (this.o.isEmpty()) {
                if (!bl) return bl;
                this.h = ad.f();
                return bl;
            }
            ArrayList arrayList = new ArrayList(this.o);
            this.o.clear();
            Iterator iterator = arrayList.iterator();
            do {
                block7 : {
                    if (!iterator.hasNext()) continue block4;
                    Runnable runnable = (Runnable)iterator.next();
                    runnable.run();
                    break block7;
                    catch (Throwable throwable) {
                        a.d("Shutdown hook raised an exception.", throwable);
                    }
                }
                bl = true;
            } while (true);
            break;
        } while (true);
    }

    private static void t() {
        throw new RejectedExecutionException("event executor terminated");
    }

    public int a() {
        return this.k.size();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final p<?> a(long var1, long var3_3, TimeUnit var5_2) {
        if (var1 < 0L) {
            var6_4 = new StringBuilder("quietPeriod: ");
            var6_4.append(var1);
            var6_4.append(" (expected >= 0)");
            throw new IllegalArgumentException(var6_4.toString());
        }
        if (var3_3 < var1) {
            var9_5 = new StringBuilder("timeout: ");
            var9_5.append(var3_3);
            var9_5.append(" (expected >= quietPeriod (");
            var9_5.append(var1);
            var9_5.append("))");
            throw new IllegalArgumentException(var9_5.toString());
        }
        if (var5_2 == null) {
            throw new NullPointerException("unit");
        }
        if (this.o()) {
            return this.w;
        }
        var14_6 = this.a(Thread.currentThread());
        do {
            if (this.o()) {
                return this.w;
            }
            var15_9 = this.s;
            var16_8 = 3;
            if (var14_6) ** GOTO lbl-1000
            switch (var15_9) {
                case 1: 
                case 2: lbl-1000: // 2 sources:
                {
                    var17_7 = true;
                    break;
                }
                default: {
                    var16_8 = var15_9;
                    var17_7 = false;
                }
            }
        } while (!ae.c.compareAndSet((Object)this, var15_9, var16_8));
        this.t = var5_2.toNanos(var1);
        this.u = var5_2.toNanos(var3_3);
        if (var15_9 == 1) {
            this.l.start();
        }
        if (var17_7 == false) return this.w;
        this.a(var14_6);
        return this.w;
    }

    public Queue<Runnable> a(int n2) {
        return new LinkedBlockingQueue(n2);
    }

    public void a(boolean bl) {
        if (!bl || this.s == 3) {
            this.k.offer((Object)b);
        }
    }

    public boolean a(Runnable runnable) {
        return true;
    }

    public final boolean a(Thread thread) {
        return thread == this.l;
    }

    public boolean awaitTermination(long l2, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (this.a(Thread.currentThread())) {
            throw new IllegalStateException("cannot await termination of the current thread");
        }
        if (this.n.tryAcquire(l2, timeUnit)) {
            this.n.release();
        }
        return this.isTerminated();
    }

    protected final boolean b(long l2) {
        ae.super.f();
        Runnable runnable = this.e();
        if (runnable == null) {
            return false;
        }
        long l3 = l2 + ad.f();
        long l4 = 0L;
        do {
            long l5;
            block8 : {
                long l6;
                block7 : {
                    try {
                        runnable.run();
                    }
                    catch (Throwable throwable) {
                        a.d("A task raised an exception.", throwable);
                    }
                    l5 = l4 + 1L;
                    if ((l5 & 63L) == 0L && (l6 = ad.f()) >= l3) break block7;
                    runnable = this.e();
                    if (runnable != null) break block8;
                    l6 = ad.f();
                }
                this.h = l6;
                return true;
            }
            l4 = l5;
        } while (true);
    }

    public abstract void c();

    public void d() {
    }

    public Runnable e() {
        Runnable runnable;
        if (!j && !this.a(Thread.currentThread())) {
            throw new AssertionError();
        }
        while ((runnable = (Runnable)this.k.poll()) == b) {
        }
        return runnable;
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        boolean bl = this.a(Thread.currentThread());
        if (bl) {
            ae.super.c(runnable);
        } else {
            if (this.s == 1 && c.compareAndSet((Object)this, 1, 2)) {
                this.l.start();
            }
            ae.super.c(runnable);
            if (this.isShutdown()) {
                if (runnable == null) {
                    throw new NullPointerException("task");
                }
                if (this.k.remove((Object)runnable)) {
                    ae.t();
                }
            }
        }
        if (!this.p && this.a(runnable)) {
            this.a(bl);
        }
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        ae.super.a("invokeAll");
        return super.invokeAll(collection);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long l2, TimeUnit timeUnit) throws InterruptedException {
        ae.super.a("invokeAll");
        return super.invokeAll(collection, l2, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        ae.super.a("invokeAny");
        return (T)super.invokeAny(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long l2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        ae.super.a("invokeAny");
        return (T)super.invokeAny(collection, l2, timeUnit);
    }

    public boolean isShutdown() {
        return this.s >= 4;
    }

    public boolean isTerminated() {
        return this.s == 5;
    }

    public final p<?> l() {
        return this.w;
    }

    protected final boolean m() {
        if (!j && !this.a(Thread.currentThread())) {
            throw new AssertionError();
        }
        return !this.k.isEmpty();
    }

    protected final boolean n() {
        boolean bl;
        do {
            bl = this.f();
            Runnable runnable = this.e();
            if (runnable == null) {
                return false;
            }
            do {
                try {
                    runnable.run();
                }
                catch (Throwable throwable) {
                    a.d("A task raised an exception.", throwable);
                }
            } while ((runnable = this.e()) != null);
        } while (!bl);
        this.h = ad.f();
        return true;
    }

    public final boolean o() {
        return this.s >= 3;
    }

    protected final boolean p() {
        if (!this.o()) {
            return false;
        }
        if (!this.a(Thread.currentThread())) {
            throw new IllegalStateException("must be invoked from an event loop");
        }
        this.j();
        if (this.v == 0L) {
            this.v = ad.f();
        }
        if (!this.n() && !this.s()) {
            long l2 = ad.f();
            if (!this.isShutdown()) {
                if (l2 - this.v > this.u) {
                    return true;
                }
                if (l2 - this.h <= this.t) {
                    this.a(true);
                    try {
                        Thread.sleep((long)100L);
                    }
                    catch (InterruptedException interruptedException) {}
                    return false;
                }
            }
            return true;
        }
        if (this.isShutdown()) {
            return true;
        }
        if (this.t == 0L) {
            return true;
        }
        this.a(true);
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Deprecated
    @Override
    public void shutdown() {
        if (this.isShutdown()) {
            return;
        }
        var1_1 = this.a(Thread.currentThread());
        do {
            if (this.o()) {
                return;
            }
            var2_3 = this.s;
            var3_4 = 4;
            if (var1_1) ** GOTO lbl-1000
            switch (var2_3) {
                case 1: 
                case 2: 
                case 3: lbl-1000: // 2 sources:
                {
                    var4_2 = true;
                    break;
                }
                default: {
                    var3_4 = var2_3;
                    var4_2 = false;
                }
            }
        } while (!ae.c.compareAndSet((Object)this, var2_3, var3_4));
        if (var2_3 == 1) {
            this.l.start();
        }
        if (var4_2 == false) return;
        this.a(var1_1);
    }
}

