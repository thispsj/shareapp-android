/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.os.AsyncTask
 *  android.support.v7.app.d
 *  android.util.SparseArray
 *  com.xiaomi.midrop.received.ReceivedActivity
 *  com.xiaomi.midrop.util.am
 *  com.xiaomi.midrop.util.g
 *  com.xiaomi.midrop.util.j
 *  com.xiaomi.midrop.util.y
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.HashSet
 */
package com.xiaomi.midrop.result;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.support.v7.app.d;
import android.util.SparseArray;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.received.ReceivedActivity;
import com.xiaomi.midrop.sender.c.i;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.g;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.y;
import java.lang.ref.WeakReference;
import java.util.HashSet;

public final class a {
    private static a o = new a();
    public long a;
    public long b;
    public SparseArray<HashSet<String>> c = new SparseArray();
    public SparseArray<HashSet<String>> d = new SparseArray();
    boolean e;
    boolean f;
    String g;
    public boolean h;
    boolean i;
    boolean j;
    String k;
    String l;
    public int m;
    public boolean n = false;

    private a() {
    }

    public static a a() {
        return o;
    }

    static /* synthetic */ void a(a a2) {
        PackageInfo packageInfo = i.a(MiDropApplication.a());
        if (packageInfo != null && y.c((int)packageInfo.versionCode)) {
            a2.f = true;
            a2.g = packageInfo.applicationInfo.sourceDir;
            a2.l = packageInfo.versionName;
        }
        if (y.b() < 5 && !am.a()) {
            a2.e = true;
        }
    }

    public final HashSet<String> a(int n2) {
        return (HashSet)this.c.get(n2);
    }

    public final void a(int n2, String string2) {
        if (this.d.get(n2) != null) {
            ((HashSet)this.d.get(n2)).remove((Object)string2);
        }
    }

    public final void a(String string2) {
        String string3 = j.d((String)string2);
        int n2 = g.l.contains((Object)string3) ? 2 : (g.h.contains((Object)string3) ? 4 : (g.i.contains((Object)string3) ? 3 : (g.j.contains((Object)string3) ? 1 : 7)));
        HashSet hashSet = (HashSet)this.c.get(n2);
        if (hashSet == null) {
            hashSet = new HashSet();
        }
        hashSet.add((Object)string2);
        this.c.put(n2, (Object)hashSet);
    }

    public final boolean a(Context context, int n2, String string2) {
        if (context instanceof ReceivedActivity && this.d.get(n2) != null) {
            return ((HashSet)this.d.get(n2)).contains((Object)string2);
        }
        return false;
    }

    private static final class a
    extends AsyncTask<Void, Void, Void> {
        private WeakReference<d> a;

        public a(d d2) {
            this.a = new WeakReference((Object)d2);
        }

        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
            a.a(a.a());
            return null;
        }

        /*
         * Exception decompiling
         */
        protected final /* synthetic */ void onPostExecute(Object var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl40 : RETURN : trying to set 0 previously set to 1
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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
    }

}

