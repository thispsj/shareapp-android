/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Iterator
 */
package a.h;

import a.e.b.d;
import a.h.b;
import a.h.i;
import java.util.Iterator;

public final class i<T, R>
implements b<R> {
    final b<T> a;
    final a.e.a.b<T, R> b;

    public i(b<? extends T> b2, a.e.a.b<? super T, ? extends R> b3) {
        d.b(b2, "sequence");
        d.b(b3, "transformer");
        this.a = b2;
        this.b = b3;
    }

    @Override
    public final Iterator<R> a() {
        return new Iterator<R>(this){
            final /* synthetic */ i a;
            private final Iterator<T> b;
            {
                this.a = i2;
                this.b = i2.a.a();
            }

            public final boolean hasNext() {
                return this.b.hasNext();
            }

            public final R next() {
                return this.a.b.a(this.b.next());
            }

            public final void remove() {
                throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }
}

