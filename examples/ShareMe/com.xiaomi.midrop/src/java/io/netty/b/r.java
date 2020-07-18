/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.a
 *  io.netty.b.ah
 *  io.netty.b.aj
 *  io.netty.b.as
 *  io.netty.b.d
 *  io.netty.b.r$1
 *  io.netty.b.r$a$1
 *  io.netty.b.w
 *  io.netty.b.x
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufHolder
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.util.Arrays
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 */
package io.netty.b;

import io.netty.b.ah;
import io.netty.b.aj;
import io.netty.b.as;
import io.netty.b.d;
import io.netty.b.e;
import io.netty.b.r;
import io.netty.b.t;
import io.netty.b.w;
import io.netty.b.x;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.d.a.m;
import io.netty.d.b.p;
import io.netty.d.b.u;
import io.netty.d.j;
import io.netty.d.k;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public final class r {
    static final int a = 0;
    public static final m<ByteBuffer[]> b;
    static final /* synthetic */ boolean j = true;
    private static final io.netty.d.b.a.d k;
    private static final AtomicLongFieldUpdater<r> n;
    private static final AtomicIntegerFieldUpdater<r> o;
    public a c;
    public a d;
    a e;
    public int f;
    public int g;
    public long h;
    public volatile long i;
    private final d l;
    private boolean m;
    private volatile int p;
    private volatile Runnable q;

    static {
        a = u.a("io.netty.transport.outboundBufferEntrySizeOverhead", 96);
        k = io.netty.d.b.a.e.a(r.class);
        b = new 1();
        n = AtomicLongFieldUpdater.newUpdater(r.class, (String)"i");
        o = AtomicIntegerFieldUpdater.newUpdater(r.class, (String)"p");
    }

    r(io.netty.b.a a2) {
        this.l = a2;
    }

    public static int a(ByteBuffer[] arrbyteBuffer, ByteBuffer[] arrbyteBuffer2, int n2) {
        for (ByteBuffer byteBuffer : arrbyteBuffer) {
            if (byteBuffer == null) break;
            int n3 = n2 + 1;
            arrbyteBuffer2[n2] = byteBuffer;
            n2 = n3;
        }
        return n2;
    }

    static long a(Object object) {
        if (object instanceof ByteBuf) {
            return ((ByteBuf)object).readableBytes();
        }
        if (object instanceof aj) {
            return ((aj)object).b();
        }
        if (object instanceof ByteBufHolder) {
            return ((ByteBufHolder)object).content().readableBytes();
        }
        return -1L;
    }

    private void a(a a2) {
        int n2;
        this.f = n2 = -1 + this.f;
        if (n2 == 0) {
            this.c = null;
            if (a2 == this.e) {
                this.e = null;
                this.d = null;
                return;
            }
        } else {
            this.c = a2.a;
        }
    }

    private static void a(x x2, Throwable throwable) {
        io.netty.d.b.a.d d2 = x2 instanceof as ? null : k;
        p.a(x2, throwable, d2);
    }

    private void a(boolean bl) {
        final t t2 = this.l.i();
        if (bl) {
            Runnable runnable = this.q;
            if (runnable == null) {
                this.q = runnable = new Runnable(){

                    public final void run() {
                        t2.d();
                    }
                };
            }
            this.l.j().execute(runnable);
            return;
        }
        t2.d();
    }

    private void d() {
        int n2 = this.g;
        if (n2 > 0) {
            this.g = 0;
            Arrays.fill((Object[])((Object[])b.get()), (int)0, (int)n2, null);
        }
    }

    public final Object a() {
        a a2 = this.c;
        if (a2 == null) {
            return null;
        }
        return a2.b;
    }

    public final void a(long l2) {
        a a2 = this.c;
        if (!j && a2 == null) {
            throw new AssertionError();
        }
        if (a2.e instanceof w) {
            a2.f = l2 + a2.f;
        }
    }

    final void a(long l2, boolean bl) {
        if (l2 == 0L) {
            return;
        }
        if (n.addAndGet((Object)this, l2) > (long)this.l.f().h()) {
            int n2;
            int n3;
            while (!o.compareAndSet((Object)this, n2 = this.p, n3 = n2 | 1)) {
            }
            if (n2 == 0 && n3 != 0) {
                r.super.a(bl);
            }
        }
    }

    final void a(long l2, boolean bl, boolean bl2) {
        if (l2 == 0L) {
            return;
        }
        long l3 = n.addAndGet((Object)this, -l2);
        if (bl2 && l3 < (long)this.l.f().i()) {
            int n2;
            int n3;
            while (!o.compareAndSet((Object)this, n2 = this.p, n3 = n2 & -2)) {
            }
            if (n2 != 0 && n3 == 0) {
                r.super.a(bl);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void a(Throwable throwable, boolean bl) {
        if (this.m) {
            return;
        }
        try {
            boolean bl2;
            this.m = true;
            do {
                a a2;
                if ((a2 = this.c) == null) {
                    r.super.d();
                    bl2 = false;
                    continue;
                }
                Object object = a2.b;
                x x2 = a2.e;
                int n2 = a2.h;
                r.super.a(a2);
                if (!a2.j) {
                    k.b(object);
                    r.a(x2, throwable);
                    this.a(n2, false, bl);
                }
                a2.a();
                bl2 = true;
            } while (bl2);
            return;
        }
        finally {
            this.m = false;
        }
    }

    public final void b(long l2) {
        block5 : {
            ByteBuf byteBuf;
            int n2;
            do {
                Object object;
                if (!((object = this.a()) instanceof ByteBuf)) {
                    if (!j && l2 != 0L) {
                        throw new AssertionError();
                    }
                    break block5;
                }
                byteBuf = (ByteBuf)object;
                n2 = byteBuf.readerIndex();
                long l3 = byteBuf.writerIndex() - n2;
                if (l3 > l2) break;
                if (l2 != 0L) {
                    this.a(l3);
                    l2 -= l3;
                }
                this.b();
            } while (true);
            if (l2 != 0L) {
                byteBuf.readerIndex(n2 + (int)l2);
                this.a(l2);
            }
        }
        r.super.d();
    }

    final void b(final Throwable throwable, final boolean bl) {
        a a2;
        if (this.m) {
            this.l.j().execute(new Runnable(){

                public final void run() {
                    r.this.b(throwable, bl);
                }
            });
            return;
        }
        this.m = true;
        if (!bl && this.l.g()) {
            throw new IllegalStateException("close() must be invoked after the channel is closed.");
        }
        if (!this.c()) {
            throw new IllegalStateException("close() must be invoked after all flushed writes are handled.");
        }
        try {
            a2 = this.d;
        }
        catch (Throwable throwable2) {
            this.m = false;
            throw throwable2;
        }
        while (a2 != null) {
            int n2 = a2.h;
            n.addAndGet((Object)this, (long)(-n2));
            if (!a2.j) {
                k.b(a2.b);
                r.a(a2.e, throwable);
            }
            a a3 = a2.a;
            a2.a();
            a2 = a3;
        }
        this.m = false;
        r.super.d();
        return;
    }

    public final boolean b() {
        a a2 = this.c;
        if (a2 == null) {
            this.d();
            return false;
        }
        Object object = a2.b;
        x x2 = a2.e;
        int n2 = a2.h;
        this.a(a2);
        if (!a2.j) {
            k.b(object);
            io.netty.d.b.a.d d2 = x2 instanceof as ? null : k;
            if (!x2.q_() && d2 != null) {
                Throwable throwable = x2.g();
                if (throwable == null) {
                    d2.c("Failed to mark a promise as success because it has succeeded already: {}", (Object)x2);
                } else {
                    d2.c("Failed to mark a promise as success because it has failed already: {}, unnotified cause:", (Object)x2, (Object)throwable);
                }
            }
            this.a(n2, false, true);
        }
        a2.a();
        return true;
    }

    public final boolean c() {
        return this.f == 0;
    }

    public static final class a {
        private static final j<a> k = new 1();
        public a a;
        public Object b;
        public ByteBuffer[] c;
        public ByteBuffer d;
        x e;
        long f;
        long g;
        int h;
        public int i;
        public boolean j;
        private final j.b l;

        private a(j.b b2) {
            this.i = -1;
            this.l = b2;
        }

        /* synthetic */ a(j.b b2, byte by) {
            super(b2);
        }

        static a a(Object object, int n2, long l2, x x2) {
            a a2 = k.get();
            a2.b = object;
            a2.h = n2 + r.a;
            a2.g = l2;
            a2.e = x2;
            return a2;
        }

        final void a() {
            this.a = null;
            this.c = null;
            this.d = null;
            this.b = null;
            this.e = null;
            this.f = 0L;
            this.g = 0L;
            this.h = 0;
            this.i = -1;
            this.j = false;
            k.recycle(this, this.l);
        }
    }

}

