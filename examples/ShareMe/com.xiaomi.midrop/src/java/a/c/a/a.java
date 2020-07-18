/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
package a.c.a;

import a.e.b.d;

public class a
extends a.c.a {
    @Override
    public final void a(Throwable throwable, Throwable throwable2) {
        d.b((Object)throwable, "cause");
        d.b((Object)throwable2, "exception");
        throwable.addSuppressed(throwable2);
    }
}

