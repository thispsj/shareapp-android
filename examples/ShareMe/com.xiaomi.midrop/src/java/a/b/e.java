/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.b.e$a$a
 *  a.b.e$b
 *  a.b.f
 *  a.e.a.m
 *  java.lang.Object
 */
package a.b;

import a.b.e;
import a.b.f;
import a.e.a.m;
import a.e.b.d;

public interface e {
    public <R> R fold(R var1, m<? super R, ? super b, ? extends R> var2);

    public <E extends b> E get(c<E> var1);

    public e minusKey(c<?> var1);

    public e plus(e var1);

    public static final class a.b.e$a {
        public static e a(e e2, e e3) {
            d.b(e3, "context");
            if (e3 == f.a) {
                return e2;
            }
            return e3.fold(e2, (m)a.a);
        }
    }

    public static interface c<E extends b> {
    }

}

