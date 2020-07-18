/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.AsyncTask
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.text.TextUtils
 *  android.widget.Toast
 *  com.xiaomi.midrop.receiver.ui.ReceiveActivity
 *  com.xiaomi.midrop.sender.a$5
 *  com.xiaomi.midrop.sender.ui.TransmissionActivity
 *  com.xiaomi.midrop.transmission.a.e
 *  com.xiaomi.midrop.transmission.upgrade.a
 *  com.xiaomi.midrop.transmission.upgrade.a$a
 *  com.xiaomi.midrop.transmission.upgrade.a$b
 *  com.xiaomi.midrop.transmission.upgrade.a.a
 *  com.xiaomi.midrop.transmission.upgrade.util.a
 *  com.xiaomi.midrop.transmission.upgrade.util.c
 *  com.xiaomi.midrop.transmission.upgrade.util.c$a
 *  com.xiaomi.midrop.util.af
 *  com.xiaomi.midrop.util.af$a
 *  com.xiaomi.midrop.util.af$b
 *  com.xiaomi.midrop.util.g
 *  com.xiaomi.midrop.util.j
 *  com.xiaomi.midrop.util.y
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.midrop.sender;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.h;
import com.xiaomi.midrop.receiver.ui.ReceiveActivity;
import com.xiaomi.midrop.sender.a;
import com.xiaomi.midrop.sender.c.i;
import com.xiaomi.midrop.sender.ui.TransmissionActivity;
import com.xiaomi.midrop.transmission.a.e;
import com.xiaomi.midrop.transmission.upgrade.a;
import com.xiaomi.midrop.transmission.upgrade.util.c;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.y;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    Activity a;
    HashMap<String, com.xiaomi.midrop.transmission.upgrade.a.a> b = new HashMap();
    a c;
    public Handler d;
    public String e;
    public boolean f;
    e g;
    com.xiaomi.midrop.transmission.upgrade.util.c h;
    e.a i;

    public a(Activity activity, a a2) {
        this.d = new Handler(Looper.getMainLooper()){

            public final void handleMessage(Message message) {
                if (a.this.c == null) {
                    return;
                }
                a.b b2 = (a.b)message.obj;
                switch (7.a[b2.ordinal()]) {
                    default: {
                        return;
                    }
                    case 2: {
                        a.this.c.a(d.a(a.a.f));
                        af.a((af.a)af.a.cT).a();
                        return;
                    }
                    case 1: 
                }
                a.this.c.a(d.a(a.a.e));
            }
        };
        this.i = new 5((a)this);
        this.a = activity;
        this.c = a2;
        this.h = new com.xiaomi.midrop.transmission.upgrade.util.c(this.d);
    }

    /*
     * Exception decompiling
     */
    static /* synthetic */ void a(a var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl35 : RETURN : trying to set 0 previously set to 1
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

    public final void a(boolean bl) {
        new c((a)this, bl).execute((Object[])new Void[0]);
    }

    public static interface a {
        public void a(e var1);

        public void a(String var1);
    }

    private static final class b
    extends AsyncTask<Void, Void, List<com.xiaomi.midrop.transmission.upgrade.a.a>> {
        private List<com.xiaomi.midrop.transmission.upgrade.a.a> a;
        private WeakReference<a> b;

        public b(List<com.xiaomi.midrop.transmission.upgrade.a.a> list, a a2) {
            this.a = list;
            this.b = new WeakReference((Object)a2);
        }

        private /* varargs */ List<com.xiaomi.midrop.transmission.upgrade.a.a> a() {
            if (this.b.get() == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (g g2 : h.a(MiDropApplication.a())) {
                PackageInfo packageInfo;
                if (g2.B || com.xiaomi.midrop.transmission.upgrade.a.a.contains((Object)g2.C)) continue;
                com.xiaomi.midrop.transmission.upgrade.a.a a2 = null;
                for (int i2 = -1 + this.a.size(); i2 >= 0; --i2) {
                    PackageInfo packageInfo2;
                    com.xiaomi.midrop.transmission.upgrade.a.a a3 = (com.xiaomi.midrop.transmission.upgrade.a.a)this.a.get(i2);
                    if (!a3.a(g2.C)) continue;
                    try {
                        packageInfo2 = MiDropApplication.a().getPackageManager().getPackageInfo(g2.C, 0);
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        nameNotFoundException.printStackTrace();
                        packageInfo2 = null;
                    }
                    if (packageInfo2 != null && a3.e > packageInfo2.versionCode && (a2 == null || a3.e > a2.e)) {
                        a2 = a3;
                    }
                    this.a.remove(i2);
                }
                if (a2 == null || arrayList.contains(a2) || a2.a("com.xiaomi.midrop") && (packageInfo = i.a(MiDropApplication.a())) != null && a2.e <= packageInfo.versionCode) continue;
                a2.h = g2.i;
                arrayList.add(a2);
            }
            return arrayList;
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
            List list = (List)object;
            if (this.b.get() != null) {
                a a2 = (a)this.b.get();
                if (list != null && list.size() > 0 && a2.c != null) {
                    if (y.h()) {
                        com.xiaomi.midrop.transmission.upgrade.a.a a3;
                        block6 : {
                            com.xiaomi.midrop.transmission.upgrade.a.a a4;
                            Iterator iterator = list.iterator();
                            do {
                                boolean bl = iterator.hasNext();
                                a3 = null;
                                if (!bl) break block6;
                            } while (!(a4 = (com.xiaomi.midrop.transmission.upgrade.a.a)iterator.next()).a(a2.a.getPackageName()));
                            a3 = a4;
                        }
                        if (a3 != null) {
                            list.remove(a3);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add((Object)a3);
                            a2.c.a(d.a((List<com.xiaomi.midrop.transmission.upgrade.a.a>)arrayList, a.a.c));
                        }
                    }
                    if (i.c() && list.size() > 0) {
                        a2.g = new e(a.b.a, a2.i);
                        a2.c.a(a2.g);
                        com.xiaomi.midrop.transmission.upgrade.util.a a5 = com.xiaomi.midrop.transmission.upgrade.util.a.e();
                        a5.e.clear();
                        a5.e.addAll((Collection)list);
                        af.a((af.a)af.a.cR).a();
                    }
                }
            }
        }
    }

    private static final class c
    extends AsyncTask<Void, Void, List<com.xiaomi.midrop.transmission.upgrade.a.a>> {
        private WeakReference<a> a;
        private boolean b;

        c(a a2, boolean bl) {
            this.a = new WeakReference((Object)a2);
            this.b = bl;
        }

        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
            if (this.a.get() == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (g g2 : h.a(MiDropApplication.a())) {
                PackageInfo packageInfo;
                com.xiaomi.midrop.transmission.upgrade.a.a a2;
                if (com.xiaomi.midrop.util.g.d((String)j.d((String)g2.i)) && !g2.B && (packageInfo = MiDropApplication.a().getPackageManager().getPackageArchiveInfo(g2.i, 0)) != null) {
                    a2 = new com.xiaomi.midrop.transmission.upgrade.a.a();
                    a2.a = g2.k;
                    String string2 = this.b ? com.xiaomi.midrop.transmission.upgrade.a.a.b((String)packageInfo.packageName) : packageInfo.packageName;
                    a2.d = this.b;
                    a2.b = string2;
                    a2.c = packageInfo.packageName;
                    a2.e = packageInfo.versionCode;
                    a2.f = packageInfo.versionName;
                    a2.g = g2.i;
                    a2.j = true;
                } else {
                    a2 = null;
                }
                if (a2 == null || !i.c() && !a2.a("com.xiaomi.midrop")) continue;
                arrayList.add(a2);
            }
            return arrayList;
        }

        protected final /* synthetic */ void onPostExecute(Object object) {
            List list = (List)object;
            if (this.a.get() != null) {
                a a2 = (a)this.a.get();
                a2.b.clear();
                if (a2.c != null && list != null) {
                    for (com.xiaomi.midrop.transmission.upgrade.a.a a3 : list) {
                        a2.b.put((Object)a3.b, (Object)a3);
                    }
                    a2.c.a(d.a((List<com.xiaomi.midrop.transmission.upgrade.a.a>)list, a.a.b));
                }
            }
        }
    }

    public static final class d {
        public static a.a a(String string2) {
            a.a a2 = a.a.a;
            try {
                a.a a3 = a.a.a((int)new JSONObject(string2).getInt("type"));
                return a3;
            }
            catch (JSONException jSONException) {
                return a2;
            }
        }

        public static String a(a.a a2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", a2.ordinal());
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            return jSONObject.toString();
        }

        public static String a(List<com.xiaomi.midrop.transmission.upgrade.a.a> list, a.a a2) {
            if (list != null && list.size() != 0) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (com.xiaomi.midrop.transmission.upgrade.a.a a3 : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        if (!a3.d) {
                            jSONObject2.put("name", (Object)a3.a);
                            jSONObject2.put("path", (Object)a3.g);
                        }
                        jSONObject2.put("packageName", (Object)a3.b);
                        jSONObject2.put("safe", a3.d);
                        jSONObject2.put("versionCode", a3.e);
                        jSONObject2.put("versionName", (Object)a3.f);
                    }
                    catch (JSONException jSONException) {
                        jSONException.printStackTrace();
                        break;
                    }
                    jSONArray.put((Object)jSONObject2);
                }
                try {
                    jSONObject.put("list", (Object)jSONArray);
                    jSONObject.put("type", a2.ordinal());
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                }
                return jSONObject.toString();
            }
            return null;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static ArrayList<com.xiaomi.midrop.transmission.upgrade.a.a> b(String string2) {
            JSONArray jSONArray;
            JSONObject jSONObject;
            ArrayList arrayList = new ArrayList();
            try {
                jSONArray = new JSONObject(string2).getJSONArray("list");
                if (jSONArray == null) {
                    return arrayList;
                }
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                return arrayList;
            }
            for (int i2 = 0; i2 < jSONArray.length() && (jSONObject = jSONArray.getJSONObject(i2)) != null; ++i2) {
                com.xiaomi.midrop.transmission.upgrade.a.a a2 = new com.xiaomi.midrop.transmission.upgrade.a.a();
                a2.a = jSONObject.optString("name");
                a2.d = jSONObject.optBoolean("safe");
                a2.b = jSONObject.optString("packageName");
                a2.e = jSONObject.optInt("versionCode");
                a2.f = jSONObject.optString("versionName");
                a2.g = jSONObject.optString("path");
                arrayList.add((Object)a2);
            }
            return arrayList;
        }
    }

}

