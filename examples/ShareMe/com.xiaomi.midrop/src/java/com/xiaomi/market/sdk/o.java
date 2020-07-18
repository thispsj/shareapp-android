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
 *  java.lang.reflect.Method
 */
package com.xiaomi.market.sdk;

import android.text.TextUtils;
import com.xiaomi.market.sdk.j;
import java.lang.reflect.Method;

final class o {
    private static Class<?> a;
    private static Method b;

    static {
        try {
            Class class_;
            a = class_ = Class.forName((String)"android.os.SystemProperties");
            b = class_.getDeclaredMethod("get", new Class[]{String.class, String.class});
        }
        catch (Exception exception) {
            j.a("MarketSdkUtils", exception.getMessage(), exception);
        }
    }

    public static String a(String string2, String string3) {
        try {
            String string4 = (String)b.invoke(a, new Object[]{string2, string3});
            boolean bl = TextUtils.isEmpty((CharSequence)string4);
            if (!bl) {
                return string4;
            }
            return string3;
        }
        catch (Exception exception) {
            j.a("MarketSdkUtils", exception.getMessage(), exception);
            return string3;
        }
    }
}

