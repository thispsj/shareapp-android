/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.app.c
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.xiaomi.midrop.util.VpnAlertUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import android.support.v7.app.c;
import android.view.View;
import com.xiaomi.midrop.util.VpnAlertUtils;

public final class aq {
    public static void a(Context context, View.OnClickListener onClickListener) {
        com.xiaomi.midrop.view.c c2 = new com.xiaomi.midrop.view.c(context);
        c2.h = true;
        c2.i = 80;
        c2.a = context.getString(2131689639);
        c2.b = context.getString(2131689638);
        c2.a(2131689540, new View.OnClickListener(onClickListener){
            final /* synthetic */ View.OnClickListener a;
            {
                this.a = onClickListener;
            }

            public final void onClick(View view) {
                if (this.a != null) {
                    this.a.onClick(view);
                }
            }
        }).b(2131689539, new View.OnClickListener(context){
            final /* synthetic */ View.OnClickListener a;
            final /* synthetic */ Context b;
            {
                this.a = null;
                this.b = context;
            }

            public final void onClick(View view) {
                if (this.a != null) {
                    this.a.onClick(view);
                }
                android.content.Intent intent = new android.content.Intent();
                intent.setAction("android.net.vpn.SETTINGS");
                if (intent.resolveActivity(this.b.getPackageManager()) != null) {
                    this.b.startActivity(intent);
                    android.widget.Toast.makeText((Context)this.b, (CharSequence)this.b.getString(2131689960), (int)1).show();
                }
            }
        }).d();
    }

    /*
     * Exception decompiling
     */
    public static boolean a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl37.1 : ICONST_0 : trying to set 1 previously set to 0
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
}

