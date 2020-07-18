/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.concurrent.atomic.AtomicReference
 */
package a.h;

import a.e.b.d;
import a.h.b;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T>
implements b<T> {
    private final AtomicReference<b<T>> a;

    public a(b<? extends T> b2) {
        d.b(b2, "sequence");
        this.a = new AtomicReference(b2);
    }

    @Override
    public final Iterator<T> a() {
        b b2 = (b)this.a.getAndSet(null);
        if (b2 == null) {
            throw (Throwable)new IllegalStateException("This sequence can be consumed only once.");
        }
        return b2.a();
    }
}

