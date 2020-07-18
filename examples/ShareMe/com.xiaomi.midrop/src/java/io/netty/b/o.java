/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.b.l
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.ConcurrentMap
 */
package io.netty.b;

import io.netty.b.d;
import io.netty.b.h;
import io.netty.b.j;
import io.netty.b.l;
import io.netty.b.n;
import io.netty.b.t;
import io.netty.d.b.a.e;
import java.util.concurrent.ConcurrentMap;

@j.a
public abstract class o<C extends d>
extends n {
    private static final io.netty.d.b.a.d a = e.a(o.class);
    private final ConcurrentMap<l, Boolean> b = io.netty.d.b.n.j();

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private boolean a(l var1) throws Exception {
        if (this.b.putIfAbsent((Object)var1, (Object)Boolean.TRUE) != null) return false;
        this.a((C)var1.a());
lbl4: // 2 sources:
        do {
            o.super.b(var1);
            return true;
            break;
        } while (true);
        {
            catch (Throwable var3_2) {
            }
            catch (Throwable var2_3) {}
            {
                this.a(var1, var2_3);
                ** continue;
            }
        }
        o.super.b(var1);
        throw var3_2;
    }

    private void b(l l2) {
        try {
            t t2 = l2.b();
            if (t2.b((j)this) != null) {
                t2.a((j)this);
            }
            return;
        }
        finally {
            this.b.remove((Object)l2);
        }
    }

    public abstract void a(C var1) throws Exception;

    @Override
    public final void a(l l2, Throwable throwable) throws Exception {
        io.netty.d.b.a.d d2 = a;
        StringBuilder stringBuilder = new StringBuilder("Failed to initialize a channel. Closing: ");
        stringBuilder.append((Object)l2.a());
        d2.d(stringBuilder.toString(), throwable);
        l2.k();
    }

    public final void c(l l2) throws Exception {
        if (l2.a().m()) {
            o.super.a(l2);
        }
    }

    @Override
    public final void e(l l2) throws Exception {
        if (o.super.a(l2)) {
            l2.b().a();
            return;
        }
        l2.e();
    }
}

