/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.Executor
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.TextView;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.util.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class a {
    HashMap<String, PackageInfo> a = new HashMap();

    /*
     * Enabled aggressive block sorting
     */
    public static void a(Context context, TextView textView, int n2) {
        Drawable drawable2;
        if (n2 <= 0) {
            textView.setText((CharSequence)context.getResources().getString(2131689516));
            textView.setTextColor(context.getResources().getColor(2131099942));
            drawable2 = context.getResources().getDrawable(2131231252);
        } else {
            int n3;
            Resources resources;
            if (n2 == 2) {
                resources = context.getResources();
                n3 = 2131689517;
            } else if (n2 == 3) {
                resources = context.getResources();
                n3 = 2131689751;
            } else if (n2 == 4) {
                resources = context.getResources();
                n3 = 2131689784;
            } else if (n2 == 5) {
                resources = context.getResources();
                n3 = 2131689648;
            } else {
                resources = context.getResources();
                n3 = 2131689515;
            }
            textView.setText((CharSequence)resources.getString(n3));
            textView.setTextColor(context.getResources().getColor(2131099941));
            drawable2 = context.getResources().getDrawable(2131231249);
        }
        textView.setBackground(drawable2);
    }

    public static void a(g g2, Map<String, PackageInfo> map) {
        PackageInfo packageInfo = MiDropApplication.a().getPackageManager().getPackageArchiveInfo(g2.i, 0);
        if (packageInfo != null && !TextUtils.isEmpty((CharSequence)packageInfo.packageName)) {
            if (map != null && map.containsKey((Object)packageInfo.packageName)) {
                PackageInfo packageInfo2 = (PackageInfo)map.get((Object)packageInfo.packageName);
                g2.E = packageInfo.versionCode <= packageInfo2.versionCode ? 0 : 2;
            } else {
                g2.E = 1;
            }
            g2.y = packageInfo.versionName;
            g2.C = packageInfo.packageName;
            return;
        }
        g2.E = 1;
    }

    public final void a(g g2, a a2) {
        new b(g2, this.a, a2, g2.i).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    }

    public static interface a {
        public void a(g var1);
    }

    private static final class b
    extends AsyncTask<Void, Void, g> {
        private g a;
        private int b;
        private String c;
        private String d;
        private String e;
        private a f;
        private HashMap<String, PackageInfo> g;

        public b(g g2, HashMap<String, PackageInfo> hashMap, a a2, String string2) {
            this.a = g2;
            this.e = string2;
            this.g = hashMap;
            this.f = a2;
        }

        /*
         * Enabled aggressive block sorting
         */
        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
            PackageInfo packageInfo = MiDropApplication.a().getPackageManager().getPackageArchiveInfo(this.a.i, 1);
            if (packageInfo != null && !TextUtils.isEmpty((CharSequence)packageInfo.packageName)) {
                if (this.g != null && this.g.containsKey((Object)packageInfo.packageName)) {
                    PackageInfo packageInfo2 = (PackageInfo)this.g.get((Object)packageInfo.packageName);
                    int n2 = packageInfo.versionCode <= packageInfo2.versionCode ? 0 : 2;
                    this.b = n2;
                } else {
                    this.b = 1;
                }
                this.c = packageInfo.versionName;
                this.d = packageInfo.packageName;
            }
            return this.a;
        }

        protected final /* synthetic */ void onPostExecute(Object object) {
            g g2 = (g)object;
            if (TextUtils.equals((CharSequence)g2.i, (CharSequence)this.e)) {
                g2.E = this.b;
                g2.y = this.c;
                g2.x = this.d;
                g2.C = this.d;
                if (this.f != null) {
                    this.f.a(g2);
                }
            }
        }
    }

}

