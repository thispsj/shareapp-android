/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
package a;

import a.e.b.d;
import a.g;

public final class h {
    public static final Object a(Throwable throwable) {
        d.b((Object)throwable, "exception");
        return new g.b(throwable);
    }

    public static final void a(Object object) {
        if (object instanceof g.b) {
            throw ((g.b)object).a;
        }
    }
}

