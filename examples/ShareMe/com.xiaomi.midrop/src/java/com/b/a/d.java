/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.b.a.c
 *  com.xiaomi.midrop.util.j
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  midrop.service.c.d
 *  midrop.service.transmitter.a.a
 */
package com.b.a;

import android.text.TextUtils;
import com.b.a.c;
import com.b.a.f;
import com.xiaomi.midrop.util.j;
import java.io.File;
import midrop.service.transmitter.a.a;

public final class d
implements Runnable {
    private c a;
    private f b;
    private volatile int c = 0;
    private String d;
    private int e;

    public d(c c2, f f2) {
        this.a = c2;
        this.b = f2;
    }

    private String a(f f2) {
        return this.a.g(f2);
    }

    private boolean a() {
        if (this.b.f == this.b.g) {
            boolean bl;
            if (TextUtils.isEmpty((CharSequence)this.b.m)) {
                bl = true;
            } else if (TextUtils.isEmpty((CharSequence)this.b.e)) {
                midrop.service.c.d.b((String)"DownloadOperator", (String)"file null", (Object[])new Object[0]);
                bl = false;
            } else {
                bl = TextUtils.equals((CharSequence)this.b.m, (CharSequence)a.b((File)new File(this.b.e)));
            }
            if (bl) {
                File file = new File(this.a(this.b), this.b.b);
                int n2 = this.b.b.lastIndexOf(".");
                if (n2 > 0) {
                    String string2 = this.b.b.substring(n2);
                    String string3 = this.b.b.substring(0, n2);
                    int n3 = 1;
                    while (file.exists()) {
                        String string4 = this.a(this.b);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(string3);
                        stringBuilder.append("_");
                        stringBuilder.append(n3);
                        stringBuilder.append(string2);
                        file = new File(string4, stringBuilder.toString());
                        ++n3;
                    }
                }
                file.mkdirs();
                j.a((String)this.b.e, (String)file.getAbsolutePath());
                this.b.e = file.getAbsolutePath();
                return true;
            }
        }
        midrop.service.c.d.b((String)"DownloadOperator", (String)"download finish rename error", (Object[])new Object[0]);
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(int n2) {
        int n3 = this.c;
        int n4 = 1;
        if (n3 != n4) {
            n4 = 0;
        }
        this.c = n2;
        if (n4 != 0) {
            void var5_4 = this;
            synchronized (var5_4) {
                this.notify();
                return;
            }
        }
    }

    /*
     * Exception decompiling
     */
    public final void run() {
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
}

