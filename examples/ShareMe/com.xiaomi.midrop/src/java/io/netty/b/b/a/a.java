/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.b.h
 *  io.netty.b.d
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.net.InetSocketAddress
 *  java.net.ServerSocket
 *  java.net.SocketAddress
 *  java.nio.channels.SelectableChannel
 *  java.nio.channels.ServerSocketChannel
 *  java.nio.channels.SocketChannel
 *  java.nio.channels.spi.SelectorProvider
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 *  java.util.List
 */
package io.netty.b.b.a;

import io.netty.b.a.c;
import io.netty.b.b.a.b;
import io.netty.b.b.d;
import io.netty.b.b.g;
import io.netty.b.b.h;
import io.netty.b.e;
import io.netty.b.p;
import io.netty.d.b.n;
import io.netty.d.b.s;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;

public class a
extends c
implements g {
    private static final p i = new p();
    private static final SelectorProvider j = SelectorProvider.provider();
    private static final io.netty.d.b.a.d k = io.netty.d.b.a.e.a(a.class);
    private final h l;

    public a() {
        this(a.a(j));
    }

    private a(ServerSocketChannel serverSocketChannel) {
        super((SelectableChannel)serverSocketChannel);
        this.l = new a((a)this, (a)this, ((ServerSocketChannel)super.F()).socket(), 0);
    }

    private static ServerSocketChannel a(SelectorProvider selectorProvider) {
        try {
            ServerSocketChannel serverSocketChannel = selectorProvider.openServerSocketChannel();
            return serverSocketChannel;
        }
        catch (IOException iOException) {
            throw new io.netty.b.g("Failed to open a server socket.", iOException);
        }
    }

    static /* synthetic */ void a(a a2) {
        a2.g = false;
    }

    @Override
    protected final boolean C() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    protected final void I() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    protected final int a(List<Object> list) throws Exception {
        SocketChannel socketChannel = s.a((ServerSocketChannel)super.F());
        if (socketChannel != null) {
            try {
                list.add((Object)new b((io.netty.b.d)this, socketChannel));
                return 1;
            }
            catch (Throwable throwable) {
                k.d("Failed to create a new channel from an accepted socket.", throwable);
                try {
                    socketChannel.close();
                }
                catch (Throwable throwable2) {
                    k.d("Failed to close a socket.", throwable2);
                }
            }
        }
        return 0;
    }

    @Override
    protected final void a(SocketAddress socketAddress) throws Exception {
        if (n.d() >= 7) {
            ((ServerSocketChannel)super.F()).bind(socketAddress, this.l.l());
            return;
        }
        ((ServerSocketChannel)super.F()).socket().bind(socketAddress, this.l.l());
    }

    @Override
    protected final boolean a(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    protected final Object b(Object object) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    protected final SocketAddress b() {
        return (SocketAddress)AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<SocketAddress>(((ServerSocketChannel)super.F()).socket()){
            final /* synthetic */ ServerSocket a;
            {
                this.a = serverSocket;
            }

            public final /* synthetic */ Object run() {
                return this.a.getLocalSocketAddress();
            }
        });
    }

    @Override
    protected final SocketAddress c() {
        return null;
    }

    @Override
    protected final void d() throws Exception {
        ((ServerSocketChannel)super.F()).close();
    }

    public final boolean h() {
        return ((ServerSocketChannel)super.F()).socket().isBound();
    }

    private final class a
    extends d {
        final /* synthetic */ a c;

        private a(a a2, a a3, ServerSocket serverSocket) {
            this.c = a2;
            super(a3, serverSocket);
        }

        /* synthetic */ a(a a2, a a3, ServerSocket serverSocket, byte by) {
            super(a2, a3, serverSocket);
        }

        protected final void k() {
            a.a(this.c);
        }
    }

}

