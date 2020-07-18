/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.c
 *  io.netty.d.a.j
 *  io.netty.d.a.s
 *  io.netty.d.a.y
 *  io.netty.d.b.g
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.InternalError
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package io.netty.d.a;

import io.netty.d.a.c;
import io.netty.d.a.e;
import io.netty.d.a.g;
import io.netty.d.a.h;
import io.netty.d.a.j;
import io.netty.d.a.r;
import io.netty.d.a.s;
import io.netty.d.a.y;
import io.netty.d.b.a.d;
import io.netty.d.b.l;
import io.netty.d.b.n;
import io.netty.d.b.t;
import io.netty.d.b.u;
import io.netty.d.b.w;
import io.netty.d.p;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class h<V>
extends c<V>
implements y<V> {
    private static final d a = io.netty.d.b.a.e.a(h.class);
    private static final d b;
    private static final int c;
    private static final AtomicReferenceFieldUpdater<h, Object> d;
    private static final p e;
    private static final p f;
    private static final a g;
    private volatile Object h;
    private final j i;
    private Object j;
    private short k;
    private boolean l;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(h.class.getName());
        stringBuilder.append(".rejectedExecution");
        b = io.netty.d.b.a.e.a(stringBuilder.toString());
        c = Math.min((int)8, (int)u.a("io.netty.defaultPromise.maxListenerStackDepth", 8));
        d = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, (String)"h");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(h.class.getName());
        stringBuilder2.append(".SUCCESS");
        e = p.a(stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(h.class.getName());
        stringBuilder3.append(".UNCANCELLABLE");
        f = p.a(stringBuilder3.toString());
        g = new Object((Throwable)w.a(new CancellationException(), h.class, "cancel(...)")){
            final Throwable a;
            {
                this.a = throwable;
            }
        };
    }

    protected h() {
        this.i = null;
    }

    public h(j j2) {
        this.i = l.a(j2, "executor");
    }

    static /* synthetic */ void a(h h2) {
        h2.f();
    }

    protected static void a(j j2, io.netty.d.a.p<?> p2, r<?> r2) {
        l.a(j2, "eventExecutor");
        l.a(p2, "future");
        l.a(r2, "listener");
        if (j2.g()) {
            io.netty.d.b.g g2 = io.netty.d.b.g.b();
            int n2 = g2.e;
            if (n2 < c) {
                g2.e = n2 + 1;
                try {
                    h.b(p2, r2);
                    return;
                }
                finally {
                    g2.e = n2;
                }
            }
        }
        h.a(j2, new Runnable(p2, r2){
            final /* synthetic */ io.netty.d.a.p a;
            final /* synthetic */ r b;
            {
                this.a = p2;
                this.b = r2;
            }

            public final void run() {
                h.a(this.a, this.b);
            }
        });
    }

    private static void a(j j2, Runnable runnable) {
        try {
            j2.execute(runnable);
            return;
        }
        catch (Throwable throwable) {
            b.e("Failed to submit a listener notification task. Event loop shut down?", throwable);
            return;
        }
    }

    static /* synthetic */ void a(io.netty.d.a.p p2, r r2) {
        h.b(p2, r2);
    }

    /*
     * Exception decompiling
     */
    private boolean a(long var1, boolean var3_2) throws InterruptedException {
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

    private boolean a(Throwable throwable) {
        return h.super.c(new /* invalid duplicate definition of identical inner class */);
    }

    private static void b(io.netty.d.a.p p2, r r2) {
        try {
            r2.a(p2);
            return;
        }
        catch (Throwable throwable) {
            d d2 = a;
            StringBuilder stringBuilder = new StringBuilder("An exception was thrown by ");
            stringBuilder.append(r2.getClass().getName());
            stringBuilder.append(".operationComplete()");
            d2.d(stringBuilder.toString(), throwable);
            return;
        }
    }

    private boolean b(V object) {
        if (object == null) {
            object = e;
        }
        return h.super.c(object);
    }

    private boolean c(Object object) {
        if (!d.compareAndSet((Object)this, null, object) && !d.compareAndSet((Object)this, (Object)f, object)) {
            return false;
        }
        h.super.m();
        return true;
    }

    private static boolean d(Object object) {
        return object instanceof a && (object).a instanceof CancellationException;
    }

    private void e() {
        j j2 = this.k_();
        if (j2.g()) {
            io.netty.d.b.g g2 = io.netty.d.b.g.b();
            int n2 = g2.e;
            if (n2 < c) {
                g2.e = n2 + 1;
                try {
                    this.f();
                    return;
                }
                finally {
                    g2.e = n2;
                }
            }
        }
        h.a(j2, new Runnable(this){
            final /* synthetic */ h a;
            {
                this.a = h2;
            }

            public final void run() {
                h.a(this.a);
            }
        });
    }

    private static boolean e(Object object) {
        return object != null && object != f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f() {
        Object object;
        h h2 = this;
        synchronized (h2) {
            if (!this.l && this.j != null) {
                this.l = true;
                object = this.j;
                this.j = null;
            } else {
                return;
            }
        }
        do {
            if (object instanceof g) {
                g g2 = (g)object;
                r<? extends io.netty.d.a.p<?>>[] arrr = g2.a;
                int n2 = g2.b;
                for (int i2 = 0; i2 < n2; ++i2) {
                    h.b((io.netty.d.a.p)((Object)this), arrr[i2]);
                }
            } else {
                h.b((io.netty.d.a.p)((Object)this), (r)object);
            }
            h2 = this;
            synchronized (h2) {
                if (this.j == null) {
                    this.l = false;
                    return;
                }
                object = this.j;
                this.j = null;
            }
        } while (true);
    }

    private void m() {
        h h2 = this;
        synchronized (h2) {
            if (this.k > 0) {
                this.notifyAll();
            }
            return;
        }
    }

    private void n() {
        if (this.k == 32767) {
            StringBuilder stringBuilder = new StringBuilder("too many waiters: ");
            stringBuilder.append((Object)this);
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.k = (short)(1 + this.k);
    }

    private void o() {
        this.k = (short)(-1 + this.k);
    }

    private void p() {
        Throwable throwable = this.g();
        if (throwable == null) {
            return;
        }
        n.a(throwable);
    }

    public y<V> a(V v2) {
        if (h.super.b(v2)) {
            h.super.e();
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder("complete already: ");
        stringBuilder.append((Object)this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final boolean a() {
        try {
            boolean bl = this.a(TimeUnit.MILLISECONDS.toNanos(10000L), false);
            return bl;
        }
        catch (InterruptedException interruptedException) {
            throw new InternalError();
        }
    }

    public final boolean a(long l2, TimeUnit timeUnit) throws InterruptedException {
        return h.super.a(timeUnit.toNanos(l2), true);
    }

    public /* synthetic */ io.netty.d.a.p b(r r2) {
        return this.c(r2);
    }

    public boolean b(Throwable throwable) {
        if (h.super.a(throwable)) {
            h.super.e();
            return true;
        }
        return false;
    }

    public /* synthetic */ io.netty.d.a.p c() throws InterruptedException {
        return this.k();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public y<V> c(r<? extends io.netty.d.a.p<? super V>> r2) {
        l.a(r2, "listener");
        void var7_2 = this;
        // MONITORENTER : var7_2
        if (this.j == null) {
            this.j = r2;
        } else if (this.j instanceof g) {
            g g2 = (g)this.j;
            int n2 = g2.b;
            Object[] arrobject = g2.a;
            if (n2 == arrobject.length) {
                arrobject = (r[])Arrays.copyOf((Object[])arrobject, (int)(n2 << 1));
                g2.a = arrobject;
            }
            arrobject[n2] = r2;
            g2.b = n2 + 1;
            if (r2 instanceof s) {
                g2.c = 1 + g2.c;
            }
        } else {
            this.j = new g((r)this.j, r2);
        }
        // MONITOREXIT : var7_2
        if (!this.isDone()) return this;
        h.super.e();
        return this;
    }

    public y<V> c(Throwable throwable) {
        if (h.super.a(throwable)) {
            h.super.e();
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder("complete already: ");
        stringBuilder.append((Object)this);
        throw new IllegalStateException(stringBuilder.toString(), throwable);
    }

    public boolean cancel(boolean bl) {
        if (d.compareAndSet((Object)this, null, (Object)g)) {
            h.super.m();
            h.super.e();
            return true;
        }
        return false;
    }

    public final V d() {
        Object object = this.h;
        if (!(object instanceof a) && object != e) {
            return (V)object;
        }
        return null;
    }

    public final Throwable g() {
        Object object = this.h;
        if (object instanceof a) {
            return (object).a;
        }
        return null;
    }

    public final boolean h() {
        Object object = this.h;
        return object != null && object != f && !(object instanceof a);
    }

    public boolean i() {
        if (d.compareAndSet((Object)this, null, (Object)f)) {
            return true;
        }
        Object object = this.h;
        if (h.e(object)) {
            return !h.d(object);
        }
        return true;
    }

    public boolean isCancelled() {
        return h.d(this.h);
    }

    public boolean isDone() {
        return h.e(this.h);
    }

    /*
     * Exception decompiling
     */
    public y<V> j() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl14 : ALOAD_0 : trying to set 1 previously set to 0
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public y<V> k() throws InterruptedException {
        if (this.isDone()) {
            return this;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException(this.toString());
        }
        this.m_();
        h h2 = this;
        synchronized (h2) {
            while (!this.isDone()) {
                this.n();
                try {
                    this.wait();
                    continue;
                }
                finally {
                    this.o();
                    continue;
                }
                break;
            }
            return this;
        }
    }

    public j k_() {
        return this.i;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected StringBuilder l() {
        StringBuilder stringBuilder;
        String string2;
        block3 : {
            block7 : {
                void var5_4;
                block6 : {
                    Object object;
                    block5 : {
                        block4 : {
                            block2 : {
                                stringBuilder = new StringBuilder(64);
                                stringBuilder.append(t.a((Object)this));
                                stringBuilder.append('@');
                                stringBuilder.append(Integer.toHexString((int)this.hashCode()));
                                object = this.h;
                                if (object != e) break block2;
                                string2 = "(success)";
                                break block3;
                            }
                            if (object != f) break block4;
                            string2 = "(uncancellable)";
                            break block3;
                        }
                        if (!(object instanceof a)) break block5;
                        stringBuilder.append("(failure: ");
                        Throwable throwable = (object).a;
                        break block6;
                    }
                    if (object == null) break block7;
                    stringBuilder.append("(success: ");
                }
                stringBuilder.append((Object)var5_4);
                stringBuilder.append(')');
                return stringBuilder;
            }
            string2 = "(incomplete)";
        }
        stringBuilder.append(string2);
        return stringBuilder;
    }

    protected void m_() {
        j j2 = this.k_();
        if (j2 != null && j2.g()) {
            throw new e(this.toString());
        }
    }

    public y<V> n_() {
        this.j();
        this.p();
        return this;
    }

    public y<V> o_() throws InterruptedException {
        this.k();
        this.p();
        return this;
    }

    public /* synthetic */ io.netty.d.a.p p_() {
        return this.n_();
    }

    public boolean q_() {
        if (this.b((V)null)) {
            this.e();
            return true;
        }
        return false;
    }

    public String toString() {
        return this.l().toString();
    }

}

