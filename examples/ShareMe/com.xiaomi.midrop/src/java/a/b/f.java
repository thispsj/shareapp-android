/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package a.b;

import a.b.e;
import a.e.a.m;
import a.e.b.d;
import java.io.Serializable;

public final class f
implements e,
Serializable {
    public static final f a = new f();
    private static final long serialVersionUID;

    private f() {
    }

    private final Object readResolve() {
        return a;
    }

    @Override
    public final <R> R fold(R r2, m<? super R, ? super e.b, ? extends R> m2) {
        d.b(m2, "operation");
        return r2;
    }

    @Override
    public final <E extends e.b> E get(e.c<E> c2) {
        d.b(c2, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override
    public final e minusKey(e.c<?> c2) {
        d.b(c2, "key");
        return (e)this;
    }

    @Override
    public final e plus(e e2) {
        d.b(e2, "context");
        return e2;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }
}

