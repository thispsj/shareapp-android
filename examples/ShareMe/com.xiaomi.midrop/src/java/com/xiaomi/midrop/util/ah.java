/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.xiaomi.midrop.util;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.e;
import java.util.ArrayList;

public class ah {
    private static volatile ah b;
    public ArrayList<e> a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ah a() {
        if (b != null) return b;
        Class<ah> class_ = ah.class;
        synchronized (ah.class) {
            if (b != null) return b;
            b = new ah();
            // ** MonitorExit[var1] (shouldn't be in output)
            return b;
        }
    }

    public static boolean a(e e2) {
        return e2 != null && !TextUtils.isEmpty((CharSequence)e2.b()) && e2.b().startsWith("//");
    }

    public static boolean b(e e2) {
        return e2.c;
    }

    @SuppressLint(value={"SdCardPath"})
    public static boolean c(e e2) {
        if (e2.e) {
            return true;
        }
        if (e2.b() != null && e2.b().contains((CharSequence)"/sdcard1")) {
            return true;
        }
        String string2 = e2.c();
        String string3 = MiDropApplication.a().getString(2131689953).replace((CharSequence)" ", (CharSequence)"");
        String string4 = string2 != null ? string2.replace((CharSequence)" ", (CharSequence)"") : "";
        return !TextUtils.isEmpty((CharSequence)string4) && string3.equalsIgnoreCase(string4);
    }
}

