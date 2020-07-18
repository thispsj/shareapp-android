/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.g
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.ThreadGroup
 */
package io.netty.d.a;

import io.netty.d.a.n;
import io.netty.d.b.g;

public final class o
extends Thread {
    public g a;
    private final boolean b;

    public o() {
        this.b = false;
    }

    public o(Runnable runnable) {
        super(n.a(runnable));
        this.b = true;
    }

    public o(ThreadGroup threadGroup, Runnable runnable, String string2) {
        super(threadGroup, n.a(runnable), string2);
        this.b = true;
    }

    public static boolean a(Thread thread) {
        return thread instanceof o && ((o)thread).b;
    }
}

