/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.aa
 *  io.netty.b.b.j
 *  io.netty.b.q
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.net.Socket
 *  java.net.SocketException
 */
package io.netty.b.b;

import io.netty.b.aa;
import io.netty.b.ak;
import io.netty.b.am;
import io.netty.b.b.i;
import io.netty.b.b.j;
import io.netty.b.g;
import io.netty.b.q;
import io.netty.buffer.ByteBufAllocator;
import java.net.Socket;
import java.net.SocketException;

public class e
extends aa
implements j {
    protected final Socket b;
    private volatile boolean c;

    /*
     * Exception decompiling
     */
    public e(i var1, Socket var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    private j c(boolean bl) {
        try {
            this.b.setKeepAlive(bl);
            return this;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    private j d(boolean bl) {
        try {
            this.b.setReuseAddress(bl);
            return this;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    private j e(boolean bl) {
        try {
            this.b.setTcpNoDelay(bl);
            return this;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    private j f(int n2) {
        try {
            this.b.setReceiveBufferSize(n2);
            return this;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    private j g(int n2) {
        try {
            this.b.setSendBufferSize(n2);
            return this;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private j h(int n2) {
        if (n2 < 0) {
            this.b.setSoLinger(false, 0);
            return this;
        }
        try {
            this.b.setSoLinger(true, n2);
            return this;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    private j i(int n2) {
        try {
            this.b.setTrafficClass(n2);
            return this;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    private int m() {
        try {
            int n2 = this.b.getReceiveBufferSize();
            return n2;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    private int n() {
        try {
            int n2 = this.b.getSendBufferSize();
            return n2;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    private int o() {
        try {
            int n2 = this.b.getTrafficClass();
            return n2;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    private boolean p() {
        try {
            boolean bl = this.b.getKeepAlive();
            return bl;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    private boolean q() {
        try {
            boolean bl = this.b.getReuseAddress();
            return bl;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    private boolean r() {
        try {
            boolean bl = this.b.getTcpNoDelay();
            return bl;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }

    public final <T> T a(q<T> q2) {
        if (q2 == q.o) {
            return e.super.m();
        }
        if (q2 == q.n) {
            return e.super.n();
        }
        if (q2 == q.y) {
            return e.super.r();
        }
        if (q2 == q.m) {
            return e.super.p();
        }
        if (q2 == q.p) {
            return e.super.q();
        }
        if (q2 == q.q) {
            return this.l();
        }
        if (q2 == q.t) {
            return e.super.o();
        }
        if (q2 == q.i) {
            return this.c;
        }
        return (T)super.a(q2);
    }

    public final <T> boolean a(q<T> q2, T t2) {
        block10 : {
            block3 : {
                block9 : {
                    block8 : {
                        block7 : {
                            block6 : {
                                block5 : {
                                    block4 : {
                                        block2 : {
                                            e.b(q2, t2);
                                            if (q2 != q.o) break block2;
                                            e.super.f((Integer)t2);
                                            break block3;
                                        }
                                        if (q2 != q.n) break block4;
                                        e.super.g((Integer)t2);
                                        break block3;
                                    }
                                    if (q2 != q.y) break block5;
                                    e.super.e((Boolean)t2);
                                    break block3;
                                }
                                if (q2 != q.m) break block6;
                                e.super.c((Boolean)t2);
                                break block3;
                            }
                            if (q2 != q.p) break block7;
                            e.super.d((Boolean)t2);
                            break block3;
                        }
                        if (q2 != q.q) break block8;
                        e.super.h((Integer)t2);
                        break block3;
                    }
                    if (q2 != q.t) break block9;
                    e.super.i((Integer)t2);
                    break block3;
                }
                if (q2 != q.i) break block10;
                this.c = (Boolean)t2;
            }
            return true;
        }
        return super.a(q2, t2);
    }

    public final int l() {
        try {
            int n2 = this.b.getSoLinger();
            return n2;
        }
        catch (SocketException socketException) {
            throw new g(socketException);
        }
    }
}

