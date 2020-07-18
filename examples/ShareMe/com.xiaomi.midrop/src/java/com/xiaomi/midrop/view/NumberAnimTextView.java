/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigDecimal
 *  java.text.DecimalFormat
 */
package com.xiaomi.midrop.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@SuppressLint(value={"AppCompatCustomView"})
public class NumberAnimTextView
extends TextView {
    private String a = "0";
    private String b;
    private long c = 800L;
    private String d = "";
    private String e = "";
    private boolean f = true;
    private boolean g;
    private ValueAnimator h;

    public NumberAnimTextView(Context context) {
        super(context);
    }

    public NumberAnimTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NumberAnimTextView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    private static String b(BigDecimal bigDecimal) {
        return new DecimalFormat("0.00").format((Object)bigDecimal);
    }

    /*
     * Exception decompiling
     */
    public final void a(String var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl158 : ALOAD : trying to set 0 previously set to 1
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

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.h != null) {
            this.h.cancel();
        }
    }

    public void setDuration(long l2) {
        this.c = l2;
    }

    public void setEnableAnim(boolean bl) {
        this.f = bl;
    }

    public void setNumberString(String string2) {
        this.a("0", string2);
    }

    public void setPostfixString(String string2) {
        this.e = string2;
    }

    public void setPrefixString(String string2) {
        this.d = string2;
    }

    private static final class a
    implements TypeEvaluator {
        private a() {
        }

        /* synthetic */ a(byte by) {
        }

        public final Object evaluate(float f2, Object object, Object object2) {
            BigDecimal bigDecimal = (BigDecimal)object;
            return ((BigDecimal)object2).subtract(bigDecimal).multiply(new BigDecimal((double)f2)).add(bigDecimal);
        }
    }

}

