/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.ai
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.d.a.j
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.ThreadFactory
 */
package io.netty.b;

import io.netty.b.ah;
import io.netty.b.ai;
import io.netty.b.d;
import io.netty.b.h;
import io.netty.d.a.j;
import io.netty.d.b.a.e;
import io.netty.d.b.u;
import io.netty.d.i;
import java.util.concurrent.ThreadFactory;

public abstract class al
extends io.netty.d.a.u
implements ai {
    private static final io.netty.d.b.a.d a = e.a(al.class);
    private static final int b = Math.max((int)1, (int)u.a("io.netty.eventLoopThreads", 2 * i.a()));

    static {
        if (a.b()) {
            a.b("-Dio.netty.eventLoopThreads: {}", (Object)b);
        }
    }

    protected /* varargs */ al(int n2, Object ... arrobject) {
        if (n2 == 0) {
            n2 = b;
        }
        super(n2, null, arrobject);
    }

    public final h a(d d2) {
        return ((ah)super.b()).a(d2);
    }

    @Override
    protected final ThreadFactory a() {
        return new io.netty.d.a.i((Class<?>)this.getClass(), 0);
    }
}

