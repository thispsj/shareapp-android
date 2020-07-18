/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  java.lang.Object
 */
package com.xiaomi.market.sdk;

import android.content.Context;
import android.content.pm.PackageManager;

public final class b {
    public static Context a;

    public static Context a() {
        return a;
    }

    public static void a(Context context) {
        a = context.getApplicationContext();
    }

    public static PackageManager b() {
        return a.getPackageManager();
    }
}

