/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.ac
 *  io.netty.d.a.j
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.lang.UnsupportedOperationException
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.AbstractExecutorService
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Future
 *  java.util.concurrent.RunnableFuture
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 */
package io.netty.d.a;

import io.netty.d.a.ac;
import io.netty.d.a.j;
import io.netty.d.a.p;
import io.netty.d.a.z;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class a
extends AbstractExecutorService
implements j {
    private final Set<j> a = Collections.singleton((Object)((Object)this));

    public ac<?> a(Runnable runnable, long l2, long l3, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public ac<?> a(Runnable runnable, long l2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public <V> ac<V> a(Callable<V> callable, long l2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final <T> p<T> a(Runnable runnable, T t2) {
        return (p)super.submit(runnable, t2);
    }

    public final <T> p<T> a(Callable<T> callable) {
        return (p)super.submit(callable);
    }

    public ac<?> b(Runnable runnable, long l2, long l3, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public j b() {
        return this;
    }

    public final p<?> b(Runnable runnable) {
        return (p)super.submit(runnable);
    }

    public final boolean g() {
        return this.a(Thread.currentThread());
    }

    public final p<?> h() {
        return this.a(2L, 15L, TimeUnit.SECONDS);
    }

    public Iterator<j> iterator() {
        return this.a.iterator();
    }

    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t2) {
        return new z<T>((j)this, runnable, t2);
    }

    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new z<T>((j)this, callable);
    }

    public /* synthetic */ ScheduledFuture schedule(Runnable runnable, long l2, TimeUnit timeUnit) {
        return this.a(runnable, l2, timeUnit);
    }

    public /* synthetic */ ScheduledFuture schedule(Callable callable, long l2, TimeUnit timeUnit) {
        return this.a(callable, l2, timeUnit);
    }

    public /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l2, long l3, TimeUnit timeUnit) {
        return this.a(runnable, l2, l3, timeUnit);
    }

    public /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l2, long l3, TimeUnit timeUnit) {
        return this.b(runnable, l2, l3, timeUnit);
    }

    @Deprecated
    public abstract void shutdown();

    @Deprecated
    public List<Runnable> shutdownNow() {
        this.shutdown();
        return Collections.emptyList();
    }

    public /* synthetic */ Future submit(Runnable runnable) {
        return this.b(runnable);
    }

    public /* synthetic */ Future submit(Runnable runnable, Object object) {
        return this.a(runnable, object);
    }

    public /* synthetic */ Future submit(Callable callable) {
        return this.a(callable);
    }
}

