/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.ag
 *  io.netty.d.a.j
 *  java.lang.Exception
 *  java.lang.Object
 *  java.nio.channels.spi.SelectorProvider
 *  java.util.concurrent.ThreadFactory
 */
package io.netty.b.a;

import io.netty.b.a.d;
import io.netty.b.ag;
import io.netty.b.al;
import io.netty.b.an;
import io.netty.b.ao;
import io.netty.d.a.aa;
import io.netty.d.a.ab;
import io.netty.d.a.j;
import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.ThreadFactory;

public final class e
extends al {
    public e() {
        this(0);
    }

    public e(int n2) {
        super(n2, (byte)0);
    }

    private e(int n2, byte by) {
        super(n2, SelectorProvider.provider());
    }

    private e(int n2, SelectorProvider selectorProvider) {
        super(n2, selectorProvider, ag.a);
    }

    private e(int n2, SelectorProvider selectorProvider, ao ao2) {
        Object[] arrobject = new Object[]{selectorProvider, ao2, ab.a()};
        super(n2, arrobject);
    }

    @Override
    protected final /* varargs */ j a(ThreadFactory threadFactory, Object ... arrobject) throws Exception {
        d d2 = new d((e)this, threadFactory, (SelectorProvider)arrobject[0], ((ao)arrobject[1]).a(), (aa)arrobject[2]);
        return d2;
    }
}

