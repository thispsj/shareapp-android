/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.concurrent.Future
 *  java.util.concurrent.TimeUnit
 */
package io.netty.d.a;

import io.netty.d.a.r;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public interface p<V>
extends Future<V> {
    public boolean a();

    public boolean a(long var1, TimeUnit var3) throws InterruptedException;

    public p<V> b(r<? extends p<? super V>> var1);

    public p<V> c() throws InterruptedException;

    public V d();

    public Throwable g();

    public boolean h();

    public p<V> p_();
}

