/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 */
package com.xiaomi.market.sdk;

import com.xiaomi.market.sdk.j;

public class Patcher {
    public static int a(String string2, String string3, String string4) {
        return new Patcher().applyPatch(string2, string3, string4);
    }

    public static boolean a() {
        try {
            System.loadLibrary((String)"sdk_patcher_jni");
            return true;
        }
        catch (Throwable throwable) {
            StringBuilder stringBuilder = new StringBuilder("load patcher library failed : ");
            stringBuilder.append(throwable.toString());
            j.b("MarketPatcher", stringBuilder.toString());
            return false;
        }
    }

    public native int applyPatch(String var1, String var2, String var3);
}

