/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.util.concurrent.TimeUnit
 */
package c;

import c.u;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class i
extends u {
    public u a;

    public i(u u2) {
        if (u2 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = u2;
    }

    @Override
    public final long A_() {
        return this.a.A_();
    }

    @Override
    public final boolean B_() {
        return this.a.B_();
    }

    @Override
    public final u C_() {
        return this.a.C_();
    }

    @Override
    public final u a(long l2) {
        return this.a.a(l2);
    }

    @Override
    public final u a(long l2, TimeUnit timeUnit) {
        return this.a.a(l2, timeUnit);
    }

    @Override
    public final long c() {
        return this.a.c();
    }

    @Override
    public final u d() {
        return this.a.d();
    }

    @Override
    public final void f() throws IOException {
        this.a.f();
    }
}

