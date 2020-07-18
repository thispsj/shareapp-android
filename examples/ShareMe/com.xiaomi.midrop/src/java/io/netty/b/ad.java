/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.d.a.j
 *  io.netty.d.a.y
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.lang.Void
 */
package io.netty.b;

import io.netty.b.ah;
import io.netty.b.d;
import io.netty.b.h;
import io.netty.b.x;
import io.netty.d.a.j;
import io.netty.d.a.p;
import io.netty.d.a.r;
import io.netty.d.a.y;
import io.netty.d.b.l;

public class ad
extends io.netty.d.a.h<Void>
implements x {
    private final d a;

    public ad(d d2) {
        this.a = l.a(d2, "channel");
    }

    public ad(d d2, j j2) {
        super(j2);
        this.a = l.a(d2, "channel");
    }

    public final /* synthetic */ h a(r r2) {
        super.c(r2);
        return this;
    }

    @Override
    public x a(Throwable throwable) {
        super.c(throwable);
        return this;
    }

    @Override
    public x b() {
        super.a(null);
        return this;
    }

    @Override
    public final x b(r<? extends p<? super Void>> r2) {
        super.c(r2);
        return this;
    }

    @Override
    public final /* synthetic */ p b(r r2) {
        super.c(r2);
        return this;
    }

    @Override
    public final /* synthetic */ p c() throws InterruptedException {
        super.k();
        return this;
    }

    @Override
    public /* synthetic */ y c(Throwable throwable) {
        return this.a(throwable);
    }

    @Override
    public final d e() {
        return this.a;
    }

    public final /* synthetic */ h f() throws InterruptedException {
        super.o_();
        return this;
    }

    @Override
    public j k_() {
        j j2 = super.k_();
        if (j2 == null) {
            j2 = this.a.j();
        }
        return j2;
    }

    @Override
    public boolean l_() {
        return this.q_();
    }

    @Override
    protected final void m_() {
        if (this.a.m()) {
            super.m_();
        }
    }

    @Override
    public final /* synthetic */ p p_() {
        super.n_();
        return this;
    }
}

