/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.netty.c.c;

import io.netty.c.c.a;
import io.netty.d.b.l;

public final class b {
    public static final b a = new b(a.a, true);
    public static final b b = new b(a.a, false);
    public static final b c = new b(a.b, true);
    public static final b d = new b(a.b, false);
    public static final b e = new b(a.c, true);
    public static final b f = new b(a.c, false);
    public final a g;
    private final boolean h;

    private b(a a2, boolean bl) {
        this.g = l.a(a2, "state");
        this.h = bl;
    }
}

