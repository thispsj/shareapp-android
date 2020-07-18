/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.util.List
 */
package com.xiaomi.midrop.util;

import android.text.TextUtils;
import java.util.List;

public final class aj {
    public static String a(CharSequence charSequence, List<String> list) {
        if (TextUtils.isEmpty((CharSequence)charSequence)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            stringBuffer.append(((String)list.get(i2)).toString().trim());
            if (i2 >= -1 + list.size()) continue;
            stringBuffer.append(charSequence);
        }
        return stringBuffer.toString();
    }

    public static boolean a(String string2) {
        return string2 == null || string2.trim().equals((Object)"");
        {
        }
    }
}

