/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.ac
 *  io.netty.d.a.j
 *  java.lang.Deprecated
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.TimeUnit
 */
package io.netty.d.a;

import io.netty.d.a.ac;
import io.netty.d.a.j;
import io.netty.d.a.p;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public interface k
extends Iterable<j>,
ScheduledExecutorService {
    public ac<?> a(Runnable var1, long var2, long var4, TimeUnit var6);

    public ac<?> a(Runnable var1, long var2, TimeUnit var4);

    public <V> ac<V> a(Callable<V> var1, long var2, TimeUnit var4);

    public p<?> a(long var1, long var3, TimeUnit var5);

    public <T> p<T> a(Runnable var1, T var2);

    public <T> p<T> a(Callable<T> var1);

    public ac<?> b(Runnable var1, long var2, long var4, TimeUnit var6);

    public j b();

    public p<?> b(Runnable var1);

    public p<?> h();

    public p<?> l();

    @Deprecated
    public void shutdown();
}

