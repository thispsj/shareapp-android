/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.ConcurrentHashMap
 */
package com.xiaomi.globalmiuiapp.common.f;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private final ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
    private String b;

    public a(String string2) {
        String string3;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string3 = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("/");
            string3 = stringBuilder.toString();
        }
        this.b = string3;
    }
}

