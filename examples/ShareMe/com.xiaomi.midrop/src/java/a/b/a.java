/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package a.b;

import a.b.e;
import a.e.a.m;
import a.e.b.d;

public abstract class a
implements e.b {
    private final e.c<?> key;

    public a(e.c<?> c2) {
        d.b(c2, "key");
        this.key = c2;
    }

    @Override
    public <R> R fold(R r, m<? super R, ? super e.b, ? extends R> m2) {
        d.b(m2, "operation");
        return e.a.a(this, r, m2);
    }

    @Override
    public <E extends e.b> E get(e.c<E> c2) {
        d.b(c2, "key");
        return e.a.a(this, c2);
    }

    @Override
    public e.c<?> getKey() {
        return this.key;
    }

    @Override
    public e minusKey(e.c<?> c2) {
        d.b(c2, "key");
        return e.a.b(this, c2);
    }

    @Override
    public e plus(e e2) {
        d.b(e2, "context");
        return e.a.a(this, e2);
    }
}

