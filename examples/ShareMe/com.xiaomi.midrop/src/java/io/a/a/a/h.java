/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.a.a.a.a.b.u
 *  io.a.a.a.a.c.a
 *  io.a.a.a.a.c.e
 *  io.a.a.a.a.c.f
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package io.a.a.a;

import io.a.a.a.a.b.u;
import io.a.a.a.a.c.a;
import io.a.a.a.a.c.e;
import io.a.a.a.a.c.f;
import io.a.a.a.g;
import io.a.a.a.i;
import java.util.concurrent.atomic.AtomicBoolean;

public final class h<Result>
extends f<Void, Void, Result> {
    final i<Result> a;

    public h(i<Result> i2) {
        this.a = i2;
    }

    private u a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.b());
        stringBuilder.append(".");
        stringBuilder.append(string2);
        u u2 = new u(stringBuilder.toString(), "KitInitialization");
        u2.a();
        return u2;
    }

    public final int a() {
        return e.c;
    }

    /*
     * Exception decompiling
     */
    protected final void b() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
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

    protected final void c() {
        this.a.i.a();
    }

    protected final void d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.b());
        stringBuilder.append(" Initialization was cancelled");
        g g2 = new g(stringBuilder.toString());
        this.a.i.a((Exception)((Object)g2));
    }

    protected final /* synthetic */ Object e() {
        u u2 = this.a("doInBackground");
        Object var2_2 = !((a)this).g.get() ? this.a.d() : null;
        u2.b();
        return var2_2;
    }
}

