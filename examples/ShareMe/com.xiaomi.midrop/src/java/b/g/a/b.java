/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  b.g.a.b$1
 *  io.netty.a.b
 *  io.netty.b.a.e
 *  io.netty.b.ai
 *  io.netty.b.b.a.b
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.b.q
 *  io.netty.buffer.ByteBuf
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.security.KeyPair
 *  java.security.PublicKey
 *  java.util.Locale
 */
package b.g.a;

import android.text.TextUtils;
import b.g.a;
import b.g.a.b;
import b.g.b.a;
import b.g.c;
import com.xiaomi.midrop.util.r;
import io.netty.b.a.e;
import io.netty.b.ai;
import io.netty.b.d;
import io.netty.b.h;
import io.netty.b.j;
import io.netty.b.q;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.d.a.p;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Locale;

public class b
extends b.g.a.a
implements a {
    static final /* synthetic */ boolean c = true;
    private c d = null;
    private boolean e = false;
    private ai f;
    private io.netty.a.b g;
    private h h;
    private boolean i;

    public b(c c2) {
        this.d = c2;
    }

    static /* synthetic */ c a(b b2) {
        return b2.d;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public final boolean a() {
        var11_1 = this;
        // MONITORENTER : var11_1
        if (!this.i) {
            var2_6 = false;
            // MONITOREXIT : var11_1
            return var2_6;
        }
        var3_2 = this.h;
        if (var3_2 == null) ** GOTO lbl15
        this.h.e().n();
        this.h.e().q().f();
        var5_3 = this.f;
lbl13: // 2 sources:
        do {
            var5_3.h();
lbl15: // 2 sources:
            var2_6 = true;
            this.i = false;
            this.e = false;
            return var2_6;
            break;
        } while (true);
        {
            catch (Throwable var7_4) {
            }
            catch (IllegalStateException | InterruptedException var4_5) {}
            {
                var4_5.printStackTrace();
                var5_3 = this.f;
                ** continue;
            }
        }
        this.f.h();
        throw var7_4;
    }

    @Override
    public final boolean a(b.g.b.a a2) {
        return this.a(a2.toString());
    }

    @Override
    public final boolean a(b.g.b.b b2) {
        return this.a(b2.toString());
    }

    @Override
    public final boolean a(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2) && this.b() && this.h != null) {
            new StringBuilder("send ").append(this.d());
            byte[] arrby = this.a(string2.getBytes());
            if (arrby != null) {
                String string3 = new String(arrby);
                ByteBuf byteBuf = Unpooled.buffer(string3.length());
                byteBuf.writeBytes(string3.getBytes());
                byteBuf.writeByte(10);
                this.h.e().a((Object)byteBuf);
                if (!c && !this.h.isDone()) {
                    throw new AssertionError();
                }
                if (!this.h.isCancelled()) {
                    if (!this.h.h()) {
                        if (this.h.g() != null) {
                            this.h.g().printStackTrace();
                        }
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final boolean a(String string2, int n2, boolean bl) {
        void var13_4 = this;
        synchronized (var13_4) {
            block9 : {
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{string2, n2, 10000, bl};
                String.format((Locale)locale, (String)"connect: %s:%d %d, %s", (Object[])arrobject);
                if (this.i) return false;
                this.a = bl ? r.a() : null;
                this.b = null;
                try {
                    this.f = new e();
                }
                catch (Exception exception) {
                    midrop.service.c.d.b("XmppClientImpl", exception.toString(), new Object[0]);
                }
                this.g = new io.netty.a.b();
                ((io.netty.a.b)((io.netty.a.b)((io.netty.a.b)((io.netty.a.b)this.g.a((ai)this.f)).a(io.netty.b.b.a.b.class)).a((q)q.y, (Object)Boolean.valueOf((boolean)true))).a((q)q.d, (Object)Integer.valueOf((int)10000))).e = new 1((b)this);
                this.h = this.g.a(string2, n2);
                if (this.h == null) return false;
                this.h.a();
                if (!c && !this.h.isDone()) {
                    throw new AssertionError();
                }
                if (!this.h.isCancelled()) {
                    if (!this.h.h()) {
                        if (this.h.g() != null) {
                            midrop.service.c.d.a("XmppClientImpl", "xmpp connect fail", this.h.g(), new Object[0]);
                        }
                    } else {
                        this.e = true;
                    }
                }
                break block9;
                return false;
            }
            boolean bl2 = this.e;
            this.i = true;
            if (!this.e) return bl2;
            if (!bl) return bl2;
            midrop.service.c.d.a("XMPP client sending public key", new Object[0]);
            b.g.b.a a2 = new b.g.b.a();
            a2.a = a.a.b;
            a2.c = "http://www.xiaomi.com/midrop";
            a2.d = "send_pk";
            a2.e = midrop.b.a.c.a(this.a.getPublic().getEncoded());
            a2.f = com.xiaomi.midrop.util.e.a();
            this.a(a2.toString());
            return bl2;
        }
    }

    @Override
    public final boolean b() {
        b b2 = this;
        synchronized (b2) {
            boolean bl = this.e;
            return bl;
        }
    }
}

