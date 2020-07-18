/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.location.LocationManager
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings
 *  android.provider.Settings$Global
 *  android.provider.Settings$System
 *  android.support.v4.app.a
 *  android.support.v4.content.a
 *  android.widget.Toast
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  midrop.service.c.d
 */
package com.xiaomi.midrop;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.a;
import android.widget.Toast;
import com.xiaomi.globalmiuiapp.common.f.b;
import com.xiaomi.midrop.MiDropApplication;
import midrop.service.c.d;

public final class e {
    public static final String[] a = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    public static final String[] b = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    public static final String[] c = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    private static final String[] d = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_SETTINGS"};

    public static void a() {
        Toast.makeText((Context)MiDropApplication.a(), (int)2131689861, (int)0).show();
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            StringBuilder stringBuilder = new StringBuilder("package:");
            stringBuilder.append(activity.getPackageName());
            intent.setData(Uri.parse((String)stringBuilder.toString()));
            try {
                activity.startActivityForResult(intent, 1015);
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                activityNotFoundException.printStackTrace();
                e.b();
            }
            Toast.makeText((Context)MiDropApplication.a(), (int)2131689815, (int)0).show();
            return;
        }
        a.a((Activity)activity, (String[])new String[]{"android.permission.WRITE_SETTINGS"}, (int)1015);
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.System.canWrite((Context)context);
        }
        return android.support.v4.content.a.a((Context)context, (String)"android.permission.WRITE_SETTINGS") == 0;
    }

    public static boolean a(Context context, String string2) {
        try {
            int n = android.support.v4.content.a.a((Context)context, (String)string2);
            return n == 0;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static boolean a(Context context, String[] arrstring) {
        for (String string2 : arrstring) {
            boolean bl;
            block2 : {
                String[] arrstring2 = d;
                int n = arrstring2.length;
                for (int i2 = 0; i2 < n; ++i2) {
                    if (!arrstring2[i2].equals((Object)string2)) continue;
                    bl = true;
                    break block2;
                }
                bl = false;
            }
            if (!bl || e.a(context, string2)) continue;
            return true;
        }
        return false;
    }

    public static boolean a(int[] arrn) {
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static void b() {
        Toast.makeText((Context)MiDropApplication.a(), (int)2131689770, (int)1).show();
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            try {
                activity.startActivityForResult(intent, 1014);
                return;
            }
            catch (Exception exception) {
                d.a((String)"PermUtils", (String)"requestOpenLocationService", (Throwable)exception, (Object[])new Object[0]);
            }
        }
    }

    public static boolean b(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return !e.d(context);
        }
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return !e.d(context);
    }

    public static void c(Activity activity) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts((String)"package", (String)activity.getPackageName(), null));
        try {
            activity.startActivity(intent);
            return;
        }
        catch (Exception exception) {
            d.a((String)"PermUtils", (String)"Setting page error", (Throwable)exception, (Object[])new Object[0]);
            e.a();
            activity.finish();
            return;
        }
    }

    public static boolean c() {
        return b.a();
    }

    public static boolean c(Context context) {
        return Build.VERSION.SDK_INT >= 26 && !e.d(context);
    }

    public static void d(Activity activity) {
        Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
        try {
            activity.startActivityForResult(intent, 1012);
            return;
        }
        catch (Exception exception) {
            new StringBuilder("goWirelessSettingsPage e=").append((Object)exception);
            return;
        }
    }

    public static boolean d(Context context) {
        LocationManager locationManager = (LocationManager)context.getSystemService("location");
        boolean bl = locationManager.isProviderEnabled("network");
        boolean bl2 = locationManager.isProviderEnabled("gps");
        Object[] arrobject = new Object[]{bl, bl2};
        String.format((String)"[networkEnabled = %b], [gpsEnabled = %b]", (Object[])arrobject);
        if (!bl) {
            return bl2;
        }
        return true;
    }

    public static boolean e(Context context) {
        boolean bl;
        return Build.VERSION.SDK_INT >= 26 && (bl = Settings.Global.getInt((ContentResolver)context.getContentResolver(), (String)"airplane_mode_on", (int)0) != 0);
    }

    public static boolean f(Context context) {
        boolean bl;
        return e.a(context, "android.permission.ACCESS_COARSE_LOCATION") && e.a(context, "android.permission.ACCESS_FINE_LOCATION") && (bl = Build.VERSION.SDK_INT < 26 ? true : e.d(context)) && e.a(context);
    }
}

