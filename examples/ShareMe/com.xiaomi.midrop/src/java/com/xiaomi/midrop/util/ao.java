/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.util;

import android.content.SharedPreferences;
import com.xiaomi.midrop.MiDropApplication;

public final class ao {
    private static String a = "reverse";

    public static boolean a() {
        return MiDropApplication.a().getSharedPreferences("version", 0).getBoolean(a, false);
    }
}

