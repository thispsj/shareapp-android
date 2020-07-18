/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.e.a.a
 *  java.lang.Object
 *  java.lang.Runtime
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  java.util.concurrent.ScheduledExecutorService
 */
package org.jetbrains.anko;

import a.e.a.a;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import org.jetbrains.anko.c;

public final class d {
    public static final d a = new d();
    private static ExecutorService b;

    static {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool((int)(2 * Runtime.getRuntime().availableProcessors()));
        a.e.b.d.a((Object)scheduledExecutorService, "Executors.newScheduledTh\u2026().availableProcessors())");
        b = (ExecutorService)scheduledExecutorService;
    }

    private d() {
    }

    public static <T> Future<T> a(a<? extends T> a2) {
        a.e.b.d.b(a2, "task");
        Future future = b.submit((Callable)new c(a2));
        a.e.b.d.a((Object)future, "executor.submit(task)");
        return future;
    }
}

