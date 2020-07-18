/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import com.xiaomi.midrop.util.Locale.b;
import java.io.File;

public final class i {
    public static String a() {
        StringBuilder stringBuilder = new StringBuilder("/");
        stringBuilder.append(b.a().b(2131689735));
        stringBuilder.append("/MIUI/ShareMe");
        return stringBuilder.toString();
    }

    public static String a(Context context) {
        StringBuilder stringBuilder = new StringBuilder("/");
        stringBuilder.append(b.a().b(2131689953));
        stringBuilder.append("/Android/data/");
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("/files/ShareMe");
        return stringBuilder.toString();
    }

    private static void a(File file) {
        if (file != null && file.exists()) {
            if (!file.isDirectory()) {
                return;
            }
            File[] arrfile = file.listFiles();
            if (arrfile != null) {
                for (File file2 : arrfile) {
                    if (file2.isFile()) {
                        file2.delete();
                        continue;
                    }
                    if (!file2.isDirectory()) continue;
                    i.a(file2);
                }
            }
            file.delete();
        }
    }

    static /* synthetic */ void a(String string2) {
        i.a(new File(string2));
    }

    public static interface a {
        public void a();
    }

}

