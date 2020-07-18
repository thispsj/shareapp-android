/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.a$a
 *  io.netty.b.aj
 *  io.netty.b.b.j
 *  io.netty.b.d
 *  io.netty.buffer.ByteBuf
 *  io.netty.d.b.g
 *  java.io.IOException
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.net.InetSocketAddress
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.nio.ByteBuffer
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 *  java.nio.channels.SelectableChannel
 *  java.nio.channels.SelectionKey
 *  java.nio.channels.SocketChannel
 *  java.nio.channels.spi.SelectorProvider
 *  java.security.AccessController
 *  java.security.PrivilegedActionException
 *  java.security.PrivilegedExceptionAction
 *  java.util.concurrent.Executor
 */
package io.netty.b.b.a;

import io.netty.b.a;
import io.netty.b.a.a;
import io.netty.b.a.b;
import io.netty.b.aj;
import io.netty.b.b.e;
import io.netty.b.b.i;
import io.netty.b.b.j;
import io.netty.b.d;
import io.netty.b.g;
import io.netty.b.p;
import io.netty.b.r;
import io.netty.buffer.ByteBuf;
import io.netty.d.a.m;
import io.netty.d.b.n;
import io.netty.d.b.s;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.Executor;

public class b
extends io.netty.b.a.a
implements i {
    private static final p j = new p();
    private static final SelectorProvider k = SelectorProvider.provider();
    final j i;

    public b() {
        this(b.a(k));
    }

    public b(d d2, SocketChannel socketChannel) {
        super(d2, (SelectableChannel)socketChannel);
        this.i = new a((b)this, (b)this, socketChannel.socket(), 0);
    }

    private b(SocketChannel socketChannel) {
        super(null, socketChannel);
    }

    private static SocketChannel a(SelectorProvider selectorProvider) {
        try {
            SocketChannel socketChannel = selectorProvider.openSocketChannel();
            return socketChannel;
        }
        catch (IOException iOException) {
            throw new g("Failed to open a socket.", iOException);
        }
    }

    static /* synthetic */ void a(b b2) throws Exception {
        b2.v();
    }

    static /* synthetic */ void b(b b2) {
        b2.g = false;
    }

    private void b(SocketAddress socketAddress) throws Exception {
        if (n.d() >= 7) {
            SocketChannel socketChannel = (SocketChannel)super.F();
            try {
                AccessController.doPrivileged((PrivilegedExceptionAction)new PrivilegedExceptionAction<Void>(socketChannel, socketAddress){
                    final /* synthetic */ SocketChannel a;
                    final /* synthetic */ SocketAddress b;
                    {
                        this.a = socketChannel;
                        this.b = socketAddress;
                    }

                    public final /* synthetic */ Object run() throws Exception {
                        this.a.bind(this.b);
                        return null;
                    }
                });
                return;
            }
            catch (PrivilegedActionException privilegedActionException) {
                throw (IOException)privilegedActionException.getCause();
            }
        }
        Socket socket = ((SocketChannel)super.F()).socket();
        try {
            AccessController.doPrivileged((PrivilegedExceptionAction)new PrivilegedExceptionAction<Void>(socket, socketAddress){
                final /* synthetic */ Socket a;
                final /* synthetic */ SocketAddress b;
                {
                    this.a = socket;
                    this.b = socketAddress;
                }

                public final /* synthetic */ Object run() throws Exception {
                    this.a.bind(this.b);
                    return null;
                }
            });
            return;
        }
        catch (PrivilegedActionException privilegedActionException) {
            throw (IOException)privilegedActionException.getCause();
        }
    }

    @Override
    protected final b.a C() {
        return new b(this, 0);
    }

    @Override
    protected final void I() throws Exception {
        if (!((SocketChannel)super.F()).finishConnect()) {
            throw new Error();
        }
    }

    protected final SocketChannel J() {
        return (SocketChannel)super.F();
    }

    @Override
    protected final int a(ByteBuf byteBuf) throws Exception {
        return byteBuf.writeBytes((ScatteringByteChannel)((SocketChannel)super.F()), byteBuf.writableBytes());
    }

    @Override
    protected final long a(aj aj2) throws Exception {
        return aj2.c();
    }

    @Override
    protected final /* synthetic */ a.a a() {
        return this.C();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    protected final void a(r var1) throws Exception {
        do {
            block20 : {
                block21 : {
                    if (var1.f == 0) {
                        this.D();
                        return;
                    }
                    var2_14 = io.netty.d.b.g.b();
                    var3_22 = r.b.get(var2_14);
                    var4_23 = var1.c;
                    var5_20 = false;
                    var6_6 = 0L;
                    var8_15 = 0;
                    block5 : do {
                        block23 : {
                            block24 : {
                                block25 : {
                                    block22 : {
                                        var9_27 = 1;
                                        var10_34 = var4_23 != null && var4_23 != var1.d;
                                        if (!var10_34 || !(var4_23.b instanceof ByteBuf)) break block22;
                                        if (var4_23.j) break block23;
                                        var33_3 = (ByteBuf)var4_23.b;
                                        var34_25 = var33_3.readerIndex();
                                        var35_31 = var33_3.writerIndex() - var34_25;
                                        if (var35_31 <= 0) break block23;
                                        if ((long)(Integer.MAX_VALUE - var35_31) < var6_6) break block22;
                                        var36_4 = var6_6 + (long)var35_31;
                                        var38_28 = var4_23.i;
                                        if (var38_28 == -1) {
                                            var4_23.i = var38_28 = var33_3.nioBufferCount();
                                        }
                                        if ((var39_26 = var8_15 + var38_28) <= var3_22.length) break block24;
                                        break block25;
                                    }
                                    var1.g = var8_15;
                                    var1.h = var6_6;
                                    var11_2 = var1.g;
                                    var12_32 = var1.h;
                                    var14_12 = (SocketChannel)super.F();
                                    switch (var11_2) {
                                        default: {
                                            var27_24 = 0L;
                                            break block5;
                                        }
                                        case 1: {
                                            var15_5 = var3_22[0];
                                            var17_10 = 0L;
                                            for (var16_13 = this.i.c() - var9_27; var16_13 >= 0; --var16_13) {
                                                var21_11 = var14_12.write(var15_5);
                                                if (var21_11 == 0) {
                                                    var19_18 = var17_10;
                                                    var5_20 = false;
                                                    break block20;
                                                }
                                                var22_19 = var21_11;
                                                var24_30 = var12_32 - var22_19;
                                                var19_18 = var17_10 + var22_19;
                                                if (var24_30 != 0L) {
                                                    var17_10 = var19_18;
                                                    var12_32 = var24_30;
                                                    continue;
                                                }
                                                ** GOTO lbl96
                                            }
                                            var19_18 = var17_10;
                                            var5_20 = false;
                                            break block21;
                                        }
                                        case 0: {
                                            super.a(var1);
                                            return;
                                        }
                                    }
                                }
                                var43_21 = var3_22.length;
                                do {
                                    if ((var43_21 <<= var9_27) >= 0) continue;
                                    throw new IllegalStateException();
                                } while (var39_26 > var43_21);
                                var44_16 = new ByteBuffer[var43_21];
                                System.arraycopy((Object)var3_22, (int)0, (Object)var44_16, (int)0, (int)var8_15);
                                r.b.set(var2_14, var44_16);
                                var3_22 = var44_16;
                            }
                            if (var38_28 == var9_27) {
                                var41_8 = var4_23.d;
                                if (var41_8 == null) {
                                    var4_23.d = var41_8 = var33_3.internalNioBuffer(var34_25, var35_31);
                                }
                                var42_9 = var8_15 + 1;
                                var3_22[var8_15] = var41_8;
                                var8_15 = var42_9;
                            } else {
                                var40_29 = var4_23.c;
                                if (var40_29 == null) {
                                    var4_23.c = var40_29 = var33_3.nioBuffers();
                                }
                                var8_15 = r.a(var40_29, var3_22, var8_15);
                            }
                            var6_6 = var36_4;
                        }
                        var4_23 = var4_23.a;
                    } while (true);
                    for (var26_7 = this.i.c() - var9_27; var26_7 >= 0; --var26_7) {
                        block26 : {
                            var29_17 = var14_12.write(var3_22, 0, var11_2);
                            if (var29_17 == 0L) {
                                var19_18 = var27_24;
                                var5_20 = false;
                                break block20;
                            }
                            var31_33 = var12_32 - var29_17;
                            var19_18 = var27_24 + var29_17;
                            if (var31_33 != 0L) break block26;
lbl96: // 2 sources:
                            var5_20 = true;
                            break block21;
                        }
                        var27_24 = var19_18;
                        var12_32 = var31_33;
                    }
                    var19_18 = var27_24;
                }
                var9_27 = 0;
            }
            var1.b(var19_18);
        } while (var5_20);
        this.a((boolean)var9_27);
    }

    @Override
    protected final void a(SocketAddress socketAddress) throws Exception {
        b.super.b(socketAddress);
    }

    @Override
    protected final boolean a(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        boolean bl;
        block4 : {
            if (socketAddress2 != null) {
                b.super.b(socketAddress2);
            }
            try {
                bl = s.a((SocketChannel)super.F(), socketAddress);
                if (bl) break block4;
            }
            catch (Throwable throwable) {
                this.d();
                throw throwable;
            }
            this.H().interestOps(8);
        }
        return bl;
    }

    @Override
    protected final int b(ByteBuf byteBuf) throws Exception {
        int n2 = byteBuf.readableBytes();
        return byteBuf.readBytes((GatheringByteChannel)((SocketChannel)super.F()), n2);
    }

    @Override
    protected final SocketAddress b() {
        return ((SocketChannel)super.F()).socket().getLocalSocketAddress();
    }

    @Override
    protected final SocketAddress c() {
        return ((SocketChannel)super.F()).socket().getRemoteSocketAddress();
    }

    @Override
    protected final void d() throws Exception {
        super.d();
        ((SocketChannel)super.F()).close();
    }

    public final boolean h() {
        SocketChannel socketChannel = (SocketChannel)super.F();
        return socketChannel.isOpen() && socketChannel.isConnected();
    }

    @Override
    protected final void u() throws Exception {
        if (n.d() >= 7) {
            ((SocketChannel)super.F()).shutdownOutput();
            return;
        }
        ((SocketChannel)super.F()).socket().shutdownOutput();
    }

    private final class a
    extends e {
        final /* synthetic */ b c;

        private a(b b2, b b3, Socket socket) {
            this.c = b2;
            super(b3, socket);
        }

        /* synthetic */ a(b b2, b b3, Socket socket, byte by) {
            super(b2, b3, socket);
        }

        protected final void k() {
            b.b(this.c);
        }
    }

    private final class b
    extends a.a {
        final /* synthetic */ b f;

        private b(b b2) {
            this.f = b2;
        }

        /* synthetic */ b(b b2, byte by) {
            super(b2);
        }

        /*
         * Exception decompiling
         */
        protected final Executor j() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl18.1 : ACONST_NULL : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
    }

}

