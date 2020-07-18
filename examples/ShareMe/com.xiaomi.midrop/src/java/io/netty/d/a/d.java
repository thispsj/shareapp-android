/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.ac
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.PriorityQueue
 *  java.util.Queue
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 */
package io.netty.d.a;

import io.netty.d.a.a;
import io.netty.d.a.ac;
import io.netty.d.a.ad;
import io.netty.d.a.d;
import io.netty.d.b.l;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class d
extends a {
    static final /* synthetic */ boolean f = true;
    protected Queue<ad<?>> e;

    private <V> ac<V> b(ad<V> ad2) {
        if (this.a(Thread.currentThread())) {
            this.i().add(ad2);
            return ad2;
        }
        this.execute(new Runnable((d)this, ad2){
            final /* synthetic */ ad a;
            final /* synthetic */ d b;
            {
                this.b = d2;
                this.a = ad2;
            }

            public final void run() {
                this.b.i().add((Object)((Object)this.a));
            }
        });
        return ad2;
    }

    @Override
    public final ac<?> a(Runnable runnable, long l2, long l3, TimeUnit timeUnit) {
        l.a(runnable, "command");
        l.a(timeUnit, "unit");
        if (l2 < 0L) {
            Object[] arrobject = new Object[]{l2};
            throw new IllegalArgumentException(String.format((String)"initialDelay: %d (expected: >= 0)", (Object[])arrobject));
        }
        if (l3 <= 0L) {
            Object[] arrobject = new Object[]{l3};
            throw new IllegalArgumentException(String.format((String)"period: %d (expected: > 0)", (Object[])arrobject));
        }
        ad ad2 = new ad((d)this, Executors.callable((Runnable)runnable, null), ad.a(timeUnit.toNanos(l2)), timeUnit.toNanos(l3));
        return d.super.b(ad2);
    }

    @Override
    public final ac<?> a(Runnable runnable, long l2, TimeUnit timeUnit) {
        l.a(runnable, "command");
        l.a(timeUnit, "unit");
        if (l2 < 0L) {
            l2 = 0L;
        }
        return d.super.b(new ad((d)this, runnable, ad.a(timeUnit.toNanos(l2))));
    }

    @Override
    public final <V> ac<V> a(Callable<V> callable, long l2, TimeUnit timeUnit) {
        l.a(callable, "callable");
        l.a(timeUnit, "unit");
        if (l2 < 0L) {
            l2 = 0L;
        }
        return d.super.b(new ad<V>((d)this, callable, ad.a(timeUnit.toNanos(l2))));
    }

    protected final Runnable a(long l2) {
        if (!f && !this.a(Thread.currentThread())) {
            throw new AssertionError();
        }
        Queue<ad<?>> queue = this.e;
        ad ad2 = queue == null ? null : (ad)((Object)queue.peek());
        if (ad2 == null) {
            return null;
        }
        if (ad2.c <= l2) {
            queue.remove();
            return ad2;
        }
        return null;
    }

    final void a(ad<?> ad2) {
        if (this.a(Thread.currentThread())) {
            this.i().remove(ad2);
            return;
        }
        this.execute(new Runnable((d)this, ad2){
            final /* synthetic */ ad a;
            final /* synthetic */ d b;
            {
                this.b = d2;
                this.a = ad2;
            }

            public final void run() {
                this.b.a(this.a);
            }
        });
    }

    @Override
    public final ac<?> b(Runnable runnable, long l2, long l3, TimeUnit timeUnit) {
        l.a(runnable, "command");
        l.a(timeUnit, "unit");
        if (l2 < 0L) {
            Object[] arrobject = new Object[]{l2};
            throw new IllegalArgumentException(String.format((String)"initialDelay: %d (expected: >= 0)", (Object[])arrobject));
        }
        if (l3 <= 0L) {
            Object[] arrobject = new Object[]{l3};
            throw new IllegalArgumentException(String.format((String)"delay: %d (expected: > 0)", (Object[])arrobject));
        }
        ad ad2 = new ad((d)this, Executors.callable((Runnable)runnable, null), ad.a(timeUnit.toNanos(l2)), -timeUnit.toNanos(l3));
        return d.super.b(ad2);
    }

    final Queue<ad<?>> i() {
        if (this.e == null) {
            this.e = new PriorityQueue();
        }
        return this.e;
    }

    protected final void j() {
        if (!f && !this.a(Thread.currentThread())) {
            throw new AssertionError();
        }
        Queue<ad<?>> queue = this.e;
        int n2 = 0;
        boolean bl = queue == null || queue.isEmpty();
        if (bl) {
            return;
        }
        ad[] arrad = (ad[])queue.toArray((Object[])new ad[queue.size()]);
        int n3 = arrad.length;
        while (n2 < n3) {
            arrad[n2].n();
            ++n2;
        }
        queue.clear();
    }

    protected final ad<?> k() {
        Queue<ad<?>> queue = this.e;
        if (queue == null) {
            return null;
        }
        return (ad)((Object)queue.peek());
    }

    @Override
    public /* synthetic */ ScheduledFuture schedule(Runnable runnable, long l2, TimeUnit timeUnit) {
        return this.a(runnable, l2, timeUnit);
    }

    @Override
    public /* synthetic */ ScheduledFuture schedule(Callable callable, long l2, TimeUnit timeUnit) {
        return this.a(callable, l2, timeUnit);
    }

    @Override
    public /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l2, long l3, TimeUnit timeUnit) {
        return this.a(runnable, l2, l3, timeUnit);
    }

    @Override
    public /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l2, long l3, TimeUnit timeUnit) {
        return this.b(runnable, l2, l3, timeUnit);
    }
}

