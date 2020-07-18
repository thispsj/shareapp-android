/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  midrop.service.c.e
 */
package com.xiaomi.midrop.util;

import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.globalmiuiapp.common.f.d;
import com.xiaomi.midrop.common.b;

public final class e {
    public static String a() {
        String string2 = b.a("custom_name", "");
        if (TextUtils.isEmpty((CharSequence)string2) && TextUtils.isEmpty((CharSequence)(string2 = d.a("ro.product.marketname")))) {
            string2 = Build.MODEL;
        }
        if (string2 == null) {
            return null;
        }
        while (string2.getBytes().length > 15) {
            string2 = string2.substring(0, -1 + string2.length());
        }
        return string2;
    }

    public static void a(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        midrop.service.c.e.a((String)"custom_name", (String)string2);
    }
}

