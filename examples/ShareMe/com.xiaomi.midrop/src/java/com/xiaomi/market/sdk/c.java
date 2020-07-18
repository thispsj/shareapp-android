/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.ConfigurationInfo
 *  android.content.pm.FeatureInfo
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Locale
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 *  javax.microedition.khronos.egl.EGLSurface
 *  javax.microedition.khronos.opengles.GL
 *  javax.microedition.khronos.opengles.GL10
 */
package com.xiaomi.market.sdk;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.xiaomi.market.sdk.b;
import com.xiaomi.market.sdk.d;
import com.xiaomi.market.sdk.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public final class c {
    static int a;
    static int b;
    static String c;
    static int d;
    static int e;
    static String f;
    static ArrayList<String> g;
    static ArrayList<String> h;
    static ArrayList<String> i;
    static int j;
    static String k;
    static String l;
    static String m;
    private static boolean n;
    private static final Object o;

    static {
        o = new Object();
    }

    public static String a() {
        return Locale.getDefault().getCountry();
    }

    static void a(Context context) {
        if (n) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        b = displayMetrics.heightPixels;
        a = displayMetrics.widthPixels;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append("*");
        stringBuilder.append(a);
        c = stringBuilder.toString();
        d = displayMetrics.densityDpi;
        ConfigurationInfo configurationInfo = ((ActivityManager)context.getSystemService("activity")).getDeviceConfigurationInfo();
        e = configurationInfo.reqTouchScreen;
        f = configurationInfo.getGlEsVersion();
        c.b(context);
        c.c(context);
        c.o();
        l = Build.VERSION.RELEASE;
        k = Build.VERSION.INCREMENTAL;
        j = Build.VERSION.SDK_INT;
        m = Settings.Secure.getString((ContentResolver)context.getContentResolver(), (String)"android_id");
        n = true;
    }

    public static String b() {
        return Locale.getDefault().getLanguage();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void b(Context context) {
        Object object;
        FeatureInfo[] arrfeatureInfo = context.getPackageManager().getSystemAvailableFeatures();
        Object object2 = object = o;
        synchronized (object2) {
            g = new ArrayList();
            if (arrfeatureInfo != null) {
                for (FeatureInfo featureInfo : arrfeatureInfo) {
                    if (TextUtils.isEmpty((CharSequence)featureInfo.name)) continue;
                    g.add((Object)featureInfo.name);
                }
            }
            Collections.sort(g);
            return;
        }
    }

    public static String c() {
        return o.a("ro.miui.region", "CN");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void c(Context context) {
        Object object;
        String[] arrstring = context.getPackageManager().getSystemSharedLibraryNames();
        Object object2 = object = o;
        synchronized (object2) {
            h = new ArrayList();
            if (arrstring != null) {
                for (String string2 : arrstring) {
                    if (TextUtils.isEmpty((CharSequence)string2)) continue;
                    h.add((Object)string2);
                }
            }
            Collections.sort(h);
            return;
        }
    }

    public static String d() {
        return o.a("ro.miui.ui.version.code", "-1");
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String e() {
        StringBuilder stringBuilder;
        String string2;
        String string3 = o.a("ro.miui.ui.version.name", "");
        boolean bl = o.a("ro.product.mod_device", "").endsWith("_alpha");
        boolean bl2 = true;
        boolean bl3 = bl || o.a("ro.product.mod_device", "").endsWith("_alpha_global");
        if (bl3) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            string2 = "-alpha";
        } else {
            if (TextUtils.isEmpty((CharSequence)Build.VERSION.INCREMENTAL) || !Build.VERSION.INCREMENTAL.matches("\\d+.\\d+.\\d+(-internal)?")) {
                bl2 = false;
            }
            if (!bl2) {
                return string3;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            string2 = "-dev";
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static String f() {
        return Build.MODEL;
    }

    public static String g() {
        return Build.DEVICE;
    }

    public static int h() {
        return o.a("ro.build.characteristics", "").contains((CharSequence)"tablet");
    }

    public static String i() {
        String string2;
        ArrayList arrayList = new ArrayList();
        boolean bl = Build.VERSION.SDK_INT >= 21;
        if (bl && !TextUtils.isEmpty((CharSequence)(string2 = o.a("ro.product.cpu.abilist", "")))) {
            arrayList = new ArrayList((Collection)Arrays.asList((Object[])TextUtils.split((String)string2, (String)",")));
        }
        if (arrayList.isEmpty()) {
            arrayList.add((Object)Build.CPU_ABI);
            arrayList.add((Object)Build.CPU_ABI2);
        }
        return TextUtils.join((CharSequence)",", (Iterable)arrayList);
    }

    public static String j() {
        return d.a(((TelephonyManager)b.a().getSystemService("phone")).getDeviceId());
    }

    static boolean k() {
        return j >= 11;
    }

    public static boolean l() {
        return j >= 24;
    }

    public static boolean m() {
        return new File("/system/app/miui.apk").exists() || new File("/system/app/miui/miui.apk").exists();
        {
        }
    }

    public static boolean n() {
        return c.m() && o.a("ro.product.mod_device", "").contains((CharSequence)"_global");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void o() {
        Object object;
        EGL10 eGL10 = (EGL10)EGLContext.getEGL();
        EGLDisplay eGLDisplay = eGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        EGLDisplay eGLDisplay2 = EGL10.EGL_NO_DISPLAY;
        int n2 = 0;
        String string2 = null;
        if (eGLDisplay != eGLDisplay2) {
            boolean bl = eGL10.eglInitialize(eGLDisplay, new int[2]);
            string2 = null;
            if (bl) {
                int[] arrn = new int[1];
                EGLConfig[] arreGLConfig = new EGLConfig[1];
                boolean bl2 = eGL10.eglChooseConfig(eGLDisplay, new int[]{12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, arreGLConfig, 1, arrn);
                string2 = null;
                if (bl2) {
                    EGLConfig eGLConfig = arrn[0] > 0 ? arreGLConfig[0] : null;
                    EGLContext eGLContext = eGL10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, null);
                    EGLSurface eGLSurface = eGL10.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, 480, 12374, 800, 12344});
                    string2 = null;
                    if (eGLSurface != null) {
                        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
                            string2 = null;
                        } else {
                            eGL10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
                            boolean bl3 = eGL10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
                            string2 = null;
                            if (bl3) {
                                String string3 = ((GL10)eGLContext.getGL()).glGetString(7939);
                                eGL10.eglDestroySurface(eGLDisplay, eGLSurface);
                                eGL10.eglDestroyContext(eGLDisplay, eGLContext);
                                eGL10.eglTerminate(eGLDisplay);
                                string2 = null;
                                if (string3 != null) {
                                    string2 = string3.trim();
                                }
                            }
                        }
                    }
                }
            }
        }
        Object object2 = object = o;
        synchronized (object2) {
            i = new ArrayList();
            if (!TextUtils.isEmpty(string2)) {
                String[] arrstring = TextUtils.split(string2, (String)" ");
                int n3 = arrstring.length;
                while (n2 < n3) {
                    String string4 = arrstring[n2];
                    if (!TextUtils.isEmpty((CharSequence)string4)) {
                        i.add((Object)string4);
                    }
                    ++n2;
                }
            }
            Collections.sort(i);
            return;
        }
    }
}

