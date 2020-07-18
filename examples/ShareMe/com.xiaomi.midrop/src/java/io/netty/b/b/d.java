/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.aa
 *  io.netty.b.b.h
 *  io.netty.b.d
 *  io.netty.b.q
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.ServerSocket
 *  java.net.SocketException
 */
package io.netty.b.b;

import io.netty.b.aa;
import io.netty.b.ak;
import io.netty.b.am;
import io.netty.b.b.g;
import io.netty.b.b.h;
import io.netty.b.e;
import io.netty.b.q;
import io.netty.buffer.ByteBufAllocator;
import java.net.ServerSocket;
import java.net.SocketException;

public class d
extends aa
implements h {
    protected final ServerSocket b;
    private volatile int c = io.netty.d.h.e;

    public d(g g2, ServerSocket serverSocket) {
        super((io.netty.b.d)g2);
        if (serverSocket == null) {
            throw new NullPointerException("javaSocket");
        }
        this.b = serverSocket;
    }

    private h c(boolean bl) {
        try {
            this.b.setReuseAddress(bl);
            return this;
        }
        catch (SocketException socketException) {
            throw new io.netty.b.g(socketException);
        }
    }

    private h f(int n2) {
        try {
            this.b.setReceiveBufferSize(n2);
            return this;
        }
        catch (SocketException socketException) {
            throw new io.netty.b.g(socketException);
        }
    }

    private boolean m() {
        try {
            boolean bl = this.b.getReuseAddress();
            return bl;
        }
        catch (SocketException socketException) {
            throw new io.netty.b.g(socketException);
        }
    }

    private int n() {
        try {
            int n2 = this.b.getReceiveBufferSize();
            return n2;
        }
        catch (SocketException socketException) {
            throw new io.netty.b.g(socketException);
        }
    }

    public final <T> T a(q<T> q2) {
        if (q2 == q.o) {
            return d.super.n();
        }
        if (q2 == q.p) {
            return d.super.m();
        }
        if (q2 == q.r) {
            return this.c;
        }
        return (T)super.a(q2);
    }

    public final <T> boolean a(q<T> q2, T t2) {
        block7 : {
            block5 : {
                block6 : {
                    block4 : {
                        d.b(q2, t2);
                        if (q2 != q.o) break block4;
                        d.super.f((Integer)t2);
                        break block5;
                    }
                    if (q2 != q.p) break block6;
                    d.super.c((Boolean)t2);
                    break block5;
                }
                if (q2 != q.r) break block7;
                int n2 = (Integer)t2;
                if (n2 < 0) {
                    StringBuilder stringBuilder = new StringBuilder("backlog: ");
                    stringBuilder.append(n2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                this.c = n2;
            }
            return true;
        }
        return super.a(q2, t2);
    }

    public final int l() {
        return this.c;
    }
}

