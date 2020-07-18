/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.ac
 *  io.netty.d.a.j
 *  io.netty.d.a.y
 *  java.lang.AssertionError
 *  java.lang.Error
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Queue
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Delayed
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicLong
 */
package io.netty.d.a;

import io.netty.d.a.ac;
import io.netty.d.a.d;
import io.netty.d.a.j;
import io.netty.d.a.y;
import io.netty.d.a.z;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ad<V>
extends z<V>
implements ac<V> {
    public static final long b = 0L;
    static final /* synthetic */ boolean d = true;
    private static final AtomicLong e = new AtomicLong();
    public long c;
    private final long f;
    private final long g;

    static {
        b = System.nanoTime();
    }

    ad(d d2, Runnable runnable, long l2) {
        super(d2, ad.a(runnable, null), l2);
    }

    ad(d d2, Callable<V> callable, long l2) {
        super(d2, callable);
        this.f = e.getAndIncrement();
        this.c = l2;
        this.g = 0L;
    }

    ad(d d2, Callable<V> callable, long l2, long l3) {
        super(d2, callable);
        this.f = e.getAndIncrement();
        if (l3 == 0L) {
            throw new IllegalArgumentException("period: 0 (expected: != 0)");
        }
        this.c = l2;
        this.g = l3;
    }

    static long a(long l2) {
        return l2 + (System.nanoTime() - b);
    }

    public static long f() {
        return System.nanoTime() - b;
    }

    @Override
    public final boolean cancel(boolean bl) {
        boolean bl2 = super.cancel(bl);
        if (bl2) {
            ((d)super.k_()).a((ad<?>)this);
        }
        return bl2;
    }

    public final /* synthetic */ int compareTo(Object object) {
        Delayed delayed = (Delayed)object;
        if (this == delayed) {
            return 0;
        }
        ad ad2 = (ad)delayed;
        long l2 = this.c - ad2.c;
        if (l2 < 0L) {
            return -1;
        }
        if (l2 <= 0L) {
            if (this.f < ad2.f) {
                return -1;
            }
            if (this.f == ad2.f) {
                throw new Error();
            }
        }
        return 1;
    }

    public final long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(this.m(), TimeUnit.NANOSECONDS);
    }

    @Override
    protected final j k_() {
        return super.k_();
    }

    @Override
    protected final StringBuilder l() {
        StringBuilder stringBuilder = super.l();
        stringBuilder.setCharAt(-1 + stringBuilder.length(), ',');
        stringBuilder.append(" id: ");
        stringBuilder.append(this.f);
        stringBuilder.append(", deadline: ");
        stringBuilder.append(this.c);
        stringBuilder.append(", period: ");
        stringBuilder.append(this.g);
        stringBuilder.append(')');
        return stringBuilder;
    }

    public final long m() {
        return Math.max((long)0L, (long)(this.c - (System.nanoTime() - b)));
    }

    final boolean n() {
        return super.cancel(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void run() {
        if (!d && !super.k_().g()) {
            throw new AssertionError();
        }
        try {
            if (this.g == 0L) {
                if (!this.e()) return;
                {
                    this.b(this.a.call());
                    return;
                }
            } else {
                if (this.isCancelled()) return;
                {
                    this.a.call();
                    if (super.k_().isShutdown()) return;
                    {
                        long l2 = this.g;
                        this.c = l2 > 0L ? l2 + this.c : System.nanoTime() - b - l2;
                        if (this.isCancelled()) return;
                        {
                            Queue<ad<?>> queue = ((d)super.k_()).e;
                            if (!d && queue == null) {
                                throw new AssertionError();
                            }
                            queue.add((Object)this);
                        }
                    }
                }
            }
            return;
        }
        catch (Throwable throwable) {
            this.a(throwable);
            return;
        }
    }
}

