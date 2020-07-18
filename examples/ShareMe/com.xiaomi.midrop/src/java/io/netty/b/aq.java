/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.ai
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.d.a.j
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.ThreadFactory
 */
package io.netty.b;

import io.netty.b.ad;
import io.netty.b.ah;
import io.netty.b.ai;
import io.netty.b.d;
import io.netty.b.h;
import io.netty.b.x;
import io.netty.d.a.aa;
import io.netty.d.a.ae;
import io.netty.d.a.j;
import io.netty.d.a.k;
import io.netty.d.b.u;
import java.util.concurrent.ThreadFactory;

public abstract class aq
extends ae
implements ah {
    protected static final int a = Math.max((int)16, (int)u.a("io.netty.eventLoop.maxPendingTasks", Integer.MAX_VALUE));

    protected aq(ai ai2, ThreadFactory threadFactory, int n2, aa aa2) {
        super((k)ai2, threadFactory, n2, aa2);
    }

    public final h a(d d2) {
        ad ad2 = new ad(d2, (j)this);
        if (d2 == null) {
            throw new NullPointerException("channel");
        }
        d2.r().a((ah)this, (x)ad2);
        return ad2;
    }

    @Override
    protected final boolean a(Runnable runnable) {
        return !(runnable instanceof a);
    }

}

