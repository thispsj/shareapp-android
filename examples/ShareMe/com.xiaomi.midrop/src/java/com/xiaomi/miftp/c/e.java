/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.miftp.c;

import android.util.Log;

public final class e {
    private static boolean a = Log.isLoggable((String)"FE_LOG", (int)2);
    private static boolean b = Log.isLoggable((String)"FE_IGNORE", (int)2);

    public static void a(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        stringBuilder.append(string3);
        Log.d((String)"FE_LOG", (String)stringBuilder.toString());
    }

    public static void b(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        stringBuilder.append(string3);
        Log.i((String)"FE_LOG", (String)stringBuilder.toString());
    }

    public static void c(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        stringBuilder.append(string3);
        Log.w((String)"FE_LOG", (String)stringBuilder.toString());
    }

    public static void d(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        stringBuilder.append(string3);
        Log.e((String)"FE_LOG", (String)stringBuilder.toString());
    }
}

