/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.a.b$b
 *  io.netty.b.a.d$1
 *  io.netty.b.ai
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.nio.channels.SelectableChannel
 *  java.nio.channels.SelectionKey
 *  java.nio.channels.Selector
 *  java.nio.channels.spi.AbstractSelector
 *  java.nio.channels.spi.SelectorProvider
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Queue
 *  java.util.Set
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package io.netty.b.a;

import io.netty.b.a.b;
import io.netty.b.a.d;
import io.netty.b.a.e;
import io.netty.b.a.f;
import io.netty.b.a.g;
import io.netty.b.ai;
import io.netty.b.an;
import io.netty.b.aq;
import io.netty.b.x;
import io.netty.d.a.aa;
import io.netty.d.a.p;
import io.netty.d.b.n;
import io.netty.d.b.u;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
extends aq {
    private static final io.netty.d.b.a.d k;
    private static final boolean l;
    private static final int m;
    Selector b;
    int c;
    boolean d;
    private final io.netty.d.g n = new 1(this);
    private final Callable<Integer> o = new Callable<Integer>(this){
        final /* synthetic */ d a;
        {
            this.a = d2;
        }

        public final /* synthetic */ Object call() throws Exception {
            return d.a(this.a);
        }
    };
    private Selector p;
    private f q;
    private final SelectorProvider r;
    private final AtomicBoolean s = new AtomicBoolean();
    private final an t;
    private volatile int u = 50;

    static {
        int n2;
        k = io.netty.d.b.a.e.a(d.class);
        l = u.a("io.netty.noKeySetOptimization", false);
        if (u.b("sun.nio.ch.bugLevel") == null) {
            try {
                AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<Void>(){

                    public final /* synthetic */ Object run() {
                        java.lang.System.setProperty((String)"sun.nio.ch.bugLevel", (String)"");
                        return null;
                    }
                });
            }
            catch (SecurityException securityException) {
                k.b("Unable to get/set System Property: sun.nio.ch.bugLevel", securityException);
            }
        }
        if ((n2 = u.a("io.netty.selectorAutoRebuildThreshold", 512)) < 3) {
            n2 = 0;
        }
        m = n2;
        if (k.b()) {
            k.b("-Dio.netty.noKeySetOptimization: {}", (Object)l);
            k.b("-Dio.netty.selectorAutoRebuildThreshold: {}", (Object)m);
        }
    }

    d(e e2, ThreadFactory threadFactory, SelectorProvider selectorProvider, an an2, aa aa2) {
        super(e2, threadFactory, a, aa2);
        if (selectorProvider == null) {
            throw new NullPointerException("selectorProvider");
        }
        if (an2 == null) {
            throw new NullPointerException("selectStrategy");
        }
        this.r = selectorProvider;
        a a2 = this.s();
        this.p = a2.b;
        this.b = a2.a;
        this.t = an2;
    }

    static /* synthetic */ int a(d d2) {
        return super.a();
    }

    private static void a(Throwable throwable) {
        k.d("Unexpected exception in the selector loop.", throwable);
        try {
            Thread.sleep((long)1000L);
        }
        catch (InterruptedException interruptedException) {}
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void a(SelectionKey selectionKey) {
        Throwable throwable2222;
        selectionKey.channel();
        if (selectionKey.isValid()) return;
        d.b(selectionKey);
        return;
        {
            catch (Throwable throwable2222) {
            }
            catch (Exception exception) {}
            {
                selectionKey.cancel();
                d.b(selectionKey);
                return;
            }
        }
        selectionKey.cancel();
        d.b(selectionKey);
        throw throwable2222;
    }

    /*
     * Exception decompiling
     */
    private void a(SelectionKey var1, b var2) {
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

    static /* synthetic */ void b(d d2) {
        d2.t();
    }

    private static void b(SelectionKey selectionKey) {
        try {
            selectionKey.channel();
            return;
        }
        catch (Exception exception) {
            k.d("Unexpected exception while running NioTask.channelUnregistered()", exception);
            return;
        }
    }

    private a s() {
        Class class_;
        AbstractSelector abstractSelector;
        block5 : {
            try {
                abstractSelector = this.r.openSelector();
                if (!l) break block5;
            }
            catch (IOException iOException) {
                throw new io.netty.b.g("failed to open a new selector", iOException);
            }
            return new Object((Selector)abstractSelector){
                final Selector a;
                final Selector b;
                {
                    this.a = selector;
                    this.b = selector;
                }
                {
                    this.a = selector;
                    this.b = selector2;
                }
            };
        }
        f f2 = new f();
        Object object = AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<Object>(this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public final Object run() {
                try {
                    Class class_ = Class.forName((String)"sun.nio.ch.SelectorImpl", (boolean)false, (java.lang.ClassLoader)n.n());
                    return class_;
                }
                catch (Throwable throwable) {
                    return throwable;
                }
            }
        });
        if (object instanceof Class && (class_ = (Class)object).isAssignableFrom(abstractSelector.getClass())) {
            Object object2 = AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<Object>(this, class_, (Selector)abstractSelector, f2){
                final /* synthetic */ Class a;
                final /* synthetic */ Selector b;
                final /* synthetic */ f c;
                final /* synthetic */ d d;
                {
                    this.d = d2;
                    this.a = class_;
                    this.b = selector;
                    this.c = f2;
                }

                public final Object run() {
                    java.lang.reflect.Field field;
                    java.lang.reflect.Field field2;
                    block6 : {
                        block5 : {
                            field = this.a.getDeclaredField("selectedKeys");
                            field2 = this.a.getDeclaredField("publicSelectedKeys");
                            Throwable throwable = io.netty.d.b.r.a((java.lang.reflect.AccessibleObject)field, true);
                            if (throwable == null) break block5;
                            return throwable;
                        }
                        Throwable throwable = io.netty.d.b.r.a((java.lang.reflect.AccessibleObject)field2, true);
                        if (throwable == null) break block6;
                        return throwable;
                    }
                    try {
                        field.set((Object)this.b, (Object)((Object)this.c));
                        field2.set((Object)this.b, (Object)((Object)this.c));
                        return null;
                    }
                    catch (java.lang.IllegalAccessException illegalAccessException) {
                        return illegalAccessException;
                    }
                    catch (java.lang.NoSuchFieldException noSuchFieldException) {
                        return noSuchFieldException;
                    }
                }
            });
            if (object2 instanceof Exception) {
                this.q = null;
                Exception exception = (Exception)((Object)object2);
                k.a("failed to instrument a special java.util.Set into: {}", (Object)abstractSelector, (Object)exception);
                return new /* invalid duplicate definition of identical inner class */;
            }
            this.q = f2;
            k.a("instrumented a special java.util.Set into: {}", (Object)abstractSelector);
            return new /* invalid duplicate definition of identical inner class */;
        }
        if (object instanceof Throwable) {
            Throwable throwable = (Throwable)((Object)object);
            k.a("failed to instrument a special java.util.Set into: {}", (Object)abstractSelector, (Object)throwable);
        }
        return new /* invalid duplicate definition of identical inner class */;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void t() {
        int n2;
        block10 : {
            a a2;
            Selector selector = this.p;
            if (selector == null) {
                return;
            }
            try {
                a2 = this.s();
                n2 = 0;
            }
            catch (Exception exception) {
                k.d("Failed to create a new Selector.", exception);
                return;
            }
            Iterator iterator = selector.keys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey)iterator.next();
                Object object = selectionKey.attachment();
                try {
                    if (!selectionKey.isValid() || selectionKey.channel().keyFor(a2.a) != null) continue;
                    int n3 = selectionKey.interestOps();
                    selectionKey.cancel();
                    SelectionKey selectionKey2 = selectionKey.channel().register(a2.a, n3, object);
                    if (object instanceof b) {
                        ((b)object).e = selectionKey2;
                    }
                    ++n2;
                }
                catch (Exception exception) {
                    k.d("Failed to re-register a Channel to the new Selector.", exception);
                    if (object instanceof b) {
                        b b2 = (b)((Object)object);
                        b2.E().a(b2.E().h());
                        continue;
                    }
                    d.b(selectionKey);
                }
            }
            this.p = a2.b;
            this.b = a2.a;
            try {
                selector.close();
            }
            catch (Throwable throwable) {
                if (!k.d()) break block10;
                k.d("Failed to close the old Selector.", throwable);
            }
        }
        io.netty.d.b.a.d d2 = k;
        StringBuilder stringBuilder = new StringBuilder("Migrated ");
        stringBuilder.append(n2);
        stringBuilder.append(" channel(s) to the new Selector.");
        d2.c(stringBuilder.toString());
    }

    private void u() {
        if (this.q != null) {
            for (int i2 = 0; i2 < this.q.b; ++i2) {
                SelectionKey selectionKey = this.q.a[i2];
                this.q.a[i2] = null;
                Object object = selectionKey.attachment();
                if (object instanceof b) {
                    this.a(selectionKey, (b)((Object)object));
                } else {
                    d.a(selectionKey);
                }
                if (!this.d) continue;
                this.q.a(i2 + 1);
                this.w();
                i2 = -1;
            }
            return;
        }
        Set set = this.p.selectedKeys();
        if (!set.isEmpty()) {
            block1 : do {
                Iterator iterator = set.iterator();
                do {
                    SelectionKey selectionKey = (SelectionKey)iterator.next();
                    Object object = selectionKey.attachment();
                    iterator.remove();
                    if (object instanceof b) {
                        this.a(selectionKey, (b)((Object)object));
                    } else {
                        d.a(selectionKey);
                    }
                    if (!iterator.hasNext()) break block1;
                } while (!this.d);
                this.w();
                set = this.p.selectedKeys();
            } while (!set.isEmpty());
        }
    }

    private void v() {
        this.w();
        Set set = this.p.keys();
        ArrayList arrayList = new ArrayList(set.size());
        for (SelectionKey selectionKey : set) {
            Object object = selectionKey.attachment();
            if (object instanceof b) {
                arrayList.add((Object)((b)((Object)object)));
                continue;
            }
            selectionKey.cancel();
            d.b(selectionKey);
        }
        for (b b2 : arrayList) {
            b2.E().a(b2.E().h());
        }
    }

    private void w() {
        this.d = false;
        try {
            this.p.selectNow();
            return;
        }
        catch (Throwable throwable) {
            k.d("Failed to update SelectionKeys.", throwable);
            return;
        }
    }

    @Override
    public final int a() {
        if (this.a(Thread.currentThread())) {
            return super.a();
        }
        return this.a(this.o).p_().d();
    }

    @Override
    protected final Queue<Runnable> a(int n2) {
        if (n2 == Integer.MAX_VALUE) {
            return n.m();
        }
        return n.c(n2);
    }

    @Override
    protected final void a(boolean bl) {
        if (!bl && this.s.compareAndSet(false, true)) {
            this.p.wakeup();
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    protected final void c() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:358)
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:61)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:372)
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

    @Override
    protected final void d() {
        try {
            this.p.close();
            return;
        }
        catch (IOException iOException) {
            k.d("Failed to close a selector.", iOException);
            return;
        }
    }

    @Override
    protected final Runnable e() {
        Runnable runnable = super.e();
        if (this.d) {
            this.w();
        }
        return runnable;
    }

    final int f() throws IOException {
        try {
            int n2 = this.p.selectNow();
            return n2;
        }
        finally {
            if (this.s.get()) {
                this.p.wakeup();
            }
        }
    }

}

