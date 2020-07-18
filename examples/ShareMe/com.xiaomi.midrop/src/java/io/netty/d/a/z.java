/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.j
 *  io.netty.d.a.y
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.concurrent.Callable
 *  java.util.concurrent.RunnableFuture
 */
package io.netty.d.a;

import io.netty.d.a.h;
import io.netty.d.a.j;
import io.netty.d.a.y;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/*
 * Exception performing whole class analysis.
 */
class z<V>
extends h<V>
implements RunnableFuture<V> {
    protected final Callable<V> a;

    z(j j2, Runnable runnable, V v2) {
        super(j2, z.a(runnable, v2));
    }

    z(j j2, Callable<V> callable) {
        super(j2);
        this.a = callable;
    }

    static <T> Callable<T> a(Runnable runnable, T t2) {
        return }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    