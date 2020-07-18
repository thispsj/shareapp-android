/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.text.method.MovementMethod
 *  android.text.method.ScrollingMovementMethod
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.Toast
 *  com.xiaomi.midrop.update.UpdateDialog
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.Locale
 */
package com.xiaomi.midrop.update;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.market.sdk.p;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.sender.c.c;
import com.xiaomi.midrop.update.UpdateDialog;
import com.xiaomi.midrop.util.aa;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.am;
import java.lang.ref.WeakReference;
import java.util.Locale;

public final class b
extends Dialog {
    private p a;
    private Activity b;
    private boolean c;
    private Boolean d;

    public b(Activity activity, p p2, Boolean bl) {
        super(activity, p2, bl, (byte)0);
    }

    private b(Activity activity, p p2, Boolean bl, byte by) {
        super((Context)activity);
        this.b = activity;
        this.a = p2;
        this.c = false;
        this.d = bl;
    }

    @Deprecated
    private b(Context context) {
        super(context, 2131755517);
        this.a = null;
        this.b = null;
        this.c = false;
    }

    static /* synthetic */ void a() {
        String string2;
        if (!TextUtils.isEmpty((CharSequence)aa.b())) {
            string2 = aa.b();
        } else if (com.xiaomi.midrop.util.Locale.b.a() != null && com.xiaomi.midrop.util.Locale.b.a().a != null && !TextUtils.isEmpty((CharSequence)com.xiaomi.midrop.util.Locale.b.a().a.getCountry())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(com.xiaomi.midrop.util.Locale.b.a().a.getCountry());
            stringBuilder.append("_");
            string2 = stringBuilder.toString();
        } else {
            string2 = null;
        }
        af af2 = af.a(af.a.ds);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            af2.a(af.b.ad, string2);
        }
        af2.a();
    }

    /*
     * Exception decompiling
     */
    static /* synthetic */ void a(Activity var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl72 : RETURN : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:885)
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static /* synthetic */ void a(boolean bl) {
        try {
            com.xiaomi.midrop.update.a.d();
            if (!bl) return;
        }
        catch (Exception exception) {
            new StringBuilder("set auto upgrade apps failed, error: ").append(exception.getMessage());
            return;
        }
        com.xiaomi.midrop.update.a.b();
    }

    static /* synthetic */ boolean a(b b2) {
        return b2.c;
    }

    static /* synthetic */ Activity b(b b2) {
        return b2.b;
    }

    static /* synthetic */ p c(b b2) {
        return b2.a;
    }

    static /* synthetic */ Boolean d(b b2) {
        return b2.d;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131427585);
        WindowManager.LayoutParams layoutParams = this.getWindow().getAttributes();
        layoutParams.width = -1;
        this.getWindow().setAttributes(layoutParams);
        this.setCanceledOnTouchOutside(false);
        TextView textView = (TextView)this.findViewById(2131296904);
        StringBuilder stringBuilder = new StringBuilder("V ");
        stringBuilder.append(this.a.b);
        textView.setText((CharSequence)stringBuilder.toString());
        TextView textView2 = (TextView)this.findViewById(2131296393);
        if (!TextUtils.isEmpty((CharSequence)this.a.a)) {
            textView2.setText((CharSequence)this.a.a);
            textView2.setMovementMethod((MovementMethod)new ScrollingMovementMethod());
        }
        this.findViewById(2131296367).setOnClickListener(new View.OnClickListener((b)this){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public void onClick(View view) {
                this.a.cancel();
            }
        });
        this.findViewById(2131296900).setOnTouchListener((View.OnTouchListener)new com.xiaomi.midrop.util.c());
        this.findViewById(2131296900).setOnClickListener(new View.OnClickListener((b)this){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public void onClick(View view) {
                this.a.cancel();
                if (b.a(this.a)) {
                    com.xiaomi.midrop.util.j.b((Context)b.b(this.a), b.c((b)this.a).d);
                    af.a(af.a.cP).a();
                    return;
                }
                new a(b.b(this.a), b.d(this.a)).execute((Object[])new Void[0]);
            }
        });
        CheckBox checkBox = (CheckBox)this.findViewById(2131296354);
        if (this.d != null) {
            checkBox.setVisibility(0);
            checkBox.setChecked(this.d.booleanValue());
            checkBox.setPaddingRelative(checkBox.getPaddingStart() + c.a((Context)this.b, 8.0f), checkBox.getPaddingTop(), checkBox.getPaddingEnd(), checkBox.getPaddingBottom());
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                public final void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                    b.this.d = bl;
                }
            });
            checkBox.setText((CharSequence)com.xiaomi.midrop.util.Locale.b.a().b(2131689528));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)this.findViewById(2131296900).getLayoutParams();
            layoutParams2.setMargins(layoutParams2.leftMargin, c.a((Context)this.b, 16.0f), layoutParams2.rightMargin, layoutParams2.bottomMargin);
            return;
        }
        checkBox.setVisibility(8);
    }

    /*
     * Exception performing whole class analysis ignored.
     */
    private static final class a
    extends AsyncTask<Void, Void, Boolean> {
        private WeakReference<Activity> a;
        private Boolean b;

        a(Activity activity, Boolean bl) {
            this.a = new WeakReference((Object)activity);
            this.b = bl;
        }

        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
            boolean bl = am.a(MiDropApplication.a());
            if (bl && this.b != null) {
                b.a(this.b);
                if (this.b.booleanValue()) {
                    b.a();
                }
            }
            return bl;
        }

        protected final /* synthetic */ void onPostExecute(Object object) {
            Boolean bl = (Boolean)object;
            super.onPostExecute((Object)bl);
            Activity activity = (Activity)this.a.get();
            if (activity != null && !activity.isDestroyed()) {
                if (activity.isFinishing()) {
                    return;
                }
                if (bl.booleanValue()) {
                    b.a(activity);
                    return;
                }
                Toast.makeText((Context)activity, (CharSequence)com.xiaomi.midrop.util.Locale.b.a().b(2131689763), (int)0).show();
            }
        }
    }

}

