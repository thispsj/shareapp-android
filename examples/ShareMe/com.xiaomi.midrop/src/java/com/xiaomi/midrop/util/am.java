/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.pm.ApplicationInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.support.v4.app.Fragment
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.text.style.ForegroundColorSpan
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.TextView
 *  com.google.zxing.d.a.a
 *  com.xiaomi.midrop.qrcode.QrCodeScannerActivity
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Locale
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.util;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import b.e.a.a.a.a.d;
import com.journeyapps.barcodescanner.CaptureActivity;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.e;
import com.xiaomi.midrop.qrcode.QrCodeScannerActivity;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ao;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

public final class am {
    private static final HashSet<String> a = new HashSet();
    private static final HashSet<String> b = new HashSet();

    static {
        Object[] arrobject = MiDropApplication.a().getResources().getStringArray(2130903041);
        a.addAll((Collection)Arrays.asList((Object[])arrobject));
    }

    public static void a(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n2);
        stringBuilder.append(":");
        String string2 = stringBuilder.toString();
        af.a(af.a.dV).a(af.b.O, string2).a();
    }

    public static void a(Context context, TextView textView, int n2) {
        if (context != null && textView != null) {
            if (n2 == 0) {
                return;
            }
            Resources resources = context.getResources();
            float f2 = resources.getDisplayMetrics().density;
            Drawable drawable2 = resources.getDrawable(n2);
            if (drawable2 == null) {
                return;
            }
            float f3 = f2 * 16.0f;
            drawable2.setBounds(0, 0, Math.round((float)f3), Math.round((float)f3));
            textView.setCompoundDrawables(drawable2, null, null, null);
            textView.setCompoundDrawablePadding((int)resources.getDimension(2131165606));
        }
    }

    public static void a(android.support.v4.app.Fragment fragment, String string2) {
        af.a(af.a.dt).a(af.b.ax, string2).a();
        com.google.zxing.d.a.a a2 = com.google.zxing.d.a.a.a((android.support.v4.app.Fragment)fragment);
        a2.g = Arrays.asList((Object[])new String[]{"QR_CODE"});
        a2.a("BEEP_ENABLED", (Object)false);
        a2.a("BARCODE_IMAGE_ENABLED", (Object)true);
        a2.h = QrCodeScannerActivity.class;
        Activity activity = a2.d;
        if (a2.h == null) {
            a2.h = CaptureActivity.class;
        }
        Intent intent = new Intent((Context)activity, a2.h);
        intent.setAction("com.google.zxing.client.android.SCAN");
        if (a2.g != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string3 : a2.g) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(',');
                }
                stringBuilder.append(string3);
            }
            intent.putExtra("SCAN_FORMATS", stringBuilder.toString());
        }
        intent.addFlags(67108864);
        intent.addFlags(524288);
        a2.a(intent);
        int n2 = a2.i;
        if (a2.e != null) {
            a2.e.startActivityForResult(intent, n2);
            return;
        }
        if (a2.f != null) {
            a2.f.startActivityForResult(intent, n2);
            return;
        }
        a2.d.startActivityForResult(intent, n2);
    }

    public static void a(View view) {
        ((InputMethodManager)MiDropApplication.a().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
        view.clearFocus();
    }

    public static void a(Window window) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-16777216);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2});
        layerDrawable.setLayerInsetTop(1, displayMetrics.heightPixels);
        window.setBackgroundDrawable((Drawable)layerDrawable);
    }

    public static void a(TextView textView, String string2, String string3, int n2) {
        String string4;
        String string5 = string2.toLowerCase();
        if (string5.contains((CharSequence)(string4 = string3.toLowerCase())) && !TextUtils.isEmpty((CharSequence)string3)) {
            int n3;
            ArrayList arrayList = new ArrayList();
            int n4 = string4.length();
            int n5 = 0;
            while ((n3 = string5.indexOf(string4, n5)) != -1) {
                int n6 = n3 + n4;
                arrayList.add((Object)new a(n3, n6, 0));
                if (n6 > string5.length()) break;
                n5 = n6;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)string2);
            for (a a2 : arrayList) {
                if (a2.a == a2.b) continue;
                int n7 = Math.min((int)a2.b, (int)spannableStringBuilder.length());
                spannableStringBuilder.setSpan((Object)new ForegroundColorSpan(n2), a2.a, n7, 33);
            }
            textView.setText((CharSequence)spannableStringBuilder);
            return;
        }
        textView.setText((CharSequence)string2);
    }

    public static boolean a() {
        boolean bl = am.h();
        if (bl && ao.a()) {
            if (!bl) {
                return true;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean a(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    /*
     * Exception decompiling
     */
    public static boolean a(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl27.1 : ICONST_0 : trying to set 1 previously set to 0
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

    public static boolean b() {
        return (129 & MiDropApplication.a().getApplicationInfo().flags) != 0;
    }

    public static boolean b(Context context) {
        int n2 = context != null ? 48 & context.getResources().getConfiguration().uiMode : 16;
        return n2 == 32;
    }

    public static boolean b(String string2) {
        if (b.isEmpty()) {
            String string3 = MiDropApplication.a().getSharedPreferences("midrop.hotApp", 0).getString("key_app_black_list", "");
            Object[] arrobject = !TextUtils.isEmpty((CharSequence)string3) ? string3.split(",") : MiDropApplication.a().getResources().getStringArray(2130903040);
            b.addAll((Collection)Arrays.asList((Object[])arrobject));
        }
        return b.contains((Object)string2);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT == 25;
    }

    public static boolean d() {
        String string2 = "";
        try {
            String string3;
            Class class_ = Class.forName((String)"android.os.SystemProperties");
            string2 = string3 = (String)class_.getMethod("get", new Class[]{String.class, String.class}).invoke((Object)class_, new Object[]{"ro.config.low_ram", "false"});
        }
        catch (Exception exception) {
            midrop.service.c.d.a((String)"Utils", (String)"isAndroidGoDevice", (Throwable)exception, (Object[])new Object[0]);
        }
        return TextUtils.equals((CharSequence)string2, (CharSequence)"true");
    }

    public static boolean e() {
        return false;
    }

    public static boolean f() {
        WifiManager wifiManager = (WifiManager)MiDropApplication.a().getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            return false;
        }
        if (!d.c(wifiManager)) {
            return false;
        }
        boolean bl = e.c();
        if (bl && TextUtils.isEmpty((CharSequence)d.f(wifiManager))) {
            return false;
        }
        return bl || Build.VERSION.SDK_INT != 25;
    }

    public static String g() {
        String string2 = "https://privacy.mi.com/all/";
        if (b.a() != null && b.a().a != null) {
            Locale locale = b.a().a;
            String string3 = locale.getLanguage();
            String string4 = locale.getCountry();
            if (!TextUtils.isEmpty((CharSequence)string3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(string3);
                string2 = stringBuilder.toString();
            }
            if (!TextUtils.isEmpty((CharSequence)string4)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append("_");
                stringBuilder.append(string4);
                string2 = stringBuilder.toString();
            }
        }
        return string2;
    }

    /*
     * Exception decompiling
     */
    private static boolean h() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl18.1 : ICONST_0 : trying to set 1 previously set to 0
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

    private static final class a {
        public int a;
        public int b;

        private a(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }

        /* synthetic */ a(int n2, int n3, byte by) {
            super(n2, n3);
        }
    }

}

