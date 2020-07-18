/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Environment
 *  android.text.TextUtils
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.xiaomi.midrop.common.b;
import com.xiaomi.midrop.util.ai;
import java.io.File;
import java.util.Locale;

public final class d {
    public static final String a;
    public static final Locale b;
    public static final String c;
    private static File d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)d.a());
        stringBuilder.append("/ShareMe");
        a = stringBuilder.toString();
        b = new Locale("es", "");
        File file = new File(a);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(a);
        stringBuilder2.append("/.cache");
        c = stringBuilder2.toString();
    }

    private static File a() {
        block3 : {
            try {
                if (d != null) break block3;
                d = new File(Environment.getExternalStorageDirectory(), "MIUI");
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
        }
        if (!d.exists() && Environment.getExternalStorageDirectory().exists()) {
            d.mkdir();
        }
        return d;
    }

    public static String a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d.b(context));
        stringBuilder.append("/.cache");
        return stringBuilder.toString();
    }

    public static String b(Context context) {
        String string2 = ai.b(context);
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("Android/data/");
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("/files/ShareMe");
        return new File(string2, stringBuilder.toString()).getAbsolutePath();
    }

    public static String c(Context context) {
        if (b.a("file_storage_loction", 0) == 1) {
            return d.b(context);
        }
        return a;
    }
}

