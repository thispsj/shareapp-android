/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.a$a
 *  io.netty.b.a.b$b
 *  io.netty.b.ac
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.b.i
 *  io.netty.d.a.ac
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.net.SocketAddress
 *  java.nio.channels.CancelledKeyException
 *  java.nio.channels.ClosedChannelException
 *  java.nio.channels.ConnectionPendingException
 *  java.nio.channels.SelectableChannel
 *  java.nio.channels.SelectionKey
 *  java.nio.channels.Selector
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 */
package io.netty.b.a;

import io.netty.b.a;
import io.netty.b.a.b;
import io.netty.b.a.d;
import io.netty.b.ac;
import io.netty.b.ah;
import io.netty.b.d;
import io.netty.b.e;
import io.netty.b.g;
import io.netty.b.h;
import io.netty.b.i;
import io.netty.b.t;
import io.netty.b.x;
import io.netty.d.a.p;
import io.netty.d.a.r;
import io.netty.d.b.w;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class b
extends io.netty.b.a {
    static final /* synthetic */ boolean h = true;
    private static final io.netty.d.b.a.d i = io.netty.d.b.a.e.a(b.class);
    private static final ClosedChannelException j = w.a(new ClosedChannelException(), b.class, "doClose()");
    final SelectableChannel c;
    protected final int d;
    volatile SelectionKey e;
    volatile boolean f;
    protected volatile boolean g;
    private x k;
    private ScheduledFuture<?> l;
    private SocketAddress m;

    protected b(io.netty.b.d d2, SelectableChannel selectableChannel, int n2) {
        super(d2);
        this.c = selectableChannel;
        this.d = n2;
        try {
            selectableChannel.configureBlocking(false);
            return;
        }
        catch (IOException iOException) {
            block4 : {
                try {
                    selectableChannel.close();
                }
                catch (IOException iOException2) {
                    if (!i.d()) break block4;
                    i.d("Failed to close a partially initialized socket.", iOException2);
                }
            }
            throw new g("Failed to enter non-blocking mode.", iOException);
        }
    }

    static /* synthetic */ SocketAddress c(b b2) {
        return b2.m;
    }

    public final b E() {
        return super.r();
    }

    protected SelectableChannel F() {
        return this.c;
    }

    public final d G() {
        return (d)super.j();
    }

    protected final SelectionKey H() {
        if (!h && this.e == null) {
            throw new AssertionError();
        }
        return this.e;
    }

    protected abstract void I() throws Exception;

    @Override
    protected final boolean a(ah ah2) {
        return ah2 instanceof d;
    }

    protected abstract boolean a(SocketAddress var1, SocketAddress var2) throws Exception;

    @Override
    protected void d() throws Exception {
        ScheduledFuture<?> scheduledFuture;
        x x2 = this.k;
        if (x2 != null) {
            x2.b((Throwable)j);
            this.k = null;
        }
        if ((scheduledFuture = this.l) != null) {
            scheduledFuture.cancel(false);
            this.l = null;
        }
    }

    @Override
    protected final void e() throws Exception {
        if (this.f) {
            return;
        }
        SelectionKey selectionKey = this.e;
        if (!selectionKey.isValid()) {
            return;
        }
        this.g = true;
        int n2 = selectionKey.interestOps();
        if ((n2 & this.d) == 0) {
            selectionKey.interestOps(n2 | this.d);
        }
    }

    public final boolean g() {
        return this.c.isOpen();
    }

    @Override
    protected final void t() throws Exception {
        boolean bl = false;
        do {
            try {
                this.e = this.F().register(((d)super.j()).b, 0, (Object)((Object)this));
                return;
            }
            catch (CancelledKeyException cancelledKeyException) {
                if (!bl) {
                    ((d)super.j()).f();
                    bl = true;
                    continue;
                }
                throw cancelledKeyException;
            }
            break;
        } while (true);
    }

    @Override
    protected final void v() throws Exception {
        d d2 = (d)super.j();
        this.H().cancel();
        d2.c = 1 + d2.c;
        if (d2.c >= 256) {
            d2.c = 0;
            d2.d = true;
        }
    }

    protected abstract class a
    extends a.a
    implements b {
        static final /* synthetic */ boolean d = true;

        protected a() {
            super((io.netty.b.a)b.this);
        }

        private void a(x x2, boolean bl) {
            if (x2 == null) {
                return;
            }
            boolean bl2 = b.this.h();
            boolean bl3 = x2.l_();
            if (!bl && bl2) {
                b.this.a.b();
            }
            if (!bl3) {
                this.a(this.h());
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final void a(SocketAddress socketAddress, SocketAddress socketAddress2, x x2) {
            if (x2.i()) {
                if (!this.b(x2)) {
                    return;
                }
                try {
                    if (b.this.k != null) {
                        throw new ConnectionPendingException();
                    }
                    boolean bl = b.this.h();
                    if (b.this.a(socketAddress, socketAddress2)) {
                        a.super.a(x2, bl);
                        return;
                    }
                    b.this.k = x2;
                    b.this.m = socketAddress;
                    int n2 = b.this.f().a();
                    if (n2 > 0) {
                        b.this.l = b.this.G().a(new Runnable((a)this, socketAddress){
                            final /* synthetic */ SocketAddress a;
                            final /* synthetic */ a b;
                            {
                                this.b = a2;
                                this.a = socketAddress;
                            }

                            public final void run() {
                                x x2 = b.a(this.b.b.this);
                                java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder("connection timed out: ");
                                stringBuilder.append((Object)this.a);
                                io.netty.b.z z2 = new io.netty.b.z(stringBuilder.toString());
                                if (x2 != null && x2.b((Throwable)((Object)z2))) {
                                    this.b.a(this.b.h());
                                }
                            }
                        }, (long)n2, TimeUnit.MILLISECONDS);
                    }
                    x2.b((r<? extends p<? super Void>>)new i(){

                        public final /* synthetic */ void a(p p2) throws Exception {
                            if (((h)p2).isCancelled()) {
                                if (b.this.l != null) {
                                    b.this.l.cancel(false);
                                }
                                b.this.k = null;
                                a.this.a(a.this.h());
                            }
                        }
                    });
                    return;
                }
                catch (Throwable throwable) {
                    x2.b(a.a((Throwable)throwable, (SocketAddress)socketAddress));
                    this.i();
                }
            }
        }

        protected final void g() {
            SelectionKey selectionKey = b.this.H();
            boolean bl = selectionKey.isValid() && (4 & selectionKey.interestOps()) != 0;
            if (bl) {
                return;
            }
            super.g();
        }

        protected final void l() {
            SelectionKey selectionKey = b.this.H();
            if (!selectionKey.isValid()) {
                return;
            }
            int n2 = selectionKey.interestOps();
            if ((n2 & b.this.d) != 0) {
                selectionKey.interestOps(n2 & (-1 ^ b.this.d));
            }
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public final void m() {
            if (!a.d && !b.this.G().a(Thread.currentThread())) {
                throw new AssertionError();
            }
            var10_1 = b.this.h();
            b.this.I();
            this.a(b.a(b.this), var10_1);
            if (b.b(b.this) == null) ** GOTO lbl10
lbl8: // 2 sources:
            do {
                b.b(b.this).cancel(false);
lbl10: // 3 sources:
                do {
                    b.a(b.this, null);
                    return;
                    break;
                } while (true);
                break;
            } while (true);
            {
                block8 : {
                    catch (Throwable var7_2) {
                    }
                    catch (Throwable var1_3) {}
                    {
                        var2_4 = b.a(b.this);
                        var3_5 = a.a((Throwable)var1_3, (SocketAddress)b.c(b.this));
                        if (var2_4 == null) break block8;
                        var2_4.b(var3_5);
                        this.i();
                    }
                }
                if (b.b(b.this) == null) ** continue;
                ** continue;
            }
            if (b.b(b.this) != null) {
                b.b(b.this).cancel(false);
            }
            b.a(b.this, null);
            throw var7_2;
        }

        public final void n() {
            super.g();
        }

    }

}

