/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.b.a$a
 *  io.netty.b.d
 *  java.lang.Exception
 *  java.lang.Object
 *  java.nio.channels.SelectableChannel
 *  java.nio.channels.SelectionKey
 *  java.util.ArrayList
 *  java.util.List
 */
package io.netty.b.a;

import io.netty.b.a;
import io.netty.b.a.b;
import io.netty.b.d;
import io.netty.b.e;
import io.netty.b.r;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

public abstract class c
extends b {
    protected c(SelectableChannel selectableChannel) {
        super(null, selectableChannel, 16);
    }

    protected abstract boolean C() throws Exception;

    protected abstract int a(List<Object> var1) throws Exception;

    @Override
    protected final /* synthetic */ a.a a() {
        return new a(this, 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected final void a(r r2) throws Exception {
        SelectionKey selectionKey = this.H();
        int n2 = selectionKey.interestOps();
        block5 : do {
            if (r2.a() == null) {
                if ((n2 & 4) == 0) return;
                selectionKey.interestOps(n2 & -5);
                return;
            }
            int n3 = this.f().c() - 1;
            do {
                block11 : {
                    boolean bl = false;
                    if (n3 >= 0) {
                        if (!this.C()) break block11;
                        bl = true;
                    }
                    if (bl) {
                        r2.b();
                        continue block5;
                    }
                    if ((n2 & 4) != 0) return;
                    selectionKey.interestOps(n2 | 4);
                    return;
                }
                --n3;
            } while (true);
            break;
        } while (true);
    }

    private final class a
    extends b.a {
        static final /* synthetic */ boolean a = true;
        final /* synthetic */ c f;
        private final List<Object> g;

        private a(c c2) {
            this.f = c2;
            this.g = new ArrayList();
        }

        /* synthetic */ a(c c2, byte by) {
            super(c2);
        }

        /*
         * Exception decompiling
         */
        public final void k() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[DOLOOP]], but top level block is 10[SIMPLE_IF_TAKEN]
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

