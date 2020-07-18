/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.List
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.market.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.xiaomi.market.sdk.Patcher;
import com.xiaomi.market.sdk.R;
import com.xiaomi.market.sdk.c;
import com.xiaomi.market.sdk.e;
import com.xiaomi.market.sdk.f;
import com.xiaomi.market.sdk.g;
import com.xiaomi.market.sdk.i;
import com.xiaomi.market.sdk.j;
import com.xiaomi.market.sdk.p;
import com.xiaomi.market.sdk.q;
import com.xiaomi.market.sdk.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class s {
    private static boolean a = false;
    private static boolean b = false;
    private static WeakReference<Context> c = new WeakReference(null);
    private static boolean d = true;
    private static boolean e;
    private static boolean f;
    private static boolean g;
    private static i h;
    private static b i;
    private static t j;
    private static f.b k;
    private static boolean l;
    private static int m;

    static {
        f.b b2 = q.c() ? f.b.b : f.b.a;
        k = b2;
        m = com.xiaomi.market.sdk.a.b;
    }

    public static void a() {
        f.a();
    }

    public static void a(Context context) {
        Class<s> class_ = s.class;
        synchronized (s.class) {
            block7 : {
                if (context != null) {
                    if (b) {
                        break block7;
                    }
                    com.xiaomi.market.sdk.b.a(context);
                    b = true;
                    c.a(context);
                    c = new WeakReference((Object)context);
                    l = false;
                    if (!a) {
                        h = null;
                        i = null;
                        f.b();
                        a = true;
                    }
                    new a(0).execute((Object[])new Void[0]);
                    // ** MonitorExit[var3_1] (shouldn't be in output)
                    return;
                }
            }
            return;
        }
    }

    public static void a(f.b b2) {
        k = b2;
    }

    public static void a(t t2) {
        j = t2;
    }

    /*
     * Exception decompiling
     */
    static i b(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl26 : ALOAD : trying to set 1 previously set to 0
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

    public static void b() {
        Context context = (Context)c.get();
        if (context == null) {
            return;
        }
        c.a(context);
        s.e();
    }

    public static void c() {
        d = false;
    }

    static Context d() {
        return (Context)c.get();
    }

    static void e() {
        Context context = (Context)c.get();
        if (context != null && i != null) {
            if (h == null) {
                return;
            }
            if (k.equals((Object)f.b.a) && s.i.b != 1 && q.b()) {
                StringBuilder stringBuilder = new StringBuilder("market://details?ref=update_sdk&back=true&id=");
                stringBuilder.append(s.h.a);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)stringBuilder.toString()));
                intent.setPackage(q.a());
                List list = context.getPackageManager().queryIntentActivities(intent, 0);
                if (list != null && list.size() == 1) {
                    ResolveInfo resolveInfo = (ResolveInfo)list.get(0);
                    if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.exported && resolveInfo.activityInfo.enabled) {
                        if (!(context instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        context.startActivity(intent);
                        return;
                    }
                }
            }
            g.a(context).a(h, i);
        }
    }

    private static final class com.xiaomi.market.sdk.s$a
    extends AsyncTask<Void, Void, Integer> {
        private com.xiaomi.market.sdk.s$a() {
        }

        /* synthetic */ com.xiaomi.market.sdk.s$a(byte by) {
        }

        private static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                j.b("MarketUpdateAgent", "update info json obj null");
                return null;
            }
            if (q.a) {
                StringBuilder stringBuilder = new StringBuilder("updateInfo : ");
                stringBuilder.append(jSONObject.toString());
                j.a("MarketUpdateAgent", stringBuilder.toString());
            }
            b b2 = new b();
            try {
                b2.a = jSONObject.getString("host");
                b2.c = jSONObject.getInt("fitness");
                b2.b = jSONObject.getInt("source");
                b2.d = jSONObject.getString("updateLog");
                b2.e = jSONObject.getInt("versionCode");
                b2.f = jSONObject.getString("versionName");
                b2.g = jSONObject.getString("apk");
                b2.h = jSONObject.getString("apkHash");
                b2.i = jSONObject.getLong("apkSize");
                if (f) {
                    b2.j = jSONObject.getString("diffFile");
                    b2.k = jSONObject.getString("diffFileHash");
                    b2.l = jSONObject.getLong("diffFileSize");
                }
                return b2;
            }
            catch (JSONException jSONException) {
                StringBuilder stringBuilder = new StringBuilder("get update info failed : ");
                stringBuilder.append(jSONException.toString());
                j.b("MarketUpdateAgent", stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder("original content : ");
                stringBuilder2.append(jSONObject.toString());
                j.b("MarketUpdateAgent", stringBuilder2.toString());
                return null;
            }
        }

        private static String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c.a);
                stringBuilder.append("*");
                stringBuilder.append(c.b);
                jSONObject.put("screenSize", (Object)stringBuilder.toString());
                jSONObject.put("resolution", (Object)c.c);
                jSONObject.put("density", c.d);
                jSONObject.put("touchScreen", c.e);
                jSONObject.put("glEsVersion", (Object)c.f);
                jSONObject.put("feature", c.g);
                jSONObject.put("library", c.h);
                jSONObject.put("glExtension", c.i);
                jSONObject.put("sdk", c.j);
                jSONObject.put("version", (Object)c.k);
                jSONObject.put("release", (Object)c.l);
            }
            catch (JSONException jSONException) {
                return "";
            }
            return jSONObject.toString();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
            int n2;
            Context context = (Context)c.get();
            if (context != null) {
                if (!q.a(context)) {
                    n2 = 3;
                    do {
                        return n2;
                        break;
                    } while (true);
                }
                if (!q.b(context) && e) {
                    n2 = 2;
                    return n2;
                }
                h = s.b(context);
                if (h == null) {
                    n2 = 5;
                    return n2;
                }
                e e2 = new e(f.b);
                e2.getClass();
                e.d d2 = new e.d(e2);
                d2.a("info", com.xiaomi.market.sdk.s$a.a());
                d2.a("packageName", s.i().a);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(s.i().c);
                d2.a("versionCode", stringBuilder.toString());
                d2.a("apkHash", s.i().g);
                d2.a("signature", s.i().e);
                d2.a("sdk", String.valueOf((int)c.j));
                d2.a("os", c.k);
                d2.a("la", c.b());
                d2.a("co", c.a());
                d2.a("lo", c.c());
                d2.a("androidId", c.m);
                d2.a("device", c.g());
                d2.a("deviceType", String.valueOf((int)c.h()));
                d2.a("cpuArchitecture", c.i());
                d2.a("model", c.f());
                d2.a("xiaomiSDKVersion", "7");
                String string2 = l ? "1" : "0";
                d2.a("debug", string2);
                d2.a("miuiBigVersionName", c.e());
                d2.a("miuiBigVersionCode", c.d());
                int n3 = m;
                int n4 = 1;
                d2.a("ext_abTestIdentifier", String.valueOf((int)(n3 - n4)));
                if (g || m == com.xiaomi.market.sdk.a.a) {
                    d2.a("imei", c.j());
                }
                if (e.c.a == e2.b()) {
                    i = com.xiaomi.market.sdk.s$a.a(e2.a());
                    if (i != null) {
                        j.c("MarketUpdateAgent", i.toString());
                        if (s.m().c != 0) return n4;
                        n4 = 0;
                        return n4;
                    }
                }
            }
            n2 = 4;
            return n2;
        }

        protected final /* synthetic */ void onPostExecute(Object object) {
            Integer n2 = (Integer)object;
            b = false;
            Context context = (Context)c.get();
            if (context != null) {
                if (d && context instanceof Activity) {
                    if (n2 != 0) {
                        return;
                    }
                    new a(0).execute((Object[])new Void[0]);
                    return;
                }
                p p2 = new p();
                if (n2 == 0) {
                    p2.a = s.m().d;
                    p2.c = s.m().e;
                    p2.b = s.m().f;
                    p2.e = s.m().i;
                    p2.f = s.m().h;
                    p2.g = s.m().l;
                    p2.d = e.a(s.m().a, s.m().g);
                }
                if (j != null) {
                    j.a(n2, p2);
                }
            }
        }

        protected final void onPreExecute() {
            j.a("MarketUpdateAgent", "start to check update");
            if (!f) {
                f = Patcher.a();
            }
        }

        private static final class a
        extends AsyncTask<Void, Void, Boolean> {
            private a() {
            }

            /* synthetic */ a(byte by) {
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                boolean bl;
                Context context = (Context)c.get();
                if (context == null) {
                    bl = false;
                    do {
                        return bl;
                        break;
                    } while (true);
                }
                bl = g.a(context).a(h);
                return bl;
            }

            /*
             * Enabled aggressive block sorting
             */
            protected final /* synthetic */ void onPostExecute(Object object) {
                Context context;
                if (!((Boolean)object).booleanValue() && (context = (Context)c.get()) != null) {
                    int n2;
                    Object[] arrobject;
                    if (context instanceof Activity && ((Activity)context).isFinishing()) {
                        j.b("MarketUpdateAgent", "activity not running!");
                        return;
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    int n3 = R.string.xiaomi_update_sdk_dialog_title;
                    Object[] arrobject2 = new Object[]{s.i().b};
                    AlertDialog.Builder builder2 = builder.setTitle((CharSequence)context.getString(n3, arrobject2));
                    if (TextUtils.isEmpty((CharSequence)s.m().j)) {
                        n2 = R.string.xiaomi_update_sdk_dialog_message;
                        arrobject = new Object[]{s.m().f, q.a(s.m().i, context)};
                    } else {
                        n2 = R.string.xiaomi_update_sdk_dialog_message_diff;
                        arrobject = new Object[]{s.m().f, q.a(s.m().l, context)};
                    }
                    String string2 = context.getString(n2, arrobject);
                    builder2.setMessage((CharSequence)string2).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener(){

                        public final void onClick(DialogInterface dialogInterface, int n2) {
                            s.e();
                        }
                    }).show();
                }
            }
        }

    }

    static final class b {
        String a;
        int b;
        int c;
        String d;
        int e;
        String f;
        String g;
        String h;
        long i;
        String j = "";
        String k = "";
        long l;

        b() {
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("UpdateInfo:\nhost = ");
            stringBuilder.append(this.a);
            stringBuilder.append("\nfitness = ");
            stringBuilder.append(this.c);
            stringBuilder.append("\nupdateLog = ");
            stringBuilder.append(this.d);
            stringBuilder.append("\nversionCode = ");
            stringBuilder.append(this.e);
            stringBuilder.append("\nversionName = ");
            stringBuilder.append(this.f);
            stringBuilder.append("\napkUrl = ");
            stringBuilder.append(this.g);
            stringBuilder.append("\napkHash = ");
            stringBuilder.append(this.h);
            stringBuilder.append("\napkSize = ");
            stringBuilder.append(this.i);
            stringBuilder.append("\ndiffUrl = ");
            stringBuilder.append(this.j);
            stringBuilder.append("\ndiffHash = ");
            stringBuilder.append(this.k);
            stringBuilder.append("\ndiffSize = ");
            stringBuilder.append(this.l);
            return stringBuilder.toString();
        }
    }

}

