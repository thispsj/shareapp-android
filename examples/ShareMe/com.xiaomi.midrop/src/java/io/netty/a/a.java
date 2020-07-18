/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.a.a$a
 *  io.netty.a.d
 *  io.netty.b.ad
 *  io.netty.b.ah
 *  io.netty.b.ai
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.b.i
 *  io.netty.b.q
 *  io.netty.b.x
 *  io.netty.d.a.j
 *  io.netty.d.a.t
 *  io.netty.d.b
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.SocketAddress
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package io.netty.a;

import io.netty.a.a;
import io.netty.a.c;
import io.netty.a.d;
import io.netty.b.ad;
import io.netty.b.ah;
import io.netty.b.ai;
import io.netty.b.d;
import io.netty.b.e;
import io.netty.b.h;
import io.netty.b.i;
import io.netty.b.j;
import io.netty.b.q;
import io.netty.b.x;
import io.netty.d.a.r;
import io.netty.d.a.t;
import io.netty.d.b;
import java.net.SocketAddress;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
 * Exception performing whole class analysis.
 */
public abstract class a<B extends a<B, C>, C extends io.netty.b.d>
implements Cloneable {
    volatile ai a;
    volatile SocketAddress b;
    final Map<q<?>, Object> c;
    final Map<b<?>, Object> d;
    public volatile j e;
    private volatile c<? extends C> f;

    a() {
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    a(a<B, C> a2) {
        Map<b<?>, Object> map;
        Map<q<?>, Object> map2;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.a = a2.a;
        this.f = a2.f;
        this.e = a2.e;
        this.b = a2.b;
        Map<q<?>, Object> map3 = map2 = a2.c;
        synchronized (map3) {
            this.c.putAll(a2.c);
        }
        Map<b<?>, Object> map4 = map = a2.d;
        synchronized (map4) {
            this.d.putAll(a2.d);
            return;
        }
    }

    private static void a(io.netty.b.d d2, q<?> q2, Object object, io.netty.d.b.a.d d3) {
        try {
            if (!d2.f().a(q2, object)) {
                d3.c("Unknown channel option '{}' for channel '{}'", (Object)q2, (Object)d2);
            }
            return;
        }
        catch (Throwable throwable) {
            d3.b("Failed to set channel option '{}' with value '{}' for channel '{}'", new Object[]{q2, object, d2, throwable});
            return;
        }
    }

    static void a(io.netty.b.d d2, Map<q<?>, Object> map, io.netty.d.b.a.d d3) {
        for (Map.Entry entry : map.entrySet()) {
            a.a(d2, (q)entry.getKey(), entry.getValue(), d3);
        }
    }

    static void a(io.netty.b.d d2, Map.Entry<q<?>, Object>[] arrentry, io.netty.d.b.a.d d3) {
        for (Map.Entry<q<?>, Object> entry : arrentry) {
            a.a(d2, (q)entry.getKey(), entry.getValue(), d3);
        }
    }

    public static void a(final h h2, final io.netty.b.d d2, final SocketAddress socketAddress, final x x2) {
        d2.j().execute(new Runnable(){

            public final void run() {
                if (h2.h()) {
                    d2.a(socketAddress, x2).a((r)i.h);
                    return;
                }
                x2.a(h2.g());
            }
        });
    }

    static /* synthetic */ void b(h h2, io.netty.b.d d2, SocketAddress socketAddress, x x2) {
        a.a(h2, d2, socketAddress, x2);
    }

    public B a() {
        if (this.a == null) {
            throw new IllegalStateException("group not set");
        }
        if (this.f == null) {
            throw new IllegalStateException("channel or channelFactory not set");
        }
        return (B)this;
    }

    public B a(ai ai2) {
        if (ai2 == null) {
            throw new NullPointerException("group");
        }
        if (this.a != null) {
            throw new IllegalStateException("group set already");
        }
        this.a = ai2;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final <T> B a(q<T> q2, T t2) {
        Map<q<?>, Object> map;
        if (q2 == null) {
            throw new NullPointerException("option");
        }
        if (t2 == null) {
            Map<q<?>, Object> map2;
            Map<q<?>, Object> map3 = map2 = this.c;
            synchronized (map3) {
                this.c.remove(q2);
                return this;
            }
        }
        Map<q<?>, Object> map4 = map = this.c;
        synchronized (map4) {
            this.c.put(q2, t2);
            return this;
        }
    }

    public final B a(Class<? extends C> class_) {
        a a2 = new /* Unavailable Anonymous Inner Class!! */;
        if (this.f != null) {
            throw new IllegalStateException("channelFactory set already");
        }
        this.f = a2;
        return this;
    }

    abstract void a(io.netty.b.d var1) throws Exception;

    public abstract B b();

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final h c() {
        io.netty.b.d d2;
        Throwable throwable;
        block5 : {
            d2 = null;
            C c2 = this.f.a();
            try {
                this.a((io.netty.b.d)c2);
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                d2 = (io.netty.b.d)c2;
                break block5;
            }
            h h2 = this.a.a(c2);
            if (h2.g() == null) return h2;
            if (c2.m()) {
                c2.n();
                return h2;
            }
            c2.r().d();
            return h2;
            catch (Throwable throwable3) {
                // empty catch block
            }
        }
        if (d2 == null) return new ad((io.netty.b.d)new d(), (io.netty.d.a.j)t.a).a(throwable);
        d2.r().d();
        return new ad(d2, (io.netty.d.a.j)t.a).a(throwable);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public String toString() {
        Map<b<?>, Object> map;
        Map<q<?>, Object> map2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(io.netty.d.b.t.a(this));
        stringBuilder.append('(');
        if (this.a != null) {
            stringBuilder.append("group: ");
            stringBuilder.append(io.netty.d.b.t.a((Object)this.a));
            stringBuilder.append(", ");
        }
        if (this.f != null) {
            stringBuilder.append("channelFactory: ");
            stringBuilder.append(this.f);
            stringBuilder.append(", ");
        }
        if (this.b != null) {
            stringBuilder.append("localAddress: ");
            stringBuilder.append((Object)this.b);
            stringBuilder.append(", ");
        }
        Map<q<?>, Object> map3 = map2 = this.c;
        // MONITORENTER : map3
        if (!this.c.isEmpty()) {
            stringBuilder.append("options: ");
            stringBuilder.append(this.c);
            stringBuilder.append(", ");
        }
        // MONITOREXIT : map3
        Map<b<?>, Object> map4 = map = this.d;
        // MONITORENTER : map4
        if (!this.d.isEmpty()) {
            stringBuilder.append("attrs: ");
            stringBuilder.append(this.d);
            stringBuilder.append(", ");
        }
        // MONITOREXIT : map4
        if (this.e != null) {
            stringBuilder.append("handler: ");
            stringBuilder.append((Object)this.e);
            stringBuilder.append(", ");
        }
        if (stringBuilder.charAt(-1 + stringBuilder.length()) == '(') {
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
        stringBuilder.setCharAt(-2 + stringBuilder.length(), ')');
        stringBuilder.setLength(-1 + stringBuilder.length());
        return stringBuilder.toString();
    }

}

