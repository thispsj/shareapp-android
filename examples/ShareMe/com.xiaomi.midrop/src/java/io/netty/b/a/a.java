/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.a$a
 *  io.netty.b.aj
 *  io.netty.b.d
 *  io.netty.b.q
 *  io.netty.buffer.ByteBuf
 *  java.lang.Boolean
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.nio.channels.SelectableChannel
 *  java.nio.channels.SelectionKey
 */
package io.netty.b.a;

import io.netty.b.a;
import io.netty.b.a.a;
import io.netty.b.a.b;
import io.netty.b.a.d;
import io.netty.b.aj;
import io.netty.b.am;
import io.netty.b.e;
import io.netty.b.q;
import io.netty.b.r;
import io.netty.b.t;
import io.netty.b.x;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.d.k;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

public abstract class a
extends b {
    private static final String i;
    private Runnable j;

    static {
        StringBuilder stringBuilder = new StringBuilder(" (expected: ");
        stringBuilder.append(io.netty.d.b.t.a(ByteBuf.class));
        stringBuilder.append(", ");
        stringBuilder.append(io.netty.d.b.t.a(aj.class));
        stringBuilder.append(')');
        i = stringBuilder.toString();
    }

    protected a(io.netty.b.d d2, SelectableChannel selectableChannel) {
        super(d2, selectableChannel, 1);
    }

    protected b.a C() {
        return new a();
    }

    protected final void D() {
        SelectionKey selectionKey = this.H();
        if (!selectionKey.isValid()) {
            return;
        }
        int n2 = selectionKey.interestOps();
        if ((n2 & 4) != 0) {
            selectionKey.interestOps(n2 & -5);
        }
    }

    protected abstract int a(ByteBuf var1) throws Exception;

    protected abstract long a(aj var1) throws Exception;

    @Override
    protected /* synthetic */ a.a a() {
        return this.C();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    protected void a(r var1) throws Exception {
        block17 : {
            block14 : {
                block15 : {
                    block16 : {
                        var2_2 = -1;
                        var3_3 = false;
                        block0 : do {
                            if ((var4_9 = var1.a()) == null) {
                                this.D();
                                return;
                            }
                            var5_8 = var4_9 instanceof ByteBuf;
                            var6_11 = 0L;
                            var8_4 = true;
                            if (var5_8) {
                                var19_7 = (ByteBuf)var4_9;
                                if (var19_7.readableBytes() != 0) {
                                    if (var2_2 == -1) {
                                        var2_2 = this.f().c();
                                    }
                                    break;
                                }
                            } else {
                                if (var4_9 instanceof aj == false) throw new Error();
                                var9_12 = (aj)var4_9;
                                var10_15 = var9_12.a() >= var9_12.b();
                                if (var10_15) break block14;
                                if (var2_2 == -1) {
                                    var2_2 = this.f().c();
                                }
                                var13_5 = var6_11;
                                break block15;
                            }
lbl26: // 3 sources:
                            do {
                                var1.b();
                                continue block0;
                                break;
                            } while (true);
                            break;
                        } while (true);
                        for (var20_17 = var2_2 - 1; var20_17 >= 0; --var20_17) {
                            var21_16 = this.b(var19_7);
                            if (var21_16 == 0) {
                                var3_3 = true;
                                break;
                            }
                            var22_6 = var6_11 + (long)var21_16;
                            if (!var19_7.isReadable()) {
                                var6_11 = var22_6;
                                break block16;
                            }
                            var6_11 = var22_6;
                        }
                        var8_4 = false;
                    }
                    var1.a(var6_11);
                    if (!var8_4) break block17;
                    ** GOTO lbl26
                }
                for (var12_14 = var2_2 - 1; var12_14 >= 0; --var12_14) {
                    var15_10 = this.a(var9_12);
                    if (var15_10 == var6_11) {
                        var3_3 = true;
                        break;
                    }
                    var17_13 = var13_5 + var15_10;
                    if (var9_12.a() >= var9_12.b()) {
                        var13_5 = var17_13;
                        var10_15 = true;
                        break;
                    }
                    var13_5 = var17_13;
                }
                var1.a(var13_5);
            }
            if (!var10_15) ** break;
            ** while (true)
        }
        this.a(var3_3);
    }

    protected final void a(boolean bl) {
        if (bl) {
            int n2;
            SelectionKey selectionKey = this.H();
            if (selectionKey.isValid() && ((n2 = selectionKey.interestOps()) & 4) == 0) {
                selectionKey.interestOps(n2 | 4);
            }
            return;
        }
        Runnable runnable = this.j;
        if (runnable == null) {
            this.j = runnable = new Runnable((a)this){
                final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public final void run() {
                    this.a.a.c.m();
                }
            };
        }
        this.G().execute(runnable);
    }

    protected abstract int b(ByteBuf var1) throws Exception;

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected final Object b(Object object) {
        if (object instanceof ByteBuf) {
            ByteBuf byteBuf;
            ByteBuf byteBuf2 = (ByteBuf)object;
            if (byteBuf2.isDirect()) {
                return object;
            }
            int n2 = byteBuf2.readableBytes();
            if (n2 == 0) {
                k.b((Object)byteBuf2);
                return Unpooled.EMPTY_BUFFER;
            }
            ByteBufAllocator byteBufAllocator = this.f().d();
            if (byteBufAllocator.isDirectBufferPooled()) {
                byteBuf = byteBufAllocator.directBuffer(n2);
            } else {
                byteBuf = ByteBufUtil.threadLocalDirectBuffer();
                if (byteBuf == null) {
                    return byteBuf2;
                }
            }
            byteBuf.writeBytes(byteBuf2, byteBuf2.readerIndex(), n2);
            k.b((Object)byteBuf2);
            return byteBuf;
        }
        if (object instanceof aj) {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder("unsupported message type: ");
        stringBuilder.append(io.netty.d.b.t.a(object));
        stringBuilder.append(i);
        throw new UnsupportedOperationException(stringBuilder.toString());
    }

    protected class a
    extends b.a {
        private am.a f;

        protected a() {
        }

        private void a(t t2) {
            SelectionKey selectionKey = a.this.H();
            a.this.f = true;
            if (a.this.c.isOpen()) {
                if (Boolean.TRUE.equals(a.this.f().a(q.i))) {
                    selectionKey.interestOps(selectionKey.interestOps() & (-1 ^ a.this.d));
                    t2.a(io.netty.b.b.a.a);
                    return;
                }
                this.a(this.h());
            }
        }

        /*
         * Exception decompiling
         */
        public final void k() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [13[DOLOOP]], but top level block is 5[TRYBLOCK]
            // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
            // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
            // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

