/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package a.b.b.a;

import a.b.b.a.a;
import a.b.c;
import a.b.e;

public abstract class f
extends a {
    public f(c<Object> c2) {
        boolean bl;
        super(c2);
        if (c2 != null && !(bl = c2.a() == a.b.f.a)) {
            throw (Throwable)new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
        }
    }

    @Override
    public final e a() {
        return a.b.f.a;
    }
}

