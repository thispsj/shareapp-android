/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.xiaomi.midrop.util.Locale.b
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.Locale
 */
package com.xiaomi.midrop.feedback;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import com.xiaomi.globalmiuiapp.common.c.a;
import com.xiaomi.globalmiuiapp.common.f.b;
import java.io.File;
import java.util.Locale;

public final class a {
    public static void a(Context context) {
        a.a a2 = new a.a();
        a2.a = "global_midrop@xiaomi.com";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n\n");
        stringBuilder.append("-----------------------------------------------------------\n");
        stringBuilder.append(com.xiaomi.midrop.util.Locale.b.a().a(2131689662));
        stringBuilder.append("\n");
        stringBuilder.append("-----------------------------------------------------------\n");
        com.xiaomi.midrop.util.Locale.b b2 = com.xiaomi.midrop.util.Locale.b.a();
        stringBuilder.append(b2.a(2131689724));
        stringBuilder.append(a.b(context));
        stringBuilder.append("\n");
        stringBuilder.append(b2.a(2131689723));
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("\n");
        stringBuilder.append(b2.a(2131689727));
        stringBuilder.append(Build.MODEL);
        stringBuilder.append("\n");
        stringBuilder.append(b2.a(2131689726));
        stringBuilder.append(context.getResources().getConfiguration().locale.getDisplayCountry());
        stringBuilder.append("\n");
        stringBuilder.append(b2.a(2131689725));
        stringBuilder.append(context.getResources().getConfiguration().locale.getDisplayLanguage());
        stringBuilder.append("\n");
        stringBuilder.append(b2.a(2131689728));
        stringBuilder.append("Android");
        stringBuilder.append("\n");
        stringBuilder.append(b2.a(2131689729));
        stringBuilder.append(Build.VERSION.SDK_INT);
        stringBuilder.append("\n");
        a2.b = stringBuilder.toString();
        a2.c = com.xiaomi.midrop.util.Locale.b.a().b(2131689523);
        a2.d = "MiDrop_log";
        com.xiaomi.globalmiuiapp.common.c.a a3 = new com.xiaomi.globalmiuiapp.common.c.a(a2, 0);
        if (b.a()) {
            Intent intent = new Intent("miui.intent.action.BUGREPORT");
            intent.putExtra("packageName", context.getPackageName());
            intent.putExtra("appTitle", com.xiaomi.globalmiuiapp.common.c.a.c);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
            return;
        }
        new AsyncTask<Void, Void, File>(a3, context){
            final /* synthetic */ Context a;
            final /* synthetic */ com.xiaomi.globalmiuiapp.common.c.a b;
            {
                this.b = a2;
                this.a = context;
            }

            protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                File file;
                if (!android.text.TextUtils.isEmpty((CharSequence)com.xiaomi.globalmiuiapp.common.c.a.d) && (file = com.xiaomi.globalmiuiapp.common.e.a.b()) != null) {
                    if (!file.exists()) {
                        return null;
                    }
                    com.xiaomi.globalmiuiapp.common.e.a.a(new java.lang.Runnable(this){
                        final /* synthetic */ a.1 a;
                        {
                            this.a = var1;
                        }

                        public final void run() {
                        }
                    });
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((Object)com.xiaomi.globalmiuiapp.common.d.a.a());
                    stringBuilder.append("/");
                    stringBuilder.append(com.xiaomi.globalmiuiapp.common.c.a.d);
                    stringBuilder.append(".zip");
                    String string2 = stringBuilder.toString();
                    if (new com.xiaomi.globalmiuiapp.common.f.g().a(file.getAbsolutePath(), string2)) {
                        return new File(string2);
                    }
                }
                return null;
            }

            protected final /* synthetic */ void onPostExecute(Object object) {
                File file = (File)object;
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(android.net.Uri.parse((String)"mailto:"));
                String[] arrstring = new String[]{com.xiaomi.globalmiuiapp.common.c.a.a};
                intent.putExtra("android.intent.extra.EMAIL", arrstring);
                intent.putExtra("android.intent.extra.TEXT", com.xiaomi.globalmiuiapp.common.c.a.b);
                if (file != null && file.exists() && file.length() > 0L) {
                    android.net.Uri uri;
                    if (Build.VERSION.SDK_INT >= 23) {
                        try {
                            Context context = com.xiaomi.globalmiuiapp.common.a.a.a.b;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(context.getPackageName());
                            stringBuilder.append(".fileProvider");
                            uri = android.support.v4.content.FileProvider.a((Context)context, (String)stringBuilder.toString(), (File)file);
                        }
                        catch (java.lang.IllegalArgumentException illegalArgumentException) {
                            return;
                        }
                    } else {
                        uri = android.net.Uri.fromFile((File)file);
                    }
                    java.util.List list = this.a.getPackageManager().queryIntentActivities(intent, 0);
                    if (list != null && list.size() > 0) {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        for (android.content.pm.ResolveInfo resolveInfo : list) {
                            Intent intent2 = new Intent("android.intent.action.SEND");
                            if (Build.VERSION.SDK_INT >= 23) {
                                intent2.setFlags(1);
                            }
                            intent2.setType("application/octet-stream");
                            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                            String[] arrstring2 = new String[]{com.xiaomi.globalmiuiapp.common.c.a.a};
                            intent2.putExtra("android.intent.extra.EMAIL", arrstring2);
                            intent2.putExtra("android.intent.extra.TEXT", com.xiaomi.globalmiuiapp.common.c.a.b);
                            intent2.putExtra("android.intent.extra.STREAM", (android.os.Parcelable)uri);
                            arrayList.add((Object)new android.content.pm.LabeledIntent(intent2, resolveInfo.activityInfo.packageName, resolveInfo.loadLabel(this.a.getPackageManager()), resolveInfo.icon));
                        }
                        Intent intent3 = Intent.createChooser((Intent)((Intent)arrayList.remove(arrayList.size() - 1)), (CharSequence)"");
                        intent3.putExtra("android.intent.extra.INITIAL_INTENTS", (android.os.Parcelable[])arrayList.toArray((Object[])new android.content.pm.LabeledIntent[arrayList.size()]));
                        if (intent3.resolveActivity(this.a.getPackageManager()) != null) {
                            this.a.startActivity(intent3);
                        }
                    }
                }
            }
        }.execute((Object[])new Void[0]);
    }

    private static String b(Context context) {
        try {
            String string2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionName;
            return string2;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return "";
        }
    }
}

