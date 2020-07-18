/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Locale
 *  java.util.Set
 */
package com.xiaomi.midrop.util;

import android.text.TextUtils;
import com.xiaomi.midrop.util.Locale.b;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class aa {
    private static final Set<String> a;
    private static final boolean b;
    private static String c;

    static {
        String string2;
        a = new HashSet((Collection)Arrays.asList((Object[])new String[]{"AT", "BE", "BG", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FR", "GB", "GR", "HR", "HU", "IE", "IT", "LT", "LU", "LV", "MT", "NL", "PL", "PT", "RO", "SE", "SI", "SK"}));
        c = string2 = aa.c();
        boolean bl = TextUtils.isEmpty((CharSequence)string2) || a.contains((Object)c.toUpperCase());
        b = bl;
        StringBuilder stringBuilder = new StringBuilder("Country ");
        stringBuilder.append(c);
        stringBuilder.append(" ");
        stringBuilder.append(b);
    }

    public static boolean a() {
        return b;
    }

    public static String b() {
        return c;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String c() {
        String string2;
        try {
            if (com.xiaomi.globalmiuiapp.common.f.b.a()) {
                Class class_ = Class.forName((String)"android.os.SystemProperties");
                return (String)class_.getMethod("get", new Class[]{String.class}).invoke((Object)class_, new Object[]{"ro.miui.region"});
            }
            b b2 = b.a();
            string2 = null;
            if (b2 == null) return string2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
        Locale locale = b.a().a;
        string2 = null;
        if (locale == null) return string2;
        return b.a().a.getCountry();
    }
}

