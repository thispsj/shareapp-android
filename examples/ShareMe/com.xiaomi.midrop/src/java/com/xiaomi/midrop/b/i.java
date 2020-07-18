/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.b;

import com.xiaomi.midrop.b.g;
import java.util.List;

public final class i
extends g {
    public String G;
    public List<g> a;
    public List<g> b;
    public String c;
    public int d;
    public boolean e;
    public boolean f = true;

    public static i a(int n2, String string2, List<g> list) {
        i i2 = new i();
        i2.c = string2;
        i2.d = n2;
        i2.b = list;
        return i2;
    }

    public static i a(String string2, g g2, List<g> list) {
        i i2 = new i();
        i2.c = string2;
        i2.g = g2.g;
        i2.h = g2.h;
        i2.i = g2.i;
        i2.k = g2.k;
        i2.l = g2.l;
        i2.m = g2.m;
        i2.n = g2.n;
        i2.o = g2.o;
        i2.p = g2.p;
        i2.u = g2.u;
        i2.v = g2.v;
        i2.w = g2.w;
        i2.b = list;
        return i2;
    }

    public static i a(List<g> list) {
        i i2 = new i();
        i2.d = 1;
        i2.b = list;
        return i2;
    }

    public final List<g> a() {
        return this.b;
    }

    public final int b() {
        return this.d;
    }

    public final List<g> d() {
        return this.a;
    }
}

