/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.u$1
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.concurrent.TimeUnit
 */
package c;

import c.u;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class u {
    public static final u c = new 1();
    private boolean a;
    private long b;
    private long d;

    public long A_() {
        return this.d;
    }

    public boolean B_() {
        return this.a;
    }

    public u C_() {
        this.a = false;
        return this;
    }

    public u a(long l2) {
        this.a = true;
        this.b = l2;
        return this;
    }

    public u a(long l2, TimeUnit timeUnit) {
        if (l2 < 0L) {
            StringBuilder stringBuilder = new StringBuilder("timeout < 0: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.d = timeUnit.toNanos(l2);
        return this;
    }

    public long c() {
        if (!this.a) {
            throw new IllegalStateException("No deadline");
        }
        return this.b;
    }

    public u d() {
        this.d = 0L;
        return this;
    }

    public void f() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.a && this.b - System.nanoTime() <= 0L) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}

