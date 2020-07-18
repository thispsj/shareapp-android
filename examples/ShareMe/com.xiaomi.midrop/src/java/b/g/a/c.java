/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.a.c$b
 *  io.netty.a.a$1
 *  io.netty.a.a$b
 *  io.netty.a.e
 *  io.netty.b.a.e
 *  io.netty.b.ai
 *  io.netty.b.b.a.a
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.b.l
 *  io.netty.b.q
 *  io.netty.b.x
 *  io.netty.buffer.ByteBuf
 *  io.netty.c.b.b
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.InetSocketAddress
 *  java.net.SocketAddress
 *  java.util.HashMap
 *  java.util.Locale
 *  java.util.Map
 */
package b.g.a;

import b.g.a.a;
import b.g.a.c;
import b.g.d;
import b.g.f;
import io.netty.a.a;
import io.netty.b.a.e;
import io.netty.b.ai;
import io.netty.b.h;
import io.netty.b.j;
import io.netty.b.l;
import io.netty.b.q;
import io.netty.b.x;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.d.a.p;
import io.netty.d.a.r;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public class c
extends a
implements d {
    static final /* synthetic */ boolean c = true;
    private boolean d;
    private f e;
    private int f;
    private ai g;
    private ai h;
    private h i;
    private Map<String, l> j;

    public c(f f2, int n2) {
        this.e = null;
        this.j = new HashMap();
        this.e = f2;
        this.f = n2;
    }

    static /* synthetic */ Map a(c c2) {
        return c2.j;
    }

    static /* synthetic */ f b(c c2) {
        return c2.e;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public final boolean a() {
        block10 : {
            c c2 = this;
            // MONITORENTER : c2
            boolean bl = this.d;
            boolean bl2 = false;
            if (bl) {
                // MONITOREXIT : c2
                return bl2;
            }
            this.g = new e(1);
            this.h = new e();
            this.b = null;
            io.netty.a.e e2 = new io.netty.a.e();
            io.netty.a.e e3 = (io.netty.a.e)((io.netty.a.e)e2.a(this.g, this.h).a(io.netty.b.b.a.a.class)).a(q.r, (Object)64);
            e3.e = new io.netty.c.b.b(io.netty.c.b.a.c);
            e3.f = new /* Unavailable Anonymous Inner Class!! */;
            this.d = true;
            try {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f);
                e2.a();
                h h2 = e2.c();
                io.netty.b.d d2 = h2.e();
                if (h2.g() == null) {
                    if (h2.isDone()) {
                        x x2 = d2.p();
                        io.netty.a.a.a(h2, d2, (SocketAddress)inetSocketAddress, x2);
                        h2 = x2;
                    } else {
                        a.b b2 = new /* Unavailable Anonymous Inner Class!! */;
                        a.1 var14_11 = new a.1((io.netty.a.a)e2, b2, d2, h2, (SocketAddress)inetSocketAddress);
                        h2.a((r)var14_11);
                        h2 = b2;
                    }
                }
                this.i = h2.f();
                if (!c && !this.i.isDone()) {
                    throw new AssertionError();
                }
                if (this.i.isCancelled() || this.i.h()) break block10;
                this.i.g().printStackTrace();
            }
            catch (Exception exception) {
                block11 : {
                    midrop.service.c.d.a("XmppServerImpl", "start xmpp", exception, new Object[0]);
                    break block11;
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                this.d = false;
                return false;
            }
        }
        this.f = ((InetSocketAddress)this.i.e().k()).getPort();
        new StringBuilder("start port:").append(this.f);
        return true;
    }

    @Override
    public final boolean a(String string2, int n2, b.g.b.a a2) {
        return this.a(string2, n2, a2.toString());
    }

    @Override
    public final boolean a(String string2, int n2, b.g.b.b b2) {
        return this.a(string2, n2, b2.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public final boolean a(String string2, int n2, String string3) {
        Map<String, l> map;
        StringBuilder stringBuilder = new StringBuilder("send: ");
        boolean bl = this.b != null;
        stringBuilder.append(bl);
        if (string3 == null) return false;
        byte[] arrby = this.a(string3.getBytes());
        if (arrby == null) return false;
        String string4 = new String(arrby);
        ByteBuf byteBuf = Unpooled.buffer(string4.length());
        byteBuf.writeBytes(string4.getBytes());
        byteBuf.writeByte(10);
        Map<String, l> map2 = map = this.j;
        // MONITORENTER : map2
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{string2, n2};
        String string5 = String.format((Locale)locale, (String)"/%s:%d", (Object[])arrobject);
        l l2 = (l)this.j.get((Object)string5);
        if (l2 == null) {
            // MONITOREXIT : map2
            return false;
        }
        l2.c((Object)byteBuf);
        // MONITOREXIT : map2
        if (!c && !this.i.isDone()) {
            throw new AssertionError();
        }
        if (this.i.isCancelled()) return false;
        if (this.i.h()) return true;
        this.i.g().printStackTrace();
        return false;
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
    public final boolean b() {
        block10 : {
            block9 : {
                var15_1 = this;
                // MONITORENTER : var15_1
                if (!this.d) break block9;
                var2_2 = true;
                this.d = false;
                this.i.e().n();
                this.i.e().q().f();
                this.g.h();
                var5_3 = this.h;
                break block10;
            }
            var2_2 = false;
            ** GOTO lbl18
        }
lbl16: // 2 sources:
        do {
            var5_3.h();
lbl18: // 2 sources:
            var7_6 = new StringBuilder("Xmpp server stop,ret ");
            var7_6.append(var2_2);
            midrop.service.c.d.a(var7_6.toString(), new Object[0]);
            // MONITOREXIT : var15_1
            return var2_2;
            break;
        } while (true);
        {
            catch (Throwable var9_4) {
            }
            catch (InterruptedException var3_5) {}
            {
                var3_5.printStackTrace();
            }
            this.g.h();
            var5_3 = this.h;
            ** continue;
        }
        this.g.h();
        this.h.h();
        throw var9_4;
    }

    @Override
    public final int c() {
        return this.f;
    }
}

