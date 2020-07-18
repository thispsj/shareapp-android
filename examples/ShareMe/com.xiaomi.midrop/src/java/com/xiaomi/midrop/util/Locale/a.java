/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.support.design.internal.SnackbarContentLayout
 *  android.support.design.widget.BaseTransientBottomBar
 *  android.support.design.widget.BaseTransientBottomBar$SnackbarBaseLayout
 *  android.support.design.widget.Snackbar
 *  android.support.design.widget.Snackbar$1
 *  android.support.design.widget.j
 *  android.support.design.widget.j$a
 *  android.support.design.widget.j$b
 *  android.support.v4.app.a
 *  android.support.v7.app.a
 *  android.support.v7.app.c
 *  android.support.v7.app.d
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.widget.Button
 *  com.xiaomi.midrop.util.Locale.BaseLanguageMiuiActivity
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.midrop.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.design.widget.j;
import android.support.v7.app.d;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.xiaomi.midrop.e;
import com.xiaomi.midrop.send.contacts.a;
import com.xiaomi.midrop.util.Locale.BaseLanguageMiuiActivity;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.y;
import com.xiaomi.midrop.view.c;

public abstract class a
extends d {
    private final String a = this.getClass().getSimpleName();
    private final String b = "Activity_Lifecycle";
    private com.xiaomi.midrop.view.e c;
    private a d;
    private Snackbar e;
    private android.support.v7.app.c f;
    private android.support.v7.app.c g;
    private android.support.v7.app.c h;
    private android.support.v7.app.c i;
    private android.support.v7.app.c j;
    private android.support.v7.app.c k;
    protected boolean s;
    public boolean t = false;

    static /* synthetic */ android.support.v7.app.c a(a a2) {
        a2.f = null;
        return null;
    }

    static /* synthetic */ android.support.v7.app.c b(a a2) {
        a2.h = null;
        return null;
    }

    static /* synthetic */ android.support.v7.app.c c(a a2) {
        a2.j = null;
        return null;
    }

    static /* synthetic */ android.support.v7.app.c d(a a2) {
        a2.k = null;
        return null;
    }

    static /* synthetic */ android.support.v7.app.c e(a a2) {
        a2.i = null;
        return null;
    }

    public final void a(int n2, boolean bl) {
        super.setContentView(n2);
        this.a(bl);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final void a(View view, CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener) {
        Object object;
        if (this.e != null && this.e.a()) {
            this.e.a(3);
        }
        if (view == null) {
            return;
        }
        Snackbar snackbar = this.e = Snackbar.a((View)view, (CharSequence)charSequence);
        Button button = ((SnackbarContentLayout)snackbar.c.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty((CharSequence)charSequence2)) {
            button.setVisibility(8);
            button.setOnClickListener(null);
        } else {
            button.setVisibility(0);
            button.setText(charSequence2);
            button.setOnClickListener((View.OnClickListener)new Snackbar.1(snackbar, onClickListener));
        }
        Snackbar snackbar2 = this.e;
        j j2 = j.a();
        int n2 = snackbar2.d;
        j.a a2 = snackbar2.e;
        Object object2 = object = j2.a;
        synchronized (object2) {
            if (j2.e(a2)) {
                j2.c.b = n2;
                j2.b.removeCallbacksAndMessages((Object)j2.c);
                j2.a(j2.c);
                return;
            }
            if (j2.f(a2)) {
                j2.d.b = n2;
            } else {
                j2.d = new j.b(n2, a2);
            }
            if (j2.c != null && j2.a(j2.c, 4)) {
                return;
            }
            j2.c = null;
            j2.b();
            return;
        }
    }

    protected final void a(CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener) {
        if (this.j == null) {
            c c2 = new c((Context)this);
            b b2 = b.a();
            c2.a = charSequence;
            c2.b = charSequence2;
            c2.b(b2.b(2131689907), onClickListener).a(b2.b(2131689657), new View.OnClickListener((a)this){
                final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public void onClick(View view) {
                    e.a();
                    this.a.finish();
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.v).a();
                }
            });
            this.j = c2.d();
            this.j.setCancelable(false);
            this.j.setOnDismissListener(new DialogInterface.OnDismissListener((a)this){
                final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    a.c(this.a);
                }
            });
        }
    }

    public final void a(String string, a.c c2) {
        this.a(new String[]{"android.permission.WRITE_CONTACTS"}, 1013, new a((a)this, string, c2){
            final /* synthetic */ String a;
            final /* synthetic */ a.c b;
            final /* synthetic */ a c;
            {
                this.c = a2;
                this.a = string;
                this.b = c2;
            }

            public final void a() {
                this.b.a(false);
            }

            public final void a(int n2) {
                com.xiaomi.midrop.send.contacts.a.a((Context)this.c, this.a, this.b);
            }
        });
    }

    public final void a(boolean bl) {
        if (e.c()) {
            if (this.c == null) {
                this.c = new com.xiaomi.midrop.view.e((Activity)this);
            }
            this.c.a(bl);
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = this.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            View view = window.getDecorView();
            int n2 = view.getSystemUiVisibility();
            int n3 = bl ? n2 | 8192 : n2 & -8193;
            view.setSystemUiVisibility(n3);
        }
    }

    public final void a(String[] arrstring, int n2, a a2) {
        boolean bl;
        block5 : {
            this.d = a2;
            if (arrstring == null) {
                this.d.a(n2);
                return;
            }
            int n3 = arrstring.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (e.a((Context)this, arrstring[i2])) continue;
                bl = true;
                break block5;
            }
            bl = false;
        }
        if (bl) {
            try {
                android.support.v4.app.a.a((Activity)this, (String[])arrstring, (int)n2);
                return;
            }
            catch (Exception exception) {
                this.d.a();
                midrop.service.c.d.a("Activity_Lifecycle", "IllegalStateException", exception, new Object[0]);
                return;
            }
        }
        this.d.a(n2);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().b(context));
    }

    /*
     * Exception decompiling
     */
    public final void c(int var1) {
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

    public final void c(View.OnClickListener onClickListener) {
        if (this.h == null) {
            b b2 = b.a();
            c c2 = new c((Context)this);
            c2.b = b2.b(2131689870);
            c2.b(b2.b(2131689864), onClickListener).a(b2.b(2131689657), new View.OnClickListener((a)this){
                final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public void onClick(View view) {
                    e.a();
                    this.a.finish();
                }
            });
            this.h = c2.d();
            this.h.setCancelable(false);
            if (this.h != null) {
                this.h.setOnDismissListener(new DialogInterface.OnDismissListener((a)this){
                    final /* synthetic */ a a;
                    {
                        this.a = a2;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        a.b(this.a);
                    }
                });
            }
        }
    }

    protected final boolean d(int n2) {
        if (e.e((Context)this)) {
            if (this.i == null) {
                String string = b.a().b(2131689817);
                View.OnClickListener onClickListener = new View.OnClickListener((a)this){
                    final /* synthetic */ a a;
                    {
                        this.a = a2;
                    }

                    public void onClick(View view) {
                        this.a.t = true;
                        e.d((Activity)this.a);
                    }
                };
                c c2 = new c((Context)this);
                b b2 = b.a();
                c2.b = string;
                c2.a(n2, new View.OnClickListener((a)this){
                    final /* synthetic */ a a;
                    {
                        this.a = a2;
                    }

                    public void onClick(View view) {
                        if (!(this.a instanceof com.xiaomi.midrop.send.FilePickNewActivity)) {
                            e.a();
                            this.a.t = false;
                            this.a.finish();
                            return;
                        }
                        com.xiaomi.midrop.send.FilePickNewActivity filePickNewActivity = (com.xiaomi.midrop.send.FilePickNewActivity)this.a;
                        if (filePickNewActivity.b || filePickNewActivity.c) {
                            filePickNewActivity.finish();
                        }
                    }
                }).b(b2.b(2131689907), onClickListener);
                c2.h = false;
                this.i = c2.d();
                this.i.setOnDismissListener(new DialogInterface.OnDismissListener((a)this){
                    final /* synthetic */ a a;
                    {
                        this.a = a2;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        a.e(this.a);
                    }
                });
            }
            return true;
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("-onCreate()");
        y.a();
    }

    public void onDestroy() {
        this.r();
        super.onDestroy();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("-onDestroy()");
    }

    public void onPause() {
        super.onPause();
        this.s = false;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("-onPause()");
    }

    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        if (arrn != null) {
            if (arrn.length <= 0) {
                return;
            }
            if (this.d == null) {
                return;
            }
            if (e.a(arrn)) {
                this.d.a(n2);
                return;
            }
            this.d.a();
        }
    }

    public void onResume() {
        super.onResume();
        this.s = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("-onResume()");
    }

    public void onStart() {
        super.onStart();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("-onStart()");
    }

    public void onStop() {
        super.onStop();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("-onStop()");
    }

    public void r() {
        if (this.f != null && this.f.isShowing()) {
            this.f.dismiss();
        }
        if (this.g != null && this.g.isShowing()) {
            this.g.dismiss();
        }
        if (this.e != null && this.e.a()) {
            this.e.a(3);
        }
        if (this.h != null && this.h.isShowing()) {
            this.h.dismiss();
        }
        if (this.i != null && this.i.isShowing()) {
            this.i.dismiss();
        }
        if (this.j != null && this.j.isShowing()) {
            this.j.dismiss();
        }
        if (this.k != null && this.k.isShowing()) {
            this.k.dismiss();
        }
    }

    public final void s() {
        if (Build.VERSION.SDK_INT >= 29) {
            if (am.b((Context)this)) {
                this.a(false);
                return;
            }
            this.a(true);
            return;
        }
        this.a(true);
    }

    public void setContentView(int n2) {
        super.setContentView(n2);
        ag.a((Activity)this, this.getTheme().obtainStyledAttributes(new int[]{2130968695}).getColor(0, this.getResources().getColor(2131099748)));
    }

    public final View t() {
        android.support.v7.app.a a2 = this.getSupportActionBar();
        if (a2 != null) {
            return a2.d();
        }
        return null;
    }

    public final void u() {
        if (this.f == null) {
            b b2 = b.a();
            c c2 = new c((Context)this);
            c2.b = b2.b(2131689861);
            c2.b(b2.b(2131689907), new View.OnClickListener(this){
                final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public void onClick(View view) {
                    e.c((Activity)this.a);
                }
            }).a(b2.b(2131689657), new View.OnClickListener(this){
                final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public void onClick(View view) {
                    e.a();
                    this.a.finish();
                }
            });
            this.f = c2.d();
            this.f.setCancelable(false);
            if (this.f != null) {
                this.f.setOnDismissListener(new DialogInterface.OnDismissListener(this){
                    final /* synthetic */ a a;
                    {
                        this.a = a2;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        a.a(this.a);
                    }
                });
            }
        }
    }

    protected final void v() {
        if (this.e != null && this.e.a()) {
            this.e.a(3);
        }
        this.e = null;
    }

    protected final void w() {
        if (this.k == null) {
            c c2 = new c((Context)this);
            b b2 = b.a();
            c2.b = b2.b(2131689748);
            c2.a(b2.b(2131689657), new View.OnClickListener(this){
                final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public void onClick(View view) {
                    e.a();
                    this.a.finish();
                }
            }).b(b2.b(2131689907), new View.OnClickListener(this){
                final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public void onClick(View view) {
                    e.b((Activity)this.a);
                }
            });
            c2.h = false;
            this.k = c2.d();
            if (this.k != null) {
                this.k.setOnDismissListener(new DialogInterface.OnDismissListener(this){
                    final /* synthetic */ a a;
                    {
                        this.a = a2;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        a.d(this.a);
                    }
                });
            }
        }
    }

    protected final void x() {
        this.getWindow().getDecorView().setSystemUiVisibility(1792);
    }

}

