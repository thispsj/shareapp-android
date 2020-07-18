/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.zip.DataFormatException
 *  java.util.zip.Inflater
 */
package c;

import c.c;
import c.e;
import c.p;
import c.q;
import c.t;
import c.u;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class k
implements t {
    private final e a;
    private final Inflater b;
    private int c;
    private boolean d;

    k(e e2, Inflater inflater) {
        if (e2 == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.a = e2;
        this.b = inflater;
    }

    private void b() throws IOException {
        if (this.c == 0) {
            return;
        }
        int n2 = this.c - this.b.getRemaining();
        this.c -= n2;
        this.a.i(n2);
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final long a(c var1, long var2_2) throws IOException {
        if (var2_2 < 0L) {
            var4_3 = new StringBuilder("byteCount < 0: ");
            var4_3.append(var2_2);
            throw new IllegalArgumentException(var4_3.toString());
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (var2_2 == 0L) {
            return 0L;
        }
        do {
            block15 : {
                var6_9 = this.b.needsInput();
                var7_8 = false;
                if (!var6_9) {
                    var7_8 = false;
                } else {
                    k.super.b();
                    if (this.b.getRemaining() != 0) {
                        throw new IllegalStateException("?");
                    }
                    if (this.a.c()) {
                        var7_8 = true;
                    } else {
                        var16_7 = this.a.b().a;
                        this.c = var16_7.c - var16_7.b;
                        this.b.setInput(var16_7.a, var16_7.b, this.c);
                    }
                }
                var9_5 = var1.e(1);
                var10_6 = (int)Math.min((long)var2_2, (long)(8192 - var9_5.c));
                var11_4 = this.b.inflate(var9_5.a, var9_5.c, var10_6);
                if (var11_4 <= 0) break block15;
                var9_5.c = var11_4 + var9_5.c;
                var12_10 = var1.b;
                var14_11 = var11_4;
                var1.b = var12_10 + var14_11;
                return var14_11;
            }
            if (this.b.finished() || this.b.needsDictionary()) ** GOTO lbl42
            if (!var7_8) continue;
            break;
        } while (true);
        try {
            throw new EOFException("source exhausted prematurely");
lbl42: // 1 sources:
            k.super.b();
            if (var9_5.b != var9_5.c) return -1L;
            var1.a = var9_5.b();
            q.a(var9_5);
            return -1L;
        }
        catch (DataFormatException var8_12) {
            throw new IOException((Throwable)var8_12);
        }
    }

    @Override
    public final u a() {
        return this.a.a();
    }

    @Override
    public final void close() throws IOException {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.a.close();
    }
}

