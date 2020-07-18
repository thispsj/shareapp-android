/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.d.a.j
 *  java.lang.InterruptedException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 */
package io.netty.b;

import io.netty.b.ah;
import io.netty.b.d;
import io.netty.b.h;
import io.netty.d.a.f;
import io.netty.d.a.j;
import io.netty.d.a.p;
import io.netty.d.a.r;

abstract class y
extends f<Void>
implements h {
    private final d a;

    protected y(d d2) {
        super(null);
        if (d2 == null) {
            throw new NullPointerException("channel");
        }
        this.a = d2;
    }

    public final h a(r<? extends p<? super Void>> r2) {
        super.b(r2);
        return this;
    }

    public final d e() {
        return this.a;
    }

    public final h f() throws InterruptedException {
        return this;
    }

    @Override
    protected final j s_() {
        j j2 = super.s_();
        if (j2 == null) {
            j2 = this.a.j();
        }
        return j2;
    }
}

