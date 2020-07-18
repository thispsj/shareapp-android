/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.d.a.c
 *  io.netty.d.a.y
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.concurrent.TimeUnit
 */
package io.netty.b;

import io.netty.b.d;
import io.netty.b.h;
import io.netty.b.t;
import io.netty.b.x;
import io.netty.d.a.c;
import io.netty.d.a.p;
import io.netty.d.a.r;
import io.netty.d.a.y;
import java.util.concurrent.TimeUnit;

final class as
extends c<Void>
implements x {
    private final d a;
    private final boolean b;

    as(d d2, boolean bl) {
        if (d2 == null) {
            throw new NullPointerException("channel");
        }
        this.a = d2;
        this.b = bl;
    }

    private void c(Throwable throwable) {
        if (this.b && this.a.m()) {
            this.a.i().a(throwable);
        }
    }

    private static void k() {
        throw new IllegalStateException("void future");
    }

    public final /* synthetic */ h a(r r2) {
        as.k();
        return this;
    }

    @Override
    public final /* synthetic */ x a(Throwable throwable) {
        as.super.c(throwable);
        return this;
    }

    public final boolean a() {
        as.k();
        return false;
    }

    public final boolean a(long l2, TimeUnit timeUnit) {
        as.k();
        return false;
    }

    public final /* synthetic */ x b(r r2) {
        as.k();
        return this;
    }

    public final /* synthetic */ p b(r r2) {
        as.k();
        return this;
    }

    public final boolean b(Throwable throwable) {
        as.super.c(throwable);
        return false;
    }

    public final /* synthetic */ p c() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return this;
    }

    public final boolean cancel(boolean bl) {
        return false;
    }

    @Override
    public final d e() {
        return this.a;
    }

    public final /* synthetic */ h f() throws InterruptedException {
        as.k();
        return this;
    }

    public final Throwable g() {
        return null;
    }

    public final boolean h() {
        return false;
    }

    public final boolean i() {
        return true;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return false;
    }

    @Override
    public final boolean l_() {
        return false;
    }

    public final /* synthetic */ p p_() {
        as.k();
        return this;
    }
}

