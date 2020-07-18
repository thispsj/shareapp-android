/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package a.b.b.a;

import a.b.c;
import a.b.e;

public final class b
implements c<Object> {
    public static final b a = new b();

    private b() {
    }

    @Override
    public final e a() {
        throw (Throwable)new IllegalStateException("This continuation is already complete".toString());
    }

    @Override
    public final void b(Object object) {
        throw (Throwable)new IllegalStateException("This continuation is already complete".toString());
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}

