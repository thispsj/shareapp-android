/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.j
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.InterruptedException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.ThreadGroup
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 *  java.util.Queue
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Executors
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package io.netty.d.a;

import io.netty.d.a.ad;
import io.netty.d.a.d;
import io.netty.d.a.i;
import io.netty.d.a.j;
import io.netty.d.a.l;
import io.netty.d.a.p;
import io.netty.d.a.t;
import io.netty.d.b.a.e;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class t
extends d {
    public static final t a;
    private static final io.netty.d.b.a.d h;
    private static final long i;
    final BlockingQueue<Runnable> b = new LinkedBlockingQueue();
    final ad<Void> c;
    final ThreadFactory d;
    volatile Thread g;
    private final a j;
    private final AtomicBoolean k;
    private final p<?> l;

    static {
        h = e.a(t.class);
        i = TimeUnit.SECONDS.toNanos(1L);
        a = new t();
    }

    private t() {
        ad ad2 = new ad(this, Executors.callable((Runnable)new Runnable(this){
            final /* synthetic */ t a;
            {
                this.a = t2;
            }

            public final void run() {
            }
        }, null), ad.a(i), -i);
        this.c = ad2;
        this.d = new i(i.a(this.getClass()), 5, null);
        this.j = new Runnable(){
            static final /* synthetic */ boolean a = true;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public final void run() {
                do {
                    Runnable runnable;
                    if ((runnable = t.this.a()) != null) {
                        try {
                            runnable.run();
                        }
                        catch (Throwable throwable) {
                            h.d("Unexpected exception from the global event executor: ", throwable);
                        }
                        if (runnable != t.this.c) continue;
                    }
                    Queue queue = t.this.e;
                    if (!t.this.b.isEmpty() || queue != null && queue.size() != 1) continue;
                    boolean bl = t.this.k.compareAndSet(true, false);
                    if (!a && !bl) {
                        throw new AssertionError();
                    }
                    if (t.this.b.isEmpty()) {
                        if (queue == null) return;
                        if (queue.size() == 1) return;
                    }
                    if (!t.this.k.compareAndSet(false, true)) return;
                } while (true);
            }
        };
        this.k = new AtomicBoolean();
        this.l = new l(this, (Throwable)new UnsupportedOperationException());
        this.i().add(this.c);
    }

    public final p<?> a(long l2, long l3, TimeUnit timeUnit) {
        return this.l;
    }

    final Runnable a() {
        Runnable runnable;
        BlockingQueue<Runnable> blockingQueue = this.b;
        do {
            ad<?> ad2;
            Runnable runnable2;
            if ((ad2 = this.k()) == null) {
                try {
                    Runnable runnable3 = (Runnable)blockingQueue.take();
                    return runnable3;
                }
                catch (InterruptedException interruptedException) {
                    return null;
                }
            }
            long l2 = ad2.m();
            if (l2 > 0L) {
                try {
                    runnable = (Runnable)blockingQueue.poll(l2, TimeUnit.NANOSECONDS);
                }
                catch (InterruptedException interruptedException) {
                    return null;
                }
            } else {
                runnable = (Runnable)blockingQueue.poll();
            }
            if (runnable != null) continue;
            long l3 = ad.f();
            while ((runnable2 = this.a(l3)) != null) {
                this.b.add((Object)runnable2);
            }
            runnable = (Runnable)blockingQueue.poll();
        } while (runnable == null);
        return runnable;
    }

    public final boolean a(Thread thread) {
        return thread == this.g;
    }

    public final boolean awaitTermination(long l2, TimeUnit timeUnit) {
        return false;
    }

    public final void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        this.b.add((Object)runnable);
        if (!this.a(Thread.currentThread()) && this.k.compareAndSet(false, true)) {
            Thread thread = this.d.newThread((Runnable)this.j);
            AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<Void>((t)this, thread){
                final /* synthetic */ Thread a;
                final /* synthetic */ t b;
                {
                    this.b = t2;
                    this.a = thread;
                }

                public final /* synthetic */ Object run() {
                    this.a.setContextClassLoader(null);
                    return null;
                }
            });
            this.g = thread;
            thread.start();
        }
    }

    public final boolean isShutdown() {
        return false;
    }

    public final boolean isTerminated() {
        return false;
    }

    public final p<?> l() {
        return this.l;
    }

    @Deprecated
    @Override
    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

}

