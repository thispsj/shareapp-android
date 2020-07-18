/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.res.AssetManager
 *  android.text.TextUtils
 *  com.xiaomi.midrop.util.am
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Type
 *  java.nio.charset.Charset
 *  java.util.List
 */
package com.xiaomi.midrop.home;

import a.a.r;
import a.e.b.d;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.google.a.b.j;
import com.google.a.e;
import com.xiaomi.midrop.home.a.b;
import com.xiaomi.midrop.home.a.c;
import com.xiaomi.midrop.util.am;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;

public final class a {
    public static final a a = new a();
    private static c b;
    private static String c = "CustomBottomSheetHelper";

    private a() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static List<b> a(Context context) {
        List<b> list;
        c c2;
        c c3;
        d.b((Object)context, "context");
        c c4 = b;
        String string2 = null;
        if (c4 != null && (list = (c2 = b) != null ? c2.a() : null) != null) {
            c c5 = b;
            if (c5 == null) {
                d.a();
            }
            List<b> list2 = c5.a();
            d.a(list2, "mResponse!!.homeScreen");
            return list2;
        }
        try {
            String string3;
            AssetManager assetManager;
            String string4;
            if (am.b()) {
                assetManager = context.getAssets();
                string4 = "home/home_screen_content.json";
            } else {
                assetManager = context.getAssets();
                string4 = "home/home_screen_content_non_xiaomi.json";
            }
            InputStream inputStream = assetManager.open(string4);
            byte[] arrby = new byte[inputStream.available()];
            inputStream.read(arrby);
            inputStream.close();
            Charset charset = Charset.forName((String)"UTF-8");
            d.a((Object)charset, "Charset.forName(\"UTF-8\")");
            string2 = string3 = new String(arrby, charset);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return r.a;
        }
        Object t2 = new e().a(string2, (Type)c.class);
        b = (c)j.a(c.class).cast(t2);
        if (am.b()) {
            try {
                if (!context.getPackageManager().getApplicationInfo((String)"com.xiaomi.mipicks", (int)0).enabled) {
                    c c6 = b;
                    if (c6 == null) {
                        d.a();
                    }
                    if (c6.a().size() >= 3) {
                        c c7 = b;
                        if (c7 == null) {
                            d.a();
                        }
                        c7.a().remove(3);
                    }
                }
            }
            catch (Exception exception) {
                new StringBuilder("checkForGetApps e=").append((Object)exception);
            }
        }
        if ((c3 = b) == null) {
            d.a();
        }
        List<b> list3 = c3.a();
        d.a(list3, "mResponse!!.homeScreen");
        return list3;
    }
}

