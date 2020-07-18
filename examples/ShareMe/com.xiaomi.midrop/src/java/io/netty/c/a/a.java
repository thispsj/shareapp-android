/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.d
 *  io.netty.b.l
 *  io.netty.buffer.ByteBuf
 *  io.netty.c.a.a$1
 *  io.netty.c.a.a$2
 *  io.netty.c.a.d
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 */
package io.netty.c.a;

import io.netty.b.e;
import io.netty.b.l;
import io.netty.b.n;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.c.a.a;
import io.netty.c.a.c;
import io.netty.c.a.d;
import io.netty.d.b.t;
import java.util.List;

public abstract class a
extends n {
    public static final a a = new 1();
    public static final a b = new 2();
    ByteBuf c;
    private a d = a;
    private boolean e;
    private boolean g;
    private boolean h;
    private byte i = 0;
    private int j = 16;
    private int k;

    protected a() {
        if (this.a()) {
            StringBuilder stringBuilder = new StringBuilder("ChannelHandler ");
            stringBuilder.append(this.getClass().getName());
            stringBuilder.append(" is not allowed to be shared");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    static ByteBuf a(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, int n2) {
        ByteBuf byteBuf2 = byteBufAllocator.buffer(n2 + byteBuf.readableBytes());
        byteBuf2.writeBytes(byteBuf);
        byteBuf.release();
        return byteBuf2;
    }

    private static void a(l l2, c c2, int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            l2.b(c2.a[i2]);
        }
    }

    /*
     * Exception decompiling
     */
    private void a(l var1, boolean var2_2) throws Exception {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[CATCHBLOCK]], but top level block is 2[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    private void b() {
        if (this.c != null && !this.h && this.c.refCnt() == 1) {
            this.c.discardSomeReadBytes();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(l l2, ByteBuf byteBuf, List<Object> list) {
        try {
            while (byteBuf.isReadable()) {
                int n2 = list.size();
                if (n2 > 0) {
                    if (list instanceof c) {
                        a.a(l2, (c)list, n2);
                    } else {
                        for (int i2 = 0; i2 < n2; ++i2) {
                            l2.b(list.get(i2));
                        }
                    }
                    list.clear();
                    if (l2.p()) break;
                    n2 = 0;
                }
                int n3 = byteBuf.readableBytes();
                a.super.c(l2, byteBuf, list);
                if (l2.p()) break;
                if (n2 == list.size()) {
                    if (n3 != byteBuf.readableBytes()) continue;
                    return;
                }
                if (n3 == byteBuf.readableBytes()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(t.a(this.getClass()));
                    stringBuilder.append(".decode() did not read anything but decoded a message.");
                    throw new d(stringBuilder.toString());
                }
                boolean bl = this.e;
                if (!bl) continue;
            }
        }
        catch (Exception exception) {
            throw new d((Throwable)exception);
        }
        catch (d d2) {
            throw d2;
        }
        return;
    }

    private void c(l l2, ByteBuf byteBuf, List<Object> list) throws Exception {
        byte by;
        this.i = by = 1;
        try {
            this.a(l2, byteBuf, list);
            return;
        }
        finally {
            if (this.i != 2) {
                by = 0;
            }
            this.i = 0;
            if (by != 0) {
                this.d(l2);
            }
        }
    }

    private void d(l l2, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.isReadable()) {
            a.super.c(l2, byteBuf, list);
        }
    }

    protected abstract void a(l var1, ByteBuf var2, List<Object> var3) throws Exception;

    /*
     * Exception decompiling
     */
    @Override
    public final void a(l var1, Object var2_2) throws Exception {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 1[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    @Override
    public final void b(l l2, Object object) throws Exception {
        if (object instanceof io.netty.b.b.a) {
            a.super.a(l2, false);
        }
        super.b(l2, object);
    }

    public final void d(l l2) throws Exception {
        if (this.i == 1) {
            this.i = (byte)2;
            return;
        }
        ByteBuf byteBuf = this.c;
        if (byteBuf != null) {
            this.c = null;
            int n2 = byteBuf.readableBytes();
            if (n2 > 0) {
                ByteBuf byteBuf2 = byteBuf.readBytes(n2);
                byteBuf.release();
                l2.b((Object)byteBuf2);
            } else {
                byteBuf.release();
            }
            this.k = 0;
            l2.i();
        }
    }

    @Override
    public final void h(l l2) throws Exception {
        a.super.a(l2, true);
    }

    @Override
    public final void i(l l2) throws Exception {
        this.k = 0;
        a.super.b();
        if (this.g) {
            this.g = false;
            if (!l2.a().f().f()) {
                l2.l();
            }
        }
        l2.i();
    }

}

