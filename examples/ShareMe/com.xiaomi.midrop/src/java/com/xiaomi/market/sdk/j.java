/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.xiaomi.market.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.market.sdk.q;

public final class j {
    public static boolean a = q.a;

    private static String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder("UpdateCheck-");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static void a(String string2, String string3) {
        if (a) {
            j.a(j.a(string2), string3, 3);
        }
    }

    private static void a(String string2, String string3, int n2) {
        if (!TextUtils.isEmpty((CharSequence)string3) && string3.length() > 3000) {
            int n3 = 0;
            while (n3 <= string3.length() / 3000) {
                int n4 = n3 * 3000;
                int n5 = string3.length();
                int n6 = Math.min((int)n5, (int)(++n3 * 3000));
                if (n4 >= n6) continue;
                j.b(string2, string3.substring(n4, n6), n2);
            }
            return;
        }
        j.b(string2, string3, n2);
    }

    public static void a(String string2, String string3, Throwable throwable) {
        String string4 = j.a(string2);
        if (!TextUtils.isEmpty((CharSequence)string3) && string3.length() > 3000) {
            int n2 = 0;
            while (n2 <= string3.length() / 3000) {
                int n3 = n2 * 3000;
                int n4 = string3.length();
                int n5 = Math.min((int)n4, (int)(++n2 * 3000));
                if (n3 >= n5) continue;
                j.b(string4, string3.substring(n3, n5), throwable);
            }
            return;
        }
        j.b(string4, string3, throwable);
    }

    public static void b(String string2, String string3) {
        j.a(j.a(string2), string3, 0);
    }

    private static void b(String string2, String string3, int n2) {
        if (string3 == null) {
            string3 = "";
        }
        switch (n2) {
            default: {
                return;
            }
            case 4: {
                Log.v((String)string2, (String)string3);
                return;
            }
            case 3: {
                Log.d((String)string2, (String)string3);
                return;
            }
            case 2: {
                Log.i((String)string2, (String)string3);
                return;
            }
            case 1: {
                Log.w((String)string2, (String)string3);
                return;
            }
            case 0: 
        }
        Log.e((String)string2, (String)string3);
    }

    private static void b(String string2, String string3, Throwable throwable) {
        if (string3 == null) {
            string3 = "";
        }
        Log.e((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void c(String string2, String string3) {
        j.a(j.a(string2), string3, 2);
    }
}

