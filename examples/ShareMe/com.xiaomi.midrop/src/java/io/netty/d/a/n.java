/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package io.netty.d.a;

import io.netty.d.a.m;
import io.netty.d.b.l;

final class n
implements Runnable {
    private final Runnable a;

    private n(Runnable runnable) {
        this.a = l.a(runnable, "runnable");
    }

    static Runnable a(Runnable runnable) {
        if (runnable instanceof n) {
            return runnable;
        }
        return new n(runnable);
    }

    public final void run() {
        try {
            this.a.run();
            return;
        }
        finally {
            m.removeAll();
        }
    }
}

