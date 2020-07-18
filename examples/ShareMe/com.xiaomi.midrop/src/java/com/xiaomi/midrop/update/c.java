/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  android.content.pm.PackageInfo
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  com.xiaomi.midrop.update.c$1
 *  java.lang.Boolean
 *  java.lang.CharSequence
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
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.xiaomi.globalmiuiapp.common.f.f;
import com.xiaomi.market.sdk.f;
import com.xiaomi.market.sdk.p;
import com.xiaomi.market.sdk.s;
import com.xiaomi.market.sdk.t;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.e;
import com.xiaomi.midrop.sender.c.i;
import com.xiaomi.midrop.update.c;
import com.xiaomi.midrop.util.aa;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.y;
import java.lang.ref.WeakReference;
import java.util.Locale;

public final class c {
    private static String a = "MiDrop:UpdateHelper";
    private static p b;

    public static void a(Activity activity) {
        if (b == null) {
            return;
        }
        c.b(activity, b, false);
    }

    static /* synthetic */ void a(Activity activity, p p2, final boolean bl, final Boolean bl2, final String string2) {
        if (activity != null && !activity.isFinishing()) {
            if (activity.isDestroyed()) {
                return;
            }
            com.xiaomi.midrop.update.b b2 = new com.xiaomi.midrop.update.b(activity, p2, bl2);
            b2.setOnShowListener(new DialogInterface.OnShowListener(){

                public final void onShow(DialogInterface dialogInterface) {
                    if (bl) {
                        y.s();
                        if (!y.r()) {
                            af.a(af.a.dc).a();
                        }
                    }
                    if (bl2 != null) {
                        af af2 = af.a(af.a.dr);
                        if (!TextUtils.isEmpty((CharSequence)string2)) {
                            af2.a(af.b.ad, string2);
                        }
                        af2.a();
                    }
                    af.a(af.a.da).a();
                }
            });
            com.xiaomi.midrop.common.a.a.b().a(b2);
        }
    }

    public static void a(Activity activity, a a2) {
        s.c();
        if (!e.c()) {
            s.a();
        }
        s.a(f.b.b);
        s.a((t)new 1(activity, a2));
        s.a((Context)activity);
        af.a(af.a.cY).a(af.b.I, "manual").a();
    }

    public static boolean a() {
        return b != null && c.b.c > 12826;
    }

    static /* synthetic */ boolean a(p p2) {
        return p2 != null && !TextUtils.isEmpty((CharSequence)p2.b);
    }

    private static void b(Activity activity, p p2, boolean bl) {
        if (activity != null && !activity.isFinishing()) {
            if (activity.isDestroyed()) {
                return;
            }
            new c(activity, p2, bl).execute((Object[])new Void[0]);
        }
    }

    public static interface a {
        public void a(String var1, boolean var2);
    }

    private static final class b
    extends AsyncTask<Void, Void, PackageInfo> {
        private WeakReference<Activity> a;
        private p b;
        private a c;

        b(Activity activity, p p2, a a2) {
            this.a = new WeakReference((Object)activity);
            this.b = p2;
            this.c = a2;
        }

        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
            return i.a(MiDropApplication.a());
        }

        protected final /* synthetic */ void onPostExecute(Object object) {
            PackageInfo packageInfo = (PackageInfo)object;
            super.onPostExecute((Object)packageInfo);
            if (packageInfo != null && this.b.c <= packageInfo.versionCode) {
                if (this.c != null) {
                    this.c.a(null, false);
                }
            } else {
                Object[] arrobject = new Object[1];
                String string2 = packageInfo == null ? "not exist" : "exist";
                arrobject[0] = string2;
                String.format((String)"local packageInfo is %s, or remote has new version", (Object[])arrobject);
                b = this.b;
                String string3 = this.b.b;
                y.a(string3, this.b.c);
                if (y.r()) {
                    c.b((Activity)this.a.get(), this.b, true);
                }
                if (this.c != null) {
                    this.c.a(string3, false);
                }
                af.a(af.a.cZ).a(af.b.I, "auto").a();
            }
            s.a(null);
        }
    }

    private static final class c
    extends AsyncTask<Void, Void, Void> {
        private WeakReference<Activity> a;
        private p b;
        private boolean c;
        private String d;
        private Boolean e;

        c(Activity activity, p p2, boolean bl) {
            this.a = new WeakReference((Object)activity);
            this.b = p2;
            this.c = bl;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private /* varargs */ Void a() {
            block12 : {
                String string2;
                block11 : {
                    block10 : {
                        if (!com.xiaomi.midrop.update.a.f()) {
                            return null;
                        }
                        try {
                            int n2 = com.xiaomi.midrop.update.a.a();
                            if (n2 == 2) {
                                return null;
                            }
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        try {
                            boolean bl = com.xiaomi.midrop.update.a.e() && !com.xiaomi.midrop.update.a.c();
                            this.e = bl;
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        if (TextUtils.isEmpty((CharSequence)aa.b())) break block10;
                        string2 = aa.b();
                        break block11;
                    }
                    if (com.xiaomi.midrop.util.Locale.b.a() == null || com.xiaomi.midrop.util.Locale.b.a().a == null || TextUtils.isEmpty((CharSequence)com.xiaomi.midrop.util.Locale.b.a().a.getCountry())) break block12;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(com.xiaomi.midrop.util.Locale.b.a().a.getCountry());
                    stringBuilder.append("_");
                    string2 = stringBuilder.toString();
                }
                this.d = string2;
                return null;
            }
            return null;
        }

        /*
         * Exception decompiling
         */
        protected final /* synthetic */ Object doInBackground(Object[] var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.ArrayIndexOutOfBoundsException: length=0; index=-1
            // java.util.ArrayList.get(ArrayList.java:315)
            // org.benf.cfr.reader.b.a.a.c.ab.a(VarArgsRewriter.java:87)
            // org.benf.cfr.reader.b.a.b.a.e.a(AbstractMemberFunctionInvokation.java:146)
            // org.benf.cfr.reader.b.a.a.c.ab.a(VarArgsRewriter.java:56)
            // org.benf.cfr.reader.b.a.d.b.u.a(StructuredReturn.java:90)
            // org.benf.cfr.reader.b.a.a.c.ab.a(VarArgsRewriter.java:42)
            // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:1185)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:760)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:885)
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

        protected final /* synthetic */ void onPostExecute(Object object) {
            super.onPostExecute((Object)((Void)object));
            c.a((Activity)this.a.get(), this.b, this.c, this.e, this.d);
        }
    }

}

