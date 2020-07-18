/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.Window
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.reflect.Method
 */
package com.xiaomi.midrop.view;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Method;

public final class e {
    private Activity a;
    private int b;
    private Method c;

    /*
     * Exception decompiling
     */
    public e(Activity var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl53 : RETURN : trying to set 0 previously set to 1
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(boolean bl) {
        if (this.c == null) {
            return;
        }
        try {
            this.a.getWindow().addFlags(Integer.MIN_VALUE);
            int n2 = this.a.getWindow().getDecorView().getSystemUiVisibility();
            if (bl) {
                this.a.getWindow().getDecorView().setSystemUiVisibility(n2 | 8192);
            } else {
                this.a.getWindow().getDecorView().setSystemUiVisibility(n2 & -8193);
            }
            Method method = this.c;
            Window window = this.a.getWindow();
            Object[] arrobject = new Object[2];
            int n3 = bl ? this.b : 0;
            arrobject[0] = n3;
            arrobject[1] = this.b;
            method.invoke((Object)window, arrobject);
            return;
        }
        catch (Exception exception) {}
    }
}

