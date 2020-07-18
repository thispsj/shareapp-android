/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package a.b.b.a;

import a.b.b.a.a;
import a.b.b.a.b;
import a.b.d;
import a.b.e;

public abstract class c
extends a {
    private final e a;
    public transient a.b.c<Object> i;

    public c(a.b.c<Object> c2) {
        e e2 = c2 != null ? c2.a() : null;
        super(c2, e2);
    }

    public c(a.b.c<Object> c2, e e2) {
        super(c2);
        this.a = e2;
    }

    @Override
    public final e a() {
        e e2 = this.a;
        if (e2 == null) {
            a.e.b.d.a();
        }
        return e2;
    }

    @Override
    protected final void b() {
        a.b.c<Object> c2 = this.i;
        if (c2 != null && c2 != this) {
            Object e2 = this.a().get(d.a);
            if (e2 == null) {
                a.e.b.d.a();
            }
            ((d)e2).b(c2);
        }
        this.i = b.a;
    }
}

