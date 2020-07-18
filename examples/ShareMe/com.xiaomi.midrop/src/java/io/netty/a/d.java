/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.a$a
 *  io.netty.b.aa
 *  io.netty.b.d
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.net.SocketAddress
 */
package io.netty.a;

import io.netty.b.a;
import io.netty.b.aa;
import io.netty.b.ah;
import io.netty.b.e;
import io.netty.b.p;
import io.netty.b.r;
import io.netty.b.x;
import java.net.SocketAddress;

final class d
extends io.netty.b.a {
    private static final p c = new p();
    private final e d = new aa((io.netty.b.d)this);

    d() {
        super(null);
    }

    @Override
    protected final a.a a() {
        return new a(this, 0);
    }

    @Override
    protected final void a(r r2) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected final void a(SocketAddress socketAddress) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected final boolean a(ah ah2) {
        return false;
    }

    @Override
    protected final SocketAddress b() {
        return null;
    }

    @Override
    protected final SocketAddress c() {
        return null;
    }

    @Override
    protected final void d() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected final void e() {
        throw new UnsupportedOperationException();
    }

    public final e f() {
        return this.d;
    }

    public final boolean g() {
        return false;
    }

    public final boolean h() {
        return false;
    }

    private final class a
    extends a.a {
        final /* synthetic */ d a;

        private a(d d2) {
            this.a = d2;
            super((io.netty.b.a)d2);
        }

        /* synthetic */ a(d d2, byte by) {
            super(d2);
        }

        public final void a(SocketAddress socketAddress, SocketAddress socketAddress2, x x2) {
            x2.a((Throwable)new UnsupportedOperationException());
        }
    }

}

