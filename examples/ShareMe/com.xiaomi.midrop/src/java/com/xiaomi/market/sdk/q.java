/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Environment
 *  com.xiaomi.market.sdk.q$1
 *  com.xiaomi.market.sdk.q$2
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 */
package com.xiaomi.market.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.xiaomi.market.sdk.R;
import com.xiaomi.market.sdk.j;
import com.xiaomi.market.sdk.n;
import com.xiaomi.market.sdk.q;
import java.io.File;
import java.lang.reflect.Method;

public final class q {
    static boolean a = new File("/sdcard/com.xiaomi.market.sdk/sdk_debug").exists();
    private static n<String> b = new 1();
    private static volatile n<Boolean> c = new 2();

    static String a() {
        return b.b();
    }

    public static String a(long l2, Context context) {
        String string2;
        int n2;
        if (context == null) {
            return "";
        }
        if (l2 < 0L) {
            return "";
        }
        if (l2 > 1000000L) {
            Object[] arrobject = new Object[]{1.0 * (double)l2 / 1000000.0};
            string2 = String.format((String)"%.1f", (Object[])arrobject);
            n2 = R.string.xiaomi_update_sdk_megabytes_unit;
        } else if (l2 > 1000L) {
            Object[] arrobject = new Object[]{1.0 * (double)l2 / 1000.0};
            string2 = String.format((String)"%.1f", (Object[])arrobject);
            n2 = R.string.xiaomi_update_sdk_kilobytes_unit;
        } else {
            string2 = String.valueOf((long)l2);
            n2 = R.string.xiaomi_update_sdk_bytes_unit;
        }
        return context.getString(n2, new Object[]{string2});
    }

    static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    static boolean b() {
        return c.b();
    }

    static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkInfo != null && networkInfo.getType() == 1;
    }

    static boolean c() {
        try {
            Class class_ = Class.forName((String)"android.os.SystemProperties");
            boolean bl = ((String)class_.getDeclaredMethod("get", new Class[]{String.class}).invoke((Object)class_, new Object[]{"ro.build.characteristics"})).contains((CharSequence)"tablet");
            return bl;
        }
        catch (Exception exception) {
            j.a("MarketSdkUtils", exception.getMessage(), exception);
            return false;
        }
    }

    static boolean d() {
        String string2 = Environment.getExternalStorageState();
        if ("mounted".equals((Object)string2)) {
            return true;
        }
        "mounted_ro".equals((Object)string2);
        return false;
    }

    static /* synthetic */ n e() {
        return b;
    }
}

