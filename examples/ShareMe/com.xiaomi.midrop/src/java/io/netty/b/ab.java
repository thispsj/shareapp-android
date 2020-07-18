/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.ac
 *  io.netty.b.m
 *  io.netty.b.s
 *  java.lang.NullPointerException
 *  java.lang.String
 */
package io.netty.b;

import io.netty.b.ac;
import io.netty.b.b;
import io.netty.b.j;
import io.netty.b.m;
import io.netty.b.s;

final class ab
extends b {
    private final j h;

    ab(ac ac2, String string2, j j2) {
        super(ac2, string2, j2 instanceof m, j2 instanceof s);
        if (j2 == null) {
            throw new NullPointerException("handler");
        }
        this.h = j2;
    }

    public final j q() {
        return this.h;
    }
}

