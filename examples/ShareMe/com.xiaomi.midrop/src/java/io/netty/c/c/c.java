/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.b.i
 *  io.netty.b.l
 *  io.netty.c.c.c$b
 *  io.netty.c.c.c$c
 *  io.netty.c.c.c$d
 *  io.netty.d.a.ac
 *  io.netty.d.a.j
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 */
package io.netty.c.c;

import io.netty.b.d;
import io.netty.b.f;
import io.netty.b.h;
import io.netty.b.i;
import io.netty.b.l;
import io.netty.b.x;
import io.netty.c.c.c;
import io.netty.d.a.ac;
import io.netty.d.a.j;
import io.netty.d.a.p;
import io.netty.d.a.r;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/*
 * Exception performing whole class analysis.
 */
public final class c
extends f {
    private static final long a;
    private final i b;
    private final boolean c;
    private final long d;
    private final long e;
    private final long g;
    private ScheduledFuture<?> h;
    private long i;
    private boolean j;
    private ScheduledFuture<?> k;
    private long l;
    private boolean m;
    private ScheduledFuture<?> n;
    private boolean o;
    private byte p;
    private boolean q;
    private long r;
    private int s;
    private long t;

    static {
        a = TimeUnit.MILLISECONDS.toNanos(1L);
    }

    public c() {
        this(TimeUnit.SECONDS);
    }

    private c(TimeUnit timeUnit) {
        super(timeUnit, (byte)0);
    }

    private c(TimeUnit timeUnit, byte by) {
        this.b = new i(){

            public final /* synthetic */ void a(p p2) throws Exception {
                c.this.l = c.b();
                c.this.m = (c.this.o = true);
            }
        };
        this.j = true;
        this.m = true;
        this.o = true;
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        this.c = false;
        this.d = Math.max((long)timeUnit.toNanos(60L), (long)a);
        this.e = Math.max((long)timeUnit.toNanos(30L), (long)a);
        this.g = 0L;
    }

    static /* synthetic */ long a(c c2) {
        return c2.d;
    }

    protected static io.netty.c.c.b a(io.netty.c.c.a a2, boolean bl) {
        switch (2.a[a2.ordinal()]) {
            default: {
                StringBuilder stringBuilder = new StringBuilder("Unhandled: state=");
                stringBuilder.append((Object)a2);
                stringBuilder.append(", first=");
                stringBuilder.append(bl);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 3: {
                if (bl) {
                    return io.netty.c.c.b.c;
                }
                return io.netty.c.c.b.d;
            }
            case 2: {
                if (bl) {
                    return io.netty.c.c.b.a;
                }
                return io.netty.c.c.b.b;
            }
            case 1: 
        }
        if (bl) {
            return io.netty.c.c.b.e;
        }
        return io.netty.c.c.b.f;
    }

    static ScheduledFuture<?> a(l l2, Runnable runnable, long l3, TimeUnit timeUnit) {
        return l2.d().a(runnable, l3, timeUnit);
    }

    static /* synthetic */ ScheduledFuture a(c c2, ScheduledFuture scheduledFuture) {
        c2.h = scheduledFuture;
        return scheduledFuture;
    }

    protected static void a(l l2, io.netty.c.c.b b2) throws Exception {
        l2.a((Object)b2);
    }

    static /* synthetic */ boolean a(c c2, l l2, boolean bl) {
        if (c2.c) {
            io.netty.b.r r2;
            if (c2.r != c2.l) {
                c2.r = c2.l;
                if (!bl) {
                    return true;
                }
            }
            if ((r2 = l2.a().r().a()) != null) {
                int n2 = System.identityHashCode((Object)r2.a());
                long l3 = r2.i;
                if (n2 != c2.s || l3 != c2.t) {
                    c2.s = n2;
                    c2.t = l3;
                    if (!bl) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static long b() {
        return System.nanoTime();
    }

    static /* synthetic */ ScheduledFuture b(c c2, ScheduledFuture scheduledFuture) {
        c2.k = scheduledFuture;
        return scheduledFuture;
    }

    static /* synthetic */ boolean b(c c2) {
        return c2.q;
    }

    static /* synthetic */ long c(c c2) {
        return c2.i;
    }

    static /* synthetic */ ScheduledFuture c(c c2, ScheduledFuture scheduledFuture) {
        c2.n = scheduledFuture;
        return scheduledFuture;
    }

    private void c() {
        this.p = (byte)2;
        if (this.h != null) {
            this.h.cancel(false);
            this.h = null;
        }
        if (this.k != null) {
            this.k.cancel(false);
            this.k = null;
        }
        if (this.n != null) {
            this.n.cancel(false);
            this.n = null;
        }
    }

    static /* synthetic */ boolean d(c c2) {
        return c2.j;
    }

    static /* synthetic */ boolean e(c c2) {
        c2.j = false;
        return false;
    }

    static /* synthetic */ long f(c c2) {
        return c2.l;
    }

    static /* synthetic */ long g(c c2) {
        return c2.e;
    }

    static /* synthetic */ boolean h(c c2) {
        return c2.m;
    }

    static /* synthetic */ long i(c c2) {
        return c2.g;
    }

    static /* synthetic */ boolean j(c c2) {
        return c2.o;
    }

    private void k(l l2) {
        long l3;
        switch (this.p) {
            default: {
                io.netty.b.r r2;
                this.p = 1;
                if (!this.c || (r2 = l2.a().r().a()) == null) break;
                this.s = System.identityHashCode((Object)r2.a());
                this.t = r2.i;
                break;
            }
            case 1: 
            case 2: {
                return;
            }
        }
        this.l = l3 = System.nanoTime();
        this.i = l3;
        if (this.d > 0L) {
            this.h = c.a(l2, (Runnable)new /* Unavailable Anonymous Inner Class!! */, this.d, TimeUnit.NANOSECONDS);
        }
        if (this.e > 0L) {
            this.k = c.a(l2, (Runnable)new /* Unavailable Anonymous Inner Class!! */, this.e, TimeUnit.NANOSECONDS);
        }
        if (this.g > 0L) {
            this.n = c.a(l2, (Runnable)new /* Unavailable Anonymous Inner Class!! */, this.g, TimeUnit.NANOSECONDS);
        }
    }

    @Override
    public final void a(l l2, Object object) throws Exception {
        if (this.d > 0L || this.g > 0L) {
            this.q = true;
            this.o = true;
            this.j = true;
        }
        l2.b(object);
    }

    @Override
    public final void a(l l2, Object object, x x2) throws Exception {
        if (this.e <= 0L && this.g <= 0L) {
            l2.a(object, x2);
            return;
        }
        l2.a(object, x2).a((r)this.b);
    }

    public final void c(l l2) throws Exception {
        if (l2.a().h() && l2.a().m()) {
            c.super.k(l2);
        }
    }

    public final void d(l l2) throws Exception {
        c.super.c();
    }

    @Override
    public final void e(l l2) throws Exception {
        if (l2.a().h()) {
            c.super.k(l2);
        }
        super.e(l2);
    }

    @Override
    public final void g(l l2) throws Exception {
        c.super.k(l2);
        super.g(l2);
    }

    @Override
    public final void h(l l2) throws Exception {
        c.super.c();
        super.h(l2);
    }

    @Override
    public final void i(l l2) throws Exception {
        if ((this.d > 0L || this.g > 0L) && this.q) {
            this.i = System.nanoTime();
            this.q = false;
        }
        l2.i();
    }

}

