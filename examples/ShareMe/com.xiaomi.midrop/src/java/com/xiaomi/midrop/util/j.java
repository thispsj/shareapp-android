/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.media.MediaMetadataRetriever
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.support.v4.content.FileProvider
 *  android.text.TextUtils
 *  com.xiaomi.midrop.GalleryActivity
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.nio.channels.FileChannel
 *  java.nio.channels.WritableByteChannel
 *  java.text.DateFormat
 *  java.text.SimpleDateFormat
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.xiaomi.midrop.GalleryActivity;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.g;
import com.xiaomi.miftp.view.dialog.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import midrop.service.c.d;

public class j {
    private static final String a = "j";

    public static Intent a(Context context, String string2, String string3) {
        Intent intent;
        block5 : {
            File file;
            block4 : {
                Uri uri;
                intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                file = new File(string3);
                if (Build.VERSION.SDK_INT < 24) break block4;
                intent.setFlags(1);
                try {
                    uri = FileProvider.a((Context)context, (String)"com.xiaomi.midrop.fileProvider", (File)file);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    d.a((String)a, (String)"openFile", (Throwable)illegalArgumentException, (Object[])new Object[0]);
                    return null;
                }
                intent.setDataAndType(uri, string2);
                break block5;
            }
            intent.setDataAndType(Uri.fromFile((File)file), string2);
            intent.setFlags(268435456);
        }
        if ("audio/*".equals((Object)string2)) {
            Intent intent2 = new Intent(intent);
            intent2.setPackage("com.miui.player");
            if (intent2.resolveActivity(context.getPackageManager()) != null) {
                return intent2;
            }
        }
        return intent;
    }

    public static String a() {
        b b2 = b.a();
        Object[] arrobject = new Object[]{0L};
        return b2.a(2131689684, arrobject);
    }

    public static String a(long l2) {
        long l3 = l2 / 1000L;
        int n2 = (int)l3 / 3600;
        int n3 = (int)(l3 % 3600L);
        int n4 = n3 / 60;
        int n5 = n3 % 60;
        if (n2 > 0) {
            Locale locale = Locale.getDefault();
            Object[] arrobject = new Object[]{n2, n4, n5};
            return String.format((Locale)locale, (String)"%02d:%02d:%02d", (Object[])arrobject);
        }
        Locale locale = Locale.getDefault();
        Object[] arrobject = new Object[]{n4, n5};
        return String.format((Locale)locale, (String)"%d:%02d", (Object[])arrobject);
    }

    public static String a(Context context) {
        return context.getCacheDir().getPath();
    }

    public static String a(Context context, String string2) {
        long l2 = System.currentTimeMillis();
        PackageInfo packageInfo = context.getPackageManager().getPackageArchiveInfo(string2, 1);
        if (packageInfo == null) {
            Locale locale = Locale.getDefault();
            Object[] arrobject = new Object[]{string2, System.currentTimeMillis() - l2};
            String.format((Locale)locale, (String)"Can not parse %s, costs %dms", (Object[])arrobject);
            return null;
        }
        String string3 = packageInfo.packageName;
        Locale locale = Locale.getDefault();
        Object[] arrobject = new Object[]{string3, string2, System.currentTimeMillis() - l2};
        String.format((Locale)locale, (String)"Load %s from %s costs %dms", (Object[])arrobject);
        return string3;
    }

    public static String a(String string2) {
        int n2 = string2.lastIndexOf(47);
        if (n2 != -1) {
            return string2.substring(n2 + 1);
        }
        return "";
    }

    public static String a(String string2, boolean bl) {
        String string3 = j.d(string2);
        String string4 = "others";
        if (bl) {
            return "folder";
        }
        if (g.d(string3)) {
            return "apk";
        }
        if (g.c(string3)) {
            return "picture";
        }
        if (g.a(string3)) {
            return "audio";
        }
        if (g.b(string3)) {
            string4 = "video";
        }
        return string4;
    }

    public static void a(Context context, com.xiaomi.midrop.b.g g2) {
        j.a(context, g2.i, g2);
    }

    private static void a(final Context context, final String string2, com.xiaomi.midrop.b.g g2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            String string3 = j.f(string2);
            if (!TextUtils.isEmpty((CharSequence)string3)) {
                j.a(context, string3, string2, g2);
                return;
            }
            d.a a2 = new d.a(context, 3);
            a2.a(2131689754);
            CharSequence[] arrcharSequence = new CharSequence[]{context.getString(2131689756), context.getString(2131689753), context.getString(2131689757), context.getString(2131689755)};
            a2.a(arrcharSequence, new DialogInterface.OnClickListener(){

                public final void onClick(DialogInterface dialogInterface, int n2) {
                    String string22 = "";
                    switch (n2) {
                        default: {
                            break;
                        }
                        case 3: {
                            string22 = "image/*";
                            break;
                        }
                        case 2: {
                            string22 = "video/*";
                            break;
                        }
                        case 1: {
                            string22 = "audio/*";
                            break;
                        }
                        case 0: {
                            string22 = "text/*";
                        }
                    }
                    j.a(context, string22, string2, null);
                    dialogInterface.dismiss();
                }
            });
            a2.b();
            return;
        }
        d.b((String)a, (String)"openFile failed. File path is null", (Object[])new Object[0]);
    }

    private static void a(Context context, String string2, String string3, com.xiaomi.midrop.b.g g2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (g2 != null && "image/*".equals((Object)string2)) {
                GalleryActivity.a((Context)context, (com.xiaomi.midrop.b.g)g2, (String)"gallery.view");
                return;
            }
            Intent intent = j.a(context, string2, string3);
            if (intent != null && intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
            return;
        }
        String string4 = a;
        StringBuilder stringBuilder = new StringBuilder("OpenFile failed. File path =");
        stringBuilder.append(string3);
        d.b((String)string4, (String)stringBuilder.toString(), (Object[])new Object[0]);
    }

    public static boolean a(long l2, long l3) {
        long l4 = Math.abs((long)(l2 - l3));
        return l4 < 86400L && l4 > -86400L && j.e(l2) == j.e(l3);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean a(File var0_1, String var1) {
        block27 : {
            block29 : {
                block28 : {
                    if (var1 == null) {
                        return false;
                    }
                    var2_2 = new File(var1);
                    if (var2_2.exists()) {
                        var2_2.delete();
                    }
                    try {
                        var2_2.createNewFile();
                    }
                    catch (IOException var3_3) {
                        var3_3.printStackTrace();
                    }
                    var4_4 = null;
                    var12_5 = new FileInputStream(var0_1).getChannel();
                    var6_6 = new FileOutputStream(var2_2).getChannel();
                    var12_5.transferTo(0L, var12_5.size(), (WritableByteChannel)var6_6);
                    if (var12_5 == null) ** GOTO lbl21
                    try {
                        var12_5.close();
lbl21: // 2 sources:
                        if (var6_6 == null) return true;
                        var6_6.close();
                        return true;
                    }
                    catch (IOException var21_7) {}
                    catch (Throwable var18_8) {
                        var4_4 = var12_5;
                        var7_9 = var18_8;
                        break block27;
                    }
                    catch (IOException var17_12) {
                        var4_4 = var12_5;
                        var10_13 = var17_12;
                        break block28;
                    }
                    catch (FileNotFoundException var16_15) {
                        var4_4 = var12_5;
                        var5_16 = var16_15;
                        break block29;
                    }
                    catch (Throwable var15_18) {
                        var4_4 = var12_5;
                        var7_9 = var15_18;
                        var6_6 = null;
                        break block27;
                    }
                    catch (IOException var14_19) {
                        var4_4 = var12_5;
                        var10_13 = var14_19;
                        var6_6 = null;
                        break block28;
                    }
                    catch (FileNotFoundException var13_20) {
                        var4_4 = var12_5;
                        var5_16 = var13_20;
                        var6_6 = null;
                        break block29;
                    }
                    catch (Throwable var7_10) {
                        var6_6 = null;
                        var4_4 = null;
                        break block27;
                    }
                    catch (IOException var10_14) {
                        var6_6 = null;
                    }
                }
                var10_13.printStackTrace();
                if (var4_4 == null) ** GOTO lbl64
                try {
                    var4_4.close();
lbl64: // 2 sources:
                    if (var6_6 == null) return false;
                    var6_6.close();
                    return false;
                }
                catch (IOException var11_21) {}
                catch (FileNotFoundException var5_17) {
                    var6_6 = null;
                }
            }
            var5_16.printStackTrace();
            if (var4_4 == null) ** GOTO lbl76
            try {
                var4_4.close();
lbl76: // 2 sources:
                if (var6_6 == null) return false;
                var6_6.close();
                return false;
            }
            catch (IOException var9_22) {}
            catch (Throwable var7_11) {
                // empty catch block
            }
        }
        if (var4_4 == null) ** GOTO lbl86
        try {
            var4_4.close();
lbl86: // 2 sources:
            if (var6_6 == null) throw var7_9;
            var6_6.close();
            throw var7_9;
        }
        catch (IOException var8_23) {}
        var21_7.printStackTrace();
        return true;
        var11_21.printStackTrace();
        return false;
        var9_22.printStackTrace();
        return false;
        var8_23.printStackTrace();
        throw var7_9;
    }

    public static boolean a(String string2, String string3) {
        File file = new File(string2);
        File file2 = new File(string3);
        if (file2.exists()) {
            file2.delete();
        }
        return file.exists() && file.renameTo(file2);
    }

    public static String b(long l2) {
        float f2 = 1.0f * (float)l2 / 1024.0f;
        float f3 = f2 / 1024.0f;
        float f4 = f3 / 1024.0f;
        b b2 = b.a();
        if (f4 >= 1.0f) {
            Object[] arrobject = new Object[]{"size", Float.valueOf((float)f4)};
            return b2.a(2131689681, arrobject);
        }
        if (f3 >= 1.0f) {
            Object[] arrobject = new Object[]{"size", Float.valueOf((float)f3)};
            return b2.a(2131689683, arrobject);
        }
        if (f2 >= 1.0f) {
            Object[] arrobject = new Object[]{"size", Float.valueOf((float)f2)};
            return b2.a(2131689682, arrobject);
        }
        Object[] arrobject = new Object[]{l2};
        return b2.a(2131689680, arrobject);
    }

    public static String b(Context context) {
        File file = new File(context.getApplicationInfo().sourceDir);
        File file2 = context.getExternalCacheDir();
        if (file2 == null) {
            return file.getAbsolutePath();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file2.getAbsolutePath());
        stringBuilder.append("/Mi Drop.apk");
        String string2 = stringBuilder.toString();
        if (j.a(file, string2)) {
            return string2;
        }
        return file.getAbsolutePath();
    }

    public static String b(String string2) {
        int n2 = string2.lastIndexOf(47);
        if (n2 != -1) {
            return j.a(string2.substring(0, n2));
        }
        return "";
    }

    public static DateFormat b() {
        Locale locale = b.a().a;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return DateFormat.getDateInstance((int)2, (Locale)locale);
    }

    public static void b(Context context, String string2) {
        j.a(context, string2, null);
    }

    public static String c(long l2) {
        Locale locale = b.a().a;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return DateFormat.getDateTimeInstance((int)2, (int)3, (Locale)locale).format((Object)l2);
    }

    public static String c(String string2) {
        int n2 = string2.lastIndexOf(47);
        if (n2 != -1) {
            String string3 = j.a(string2.substring(0, n2));
            int n3 = string3.lastIndexOf(47);
            int n4 = n3 == -1 ? 0 : n3 + 1;
            return string3.substring(n4);
        }
        return "";
    }

    public static String d(long l2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(l2));
        if (calendar2.get(1) == calendar.get(1)) {
            int n2 = calendar2.get(6) - calendar.get(6);
            if (n2 == 0) {
                return new SimpleDateFormat("HH:mm", b.a().a).format((Object)l2);
            }
            if (n2 == -1) {
                return b.a().b(2131690058);
            }
        }
        return j.b().format((Object)l2);
    }

    public static String d(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return "";
        }
        int n2 = string2.lastIndexOf(46);
        if (n2 > 0) {
            return string2.substring(n2 + 1);
        }
        return "";
    }

    private static long e(long l2) {
        return (l2 + (long)TimeZone.getDefault().getOffset(l2)) / 86400L;
    }

    public static boolean e(String string2) {
        boolean bl = TextUtils.isEmpty((CharSequence)string2);
        if (bl) {
            return false;
        }
        File file = new File(string2);
        if (file.exists()) {
            if (file.isFile()) {
                return file.delete();
            }
            if (file.isDirectory()) {
                File[] arrfile = file.listFiles();
                if (arrfile != null && arrfile.length != 0) {
                    int n2 = arrfile.length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        j.e(arrfile[i2].getAbsolutePath());
                    }
                    return file.delete();
                }
                return file.delete();
            }
        }
        return false;
    }

    public static String f(String string2) {
        String string3 = j.d(string2);
        if (g.d(string3)) {
            return "application/vnd.android.package-archive";
        }
        if (TextUtils.equals((CharSequence)"txt", (CharSequence)string3)) {
            return "text/*";
        }
        if (g.a(string3)) {
            return "audio/*";
        }
        if (g.b(string3)) {
            return "video/*";
        }
        if (g.c(string3)) {
            return "image/*";
        }
        return null;
    }

    public static boolean g(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return false;
        }
        return new File(string2).exists();
    }

    public static long h(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return 0L;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(string2);
            long l2 = Long.parseLong((String)mediaMetadataRetriever.extractMetadata(9));
            return l2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return 0L;
        }
    }

}

