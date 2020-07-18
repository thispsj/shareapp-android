/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.a$a
 *  io.netty.b.ac
 *  io.netty.b.d
 *  io.netty.b.h
 *  io.netty.b.l
 *  io.netty.d.a.y
 *  io.netty.d.e
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.ConnectException
 *  java.net.NoRouteToHostException
 *  java.net.SocketAddress
 *  java.net.SocketException
 *  java.nio.channels.ClosedChannelException
 *  java.nio.channels.NotYetConnectedException
 */
package io.netty.b;

import io.netty.b.a;
import io.netty.b.ac;
import io.netty.b.ad;
import io.netty.b.ah;
import io.netty.b.ar;
import io.netty.b.as;
import io.netty.b.d;
import io.netty.b.h;
import io.netty.b.l;
import io.netty.b.r;
import io.netty.b.t;
import io.netty.b.x;
import io.netty.d.a.y;
import io.netty.d.b.n;
import io.netty.d.b.w;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;

public abstract class a
extends io.netty.d.e
implements io.netty.b.d {
    private static final io.netty.d.b.a.d c = io.netty.d.b.a.e.a(a.class);
    private static final ClosedChannelException d = w.a(new ClosedChannelException(), a.class, "flush0()");
    private static final ClosedChannelException e = w.a(new ClosedChannelException(), a.class, "ensureOpen(...)");
    private static final ClosedChannelException f = w.a(new ClosedChannelException(), a.class, "close(...)");
    private static final ClosedChannelException g = w.a(new ClosedChannelException(), a.class, "write(...)");
    private static final NotYetConnectedException h = w.a(new NotYetConnectedException(), a.class, "flush0()");
    public final ac a;
    volatile boolean b;
    private final io.netty.b.d i;
    private final long j = n.o().nextLong();
    private final d.a k;
    private final h l;
    private final as m;
    private final as n;
    private final e o;
    private volatile SocketAddress p;
    private volatile SocketAddress q;
    private volatile ah r;
    private boolean s;
    private boolean t;
    private String u;

    protected a(io.netty.b.d d2) {
        this.l = new ar((io.netty.b.d)this);
        this.m = new as((io.netty.b.d)this, true);
        this.n = new as((io.netty.b.d)this, false);
        this.o = new e((a)this);
        this.i = d2;
        this.k = this.a();
        this.a = new ac((io.netty.b.d)this);
    }

    static /* synthetic */ ClosedChannelException A() {
        return d;
    }

    static /* synthetic */ ClosedChannelException B() {
        return e;
    }

    static /* synthetic */ ah a(a a2, ah ah2) {
        a2.r = ah2;
        return ah2;
    }

    static /* synthetic */ boolean a(a a2) {
        return a2.b;
    }

    static /* synthetic */ boolean a(a a2, boolean bl) {
        a2.b = bl;
        return bl;
    }

    static /* synthetic */ ah b(a a2) {
        return a2.r;
    }

    static /* synthetic */ e c(a a2) {
        return a2.o;
    }

    static /* synthetic */ ac d(a a2) {
        return a2.a;
    }

    static /* synthetic */ boolean e(a a2) {
        return a2.s;
    }

    static /* synthetic */ boolean f(a a2) {
        a2.s = true;
        return true;
    }

    static /* synthetic */ as g(a a2) {
        return a2.n;
    }

    static /* synthetic */ io.netty.d.b.a.d w() {
        return c;
    }

    static /* synthetic */ ClosedChannelException x() {
        return f;
    }

    static /* synthetic */ ClosedChannelException y() {
        return g;
    }

    static /* synthetic */ NotYetConnectedException z() {
        return h;
    }

    public abstract a a();

    public final h a(Object object) {
        return this.a.c.c(object);
    }

    public final h a(SocketAddress socketAddress, x x2) {
        return this.a.c.a(socketAddress, x2);
    }

    public final h a(SocketAddress socketAddress, SocketAddress socketAddress2, x x2) {
        return this.a.c.a(socketAddress, socketAddress2, x2);
    }

    public abstract void a(r var1) throws Exception;

    public abstract void a(SocketAddress var1) throws Exception;

    public abstract boolean a(ah var1);

    public final h b(SocketAddress socketAddress, x x2) {
        return this.a.c.a(socketAddress, null, x2);
    }

    public Object b(Object object) throws Exception {
        return object;
    }

    public abstract SocketAddress b();

    public abstract SocketAddress c();

    public /* synthetic */ int compareTo(Object object) {
        io.netty.b.d d2 = (io.netty.b.d)object;
        if (this == d2) {
            return 0;
        }
        long l2 = this.j - (long)d2.hashCode();
        if (l2 > 0L) {
            return 1;
        }
        if (l2 < 0L) {
            return -1;
        }
        long l3 = System.identityHashCode((Object)this) - System.identityHashCode((Object)d2);
        if (l3 != 0L) {
            return (int)l3;
        }
        throw new Error();
    }

    public abstract void d() throws Exception;

    public abstract void e() throws Exception;

    public final boolean equals(Object object) {
        return this == object;
    }

    public final int hashCode() {
        return (int)this.j;
    }

    public final t i() {
        return this.a;
    }

    public ah j() {
        ah ah2 = this.r;
        if (ah2 == null) {
            throw new IllegalStateException("channel not registered to an event loop");
        }
        return ah2;
    }

    /*
     * Exception decompiling
     */
    public SocketAddress k() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl17 : ALOAD_1 : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public SocketAddress l() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl17 : ALOAD_1 : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public final boolean m() {
        return this.b;
    }

    public final h n() {
        return this.a.c.k();
    }

    public final io.netty.b.d o() {
        this.a.c.l();
        return this;
    }

    public final x p() {
        return new ad(this);
    }

    public final h q() {
        return this.o;
    }

    public d.a r() {
        return this.k;
    }

    public final x s() {
        return this.m;
    }

    public void t() throws Exception {
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        String string2;
        boolean bl = this.h();
        if (this.t == bl && this.u != null) {
            return this.u;
        }
        SocketAddress socketAddress = this.l();
        SocketAddress socketAddress2 = this.k();
        if (socketAddress != null) {
            String string3 = bl ? "-" : "!";
            Object[] arrobject = new Object[]{(int)this.j, socketAddress2, string3, socketAddress};
            string2 = String.format((String)"[id: 0x%08x, L:%s %s R:%s]", (Object[])arrobject);
        } else if (socketAddress2 != null) {
            Object[] arrobject = new Object[]{(int)this.j, socketAddress2};
            string2 = String.format((String)"[id: 0x%08x, L:%s]", (Object[])arrobject);
        } else {
            Object[] arrobject = new Object[]{(int)this.j};
            string2 = String.format((String)"[id: 0x%08x]", (Object[])arrobject);
        }
        this.u = string2;
        this.t = bl;
        return this.u;
    }

    protected void u() throws Exception {
        this.d();
    }

    public void v() throws Exception {
    }

    static final class e
    extends ad {
        e(a a2) {
            super(a2);
        }

        @Override
        public final x a(Throwable throwable) {
            throw new IllegalStateException();
        }

        @Override
        public final x b() {
            throw new IllegalStateException();
        }

        @Override
        public final boolean b(Throwable throwable) {
            throw new IllegalStateException();
        }

        @Override
        public final /* synthetic */ y c(Throwable throwable) {
            throw new IllegalStateException();
        }

        @Override
        public final boolean l_() {
            throw new IllegalStateException();
        }

        final boolean r_() {
            return super.l_();
        }
    }

}

