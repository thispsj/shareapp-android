/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.a.s
 *  java.lang.Object
 */
package io.netty.d.a;

import io.netty.d.a.p;
import io.netty.d.a.r;
import io.netty.d.a.s;

final class g {
    r<? extends p<?>>[] a = new r[2];
    int b;
    int c;

    g(r<? extends p<?>> r2, r<? extends p<?>> r3) {
        this.a[0] = r2;
        this.a[1] = r3;
        this.b = 2;
        if (r2 instanceof s) {
            this.c = 1 + this.c;
        }
        if (r3 instanceof s) {
            this.c = 1 + this.c;
        }
    }
}

