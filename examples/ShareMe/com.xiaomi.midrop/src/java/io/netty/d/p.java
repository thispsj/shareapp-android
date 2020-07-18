/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Deprecated
 *  java.lang.Error
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.ConcurrentMap
 */
package io.netty.d;

import io.netty.d.b.n;
import io.netty.d.q;
import java.util.concurrent.ConcurrentMap;

public final class p
extends Error {
    private static final ConcurrentMap<String, Boolean> a = n.j();
    private static final long serialVersionUID = -221145131122459977L;
    private final q b;

    @Deprecated
    private p(String string2) {
        super(string2);
        this.b = new q(a, string2);
    }

    public static p a(String string2) {
        return new p(string2);
    }

    public final Throwable fillInStackTrace() {
        return this;
    }

    public final Throwable initCause(Throwable throwable) {
        return this;
    }

    public final String toString() {
        return this.b.E;
    }
}

