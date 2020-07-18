/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  io.a.a.a.a.b.g
 *  io.a.a.a.a.b.i
 *  io.a.a.a.a.b.k
 *  io.a.a.a.a.b.l
 *  io.a.a.a.a.b.p
 *  io.a.a.a.a.b.t
 *  io.a.a.a.a.e.e
 *  io.a.a.a.a.g.i
 *  io.a.a.a.a.g.j
 *  io.a.a.a.a.g.k
 *  io.a.a.a.a.g.l
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Locale
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.atomic.AtomicReference
 */
package io.a.a.a.a.g;

import android.content.Context;
import android.os.Build;
import io.a.a.a.a.b.p;
import io.a.a.a.a.e.e;
import io.a.a.a.a.g.g;
import io.a.a.a.a.g.j;
import io.a.a.a.a.g.k;
import io.a.a.a.a.g.l;
import io.a.a.a.a.g.r;
import io.a.a.a.a.g.s;
import io.a.a.a.a.g.t;
import io.a.a.a.a.g.v;
import io.a.a.a.a.g.w;
import io.a.a.a.a.g.x;
import io.a.a.a.c;
import io.a.a.a.i;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class q {
    private final AtomicReference<t> a;
    private final CountDownLatch b;
    private s c;
    private boolean d;

    private q() {
        this.a = new AtomicReference();
        this.b = new CountDownLatch(1);
        this.d = false;
    }

    /* synthetic */ q(byte by) {
    }

    private void a(t t2) {
        this.a.set((Object)t2);
        this.b.countDown();
    }

    public final q a(i i2, p p2, e e2, String string2, String string3, String string4) {
        q q2 = this;
        synchronized (q2) {
            block5 : {
                boolean bl = this.d;
                if (!bl) break block5;
                return this;
            }
            if (this.c == null) {
                Context context = i2.h;
                String string5 = p2.b;
                new io.a.a.a.a.b.g();
                String string6 = io.a.a.a.a.b.g.a((Context)context);
                String string7 = p2.d();
                io.a.a.a.a.b.t t2 = new io.a.a.a.a.b.t();
                k k2 = new k();
                io.a.a.a.a.g.i i3 = new io.a.a.a.a.g.i(i2);
                String string8 = io.a.a.a.a.b.i.i((Context)context);
                l l2 = new l(i2, string4, String.format((Locale)Locale.US, (String)"https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", (Object[])new Object[]{string5}), e2);
                String string9 = p.b();
                String string10 = p.a((String)Build.VERSION.INCREMENTAL);
                String string11 = p.a((String)Build.VERSION.RELEASE);
                String string12 = p2.e();
                String string13 = p2.a();
                String string14 = p2.f();
                String[] arrstring = new String[]{io.a.a.a.a.b.i.k((Context)context)};
                String string15 = io.a.a.a.a.b.i.a((String[])arrstring);
                int n2 = io.a.a.a.a.b.l.a((String)string7).e;
                w w2 = new w(string6, string9, string10, string11, string12, string13, string14, string15, string3, string2, n2, string8);
                j j2 = new j(i2, w2, (io.a.a.a.a.b.k)t2, (v)k2, (g)i3, (x)l2);
                this.c = j2;
            }
            this.d = true;
            return this;
        }
    }

    public final t a() {
        try {
            this.b.await();
            t t2 = (t)this.a.get();
            return t2;
        }
        catch (InterruptedException interruptedException) {
            c.a().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean b() {
        q q2 = this;
        synchronized (q2) {
            t t2 = this.c.a();
            this.a(t2);
            if (t2 == null) return false;
            return true;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean c() {
        q q2 = this;
        synchronized (q2) {
            t t2;
            block4 : {
                t2 = this.c.a(r.b);
                this.a(t2);
                if (t2 != null) break block4;
                c.a().c("Fabric", "Failed to force reload of settings from Crashlytics.", null);
            }
            if (t2 == null) return false;
            return true;
        }
    }

    public static final class a {
        private static final q a = new q(0);

        public static /* synthetic */ q a() {
            return a;
        }
    }

}

